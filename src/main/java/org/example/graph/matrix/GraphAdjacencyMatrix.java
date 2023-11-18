package org.example.graph.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjacencyMatrix {
    ArrayList<GraphMatrixNode> nodeList;
    int[][] adjacencyMatrix;

    public GraphAdjacencyMatrix(ArrayList<GraphMatrixNode> nodeList) {
        this.nodeList = nodeList;
        int size = nodeList.size();
        adjacencyMatrix = new int[size][size];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public ArrayList<GraphMatrixNode> getNeighbours(GraphMatrixNode matrixNode) {
        ArrayList<GraphMatrixNode> neighbours = new ArrayList<>();
        int nodeIndex = matrixNode.index;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1) {
                neighbours.add(nodeList.get(i));
            }
        }

        return neighbours;
    }

    //BFS internal
    void bfsVisit(GraphMatrixNode matrixNode) {
        LinkedList<GraphMatrixNode> queue = new LinkedList<>();
        queue.add(matrixNode);

        while (!queue.isEmpty()) {
            GraphMatrixNode current = queue.poll();
            current.isVisited = true;
            System.out.print(current.name + " ");
            ArrayList<GraphMatrixNode> neighbours = getNeighbours(current);
            for (GraphMatrixNode neighbour : neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    public void bfs() {
        for (GraphMatrixNode node : nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    void dfsVisit(GraphMatrixNode node) {
        Stack<GraphMatrixNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            GraphMatrixNode currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphMatrixNode> neighbours = getNeighbours(currentNode);
            for (GraphMatrixNode neighbour : neighbours) {
                if (!neighbour.isVisited) {
                    stack.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    public void dfs() {
        for (GraphMatrixNode node : nodeList) {
            if (!node.isVisited) {
                dfsVisit(node);
            }
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        ArrayList<GraphMatrixNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphMatrixNode("A", 0));
        nodeList.add(new GraphMatrixNode("B", 1));
        nodeList.add(new GraphMatrixNode("C", 2));
        nodeList.add(new GraphMatrixNode("D", 3));
        nodeList.add(new GraphMatrixNode("E", 4));

        GraphAdjacencyMatrix graphAdjacencyMatrix = new GraphAdjacencyMatrix(nodeList);

        graphAdjacencyMatrix.addUndirectedEdge(0, 1);
        graphAdjacencyMatrix.addUndirectedEdge(0, 2);
        graphAdjacencyMatrix.addUndirectedEdge(0, 3);
        graphAdjacencyMatrix.addUndirectedEdge(1, 4);
        graphAdjacencyMatrix.addUndirectedEdge(2, 3);
        graphAdjacencyMatrix.addUndirectedEdge(3, 4);

        System.out.println(graphAdjacencyMatrix);

        graphAdjacencyMatrix.dfs();

        System.out.println();
    }

}
