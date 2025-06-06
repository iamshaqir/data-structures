package slidingwindow;


import java.util.Arrays;

public class SW7_MaxPointsFromCards {

    //    Time Complexity: O(K)
    public static int maxScoreOptimal(int[] A, int k) {
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

    public int maxScoreBrute(int[] A, int k) {

        int n = A.length;
        int maxScore = 0;

        for (int i = 0; i <= k; i++) {
            int currentScore = 0;

            for (int j = 0; j < i; j++) {
                currentScore += A[j];
            }

            for (int j = 0; j < k - i; j++) {
                currentScore += A[n - 1 - j];
            }

            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}

/*
    Problem Statement: You are given an integer array cardPoints representing points on cards arranged in a row.
    In one step, you can take a card from either the beginning or the end of the row. You must take exactly k cards.
    Your score is the sum of the points of the cards you have taken. Return the maximum score you can obtain.

    For example, if k = 3:

    You can take 3 from the beginning, 0 from the end.
    You can take 2 from the beginning, 1 from the end.
    You can take 1 from the beginning, 2 from the end.
    You can take 0 from the beginning, 3 from the end.
    The total number of ways to pick k cards this way is k + 1 distinct scenarios.

    Input: cardPoints = [1, 2, 3, 4, 5], k = 5
    Expected Output: 15

    Input: cardPoints = [1, 1, 100, 1, 1], k = 4
    Expected Output: 103
 */