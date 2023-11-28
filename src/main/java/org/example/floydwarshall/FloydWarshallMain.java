package org.example.floydwarshall;

import org.example.dijkstras.WeightedGraph;
import org.example.dijkstras.WeightedNode;

import java.util.ArrayList;

public class FloydWarshallMain {

    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();

        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));

        WeightedGraph newGraph = new WeightedGraph(nodeList);

        newGraph.addWeightedEdge(0, 3, 1);
        newGraph.addWeightedEdge(0, 1, 8);
        newGraph.addWeightedEdge(1, 2, 1);
        newGraph.addWeightedEdge(2, 0, 4);
        newGraph.addWeightedEdge(3, 1, 2);
        newGraph.addWeightedEdge(3, 2, 9);

        newGraph.floydWarshall();
    }

}
