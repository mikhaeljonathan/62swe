// B-Tree implementation in C

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX 3
#define MIN 2

struct BTreeNode {
    int val[MAX + 1], count;
    struct BTreeNode* link[MAX + 1];
};

struct BTreeNode* root;

// Create a node

struct BTreeNode* createNode(int val, struct BTreeNode* child) {
    struct BTreeNode* newNode;
    newNode = (struct BTreeNode*)malloc(sizeof(struct BTreeNode));
    newNode->val[1] = val;
    newNode->count = 1;
    newNode->link[0] = root;
    newNode->link[1] = child;
    return newNode;
}

// Insert node

void insertNode(int val, int pos, struct BTreeNode* node,
    struct BTreeNode* child) {
    int j = node->count;
    while (j > pos) {
        node->val[j + 1] = node->val[j];
        node->link[j + 1] = node->link[j];
        j--;
    }
    node->val[j + 1] = val;
    node->link[j + 1] = child;
    node->count++;
}

// Split node

void splitNode(int val, int* pval, int pos, struct BTreeNode* node,
    struct BTreeNode* child, struct BTreeNode** newNode) {
    int median, j;

    if (pos > MIN)
        median = MIN + 1;
    else
        median = MIN;

    *newNode = (struct BTreeNode*)malloc(sizeof(struct BTreeNode));
    j = median + 1;
    while (j <= MAX) {
        (*newNode)->val[j - median] = node->val[j];
        (*newNode)->link[j - median] = node->link[j];
        j++;
    }
    node->count = median;
    (*newNode)->count = MAX - median;

    if (pos <= MIN) {
        insertNode(val, pos, node, child);
    } else {
        insertNode(val, pos - median, *newNode, child);
    }
    *pval = node->val[node->count];
    (*newNode)->link[0] = node->link[node->count];
    node->count--;
}

// Set the value

int setValue(int val, int* pval,
    struct BTreeNode* node, struct BTreeNode** child) {
    int pos;
    if (!node) {
        *pval = val;
        *child = NULL;
        return 1;
    }

    if (val < node->val[1]) {
        pos = 0;
    } else {
        for (pos = node->count;
            (val < node->val[pos] && pos > 1); pos--)
            ;
        if (val == node->val[pos]) {
            printf("Duplicates not allowed\n");
            return 0;
        }
    }
    if (setValue(val, pval, node->link[pos], child)) {
        if (node->count < MAX) {
            insertNode(*pval, pos, node, *child);
        } else {
            splitNode(*pval, pval, pos, node, *child, child);
            return 1;
        }
    }
    return 0;
}

// Insert the value

void insertion(int val) {
    int flag, i;
    struct BTreeNode* child;

    flag = setValue(val, &i, root, &child);
    if (flag)
        root = createNode(i, child);
}

// Copy the successor

void copySuccessor(struct BTreeNode* myNode, int pos) {
    struct BTreeNode* dummy;
    dummy = myNode->link[pos];

    for (; dummy->link[0] != NULL;)
        dummy = dummy->link[0];
    myNode->val[pos] = dummy->val[1];
}

// Remove the value

void removeVal(struct BTreeNode* myNode, int pos) {
    int i = pos + 1;
    while (i <= myNode->count) {
        myNode->val[i - 1] = myNode->val[i];
        myNode->link[i - 1] = myNode->link[i];
        i++;
    }
    myNode->count--;
}

// Do right shift

void rightShift(struct BTreeNode* myNode, int pos) {
    struct BTreeNode* x = myNode->link[pos];
    int j = x->count;

    while (j > 0) {
        x->val[j + 1] = x->val[j];
        x->link[j + 1] = x->link[j];
    }
    x->val[1] = myNode->val[pos];
    x->link[1] = x->link[0];
    x->count++;

    x = myNode->link[pos - 1];
    myNode->val[pos] = x->val[x->count];
    myNode->link[pos] = x->link[x->count];
    x->count--;
    return;
}

// Do left shift

void leftShift(struct BTreeNode* myNode, int pos) {
    int j = 1;
    struct BTreeNode* x = myNode->link[pos - 1];

    x->count++;
    x->val[x->count] = myNode->val[pos];
    x->link[x->count] = myNode->link[pos]->link[0];

    x = myNode->link[pos];
    myNode->val[pos] = x->val[1];
    x->link[0] = x->link[1];
    x->count--;

    while (j <= x->count) {
        x->val[j] = x->val[j + 1];
        x->link[j] = x->link[j + 1];
        j++;
    }
    return;
}

// Merge the nodes

void mergeNodes(struct BTreeNode* myNode, int pos) {
    int j = 1;
    struct BTreeNode* x1 = myNode->link[pos], * x2 = myNode->link[pos - 1];

    x2->count++;
    x2->val[x2->count] = myNode->val[pos];
    x2->link[x2->count] = myNode->link[0];

    while (j <= x1->count) {
        x2->count++;
        x2->val[x2->count] = x1->val[j];
        x2->link[x2->count] = x1->link[j];
        j++;
    }

    j = pos;
    while (j < myNode->count) {
        myNode->val[j] = myNode->val[j + 1];
        myNode->link[j] = myNode->link[j + 1];
        j++;
    }
    myNode->count--;
    free(x1);
}

// Adjust the node

void adjustNode(struct BTreeNode* myNode, int pos) {
    if (!pos) {
        if (myNode->link[1]->count > MIN) {
            leftShift(myNode, 1);
        } else {
            mergeNodes(myNode, 1);
        }
    } else {
        if (myNode->count != pos) {
            if (myNode->link[pos - 1]->count > MIN) {
                rightShift(myNode, pos);
            } else {
                if (myNode->link[pos + 1]->count > MIN) {
                    leftShift(myNode, pos + 1);
                } else {
                    mergeNodes(myNode, pos);
                }
            }
        } else {
            if (myNode->link[pos - 1]->count > MIN)
                rightShift(myNode, pos);
            else
                mergeNodes(myNode, pos);
        }
    }
}

// Delete the value

int delValFromNode(int val, struct BTreeNode* myNode) {
    int pos, flag = 0;
    if (myNode) {
        if (val < myNode->val[1]) {
            pos = 0;
            flag = 0;
        } else {
            for (pos = myNode->count;
                (val < myNode->val[pos] && pos > 1); pos--)
                ;
            if (val == myNode->val[pos]) {
                flag = 1;
            } else {
                flag = 0;
            }
        }
        if (flag) {
            if (myNode->link[pos - 1]) {
                copySuccessor(myNode, pos);
                flag = delValFromNode(myNode->val[pos], myNode->link[pos]);
                if (flag == 0) {
                    printf("Given data is not present in B-Tree\n");
                }
            } else {
                removeVal(myNode, pos);
            }
        } else {
            flag = delValFromNode(val, myNode->link[pos]);
        }
        if (myNode->link[pos]) {
            if (myNode->link[pos]->count < MIN)
                adjustNode(myNode, pos);
        }
    }
    return flag;
}

// Delete the value

void deletion(int val, struct BTreeNode* myNode) {
    struct BTreeNode* tmp;
    if (!delValFromNode(val, myNode)) {
        printf("Given value is not present in B-Tree\n");
        return;
    } else {
        if (myNode->count == 0) {
            tmp = myNode;
            myNode = myNode->link[0];
            free(tmp);
        }
    }
    root = myNode;
    return;
}

// Search node

void searching(int val, int* pos, struct BTreeNode* myNode) {
    if (!myNode) {
        return;
    }

    if (val < myNode->val[1]) {
        *pos = 0;
    } else {
        for (*pos = myNode->count;
            (val < myNode->val[*pos] && *pos > 1); (*pos)--)
            ;
        if (val == myNode->val[*pos]) {
            printf("Given data %d is present in B-Tree", val);
            return;
        }
    }
    searching(val, pos, myNode->link[*pos]);
    return;
}

// Traversal

void traversal(struct BTreeNode* myNode) {
    int i;
    if (myNode) {
        for (i = 0; i < myNode->count; i++) {
            traversal(myNode->link[i]);
            printf("%d ", myNode->val[i + 1]);
        }
        traversal(myNode->link[i]);
    }
}

int main() {
    int val, ch;
    int i;
    root = NULL;
    srand(time(0));
    for (i = 0; i < 10; i++) {
        val = rand() % 100 + 1;
        insertion(val);
    }

    printf("Traversal of tree\n");
    traversal(root);

    printf("\n\nEnter the value which you want to search: ");
    scanf("%d", &val);
    searching(val, &i, root);

    printf("\n\nEnter the value which you want to insert: ");
    scanf("%d", &val);
    insertion(val);

    printf("\nTraversal of tree\n");
    traversal(root);

    printf("\n\nEnter the value which you want to delete: ");
    scanf("%d", &val);
    deletion(val, root);

    printf("\nTraversal of tree\n");
    traversal(root);
    printf("\n");
    return 0;
}

// Output
// Traversal of tree
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
//
// Enter the value which you want to search: 5
// Given data 5 is present in B-Tree
//
// Enter the value which you want to insert: 16
//