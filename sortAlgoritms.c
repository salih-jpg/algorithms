#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define SIZE 5
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

void selection(int arr[]){
	int min;
	int i;
	for(i = 0; i< SIZE-1; i++){
		min = i;
		int j;
		for(j = i+1; j<SIZE; j++){
			if(arr[j] < arr[min]){
				min = j;
			}
		}
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
	}
}
void insertion(int arr[], int n){
	int i, key, j;
    for (i = 1; i < n; i++) {
        key = arr[i];
        j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

void swap(int* xp, int* yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

void bubbleSort(int arr[], int n){
	int i, j;
    for (i = 0; i < n - 1; i++){
    	for (j = 0; j < n - i - 1; j++){
            if (arr[j] > arr[j + 1])
                swap(&arr[j], &arr[j + 1]);
		}
	}
		 
}
	
void print(int arr[]){
	int i;
	for(i=0 ; i<SIZE; i++){
		printf("%d ", arr[i]);
	}
	printf("\n");
}

int main(int argc, char *argv[]) {
	int arr1[SIZE] = {1,2,34,5,6};
	selection(arr1);
	print(arr1);
	int arr2[SIZE] = {22,5,8,2,1};
	insertion(arr2, SIZE);
	print(arr2);
    int arr3[] = { 64, 34, 25, 12, 2 };
	bubbleSort(arr3, SIZE);
	print(arr3);
	return 0;
}