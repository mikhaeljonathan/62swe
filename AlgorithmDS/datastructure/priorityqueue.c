// Priority queue implementation in C
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct Node {
    int data;
    int priority;
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

    // copy arr to priority queue
    struct Node* head = NULL;
    struct Node* tail = NULL;
    for (int i = 0; i < SIZE; i++) {
        struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
        temp->data = arr[i];
        temp->priority = rand() % 100;
        temp->next = NULL;
        if (head == NULL) {
            head = temp;
            tail = temp;
        } else {
            struct Node* curr = head;
            struct Node* prev = NULL;
            while (curr != NULL && curr->priority > temp->priority) {
                prev = curr;
                curr = curr->next;
            }
            if (prev == NULL) {
                temp->next = head;
                head = temp;
            } else {
                temp->next = curr;
                prev->next = temp;
            }
        }
    }

    // print the content of the priority queue
    struct Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");

    // enqueue
    int data = rand() % 100;
    int priority = rand() % 100;
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
    new_node->data = data;
    new_node->priority = priority;
    new_node->next = NULL;
    if (head == NULL) {
        head = new_node;
        tail = new_node;
    } else {
        struct Node* curr = head;
        struct Node* prev = NULL;
        while (curr != NULL && curr->priority > new_node->priority) {
            prev = curr;
            curr = curr->next;
        }
        if (prev == NULL) {
            new_node->next = head;
            head = new_node;
        } else {
            new_node->next = curr;
            prev->next = new_node;
        }
    }

    // dequeue
    temp = head;
    head = head->next;
    free(temp);

    return 0;
}