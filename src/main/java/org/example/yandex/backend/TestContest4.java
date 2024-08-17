package org.example.yandex.backend;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestContest4 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        try {
            count = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println(e);
        }

        String[] inputs = new String[count];
        for (int i = 0; i < count; i++) {
            try {
                inputs[i] = reader.readLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        Order[] orders = new Order[count];
        int j = 0;
        for (String input : inputs) {
            String[] values = input.split(" ");
            int start = Integer.parseInt(values[0]);
            int end = Integer.parseInt(values[1]);
            int cost = Integer.parseInt(values[2]);

            Order order = new Order();
            order.start = start;
            order.end = end;
            order.cost = cost;
            orders[j] = order;
            j++;
        }


        int requestC = 0;
        try {
            requestC = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println(e);
        }

        String[] requests = new String[requestC];
        for (int k = 0; k < requestC; k++) {
            try {
                requests[k] = reader.readLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        StringBuilder res = new StringBuilder();

        for (String request: requests) {
            String[] rValues = request.split(" ");
            int type = Integer.parseInt(rValues[2]);
            int start = Integer.parseInt(rValues[0]);
            int end = Integer.parseInt(rValues[1]);
            int sum = 0;
            for (Order order: orders) {
                if (type == 2) {
                    if (order.end >= start && order.end <= end) {
                        sum += order.end - order.start;
                    }
                } else {
                    if (order.start >= start && order.start <= end) {
                        sum += order.cost;
                    }
                }
            }

            if (res.isEmpty()) {
                res.append(sum);
            } else {
                res.append(" ");
                res.append(sum);
            }
        }
        System.out.println(res);
    }

}

class Order {
    int start;
    int end;
    int cost;

    public Order() {

    }

}
