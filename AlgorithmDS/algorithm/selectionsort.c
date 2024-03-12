#include <stdio.h>
#include <time.h>
#include <stdlib.h>
clock_t begin;
clock_t end;

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

    // selection sort
    for (int i = 0; i < SIZE; i++) {
        int min = i;
        for (int j = i + 1; j < SIZE; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        // swap
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

    for (int i = 0; i < SIZE; i++) {
        printf("%d ", arr[i]);
    }
    printTimeElapsed();
    return 0;
}
