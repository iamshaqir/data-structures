package slidingwindow;

/**
 * TUF: <a href="https://takeuforward.org/plus/dsa/sliding-window-and-2-pointer/longest-and-smallest-window-problems/max-consecutive-ones-iii">Max consecutive ones</a>
 */
public class SW9_MaxConsecutiveOnes {
    int maxConsecutiveOnesOptimal(int[] A, int k) {
        int left = 0;
        int maxOnes = 0;
        int flips = 0;
        for (int rigth = 0; rigth < A.length; rigth++) {
            if (A[rigth] == 0) flips++;

            if (flips > k) {
                if (A[left] == 0) flips--;
                left++;
            }
            if (flips <= k) {
                maxOnes = Math.max(maxOnes, rigth - left + 1);
            }
        }
        return maxOnes;

    }

    int longestOnesBetter(int[] A, int k) {
        int longestOnes = 0;
        int left = 0, right = 0, flips = 0;

        while (right < A.length) {
            if (A[right] == 0) flips++;

            while (flips > k) {
                if (A[left] == 0) flips--;
                left++;
            }

            longestOnes = Math.max(longestOnes, right - left + 1);
            right++;
        }
        return longestOnes;
    }

    // [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0] and k = 3
    void maxConsecutiveOnesBrute(int[] A, int k) {
        int maxOnes = 0;
        for (int i = 0; i < A.length; i++) {
            int flip = 0;
            for (int j = i; j < A.length; j++) {
                if (A[j] == 0) flip++;

                if (flip > k) break;

                maxOnes = Math.max(maxOnes, j - i + 1);
            }
        }
    }
}

/*
    Input : nums = [0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1] , k = 3
    Output : 9

    Input : nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0] , k = 3
    Output : 10
 */
