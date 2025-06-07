package slidingwindow;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Count Substrings Without Repeating Characters
 * <p>
 * Input : s = "cook"
 * <p>
 * Output : 6
 * <p>
 * Explanation :
 * The special substrings are - 'c' , 'o' , 'o' , 'k' , 'co' , 'ok'.
 * <p>
 * TUF: <a href="https://takeuforward.org/plus/dsa/problems/count-substrings-without-repeating-characters">Count Substrings Without Repeating Characters</a>
 */
public class SW2_CountUniqueSubstring {

    @Test
    void countUniqueSubstrings() {

        assertAll(
                () -> assertEquals(numberOfSpecialSubstrings("abcde"), 15),
                () -> assertEquals(numberOfSpecialSubstrings("aaaaa"), 5),
                () -> assertEquals(numberOfSpecialSubstrings("abacaba"), 15),
                () -> assertEquals(numberOfSpecialSubstrings("topcoder"), 28),
                () -> assertEquals(numberOfSpecialSubstrings("aa"), 2)
        );
    }
    // abcab
    public int numberOfSpecialSubstrings(String s) {
        int count = 0;
        Set<Character> visited = new HashSet<>();

        int left = 0, right = 0;
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            while (visited.contains(currentChar)) {
                visited.remove(s.charAt(left));
                left++;
            }
            visited.add(s.charAt(right));
            count += right - left + 1;
            right++;
        }
        return count;
    }

    public int numberOfSpecialSubstringsBruteForce(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                if (seen.contains(currentChar)) break;
                seen.add(currentChar);
                count += 1;
            }
        }
        return count;
    }

}

/*


 */
