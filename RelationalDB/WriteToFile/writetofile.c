#include <stdio.h>
#include <string.h>

typedef struct {
    char name[50];
    int age;
    float salary;
} Employee;

int main() {
    Employee e1, e2, e3;
    // e1
    strcpy(e1.name, "John");
    e1.age = 30;
    e1.salary = 10000;
    // e2
    strcpy(e2.name, "Alex");
    e2.age = 25;
    e2.salary = 12000;
    // e3
    strcpy(e3.name, "Steve");
    e3.age = 35;
    e3.salary = 15000;

    // write employees (plaintext) to file employee.txt
    FILE* fp = fopen("employee.txt", "w");
    if (fp == NULL) {
        printf("Error opening file!\n");
        return 0;
    }
    fprintf(fp, "%s %d %f\n", e1.name, e1.age, e1.salary);
    fprintf(fp, "%s %d %f\n", e2.name, e2.age, e2.salary);
    fprintf(fp, "%s %d %f\n", e3.name, e3.age, e3.salary);
    fclose(fp);

    // read employees (plaintext) from file employee.txt
    FILE* fp2 = fopen("employee.txt", "r");
    if (fp2 == NULL) {
        printf("Error opening file!\n");
        return 0;
    }
    char name[50];
    int age;
    float salary;

    fscanf(fp2, "%s %d %f\n", name, &age, &salary);
    printf("%s %d %f\n", name, age, salary);
    fscanf(fp2, "%s %d %f\n", name, &age, &salary);
    printf("%s %d %f\n", name, age, salary);
    fscanf(fp2, "%s %d %f\n", name, &age, &salary);
    printf("%s %d %f\n", name, age, salary);
    fclose(fp2);

    return 0;
}