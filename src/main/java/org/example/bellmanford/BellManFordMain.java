package org.example.bellmanford;

import org.example.dijkstras.WeightedGraph;
import org.example.dijkstras.WeightedNode;

import java.util.ArrayList;

public class BellManFordMain {

    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();

        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));
        nodeList.add(new WeightedNode("F", 5));
        nodeList.add(new WeightedNode("G", 6));

        WeightedGraph weightedGraph = new WeightedGraph(nodeList);

        weightedGraph.addWeightedEdge(0, 1, 2);
        weightedGraph.addWeightedEdge(0, 2, 5);
        weightedGraph.addWeightedEdge(1, 2, 6);
        weightedGraph.addWeightedEdge(1, 3, 1);
        weightedGraph.addWeightedEdge(1, 4, 3);
        weightedGraph.addWeightedEdge(2, 5, 8);
        weightedGraph.addWeightedEdge(2, 4, 4);
        weightedGraph.addWeightedEdge(4, 6, 9);
        weightedGraph.addWeightedEdge(5, 6, 7);

        System.out.println("Printing BellMan Ford from source: A");
        weightedGraph.bellmanFord(nodeList.get(0));
    }

}
