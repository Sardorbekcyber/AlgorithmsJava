package org.example.graph.list;

import java.util.ArrayList;

public class GraphListNode {
    public String name;
    public int index;
    public boolean isVisited = false;

    public ArrayList<GraphListNode> neighbors = new ArrayList<GraphListNode>();

    public GraphListNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
