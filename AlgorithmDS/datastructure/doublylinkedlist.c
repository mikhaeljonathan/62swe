// Doubly linked list implementation in C
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// doubly linked list
struct Node {
    int data;
    struct Node* prev;
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

    // copy arr to linked list
    struct Node* head = NULL;
    struct Node* tail = NULL;
    for (int i = 0; i < SIZE; i++) {
        struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
        temp->data = arr[i];
        temp->prev = NULL;
        temp->next = NULL;
        if (head == NULL) {
            head = temp;
            tail = temp;
        } else {
            tail->next = temp;
            temp->prev = tail;
            tail = tail->next;
        }
    }

    // print the content of linked list
    struct Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");

    // insert a data at the end of linked list
    int data = rand() % 100;
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
    new_node->data = data;
    new_node->prev = NULL;
    new_node->next = NULL;
    tail->next = new_node;
    new_node->prev = tail;
    tail = tail->next;

    // insert a data in the middle of linked list
    data = rand() % 100;
    new_node = (struct Node*)malloc(sizeof(struct Node));
    new_node->data = data;
    new_node->prev = NULL;
    new_node->next = NULL;
    temp = head;
    while (temp->next->data < data) {
        temp = temp->next;
    }
    new_node->next = temp->next;
    new_node->prev = temp;
    temp->next = new_node;
    temp->next->prev = new_node;

    // delete a data in the middle of doubly linked list
    data = rand() % 100;
    temp = head;
    while (temp->next->data != data) {
        temp = temp->next;
    }
    temp->next = temp->next->next;
    temp->next->prev = temp;

    return 0;
}