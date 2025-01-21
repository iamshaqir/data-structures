package org.mshaq.ds.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ENMeetingsInOneRoomTest {

    E_NMeetingsInOneRoom ENMeetingsInOneRoom;

    @BeforeEach
    void setUp() {
        ENMeetingsInOneRoom = new E_NMeetingsInOneRoom();
    }

    @Test
    void maxMeetings() {

        int[] start = {0, 3, 1, 5, 5, 8};
        int[] end = {5, 4, 2, 9, 7, 9};

        int meetings = ENMeetingsInOneRoom.maxMeetings(start, end);
        assertEquals(4, meetings, "Count didn't match");
    }
}