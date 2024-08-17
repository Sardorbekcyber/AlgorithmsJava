package org.example.yandex.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TestContest5 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        //A-1, B-2
        String[] recipes = new String[count - 2];
        for (int i = 0; i < recipes.length; i++) {
            recipes[i] = reader.readLine();
        }
        HashMap<Integer, String> map = new HashMap<>();

        for (int j=0; j<recipes.length; j++) {
            String recipe = recipes[j];
            String[] values = recipe.split(" ");
            HashMap<String, Integer> ing = new HashMap<>();
            for (int k=1; k<values.length; k++) {
                String value = values[k];
                ing.merge(value, 1, Integer::sum);
            }
            map.put(j+3, "");
        }

        int r = Integer.parseInt(reader.readLine());
        String[] requests = new String[r];
        for (int j = 0; j < requests.length; j++) {
            requests[j] = reader.readLine();
        }

    }

}
