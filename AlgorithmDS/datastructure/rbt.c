// Red black tree implementation in C

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct Node {
    int data;
    struct Node* left;
    struct Node* right;
    int color;
};

struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    newNode->color = 1;
    return newNode;
}

struct Node* bstInsert(struct Node* root, int data) {
    if (root == NULL) {
        return createNode(data);
    }
    if (data < root->data) {
        root->left = bstInsert(root->left, data);
    } else if (data > root->data) {
        root->right = bstInsert(root->right, data);
    }
    return root;
}


struct Node* rightRotate(struct Node* root) {
    struct Node* newRoot = root->left;
    struct Node* temp = newRoot->right;
    newRoot->right = root;
    root->left = temp;
    return newRoot;
}


struct Node* leftRotate(struct Node* root) {
    struct Node* newRoot = root->right;
    struct Node* temp = newRoot->left;
    newRoot->left = root;
    root->right = temp;
    return newRoot;
}


struct Node* insert(struct Node* root, int data) {
    if (root == NULL) {
        return createNode(data);
    }
    if (data < root->data) {
        root->left = insert(root->left, data);
    } else if (data > root->data) {
        root->right = insert(root->right, data);
    } else {
        return root;
    }
    if (root->left == NULL || root->right == NULL) {
        return root;
    }
    if (root->left->color == 0 && root->right->color == 0) {
        if (root->left->left != NULL && root->left->left->color == 0) {
            root->left->color = 1;
            root->left->left->color = 1;
            root->color = 0;
            return root;
        }
        if (root->left->right != NULL && root->left->right->color == 0) {
            root->left->color = 1;
            root->left->right->color = 1;
            root->color = 0;
            return root;
        }
        if (root->right->left != NULL && root->right->left->color == 0) {
            root->right->color = 1;
            root->right->left->color = 1;
            root->color = 0;
            return root;
        }
        if (root->right->right != NULL && root->right->right->color == 0) {
            root->right->color = 1;
            root->right->right->color = 1;
            root->color = 0;
            return root;
        }
    }
    if (root->left->color == 0) {
        if (root->left->left != NULL && root->left->left->color == 0) {
            root->left = rightRotate(root->left);
            root->left->color = 1;
            root->color = 0;
            return root;
        }
        if (root->left->right != NULL && root->left->right->color == 0) {
            root->left->right = rightRotate(root->left->right);
            root->left->right->color = 1;
            root->left->color = 0;

            root->left = leftRotate(root->left);
            root->left->color = 1;
            root->color = 0;
            return root;
        }
    }
    if (root->right->color == 0) {
        if (root->right->left != NULL && root->right->left->color == 0) {
            root->right->left = leftRotate(root->right->left);
            root->right->left->color = 1;
            root->right->color = 0;

            root->right = rightRotate(root->right);
            root->right->color = 1;
            root->color = 0;
            return root;
        }
        if (root->right->right != NULL && root->right->right->color == 0) {
            root->right = leftRotate(root->right);
            root->right->color = 1;
            root->color = 0;
            return root;
        }
    }
    return root;
}


void printInorder(struct Node* root) {
    if (root == NULL) {
        return;
    }
    printInorder(root->left);
    printf("%d ", root->data);
    printInorder(root->right);
}

int main() {
    struct Node* root = NULL;
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter %d nodes: ", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        root = insert(root, arr[i]);
    }
    printf("Inorder traversal of the constructed tree is: ");
    printInorder(root);
    printf("\n");
    return 0;
}