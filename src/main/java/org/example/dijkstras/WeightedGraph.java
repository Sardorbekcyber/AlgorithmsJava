package org.example.dijkstras;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {
    ArrayList<WeightedNode> nodeList;

    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

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
