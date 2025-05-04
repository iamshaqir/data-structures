package greedy;

/**
 * Leetcode: <a href="https://leetcode.com/problems/jump-game-ii/description/?source=submission-ac">Jump game 2</a>
 */
public class G02_JumpGame2 {

    // Using sliding window
    public int jump(int[] A) {
        int jumps = 0;
        int left = 0, right = 0;

        while (right < A.length - 1) {

            int farthest = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + A[i]);
            }

            if (farthest >= A.length - 1) {
                jumps++;
                break;
            }
            left = right + 1;
            right = farthest;
            jumps++;
        }
        return jumps;
    }

    public int jumpO(int[] A) {
        int jumps = 0, end = 0;
        int farthest = Integer.MIN_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            farthest = Math.max(farthest, i + A[i]);

            if (farthest >= A.length - 1) {
                jumps++;
                break;
            }
            if (i == end) {
                end = farthest;
                jumps++;
            }
        }
        return jumps;

    }
}

/*
    Test cases:
    Test Case 1: Straightforward Single Jump => nums = [5, 1, 1, 1, 1, 1]
    Test Case 2: Maximum Jump Each Time => nums = [1, 1, 1, 1, 1]
    Test Case 3: Optimal Jumps are Not Obvious => nums = [1, 4, 3, 7, 1, 2, 6, 7, 6, 10]
 */
