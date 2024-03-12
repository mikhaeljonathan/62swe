// Hash table implementation in C
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>


struct Node {
    char* key;
    char* value;
    struct Node* next;
};

struct HashTable {
    int size;
    struct Node** table; // array of pointers to Node
};

struct HashTable* createHashTable(int size) {
    struct HashTable* hashTable = (struct HashTable*)malloc(sizeof(struct HashTable));
    hashTable->size = size;
    hashTable->table = (struct Node**)malloc(sizeof(struct Node*) * size);
    for (int i = 0; i < size; i++) {
        hashTable->table[i] = NULL;
    }
    return hashTable;
}

int hash(struct HashTable* hashTable, char* key) {
    int hash = 0;
    for (int i = 0; i < strlen(key); i++) {
        hash = ((hash * 31) + key[i]) % hashTable->size;
    }
    return hash % hashTable->size;
}

void insert(struct HashTable* hashTable, char* key, char* value) {
    int index = hash(hashTable, key);
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->key = key;
    newNode->value = value;
    newNode->next = NULL;
    if (hashTable->table[index] == NULL) {
        hashTable->table[index] = newNode;
    } else {
        struct Node* temp = hashTable->table[index];
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newNode;
    }
}

char* search(struct HashTable* hashTable, char* key) {
    int index = hash(hashTable, key);
    struct Node* temp = hashTable->table[index];
    while (temp != NULL) {
        if (strcmp(temp->key, key) == 0) {
            return temp->value;
        }
        temp = temp->next;
    }
    return NULL;
}

void delete(struct HashTable* hashTable, char* key) {
    int index = hash(hashTable, key);
    struct Node* temp = hashTable->table[index];
    if (temp != NULL) {
        if (strcmp(temp->key, key) == 0) {
            hashTable->table[index] = temp->next;
            free(temp);
        } else {
            while (temp->next != NULL) {
                if (strcmp(temp->next->key, key) == 0) {
                    struct Node* deletedNode = temp->next;
                    temp->next = temp->next->next;
                    free(deletedNode);
                    return;
                }
                temp = temp->next;
            }
        }
    }
}

void printHashTable(struct HashTable* hashTable) {
    for (int i = 0; i < hashTable->size; i++) {
        struct Node* temp = hashTable->table[i];
        printf("%d: ", i);
        while (temp != NULL) {
            printf("%s ", temp->value);
            temp = temp->next;
        }
        printf("\n");
    }
}

int main() {
    srand(time(NULL));

    const int SIZE = 10;

    // phone book
    char* names[SIZE] = { "John", "Jane", "Bob", "Alice", "Jack", "Jill", "James", "Jenny", "Joe", "Jade" };
    char* numbers[SIZE] = { "1234567890", "1234567891", "1234567892", "1234567893", "1234567894", "1234567895", "1234567896", "1234567897", "1234567898", "1234567899" };

    // create hash table
    struct HashTable* hashTable = createHashTable(SIZE);
    insert(hashTable, names[0], numbers[0]);
    insert(hashTable, names[1], numbers[1]);
    insert(hashTable, names[2], numbers[2]);
    insert(hashTable, names[3], numbers[3]);
    insert(hashTable, names[4], numbers[4]);
    insert(hashTable, names[5], numbers[5]);
    insert(hashTable, names[6], numbers[6]);
    insert(hashTable, names[7], numbers[7]);
    insert(hashTable, names[8], numbers[8]);
    insert(hashTable, names[9], numbers[9]);

    return 0;
}