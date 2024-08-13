#include <stdio.h>
#include <stdlib.h>

struct node
{
  int info;
  struct node *link;
} *top = NULL;

void push(int item);
int pop();
int peek();
int isEmpty();
void display();

void main()
{
  int choice, item;
  while (1)
  {
    printf("1.Push\n");
    printf("2.Pop\n");
    printf("3.Display item at the top\n");
    printf("4.Display all items of the stack\n");
    printf("5.Quit\n");
    printf("Enter your choice : ");
    scanf("%d", &choice);

    switch (choice)
    {
    case 1:
      printf("Enter the item to be pushed : ");
      scanf("%d", &item);
      push(item);
      break;
    case 2:
      item = pop();
      printf("Popped item is : %d\n", item);
      break;
    case 3:
      printf("Item at the top is %d\n", peek());
      break;
    case 4:
      display();
      break;
    case 5:
      exit(1);
    default:
      printf("Wrong choice\n");
    }
  }
}
void push(int item)
{
  struct node *temp;
  temp = (struct node *)malloc(sizeof(struct node));
  if (temp == NULL)
  {
    printf("Stack Overflow\n");
    return;
  }
  temp->info = item;
  temp->link = top;
  top = temp;
}

int pop()
{
  struct node *temp;
  int item;
  if (isEmpty())
  {
    printf("Stack Underflow\n");
    exit(1);
  }
  temp = top;
  item = temp->info;
  top = top->link;
  free(temp);
  return item;
}

int peek()
{
  if (isEmpty())
  {
    printf("Stack Underflow\n");
    exit(1);
  }
  return top->info;
}

int isEmpty()
{
  if (top == NULL)
    return 1;
  else
    return 0;
}

void display()
{
  struct node *ptr;
  ptr = top;
  if (isEmpty())
  {
    printf("Stack is empty\n");
    return;
  }
  printf("Stack elements :\n\n");
  while (ptr != NULL)
  {
    printf(" %d\n", ptr->info);
    ptr = ptr->link;
  }
  printf("\n");
}