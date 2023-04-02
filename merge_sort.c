#include <stdio.h>

void merge(int arr[], int left[], int leftSize, int right[], int rightSize)
{
    int i, j, k;
    i = 0;
    j = 0;
    k = 0;
    while (i < leftSize && j < rightSize)
    {
        if (left[i] <= right[j])
        {
            arr[k] = left[i];
            i++;
        }
        else
        {
            arr[k] = right[j];
            j++;
        }
        k++;
    }
    while (i < leftSize)
    {
        arr[k] = left[i];
        i++;
        k++;
    }
    while (j < rightSize)
    {
        arr[k] = right[j];
        j++;
        k++;
    }
}

void mergeSort(int arr[], int size)
{
    if (size < 2)
    {
        return;
    }
    int mid = size / 2;
    int left[mid];
    int right[size - mid];
    for (int i = 0; i < mid; i++)
    {
        left[i] = arr[i];
    }
    for (int i = mid; i < size; i++)
    {
        right[i - mid] = arr[i];
    }
    mergeSort(left, mid);
    mergeSort(right, size - mid);
    merge(arr, left, mid, right, size - mid);
}

int main()
{
    int arr[] = {5, 3, 8, 6, 2, 7, 1, 4};
    int size = sizeof(arr) / sizeof(int);
    mergeSort(arr, size);
    for (int i = 0; i < size; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
    return 0;
}
