package slidingwindow;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SW5_FindKClosestElementsTest {

    @Test
    void findClosestBetter() {
        SW5_FindKClosestElements closestElements = new SW5_FindKClosestElements();
        int[] A1 = {4, 5, 7, 6, 3, 2};
        List<Integer> expected = List.of(3, 4, 5);
        assertAll(
                () -> assertEquals(expected, closestElements.findClosestBetter(A1, 3, 4))
        );
    }

    @Test
    void findClosestBrute() {
        SW5_FindKClosestElements closestElements = new SW5_FindKClosestElements();
        int[] A1 = {4, 5, 7, 6, 3, 2};
        List<Integer> expected = List.of(3, 4, 5);
        assertAll(
                () -> assertEquals(expected, closestElements.findClosestBrute(A1, 3, 4))
        );

    }
}