#include <stdio.h>
#include <stdlib.h>
#define MAX 100
#define initial 1
#define visited 2

int n;
int adj[MAX][MAX];
int state[MAX];

void DF_Traversal();
void DFS(int v);
void create_graph();
int stack[MAX];
int top = -1;

void push(int v);
int pop();
int isEmpty_stack();

main()
{
  create_graph();
  DF_Traversal();
}

void DF_Traversal()
{
  int v;
  for (v = 0; v < n; v++)
    state[v] = initial;
  printf("Enter starting vertex for Depth First Search : ");
  scanf("%d", &v);
  DFS(v);
  for (v = 0; v < n; v++)
  {
    if (state[v] == initial)
      DFS(v);
  }
  printf("\n");
}

void DFS(int v)
{
  int i;
  push(v);
  while (!isEmpty_stack())
  {
    v = pop();
    if (state[v] == initial)
    {
      printf("%d ", v);
      state[v] = visited;
    }
    for (i = n - 1; i >= 0; i--)
    {
      if (adj[v][i] == 1 && state[i] == initial)
        push(i);
    }
  }
}

void push(int v)
{
  if (top == (MAX - 1))
  {
    printf("Stack Overflow\n");
    return;
  }
  top = top + 1;
  stack[top] = v;
}

int pop()
{
  int v;
  if (top == -1)
  {
    printf("Stack Underflow\n");
    exit(1);
  }
  else
  {
    v = stack[top];
    top = top - 1;
    return v;
  }
}

int isEmpty_stack()
{
  if (top == -1)
    return 1;
  else
    return 0;
}

void create_graph()
{
  int i, max_edges, origin, destin;
  printf("Enter the number of vertices : ");
  scanf("%d", &n);
  max_edges = n * (n - 1);
  for (i = 1; i <= max_edges; i++)
  {
    printf("Enter edge %d( -1 -1 to quit ) : ", i);
    scanf("%d %d", &origin, &destin);
    if ((origin == -1) && (destin == -1))
      break;
    if (origin >= n || destin >= n || origin < 0 || destin < 0)
    {
      printf("Invalid edge!\n");
      i--;
    }
    else
    {
      adj[origin][destin] = 1;
    }
  }
}
