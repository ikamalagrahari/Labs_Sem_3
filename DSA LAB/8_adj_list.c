#include <stdio.h>
#include <stdlib.h>

struct Edge;
struct Vertex
{
  int info;
  struct Vertex *nextVertex;
  struct Edge *firstEdge;
} *start = NULL;

struct Edge
{
  struct Vertex *destVertex;
  struct Edge *nextEdge;
};

struct Vertex *findVertex(int u);
void insertVertex(int u);
void insertEdge(int u, int v);
void deleteEdge(int u, int v);
void deleteIncomingEdges(int u);
void deleteVertex(int u);
void display();
void main()
{
  int choice, u, origin, destin;
  while (1)
  {
    printf("1.Insert a Vertex\n");
    printf("2.Insert an Edge\n");
    printf("3.Delete a Vertex\n");
    printf("4.Delete an Edge\n");
    printf("5.Display\n");
    printf("6.Exit\n");
    printf("Enter your choice : ");
    scanf("%d", &choice);
    switch (choice)
    {
    case 1:
      printf("Enter a vertex to be inserted : ");
      scanf("%d", &u);

      insertVertex(u);
      break;
    case 2:
      printf("Enter an Edge to be inserted : ");
      scanf("%d %d", &origin, &destin);
      insertEdge(origin, destin);
      break;
    case 3:
      printf("Enter a vertex to be deleted : ");
      scanf("%d", &u);
      deleteIncomingEdges(u);
      deleteVertex(u);
      break;
    case 4:
      printf("Enter an edge to be deleted : ");
      scanf("%d %d", &origin, &destin);
      deleteEdge(origin, destin);
      break;
    case 5:
      display();
      break;
    case 6:
      exit(1);
    default:
      printf("Wrong choice\n");
      break;
    }
  }
}

void insertVertex(int u)
{
  struct Vertex *tmp, *ptr;
  tmp = malloc(sizeof(struct Vertex));
  tmp->info = u;
  tmp->nextVertex = NULL;
  tmp->firstEdge = NULL;
  if (start == NULL)
  {
    start = tmp;
    return;
  }
  ptr = start;
  while (ptr->nextVertex != NULL)
    ptr = ptr->nextVertex;
  ptr->nextVertex = tmp;
}

void deleteVertex(int u)
{
  struct Vertex *tmp, *q;
  struct Edge *p, *temporary;
  if (start == NULL)
  {
    printf("No vertices to be deleted\n");
    return;
  }
  if (start->info == u)
  {
    tmp = start;
    start = start->nextVertex;
  }
  else
  {
    q = start;
    while (q->nextVertex != NULL)
    {
      if (q->nextVertex->info == u)
        break;
      q = q->nextVertex;
    }
    if (q->nextVertex == NULL)
    {
      printf("Vertex not found\n");
      return;
    }
    else
    {
      tmp = q->nextVertex;
      q->nextVertex = tmp->nextVertex;
    }
  }
  p = tmp->firstEdge;
  while (p != NULL)
  {
    temporary = p;
    p = p->nextEdge;
    free(temporary);
  }
  free(tmp);
}

void deleteIncomingEdges(int u)
{
  struct Vertex *ptr;
  struct Edge *q, *tmp;
  ptr = start;
  while (ptr != NULL)
  {
    if (ptr->firstEdge == NULL)
    {
      ptr = ptr->nextVertex;
      continue;
    }
    if (ptr->firstEdge->destVertex->info == u)
    {
      tmp = ptr->firstEdge;
      ptr->firstEdge = ptr->firstEdge->nextEdge;
      free(tmp);
      continue;
    }
    q = ptr->firstEdge;
    while (q->nextEdge != NULL)
    {
      if (q->nextEdge->destVertex->info == u)
      {
        tmp = q->nextEdge;
        q->nextEdge = tmp->nextEdge;
        free(tmp);
        continue;
      }
      q = q->nextEdge;
    }
    ptr = ptr->nextVertex;
  }
}

struct Vertex *findVertex(int u)
{
  struct Vertex *ptr, *loc;
  ptr = start;
  while (ptr != NULL)
  {
    if (ptr->info == u)
    {
      loc = ptr;
      return loc;
    }
    else
      ptr = ptr->nextVertex;
  }
  loc = NULL;
  return loc;
}

void insertEdge(int u, int v)
{
  struct Vertex *locu, *locv;
  struct Edge *ptr, *tmp;
  locu = findVertex(u);
  locv = findVertex(v);
  if (locu == NULL)
  {
    printf("Start vertex not present, first insert vertex %d\n", u);
    return;
  }
  if (locv == NULL)
  {
    printf("End vertex not present, first insert vertex %d\n", v);
    return;
  }
  tmp = malloc(sizeof(struct Edge));
  tmp->destVertex = locv;
  tmp->nextEdge = NULL;
  if (locu->firstEdge == NULL)
  {
    locu->firstEdge = tmp;
    return;
  }
  ptr = locu->firstEdge;
  while (ptr->nextEdge != NULL)
    ptr = ptr->nextEdge;
  ptr->nextEdge = tmp;
}

void deleteEdge(int u, int v)
{
  struct Vertex *locu;
  struct Edge *tmp, *q;
  locu = findVertex(u);
  if (locu == NULL)
  {
    printf("Start vertex not present\n");
    return;
  }
  if (locu->firstEdge == NULL)
  {
    printf("Edge not present\n");
    return;
  }
  if (locu->firstEdge->destVertex->info == v)
  {
    tmp = locu->firstEdge;
    locu->firstEdge = locu->firstEdge->nextEdge;
    free(tmp);
    return;
  }
  q = locu->firstEdge;
  while (q->nextEdge != NULL)
  {
    if (q->nextEdge->destVertex->info == v)
    {
      tmp = q->nextEdge;
      q->nextEdge = tmp->nextEdge;
      free(tmp);
      return;
    }
    q = q->nextEdge;
  }
  printf("This Edge not present in the graph\n");
}

void display()
{
  struct Vertex *ptr;
  struct Edge *q;
  ptr = start;
  while (ptr != NULL)
  {
    printf("%d ->", ptr->info);
    q = ptr->firstEdge;
    while (q != NULL)
    {
      printf(" %d", q->destVertex->info);
      q = q->nextEdge;
    }
    printf("\n");
    ptr = ptr->nextVertex;
  }
}
