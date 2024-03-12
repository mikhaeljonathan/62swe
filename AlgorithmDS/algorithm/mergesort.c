#include <stdio.h>
#include <time.h>
#include <stdlib.h>
clock_t begin;
clock_t end;

// merge sort
void merge(int arr[], int left, int mid, int right) {
    int i, j, k;
    int n1 = mid - left + 1;
    int n2 = right - mid;

    // create temp arrays
    int L[n1], R[n2];

    // copy data to temp arrays L[] and R[]
    for (i = 0; i < n1; i++) {
        L[i] = arr[left + i];
    }
    for (j = 0; j < n2; j++) {
        R[j] = arr[mid + 1 + j];
    }

    // merge the temp arrays back into arr[left..right]
    i = 0; // initial index of first subarray
    j = 0; // initial index of second subarray
    k = left; // initial index of merged subarray
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k++] = L[i++];
        } else {
            arr[k++] = R[j++];
        }
    }

    // copy the remaining elements of L[], if there are any
    while (i < n1) {
        arr[k++] = L[i++];
    }

    // copy the remaining elements of R[], if there are any
    while (j < n2) {
        arr[k++] = R[j++];
    }
}

void mergeSort(int arr[], int left, int right) {
    if (left < right) {
        // same as (left + right) / 2, but avoids overflow for large left and right
        int mid = left + (right - left) / 2;

        // sort first and second halves
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }
}

void printTimeElapsed() {
    end = clock();
    double time_spent = (double)(end - begin);
    printf("time spent: %f\n", time_spent);
}

int main() {
    begin = clock();
    srand(time(NULL));

    const int SIZE = 100000;
    int arr[SIZE];
    // fill arr with random integer
    for (int i = 0; i < SIZE; i++) {
        arr[i] = rand() % 3000000000;
    }

    // merge sort
    mergeSort(arr, 0, SIZE - 1);

    // for (int i = 0; i < SIZE; i++) {
    //     printf("%d ", arr[i]);
    // }
    printTimeElapsed();
    return 0;
}
