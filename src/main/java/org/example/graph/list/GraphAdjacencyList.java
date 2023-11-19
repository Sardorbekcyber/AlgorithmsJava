package org.example.graph.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public void addDirectedEdge(int i, int j) {
        GraphListNode first = nodeList.get(i);
        GraphListNode second = nodeList.get(j);

        first.neighbors.add(second);
    }

    void topologicalVisit(GraphListNode node, Stack<GraphListNode> stack) {
        for (GraphListNode neighbour : node.neighbors) {
            if (!neighbour.isVisited) {
                topologicalVisit(neighbour, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    void topologicalSort() {
        Stack<GraphListNode> stack = new Stack<>();
        for (GraphListNode node : nodeList) {
            if (!node.isVisited) {
                topologicalVisit(node, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
    }

    //BFS internal
    void bfs(GraphListNode listNode) {
        Queue<GraphListNode> queue = new LinkedList<>();
        queue.add(listNode);

        while (!queue.isEmpty()) {
            GraphListNode current = queue.poll();
            current.isVisited = true;

            System.out.print(current.name + " ");

            for (GraphListNode neighbour : current.neighbors) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    public void bfs() {
        for (GraphListNode listNode : nodeList) {
            if (!listNode.isVisited) {
                bfs(listNode);
            }
        }
    }

    void dfsVisit(GraphListNode node) {
        Stack<GraphListNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            GraphListNode currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for (GraphListNode neighbour : currentNode.neighbors) {
                if (!neighbour.isVisited) {
                    stack.push(neighbour);
                    neighbour.isVisited = true;
                }
            }

        }
    }

    public void dfs() {
        for (GraphListNode graphNode : nodeList) {
            if (!graphNode.isVisited) {
                dfsVisit(graphNode);
            }
        }
    }

    //Single Source Shortest Path Problem
    public void bfsForSingleSourceShortestPath(GraphListNode node) {
        Queue<GraphListNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphListNode current = queue.poll();
            current.isVisited = true;
            System.out.print("Printing path for node " + current.name + ": ");
            pathPrint(current);
            System.out.println();
            for (GraphListNode neighbour: current.neighbors) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = current;
                }
            }
        }
    }

    public static void pathPrint(GraphListNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
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
        nodeList.add(new GraphListNode("F", 5));
        nodeList.add(new GraphListNode("G", 6));

        GraphAdjacencyList graph = new GraphAdjacencyList(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(1, 6);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(3, 5);
        graph.addUndirectedEdge(4, 5);
        graph.addUndirectedEdge(5, 6);

        System.out.println(graph);

        graph.bfsForSingleSourceShortestPath(nodeList.get(0));

        System.out.println();
    }

}
