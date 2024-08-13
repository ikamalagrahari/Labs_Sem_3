#include <stdio.h>
#define MAX 100
#define STOP getchar()

main()
{
  int arr[MAX], n, i;
  printf("Enter the number of elements : ");
  scanf("%d", &n);
  for (i = 0; i < n; i++)
  {
    printf("Enter element %d : ", i + 1);
    scanf("%d", &arr[i]);
  }
  quick(arr, 0, n - 1);

  printf("Sorted list is :\n");
  display(arr, 0, n - 1);
  printf("\n");
}

quick(int arr[], int low, int up)
{
  int pivloc;
  if (low >= up)
  {
    if (low == up)
      return;
    return;
  }
  pivloc = partition(arr, low, up);
  quick(arr, low, pivloc - 1);
  quick(arr, pivloc + 1, up);
}

partition(int arr[], int low, int up)
{
  int temp, i, j, pivot;
  i = low + 1;
  j = up;
  pivot = arr[low];
  while (i <= j)
  {
    while (arr[i] < pivot && i < up)
    {
      i++;
    }
    if (arr[i] == pivot)
      ;
    else if (arr[i] > pivot)
      ;
    else
      STOP;
    while (arr[j] > pivot)
    {
      j--;
    }
    if (arr[j] == pivot)
      ;
    else if (arr[j] < pivot)
      ;
    STOP;
    if (i < j)
    {
      temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
      STOP;
    }
    else
    {
      if (i == j)
        ;
      else
        ;
      i++;
      STOP;
    }
  }
  return j;
}

display(int arr[], int low, int up)
{
  int i;
  for (i = low; i <= up; i++)
    printf("%d ", arr[i]);
}
