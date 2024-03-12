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

    // bubble sort
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // swap
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

    // for (int i = 0; i < SIZE; i++) {
    //     printf("%d ", arr[i]);
    // }
    printTimeElapsed();
    return 0;
}
