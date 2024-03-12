// BFS and DFS implementation in C
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX 100

// Queue
int queue[MAX];
int rear = -1;
int front = 0;
int queueItemCount = 0;

// Queue functions
void insert(int data);
int removeData();
int peek();
bool isQueueEmpty();

// Graph
// Adjacency matrix
int adjMatrix[MAX][MAX];
// Vertex count
int vertexCount = 0;
// Visited array to flag the vertex that has been visited
int visited[MAX];

// Functions
void addVertex(int data);
void addEdge(int start, int end);
void displayVertex(int vertexIndex);

// Breadth First Search
void breadthFirstSearch();

// Depth First Search
void depthFirstSearch();

int main() {
    int i, j;

    // Set adjacency matrix to 0
    for (i = 0; i < MAX; i++)
        for (j = 0; j < MAX; j++)
            adjMatrix[i][j] = 0;

    addVertex(1);
    addVertex(2);
    addVertex(3);
    addVertex(4);
    addVertex(5);

    addEdge(1, 2);
    addEdge(1, 3);
    addEdge(2, 4);
    addEdge(3, 4);
    addEdge(4, 5);

    printf("\nDepth First Search: ");
    depthFirstSearch();

    return 0;
}

void addVertex(int data) {
    // Check if vertex count is less than maximum
    if (vertexCount < MAX)
    {
        // Add vertex to the vertex list
        // Set the vertex to visited
        visited[vertexCount] = 0;
        vertexCount++;
    }
}

void addEdge(int start, int end) {
    // Check if vertex count is valid
    if (start < vertexCount && end < vertexCount)
    {
        // Add edge between the 2 vertices
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }
}

void displayVertex(int vertexIndex) {
    printf("%d ", vertexIndex + 1);
}

// Breadth First Search
void breadthFirstSearch() {
    int i, j;

    // Mark the current node as visited and enqueue it
    visited[0] = 1;
    insert(0);
    displayVertex(0);

    while (!isQueueEmpty())
    {
        // Get the first element from the queue
        int currentVertex = removeData();
        // Check adjacent nodes from currentVertex
        for (i = 0; i < vertexCount; i++)
        {
            // Check if there's an adjacent node and if it has been visited
            if (adjMatrix[currentVertex][i] == 1 && visited[i] == 0)
            {
                visited[i] = 1;
                insert(i);
                displayVertex(i);
            }
        }
    }

    // Queue is empty, search is complete, reset the visited flag
    for (i = 0; i < vertexCount; i++)
        visited[i] = 0;
}

// Depth First Search
void depthFirstSearch() {
    int i, j;

    // Mark the current node as visited and enqueue it
    visited[0] = 1;
    displayVertex(0);

    // Get the adjacent node of the current node
    for (i = 0; i < vertexCount; i++)
    {
        // Check if there's an adjacent node and if it has been visited
        if (adjMatrix[0][i] == 1 && visited[i] == 0)
        {
            visited[i] = 1;
            displayVertex(i);
        }
    }

    // Queue is empty, search is complete, reset the visited flag
    for (i = 0; i < vertexCount; i++)
        visited[i] = 0;
}

void insert(int data) {
    queue[++rear] = data;
    queueItemCount++;
}

int removeData() {
    queueItemCount--;
    return queue[front++];
}

int peek() {
    return queue[front];
}

bool isQueueEmpty() {
    return queueItemCount == 0;
}

// Output
// Depth First Search: 1 2 4 3 5
