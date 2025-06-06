package slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class SW7_MaxPointsFromCardsTest {

    @Test
    void manager() {
        int[] A = {6, 2, 3, 4, 7};
        int k = 2;
        int result = maxScoreOptimal(A, 2);
        Assertions.assertEquals(13, result);
    }

    public int maxScoreOptimal(int[] A, int k) {
        int n = A.length;
        int leftSum = Arrays.stream(A)
                .limit(k)
                .sum();

        if (k == n) return leftSum;

        int maxSum = leftSum, rightSum = 0;
        for (int i = 1; i <= k; i++) {
            leftSum -= A[k - i];
            rightSum += A[n - i];

            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }

}