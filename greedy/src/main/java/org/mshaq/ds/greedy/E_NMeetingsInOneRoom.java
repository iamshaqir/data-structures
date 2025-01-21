package org.mshaq.ds.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class E_NMeetingsInOneRoom {

    public int maxMeetings(int[] start, int[] end) {
        List<Tuple> meetings = getMeetings(start, end);
        meetings.sort(Comparator.comparingInt((Tuple tuple) -> tuple.end));
        int noOfMeetings = 1;
        int freeTime = meetings.get(0).end;
        for (int i = 1; i < meetings.size(); i++) {
            Tuple meeting = meetings.get(i);
            if (meeting.start > freeTime) {
                noOfMeetings += 1;
                freeTime = meeting.end;
            }
        }
        return noOfMeetings;
    }

    private List<Tuple> getMeetings(int[] start, int[] end) {
        List<Tuple> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetings.add(new Tuple(start[i], end[i], i + 1));
        }
        return meetings;
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
            return "Job{" +
                    "start=" + start +
                    ", end=" + end +
                    ", position=" + position +
                    '}';
        }
    }
}
