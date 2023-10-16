package org.example.tree;

import com.sun.source.tree.Tree;

public class TreeNodeMain {

    public static void main(String[] args) {
        TreeNode drinks = new TreeNode("Drinks");

        TreeNode hot = new TreeNode("Hot");
        TreeNode cold = new TreeNode("Cold");

        drinks.addChild(hot);
        drinks.addChild(cold);

        TreeNode coffee = new TreeNode("Coffee");
        TreeNode tea = new TreeNode("Tea");

        hot.addChild(coffee);
        hot.addChild(tea);

        TreeNode juice = new TreeNode("Juice");
        TreeNode water = new TreeNode("Water");

        cold.addChild(juice);
        cold.addChild(water);

        System.out.println(drinks.print(0));
    }

}
