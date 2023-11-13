package org.example.graph.list;

import org.example.graph.matrix.GraphMatrixNode;

import java.util.ArrayList;

public class GraphAdjacencyList {
    public ArrayList<GraphListNode> nodeList;

    public GraphAdjacencyList(ArrayList<GraphListNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphListNode first = nodeList.get(i);
        GraphListNode second = nodeList.get(j);

        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
                if (j == nodeList.get(i).neighbors.size() - 1) {
                    s.append((nodeList.get(i).neighbors.get(j).name));
                } else {
                    s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        ArrayList<GraphListNode> nodeList = new ArrayList<>();

        nodeList.add(new GraphListNode("A", 0));
        nodeList.add(new GraphListNode("B", 1));
        nodeList.add(new GraphListNode("C", 2));
        nodeList.add(new GraphListNode("D", 3));
        nodeList.add(new GraphListNode("E", 4));

        GraphAdjacencyList graph = new GraphAdjacencyList(nodeList);
        graph.addUndirectedEdge(0,1);
        graph.addUndirectedEdge(0,2);
        graph.addUndirectedEdge(0,3);
        graph.addUndirectedEdge(1,4);
        graph.addUndirectedEdge(2,3);
        graph.addUndirectedEdge(3,4);

        System.out.println(graph);
    }

}
