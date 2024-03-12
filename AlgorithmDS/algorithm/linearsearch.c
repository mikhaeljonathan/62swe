#include <stdio.h>
#include <time.h>
clock_t begin;
clock_t end;

void printTimeElapsed() {
    end = clock();
    double time_spent = (double)(end - begin);
    printf("time spent: %f\n", time_spent);
}

int main() {
    // returns the approximate processor time that is consumed by the program which 
    // is the number of clock ticks used by the program since the program started
    begin = clock();
    const int SIZE = 1000000;

    int arr[SIZE];
    for (int i = 0; i < SIZE; i++)
        arr[i] = i;

    int x = -1;
    // linear search

    for (int i = 0; i < SIZE; i++) {
        if (arr[i] == x) {
            printf("yes\n");
            printTimeElapsed();
            return 0;
        }
    }

    printf("no\n");
    printTimeElapsed();
    return 0;
}
