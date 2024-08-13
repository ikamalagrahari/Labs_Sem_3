#include <stdio.h>
#include <stdlib.h>

struct node
{
  int info;
  struct node *link;
};

struct node *create_list(struct node *start);
void display(struct node *start);
struct node *add_at_beg(struct node *start, int data);
struct node *add_at_end(struct node *start, int data);
struct node *add_after(struct node *start, int data, int item);
struct node *add_before(struct node *start, int data, int item);
struct node *add_at_pos(struct node *start, int data, int pos);
struct node *del(struct node *start, int data);

int main()
{
  struct node *start = NULL;
  int choice, data, item, pos;

  while (1)
  {
    printf("--------------------------------------------------------------------------------------------");
    printf("\n1. Create list\t");
    printf("\t2. Display\t");
    printf("3. Add to empty list / Add at beginning\t");
    printf("4. Add at end\t");
    printf("\t5. Add after node\t");
    printf("6. Add before node\t\t");
    printf("\t7. Add at position\t");
    printf("8. Delete\t");
    printf("9. Quit\n\n");

    printf("Enter your choice: ");
    scanf("%d", &choice);

    switch (choice)
    {
    case 1:
      start = create_list(start);
      break;
    case 2:
      display(start);
      break;
    case 3:
      printf("Enter the element to be inserted: ");
      scanf("%d", &data);
      start = add_at_beg(start, data);
      break;
    case 4:
      printf("Enter the element to be inserted: ");
      scanf("%d", &data);
      start = add_at_end(start, data);
      break;
    case 5:
      printf("Enter the element to be inserted: ");
      scanf("%d", &data);
      printf("Enter the element after which to insert: ");
      scanf("%d", &item);
      start = add_after(start, data, item);
      break;
    case 6:
      printf("Enter the element to be inserted: ");
      scanf("%d", &data);
      printf("Enter the element before which to insert: ");
      scanf("%d", &item);
      start = add_before(start, data, item);
      break;
    case 7:
      printf("Enter the element to be inserted: ");
      scanf("%d", &data);
      printf("Enter the position at which to insert: ");
      scanf("%d", &pos);
      start = add_at_pos(start, data, pos);
      break;
    case 8:
      printf("Enter the element to be deleted: ");
      scanf("%d", &data);
      start = del(start, data);
      break;
    case 9:
      exit(1);
    default:
      printf("Wrong choice\n");
      break;
    }
  }
  return 0;
}

struct node *create_list(struct node *start)
{
  int i, n, data;
  printf("Enter the number of nodes: ");
  scanf("%d", &n);
  start = NULL;
  if (n == 0)
    return start;
  printf("Enter the element to be inserted: ");
  scanf("%d", &data);
  start = add_at_beg(start, data);

  for (i = 2; i <= n; i++)
  {
    printf("Enter the element to be inserted: ");
    scanf("%d", &data);
    start = add_at_end(start, data);
  }
  return start;
}

void display(struct node *start)
{
  struct node *p;
  if (start == NULL)
  {
    printf("List is empty\n");
    return;
  }
  p = start;
  printf("List is: \n");
  while (p != NULL)
  {
    printf("%d, ", p->info);
    p = p->link;
  }
  printf("\n\n");
}

struct node *add_at_beg(struct node *start, int data)
{
  struct node *temp;
  temp = (struct node *)malloc(sizeof(struct node));
  temp->info = data;
  temp->link = start;
  start = temp;
  return start;
}

struct node *add_at_end(struct node *start, int data)
{
  struct node *p, *temp;
  temp = (struct node *)malloc(sizeof(struct node));
  temp->info = data;
  p = start;
  while (p->link != NULL)
    p = p->link;
  p->link = temp;
  temp->link = NULL;
  return start;
}

struct node *add_after(struct node *start, int data, int item)
{
  struct node *temp, *p;
  p = start;
  while (p != NULL)
  {
    if (p->info == item)
    {
      temp = (struct node *)malloc(sizeof(struct node));
      temp->info = data;
      temp->link = p->link;
      p->link = temp;
      return start;
    }
    p = p->link;
  }
  printf("%d not present in the list\n", item);
  return start;
}

struct node *add_before(struct node *start, int data, int item)
{
  struct node *temp, *p;
  if (start == NULL)
  {
    printf("List is empty\n");
    return start;
  }
  if (item == start->info)
  {
    temp = (struct node *)malloc(sizeof(struct node));
    temp->info = data;
    temp->link = start;
    start = temp;
    return start;
  }
  p = start;
  while (p->link != NULL)
  {
    if (p->link->info == item)
    {
      temp = (struct node *)malloc(sizeof(struct node));
      temp->info = data;
      temp->link = p->link;
      p->link = temp;
      return start;
    }
    p = p->link;
  }
  printf("%d not present in the list\n", item);
  return start;
}

struct node *add_at_pos(struct node *start, int data, int pos)
{
  struct node *temp, *p;
  int i;
  temp = (struct node *)malloc(sizeof(struct node));
  temp->info = data;
  if (pos == 1)
  {
    temp->link = start;
    start = temp;
    return start;
  }
  p = start;
  for (i = 1; i < pos - 1 && p != NULL; i++)
    p = p->link;
  if (p == NULL)
  {
    printf("There are less than %d elements\n", pos);
  }
  else
  {
    temp->link = p->link;
    p->link = temp;
  }
  return start;
}

struct node *del(struct node *start, int data)
{
  struct node *temp, *p;
  if (start == NULL)
  {
    printf("List is Empty\n");
    return start;
  }
  if (start->info == data)
  {
    temp = start;
    start = start->link;
    free(temp);
    return start;
  }

  p = start;
  while (p->link != NULL)
  {
    if (p->link->info == data)
    {
      temp = p->link;
      p->link = temp->link;
      free(temp);
      return start;
    }
    p = p->link;
  }
  printf("Element %d not found\n", data);
  return start;
}