// AVL tree implementation in C
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct Node {
    int data;
    struct Node* left;
    struct Node* right;
    int height;
};

struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    newNode->height = 1;
    return newNode;
}

int max(int a, int b) {
    return (a > b) ? a : b;
}

int height(struct Node* root) {
    if (root == NULL) {
        return 0;
    }
    return root->height;
}

int getBalance(struct Node* root) {
    if (root == NULL) {
        return 0;
    }
    return height(root->left) - height(root->right);
}

struct Node* rightRotate(struct Node* root) {
    struct Node* newRoot = root->left;
    struct Node* temp = newRoot->right;
    newRoot->right = root;
    root->left = temp;
    root->height = max(height(root->left), height(root->right)) + 1;
    newRoot->height = max(height(newRoot->left), height(newRoot->right)) + 1;
    return newRoot;
}

struct Node* leftRotate(struct Node* root) {
    struct Node* newRoot = root->right;
    struct Node* temp = newRoot->left;
    newRoot->left = root;
    root->right = temp;
    root->height = max(height(root->left), height(root->right)) + 1;
    newRoot->height = max(height(newRoot->left), height(newRoot->right)) + 1;
    return newRoot;
}

struct Node* insert(struct Node* root, int data) {
    if (root == NULL) {
        root = createNode(data);
    } else if (data <= root->data) {
        root->left = insert(root->left, data);
    } else {
        root->right = insert(root->right, data);
    }
    root->height = max(height(root->left), height(root->right)) + 1;
    int balance = getBalance(root);
    if (balance > 1 && data <= root->left->data) {
        return rightRotate(root);
    }
    if (balance < -1 && data > root->right->data) {
        return leftRotate(root);
    }
    if (balance > 1 && data > root->left->data) {
        root->left = leftRotate(root->left);
        return rightRotate(root);
    }
    if (balance < -1 && data <= root->right->data) {
        root->right = rightRotate(root->right);
        return leftRotate(root);
    }
    return root;
}

void inorder(struct Node* root) {
    if (root != NULL) {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);
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

    // copy arr to AVL tree
    struct Node* root = NULL;
    for (int i = 0; i < SIZE; i++) {
        root = insert(root, arr[i]);
    }

    // print the content of the AVL tree
    inorder(root);
    printf("\n");

    // insert
    int data = rand() % 100;
    root = insert(root, data);

    return 0;
}
