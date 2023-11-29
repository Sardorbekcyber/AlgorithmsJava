package org.example.disjointset;

import org.example.dijkstras.WeightedNode;

import java.util.ArrayList;

public class DisjointSetMain {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();

        nodeList.add(new WeightedNode("A"));
        nodeList.add(new WeightedNode("B"));
        nodeList.add(new WeightedNode("C"));
        nodeList.add(new WeightedNode("D"));

        DisjointSet.makeSet(nodeList);
        WeightedNode firstNode = nodeList.get(0);
        WeightedNode secondNode = nodeList.get(1);

        DisjointSet output = DisjointSet.findSet(secondNode);
        output.printAllNodesOfSet();

        DisjointSet.union(firstNode, secondNode);

        output = DisjointSet.findSet(secondNode);
        output.printAllNodesOfSet();
    }

}
