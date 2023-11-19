package org.example.graph.matrix;

import org.example.graph.list.GraphAdjacencyList;
import org.example.graph.list.GraphListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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

    public void addDirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
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

    void topologicalVisit(GraphMatrixNode node, Stack<GraphMatrixNode> stack) {
        ArrayList<GraphMatrixNode> neighbours = getNeighbours(node);

        for (GraphMatrixNode neighbour : neighbours) {
            if (!neighbour.isVisited) {
                topologicalVisit(neighbour, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    public void topologicalSort() {
        Stack<GraphMatrixNode> stack = new Stack<>();

        for (GraphMatrixNode node : nodeList) {
            if (!node.isVisited) {
                topologicalVisit(node, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
    }

    //Single Source Shortest Path Problem
    public void bfsForSingleSourceShortestPath(GraphMatrixNode node) {
        Queue<GraphMatrixNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphMatrixNode current = queue.poll();
            current.isVisited = true;
            System.out.print("Printing path for ndoe " + current.name + ": ");
            pathPrint(current);
            System.out.println();
            ArrayList<GraphMatrixNode> neighbours = getNeighbours(current);
            for (GraphMatrixNode neighbour: neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = current;
                }
            }
        }
    }

    public static void pathPrint(GraphMatrixNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
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
        nodeList.add(new GraphMatrixNode("F", 5));
        nodeList.add(new GraphMatrixNode("G", 6));

        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(1, 6);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(3, 5);
        graph.addUndirectedEdge(4, 5);
        graph.addUndirectedEdge(5, 6);

        System.out.println(graph);

        graph.bfsForSingleSourceShortestPath(nodeList.get(0));

        System.out.println();
    }

}
