package org.example.yandex.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TestContest2 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        try {
            count = Integer.parseInt(reader.readLine());
        } catch (Exception e) {

        }
        String[] inputs = new String[count];
        for (int i=0; i<count; i++) {
            try {
                inputs[i] = reader.readLine();
            } catch (IOException e) {

            }
        }
        //day hour minute id status
        HashMap<Integer,  Long> res = new HashMap<>();
        HashMap<Integer, FlightRecord> map = new HashMap<>();
        PriorityQueue<FlightRecord> queue = new PriorityQueue<>();
        for (String input: inputs) {
            String[] values = input.split(" ");
            int day = Integer.parseInt(values[0]);
            int hour = Integer.parseInt(values[1]);
            int minute = Integer.parseInt(values[2]);
            int rocketId = Integer.parseInt(values[3]);
            String status = values[4];

            FlightRecord record = new FlightRecord();
            record.day = day;
            record.hour = hour;
            record.minute = minute;
            record.rocketId = rocketId;
            record.status = status;

            queue.add(record);
        }

        while (!queue.isEmpty()) {
            FlightRecord rec = queue.poll();
            if (rec.status.equals("A")) {
                map.put(rec.rocketId, rec);
            } else if (rec.status.equals("S") || rec.status.equals("C")){
                FlightRecord prev = map.get(rec.rocketId);
                long flightTime = rec.time() - prev.time();
                res.merge(rec.rocketId, flightTime, Long::sum);
            }
        }
        StringBuilder str = new StringBuilder();
        ArrayList<Integer> keys = new ArrayList<>(res.keySet());
        for (Integer rocketId: keys) {
            if (!str.isEmpty()) {
                str.append(" ");
            }
            str.append(res.get(rocketId));
        }

        System.out.println(str);
    }
}

class FlightRecord implements Comparable<FlightRecord> {
    int day;
    int hour;
    int minute;
    int rocketId;
    String status;

    public FlightRecord() {

    }

    @Override
    public int compareTo(FlightRecord o) {
        int hash = o.day * 1440 + o.hour * 60 + o.minute;
        int cur = day * 1440 + hour * 60 + minute;
        return cur-hash;
    }

    public int time() {
        return day * 1440 + hour * 60 + minute;
    }

    @Override
    public String toString() {
        return "FlightRecord{" +
                "day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", rocketId=" + rocketId +
                ", status='" + status + '\'' +
                '}';
    }
}