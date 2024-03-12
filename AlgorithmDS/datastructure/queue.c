// Queue implementation in C
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct Node {
    int data;
    struct Node* next;
};

int main() {
    srand(time(NULL));

    const int SIZE = 5;
    int arr[SIZE];
    // fill arr with random integer
    for (int i = 0; i < SIZE; i++) {
        arr[i] = rand() % 100;
    }

    // copy arr to queue
    struct Node* head = NULL;
    struct Node* tail = NULL;
    for (int i = 0; i < SIZE; i++) {
        struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
        temp->data = arr[i];
        temp->next = NULL;
        if (head == NULL) {
            head = temp;
            tail = temp;
        } else {
            tail->next = temp;
            tail = tail->next;
        }
    }

    // print the content of the queue
    struct Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");

    // enqueue
    int data = rand() % 100;
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
    new_node->data = data;
    new_node->next = NULL;
    tail->next = new_node;
    tail = tail->next;

    // dequeue
    temp = head;
    head = head->next;
    free(temp);

    return 0;
}