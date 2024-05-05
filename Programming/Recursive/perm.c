#include <stdio.h>

int perm[10]; // Global array, can hold up to 10 elements

void printArray(int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("%d ", perm[i]);
    }
    printf("\n");
}

void permute(int start, int n)
{
    // printf("permute(%d, %d) debug: ", start, n);
    // printArray(n);
    if (start == n)
    {
        printArray(n);
        return;
    }

    for (int i = start; i < n; i++)
    {
        // Swap perm[start] and perm[i]
        int temp = perm[start];
        perm[start] = perm[i];
        perm[i] = temp;

        permute(start + 1, n);

        // Swap perm[start] and perm[i] (backtrack)
        temp = perm[start];
        perm[start] = perm[i];
        perm[i] = temp;
    }
}

int main()
{
    int n;
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    // Initialize global array with 1 to n
    for (int i = 0; i < n; i++)
    {
        perm[i] = i + 1;
    }

    permute(0, n);
    return 0;
}