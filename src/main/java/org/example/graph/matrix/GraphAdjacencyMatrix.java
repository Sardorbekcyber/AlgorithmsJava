package org.example.graph.matrix;

import java.util.ArrayList;

public class GraphAdjacencyMatrix {
    ArrayList<GraphMatrixNode> nodeList = new ArrayList<>();
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
    }

}
