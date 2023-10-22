package org.example.tree.binaryHeap;



public class BinaryHeapMain {

    public static void main(String[] args) {
        BinaryHeap newBp = new BinaryHeap(5);
        newBp.insert(10, "Min");
        newBp.insert(5, "Min");
        newBp.insert(15, "Min");
        newBp.insert(1, "Min");

        newBp.levelOrder();
    }

}
