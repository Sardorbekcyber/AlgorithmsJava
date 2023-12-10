package org.example.greedy.activitySelection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivitySelection {

    public static void main(String[] args) {
        ArrayList<Activity> activityList = new ArrayList<>();

        activityList.add(new Activity("A1", 0, 6));
        activityList.add(new Activity("A2", 3, 4));
        activityList.add(new Activity("A3", 1, 2));
        activityList.add(new Activity("A4", 5, 8));
        activityList.add(new Activity("A5", 5, 7));
        activityList.add(new Activity("A6", 8, 9));

        activitySelection(activityList);
    }

    static void activitySelection(ArrayList<Activity> activityList) {
        Comparator<Activity> finishTimeComparator = new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.getFinishTime() - o2.getFinishTime();
            }
        };

        Collections.sort(activityList, finishTimeComparator);
        Activity previousActivity = activityList.get(0);

        System.out.println("\n\nRecommended Schedule:\n" + previousActivity.toString());

        for (int i = 1; i < activityList.size(); i++) {
            Activity activity = activityList.get(i);

            if (activity.getStartTime() >= previousActivity.getFinishTime()) {
                System.out.println(activity);
                previousActivity = activity;
            }
        }
    }
}
