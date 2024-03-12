// Heap implementation using array in C
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int getParent(int index) {
    return (index - 1) / 2;
}

int getLeft(int index) {
    return index * 2 + 1;
}

int getRight(int index) {
    return index * 2 + 2;
}

int main() {
    srand(time(NULL));

    const int SIZE = 5;
    int arr[SIZE];
    // fill arr with random integer
    for (int i = 0; i < SIZE; i++) {
        arr[i] = rand() % 100;
    }

    // copy arr to heap
    int heap[SIZE];
    int heapSize = 0;
    for (int i = 0; i < SIZE; i++) {
        heap[heapSize] = arr[i];
        heapSize++;
        int curr = heapSize - 1;
        int parent = (curr - 1) / 2;
        while (curr > 0 && heap[curr] > heap[parent]) {
            int temp = heap[curr];
            heap[curr] = heap[parent];
            heap[parent] = temp;
            curr = parent;
            parent = (curr - 1) / 2;
        }
    }

    // heapify
    for (int i = heapSize - 1; i >= 0; i--) {
        int curr = i;
        int left = curr * 2 + 1;
        int right = curr * 2 + 2;
        while (left < heapSize) {
            int max = left;
            if (right < heapSize && heap[right] > heap[left]) {
                max = right;
            }
            if (heap[curr] < heap[max]) {
                int temp = heap[curr];
                heap[curr] = heap[max];
                heap[max] = temp;
                curr = max;
                left = curr * 2 + 1;
                right = curr * 2 + 2;
            } else {
                break;
            }
        }
    }

    // print the content of the heap
    for (int i = 0; i < heapSize; i++) {
        printf("%d ", heap[i]);
    }
    printf("\n");

    // enqueue
    int data = rand() % 100;
    heap[heapSize] = data;
    heapSize++;
    int curr = heapSize - 1;
    int parent = (curr - 1) / 2;
    while (curr > 0 && heap[curr] > heap[parent]) {
        int temp = heap[curr];
        heap[curr] = heap[parent];
        heap[parent] = temp;
        curr = parent;
        parent = (curr - 1) / 2;
    }

    // print the content of the heap
    for (int i = 0; i < heapSize; i++) {
        printf("%d ", heap[i]);
    }
    printf("\n");

    // dequeue
    int temp = heap[0];
    heap[0] = heap[heapSize - 1];
    heap[heapSize - 1] = temp;
    heapSize--;
    int curr = 0;
    int left = curr * 2 + 1;
    int right = curr * 2 + 2;
    while (left < heapSize) {
        int max = left;
        if (right < heapSize && heap[right] > heap[left]) {
            max = right;
        }
        if (heap[curr] < heap[max]) {
            int temp = heap[curr];
            heap[curr] = heap[max];
            heap[max] = temp;
            curr = max;
            left = curr * 2 + 1;
            right = curr * 2 + 2;
        } else {
            break;
        }
    }

    // print the content of the heap
    for (int i = 0; i < heapSize; i++) {
        printf("%d ", heap[i]);
    }
    printf("\n");

    return 0;
}