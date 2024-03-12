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
    begin = clock();

    const int SIZE = 1000000;
    int arr[SIZE];

    for (int i = 0; i < SIZE; i++) arr[i] = i;
    int x = SIZE - 1;

    // binary search
    int low = 0;
    int high = SIZE - 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[mid] == x) {
            printf("yes\n");
            printTimeElapsed();
            return 0;
        }
        if (arr[mid] < x)
            low = mid + 1;
        else
            high = mid - 1;
    }
    printf("no\n");
    printTimeElapsed();
    return 0;
}
