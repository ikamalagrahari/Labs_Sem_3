#include <stdio.h>
#include <stdlib.h>

#define M 5
#define MAX (M - 1)

#if M % 2 == 0
#define CEIL_Mdiv2 (M / 2)
#else
#define CEIL_Mdiv2 ((M + 1) / 2)
#endif

#define MIN (CEIL_Mdiv2 - 1)

struct node
{
  int count;
  int key[MAX + 1];
  struct node *child[MAX + 1];
};

struct node *Search(int skey, struct node *p, int *pn);
int search_node(int skey, struct node *p, int *pn);
void display(struct node *ptr, int blanks);
void inorder(struct node *ptr);

struct node *Insert(int ikey, struct node *proot);
int rec_ins(int ikey, struct node *p, int *pk, struct node **pkrchild);
void insertByShift(int k, struct node *krchild, struct node *p, int n);
void split(int k, struct node *krchild, struct node *p, int n, int *upkey, struct node **newnode);

struct node *Delete(int dkey, struct node *root);
void rec_del(int dkey, struct node *p);
void delByShift(struct node *p, int n);

int copy_succkey(struct node *p, int n);
void restore(struct node *p, int n);
void borrowLeft(struct node *p, int n);
void borrowRight(struct node *p, int n);
void combine(struct node *p, int m);

int main()
{
  struct node *root = NULL, *ptr;
  int key, choice, n;
  while (1)
  {
    printf("1.Search\n2.Insert\n3.Delete\n");
    printf("4.Display\n5.Inorder traversal\n6.Quit\n");
    printf("Enter your choice : ");
    scanf("%d", &choice);
    switch (choice)
    {
    case 1:
      printf("Enter the key to be searched : ");
      scanf("%d", &key);
      if ((ptr = Search(key, root, &n)) == NULL)
        printf("Key not present\n");
      else
        printf("Node %p, Position %d\n", ptr, n);
      break;

    case 2:
      printf("Enter the key to be inserted : ");
      scanf("%d", &key);
      root = Insert(key, root);
      break;
    case 3:
      printf("Enter the key to be deleted : ");
      scanf("%d", &key);
      root = Delete(key, root);
      break;
    case 4:
      printf("Btree is :\n\n");
      display(root, 0);
      printf("\n\n");
      break;
    case 5:
      inorder(root);
      printf("\n\n");
      break;
    case 6:
      exit(1);
    default:
      printf("Wrong choice\n");
      break;
    }
  }
}

struct node *Search(int skey, struct node *p, int *pn)
{
  if (p == NULL)
    return NULL;
  else if (search_node(skey, p, pn))
    return p;
  else
    return Search(skey, p->child[*pn], pn);
}

int search_node(int skey, struct node *p, int *pn)
{
  if (skey < p->key[1])
  {
    *pn = 0;
    return 0;
  }
  *pn = p->count;
  while ((skey < p->key[*pn]) && *pn > 1)
    (*pn)--;
  if (skey == p->key[*pn])
    return 1;
  else
    return 0;
}

struct node *Insert(int ikey, struct node *proot)
{
  int k, taller;
  struct node *krchild, *temp;

  taller = rec_ins(ikey, proot, &k, &krchild);

  if (taller)
  {
    temp = (struct node *)malloc(sizeof(struct node));
    temp->count = 1;
    temp->child[0] = proot;
    temp->key[1] = k;
    temp->child[1] = krchild;
    proot = temp;
  }
  return proot;
}

int rec_ins(int ikey, struct node *p, int *pk, struct node **pkrchild)
{
  int n;
  int flag;

  if (p == NULL)
  {
    *pk = ikey;
    *pkrchild = NULL;
    return 1;
  }

  if (search_node(ikey, p, &n))
  {
    printf("Duplicate keys are not allowed\n");
    return 0;
  }

  flag = rec_ins(ikey, p->child[n], pk, pkrchild);
  if (flag)
  {
    if (p->count < MAX)
    {
      insertByShift(*pk, *pkrchild, p, n);
      return 0;
    }
    else
    {
      split(*pk, *pkrchild, p, n, pk, pkrchild);
      return 1;
    }
  }
  return 0;
}

void insertByShift(int k, struct node *krchild, struct node *p, int n)
{
  int i;

  for (i = p->count; i > n; i--)
  {
    p->key[i + 1] = p->key[i];
    p->child[i + 1] = p->child[i];
  }
  p->key[n + 1] = k;
  p->child[n + 1] = krchild;
  p->count++;
}

void split(int k, struct node *krchild, struct node *p, int n, int *upkey, struct node **newnode)
{
  int i, j;
  int lastkey;
  struct node *lastchild;
  int d = CEIL_Mdiv2;

  if (n == MAX)
  {
    lastkey = k;
    lastchild = krchild;
  }
  else
  {
    lastkey = p->key[MAX];
    lastchild = p->child[MAX];
    for (i = p->count - 1; i > n; i--)
    {
      p->key[i + 1] = p->key[i];
      p->child[i + 1] = p->child[i];
    }
    p->key[i + 1] = k;
    p->child[i + 1] = krchild;
  }
  *newnode = (struct node *)malloc(sizeof(struct node));
  *upkey = p->key[d];

  for (i = 1, j = d + 1; j <= MAX; i++, j++)
  {
    (*newnode)->key[i] = p->key[j];
    (*newnode)->child[i] = p->child[j];
  }

  (*newnode)->child[0] = p->child[d];

  p->count = d - 1;
  (*newnode)->count = M - d;
  (*newnode)->key[M - d] = lastkey;
  (*newnode)->child[M - d] = lastchild;
}

struct node *Delete(int dkey, struct node *root)
{
  struct node *temp;
  rec_del(dkey, root);

  if (root != NULL && root->count == 0)
  {
    temp = root;
    root = root->child[0];
    free(temp);
  }
  return root;
}

void rec_del(int dkey, struct node *p)
{
  int n, flag, succkey;
  if (p == NULL)
    printf("Value %d not found\n");
  else
  {
    flag = search_node(dkey, p, &n);
    if (flag)
    {
      if (p->child[n] == NULL)
        delByShift(p, n);
      else
      {
        succkey = copy_succkey(p, n);
        rec_del(succkey, p->child[n]);
      }
    }
    else
      rec_del(dkey, p->child[n]);

    if (p->child[n] != NULL)
    {
      if (p->child[n]->count < MIN)
        restore(p, n);
    }
  }
}

void delByShift(struct node *p, int n)
{
  int i;

  for (i = n + 1; i <= p->count; i++)
  {
    p->key[i - 1] = p->key[i];
    p->child[i - 1] = p->child[i];
  }
  p->count--;
}

int copy_succkey(struct node *p, int n)
{
  struct node *ptr;
  ptr = p->child[n];

  while (ptr->child[0] != NULL)
    ptr = ptr->child[0];

  p->key[n] = ptr->key[1];
  return ptr->key[1];
}

void restore(struct node *p, int n)
{
  if (n != 0 && p->child[n - 1]->count > MIN)
    borrowLeft(p, n);
  else if (n != p->count && p->child[n + 1]->count > MIN)
    borrowRight(p, n);
  else
  {
    if (n == 0)
      combine(p, n + 1);
    else
      combine(p, n);
  }
}

void borrowLeft(struct node *p, int n)
{
  int i;
  struct node *u;
  struct node *ls;

  u = p->child[n];
  ls = p->child[n - 1];

  for (i = u->count; i > 0; i--)
  {
    u->key[i + 1] = u->key[i];
    u->child[i + 1] = u->child[i];
  }
  u->child[1] = u->child[0];

  u->key[1] = p->key[n];
  u->count++;

  p->key[n] = ls->key[ls->count];

  u->child[0] = ls->child[ls->count];

  ls->count--;
}

void borrowRight(struct node *p, int n)
{
  int i;
  struct node *u;
  struct node *rs;

  u = p->child[n];
  rs = p->child[n + 1];

  u->count++;
  u->key[u->count] = p->key[n + 1];

  u->child[u->count] = rs->child[0];

  p->key[n + 1] = rs->key[1];
  rs->count--;

  rs->child[0] = rs->child[1];

  for (i = 1; i <= rs->count; i++)
  {
    rs->key[i] = rs->key[i + 1];
    rs->child[i] = rs->child[i + 1];
  }
}

void combine(struct node *p, int m)
{
  int i;
  struct node *x;
  struct node *y;

  x = p->child[m];
  y = p->child[m - 1];

  y->count++;

  y->key[y->count] = p->key[m];

  for (i = m; i < p->count; i++)
  {
    p->key[i] = p->key[i + 1];
    p->child[i] = p->child[i + 1];
  }
  p->count--;

  y->child[y->count] = x->child[0];

  for (i = 1; i <= x->count; i++)
  {
    y->count++;
    y->key[y->count] = x->key[i];
    y->child[y->count] = x->child[i];
  }
  free(x);
}

void display(struct node *ptr, int blanks)
{
  if (ptr)
  {
    int i;

    for (i = 1; i <= blanks; i++)
      printf(" ");
    for (i = 1; i <= ptr->count; i++)
      printf("%d ", ptr->key[i]);
    printf("\n");
    for (i = 0; i <= ptr->count; i++)
      display(ptr->child[i], blanks + 10);
  }
}

void inorder(struct node *ptr)
{
  int i;
  if (ptr != NULL)
  {
    for (i = 0; i < ptr->count; i++)
    {
      inorder(ptr->child[i]);
      printf("%d\t", ptr->key[i + 1]);
    }
    inorder(ptr->child[i]);
  }
}
