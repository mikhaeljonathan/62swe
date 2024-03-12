// BST implementation in C
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

void inorder(struct Node* root) {
    if (root != NULL) {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);
    }
}

void preorder(struct Node* root) {
    if (root != NULL) {
        printf("%d ", root->data);
        preorder(root->left);
        preorder(root->right);
    }
}

void postorder(struct Node* root) {
    if (root != NULL) {
        postorder(root->left);
        postorder(root->right);
        printf("%d ", root->data);
    }
}

struct Node* insert(struct Node* root, int data) {
    if (root == NULL) {
        root = createNode(data);
    } else if (data <= root->data) {
        root->left = insert(root->left, data);
    } else {
        root->right = insert(root->right, data);
    }
    return root;
}

int search(struct Node* root, int data) {
    if (root == NULL) {
        return 0;
    } else if (root->data == data) {
        return 1;
    } else if (data <= root->data) {
        return search(root->left, data);
    } else {
        return search(root->right, data);
    }
}

int main() {
    srand(time(NULL));

    const int SIZE = 5;
    int arr[SIZE];
    // fill arr with random integer
    for (int i = 0; i < SIZE; i++) {
        arr[i] = rand() % 100;
    }

    // copy arr to BST
    struct Node* root = NULL;
    for (int i = 0; i < SIZE; i++) {
        root = insert(root, arr[i]);
    }

    // print the content of the BST
    printf("Inorder traversal: ");
    inorder(root);
    printf("\n");
    printf("Preorder traversal: ");
    preorder(root);
    printf("\n");
    printf("Postorder traversal: ");
    postorder(root);
    printf("\n");

    // search
    int data = rand() % 100;
    if (search(root, data)) {
        printf("%d is found\n", data);
    } else {
        printf("%d is not found\n", data);
    }

    return 0;
}
