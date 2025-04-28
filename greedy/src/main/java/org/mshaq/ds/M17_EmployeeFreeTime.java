package org.mshaq.ds;

import java.util.*;

/**
 * AlgoMonster: <a href="https://algo.monster/liteproblems/759">Employee Free Time</a>
 * <p>Similar to Merge interval problem with few changes
 */
public class M17_EmployeeFreeTime {


    /**
     * [ [[1,2],[5,6]] ,[[1,3]], [[4,10]] ]
     * <p>TC: NlogN
     */
    public static List<Interval> freeTime(List<List<Interval>> intervals) {

        List<Interval> list = new ArrayList<>();
        for (List<Interval> interval : intervals) {
            list.addAll(interval);
        }
        list.sort((a, b) -> a.start - b.start);
        List<Interval> result = new ArrayList<>();
        Interval previous = list.get(0);
        for (Interval current : list) {
            if (current.start > previous.end) {
                result.add(new Interval(previous.end, current.start));
                previous = current;
            } else {
                previous.end = Math.max(previous.end, current.end);
            }
        }

        return result;
    }

    /**
     * Insert the first interval of every employee into a min-heap (sorted by start time).
     * <p>Pop the earliest interval, track the last end time.
     * <p>If the next interval starts after the last end time → we have a gap → free time!
     * <p>Keep pushing next intervals from the employee into the heap.
     * <p>TC: NlogK
     * <p>N = total number of intervals
     * <p>K = number of employees
     */
    public static List<Interval> freeTimePQ(List<List<Interval>> intervals) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.interval.start - b.interval.start);

        for (int i = 0; i < intervals.size(); i++) {
            queue.offer(new Node(intervals.get(i).get(0), i, 0));
        }
        Interval previous = Objects.requireNonNull(queue.peek()).interval;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            Interval current = currentNode.interval;
            if (current.start > previous.end) {
                result.add(new Interval(previous.end, current.start));
                previous = current;
            } else {
                previous.end = Math.max(previous.end, current.end);
            }

            List<Interval> employee = intervals.get(currentNode.employeeIdx);
            int employeeNextIdx = currentNode.intervalIdx + 1;
            if (employeeNextIdx < employee.size()) {
                queue.add(new Node(employee.get(employeeNextIdx), currentNode.employeeIdx, employeeNextIdx));
            }
        }

        return result;
    }

    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class Node {
        Interval interval;
        int employeeIdx;
        int intervalIdx;

        public Node(Interval interval, int employeeIdx, int intervalIdx) {
            this.interval = interval;
            this.employeeIdx = employeeIdx;
            this.intervalIdx = intervalIdx;
        }
    }
}
