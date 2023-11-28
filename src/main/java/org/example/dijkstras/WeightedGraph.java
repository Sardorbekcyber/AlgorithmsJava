package org.example.dijkstras;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {
    ArrayList<WeightedNode> nodeList;

    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    //Dijkstra's Algorithm
    void dijkstra(WeightedNode node) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while (!queue.isEmpty()) {
            WeightedNode current = queue.poll();
            for (WeightedNode neighbour : current.neighbours) {
                if (queue.contains(neighbour)) {
                    if (neighbour.distance > current.distance + current.weighMap.get(neighbour)) {
                        neighbour.distance = current.distance + current.weighMap.get(neighbour);
                        neighbour.parent = current;
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }

        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    //Bellman Ford Algorithm
    public void bellmanFord(WeightedNode sourceNode) {
        sourceNode.distance = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            for (WeightedNode currentNode : nodeList) {
                for (WeightedNode neighbour : currentNode.neighbours) {
                    if (neighbour.distance > currentNode.distance + currentNode.weighMap.get(neighbour)) {
                        neighbour.distance = currentNode.distance + currentNode.weighMap.get(neighbour);
                        neighbour.parent = currentNode;
                    }
                }
            }
        }
        System.out.println("Checking for Negative Cycle...");
        for (WeightedNode currentNode : nodeList) {
            for (WeightedNode neighbour : currentNode.neighbours) {
                if (neighbour.distance > currentNode.distance + currentNode.weighMap.get(neighbour)) {
                    System.out.println("Negative cycle found: \n");
                    System.out.println("Vertex name: " + neighbour.name);
                    System.out.println("Old distance: " + neighbour.distance);
                    int newDistance = currentNode.distance + currentNode.weighMap.get(neighbour);
                    System.out.println("New distance: " + newDistance);
                    return;
                }
            }
        }
        System.out.println("Negative Cycle not found");

        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    //Floyd Warshall Algorithm
    public void floydWarshall() {
        int size = nodeList.size();
        int[][] V = new int[size][size];
        for (int i = 0; i < size; i++) {
            WeightedNode firstNode = nodeList.get(i);
            for (int j = 0; j < size; j++) {
                WeightedNode second = nodeList.get(j);
                if (i == j) {
                    V[i][j] = 0;
                } else if (firstNode.weighMap.containsKey(second)) {
                    V[i][j] = firstNode.weighMap.get(second);
                } else {
                    V[i][j] = Integer.MAX_VALUE / 10;
                }
            }
        }

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (V[i][j] > V[i][k] + V[k][j]) {
                        V[i][j] = V[i][k] + V[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print("Printing distance list for Node " + nodeList.get(i) + ": ");
            for (int j = 0; j < size; j++) {
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void pathPrint(WeightedNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    public void addWeightedEdge(int start, int end, int weight) {
        WeightedNode first = nodeList.get(start);
        WeightedNode second = nodeList.get(end);

        first.neighbours.add(second);
        first.weighMap.put(second, weight);
    }

}
