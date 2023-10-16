package org.example.tree;

import java.util.ArrayList;

public class TreeNode {

    private String data;
    private ArrayList<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }


    public String print(int level) {
        StringBuilder ret = new StringBuilder("  ".repeat(level) + data + "\n");
        for (TreeNode node : children) {
            ret.append(node.print(level + 1));
        }
        return ret.toString();
    }
}
