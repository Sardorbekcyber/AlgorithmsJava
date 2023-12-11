package org.example.greedy.knapsack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String[] args) {
        ArrayList<KnapsackItem> items = new ArrayList<>();
        int[] value = {100, 120, 60};
        int[] weight = {20, 30, 10};
        int capacity = 50;
        for (int i = 0; i < value.length; i++) {
            items.add(new KnapsackItem(i + 1, value[i], weight[i]));
        }

        FractionalKnapsack.knapsack(items, capacity);
    }

    static void knapsack(ArrayList<KnapsackItem> items, int capacity) {
        Comparator<KnapsackItem> comparator = new Comparator<KnapsackItem>() {
            @Override
            public int compare(KnapsackItem o1, KnapsackItem o2) {
                if (o2.getRatio() > o1.getRatio()) {
                    return 1;
                } else return -1;
            }
        };

        Collections.sort(items, comparator);

        int usedCapacity = 0;
        double totalValue = 0;
        for (KnapsackItem item : items) {
            if (usedCapacity + item.getWeight() <= capacity) {
                usedCapacity += item.getWeight();
                System.out.println("Taken " + item);
                totalValue += item.getValue();
            } else {
                int usedWeight = capacity - usedCapacity;
                double value = item.getRatio() * usedWeight;
                System.out.println("Taken: item index = " + item.getIndex() + ", obtained value = " + value +
                        ", used weight = " + usedWeight + ", ratio = " + item.getRatio());
                usedCapacity += usedWeight;
                totalValue += value;
            }

            if (usedCapacity == capacity) break;
        }

        System.out.println("\nTotal value obtained " + totalValue);
    }
}
