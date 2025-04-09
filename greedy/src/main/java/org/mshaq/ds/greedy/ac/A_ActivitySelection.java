package org.mshaq.ds.greedy.ac;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href="https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1?
 * itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card">Activity selection</a>
 * <p>
 * Similar to N meetings in one room
 */
public class A_ActivitySelection {
    public static void main(String[] args) {
//        int[] start = {1, 3, 0, 5, 8, 5};
//        int[] finish = {2, 4, 6, 7, 9, 9};

        int[] start = {1, 3, 2, 5};
        int[] finish = {2, 4, 3, 6};

        int result = activitySelection(start, finish);
        System.out.println(result);
    }

    public static int activitySelection(int[] start, int[] finish) {

        List<Tuple> activities = getActivities(start, finish);
        activities.sort((a, b) -> Integer.compare(a.end, b.end));
        System.out.println(activities);
        int result = 1;
        Tuple previous = activities.get(0);
        for (Tuple current : activities) {
            if (current.start > previous.end) {
                previous = current;
                result++;
            }
        }
        return result;
    }

    private static List<Tuple> getActivities(int[] start, int[] finish) {
        List<Tuple> tuples = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            tuples.add(new Tuple(start[i], finish[i], i));
        }
        return tuples;
    }

    public static class Tuple {
        int start;
        int end;
        int position;

        public Tuple(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "start=" + start +
                    ", end=" + end +
                    ", position=" + position +
                    '}';
        }
    }
}

/*
    Example - 1:
    start[] = {1, 3, 0, 5, 8, 5}
    finish[] = {2, 4, 6, 7, 9, 9}

    (1,2) (3,4) (0,6) (5,7) (8,9) (5,9)

    Example - 2:
    start[] = [10, 12, 20]
    finish[] = [20, 25, 30]

    Example - 3:
    start[] = [1, 3, 2, 5]
    finish[] = [2, 4, 3, 6]

    (1,2) (2,3) (3,4) (5, 6)
*/