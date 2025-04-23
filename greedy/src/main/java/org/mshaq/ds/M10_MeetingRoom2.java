package org.mshaq.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * Neetcode: <a href="https://neetcode.io/problems/meeting-schedule-ii">Meeting Room 2</a>
 * <p>æ
 * N Room for given meetings
 */
public class M10_MeetingRoom2 {


    public static int minMeetingRoomsO(List<Interval> intervals) {

//        [[0, 30], [5, 10], [15, 20]] => result = 2
//        sort by end = [[5, 10], [15,20], [0, 30]]
//         [[1, 4], [2, 5], [7, 9], [8, 10]] => result = 2
//        sort by end =

//        1 2 7 8
//        4 5 9 10
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        int noOfRooms = 0, startPointer = 0, endPointer = 0;
        int result = 0;
        while (startPointer < start.length) {
            if (start[startPointer] < end[endPointer]) {
                noOfRooms++;
                startPointer++;
            } else {
                noOfRooms--;
                endPointer++;
            }
            result = Math.max(result, noOfRooms);
        }
        return result;
    }

    public static int minMeetingRooms(List<Interval> intervals) {
        List<int[]> time = new ArrayList<>();

        // +1 to create a room, -1 to remove a room After meeting is ended room will be removed

        for (Interval interval : intervals) {
            time.add(new int[]{interval.start, 1});
            time.add(new int[]{interval.end, -1});
        }

        /**
         * Sort the meeting with start time so that overlapping meeting will be conducted in new rooms
         *
         * Meeting 1 starts at 0
         * Meeting 2 starts at 5 (while Meeting 1 is still running)
         * Meeting 2 ends at 10
         * Meeting 3 starts at 15, and so on
         */
        time.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int noOfRooms = 0;
        int count = 0;
        for (int[] t : time) {
            count += t[1];
            noOfRooms = Math.max(noOfRooms, count);

        }
        return noOfRooms;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 40));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));
        int rooms = minMeetingRooms(intervals);
    }

    public static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
/**
 * [[0, 30], [5, 10], [15, 20]] - Basic
 * [[1, 5], [6, 10], [11, 15]] - No overlap
 * [[1, 10], [2, 9], [3, 8], [4, 7]] - All overlap
 * [[1, 4], [2, 5], [7, 9], [8, 10]] - Partial overlap
 */
