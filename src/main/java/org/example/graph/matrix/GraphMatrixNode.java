package org.example.graph.matrix;

public class GraphMatrixNode {
    public String name;
    public int index;
    public boolean isVisited = false;
    public GraphMatrixNode parent;

    public GraphMatrixNode(String name, int index) {
        this.name = name;
        this.index = index;
    }

}
