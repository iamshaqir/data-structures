package org.mshaq.ds;

import java.util.ArrayList;
import java.util.List;

public class M05_NMeetingsOneRoom {

    public int maxMeetings(int[] start, int[] end) {
        List<Meeting> meetings = getMeetingsList(start, end);
        meetings.sort((a, b) -> Integer.compare(a.end, b.end));
        int previous = meetings.get(0).end;
        int numOfMeetings = 1;
        for (Meeting current : meetings) {
            if (current.start > previous) {
                numOfMeetings += 1;
                previous = current.end;
            }
        }
        return numOfMeetings;
    }

    private List<Meeting> getMeetingsList(int[] start, int[] end) {
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }
        return meetings;
    }

    public static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
