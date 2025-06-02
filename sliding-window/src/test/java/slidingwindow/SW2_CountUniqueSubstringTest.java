package slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SW2_CountUniqueSubstringTest {

    @Test
    void countUniqueSubstrings() {

        SW2_CountUniqueSubstring uniqueSubstring = new SW2_CountUniqueSubstring();
        assertAll(
                () -> assertEquals(uniqueSubstring.numberOfSpecialSubstrings("abcde"), 15),
                () -> assertEquals(uniqueSubstring.numberOfSpecialSubstrings("aaaaa"), 5),
                () -> assertEquals(uniqueSubstring.numberOfSpecialSubstrings("abacaba"), 15),
                () -> assertEquals(uniqueSubstring.numberOfSpecialSubstrings("topcoder"), 28),
                () -> assertEquals(uniqueSubstring.numberOfSpecialSubstrings("aa"), 2)
        );
    }
}