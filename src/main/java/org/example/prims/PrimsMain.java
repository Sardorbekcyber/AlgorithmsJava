package org.example.prims;

import org.example.dijkstras.WeightedNode;
import org.example.kruskal.Kruskal;

import java.util.ArrayList;

public class PrimsMain {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();

        nodeList.add(new WeightedNode("A"));
        nodeList.add(new WeightedNode("B"));
        nodeList.add(new WeightedNode("C"));
        nodeList.add(new WeightedNode("D"));
        nodeList.add(new WeightedNode("E"));

        Prims graph = new Prims(nodeList);

        graph.addWeightedUndirectedEdge(0, 1, 5);
        graph.addWeightedUndirectedEdge(0, 2, 13);
        graph.addWeightedUndirectedEdge(0, 4, 15);
        graph.addWeightedUndirectedEdge(1, 2, 10);
        graph.addWeightedUndirectedEdge(1, 3, 8);
        graph.addWeightedUndirectedEdge(2, 3, 6);
        graph.addWeightedUndirectedEdge(2, 4, 20);

        System.out.println("Running Prims Algo on the graph");

        graph.prims(nodeList.get(4));
    }

}
