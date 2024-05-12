#include <stdio.h>

int main() {
    int a = 5;
    double b = 2.5;
    double result;

    // Implicit conversion from int to double
    result = a + b;

    printf("The result is: %f\n", result);

    // Implicit conversion from double to int (information loss)
    int sum = a + b;

    printf("The sum is: %d\n", sum);

    return 0;
}
