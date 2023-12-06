package org.example.prims;

import org.example.dijkstras.WeightedNode;
import org.example.kruskal.UndirectedEdge;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public Prims(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
        WeightedNode firstNode = edge.first;
        WeightedNode secondNode = edge.second;
        firstNode.neighbours.add(secondNode);
        secondNode.neighbours.add(firstNode);
        firstNode.weighMap.put(secondNode, weight);
        secondNode.weighMap.put(firstNode, weight);
    }

    //Prim's Algorithm
    void prims(WeightedNode node) {
        for (int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).distance = Integer.MAX_VALUE;
        }

        node.distance = 0;
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        queue.addAll(nodeList);
        while (!queue.isEmpty()) {
            WeightedNode current = queue.poll();
            for (WeightedNode neighbour : current.neighbours) {
                if (queue.contains(neighbour)) {
                    if (neighbour.distance > current.weighMap.get(neighbour)) {
                        neighbour.distance = current.weighMap.get(neighbour);
                        neighbour.parent = current;
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }

        int cost = 0;

        for (WeightedNode nodeToCheck : nodeList) {
            System.out.println("Node: " + nodeToCheck + ", key " + nodeToCheck.distance + " Parent: " + nodeToCheck.parent);
            cost = cost + nodeToCheck.distance;
        }

        System.out.println("\nTotal cost of MST: " + cost);
    }

}
