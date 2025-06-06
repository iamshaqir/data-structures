package slidingwindow;

/**
 * TUF: <a href="https://takeuforward.org/plus/dsa/problems/diet-plan-performance">Diet Plan Performance</a>
 */
public class SW3_DietPlanPerformance {

    public int dietPlanPerformance(int[] A, int k, int lower, int upper) {
        int calories = 0, calorieIntake = 0;
        for (int i = 0; i < A.length; i++) {
            calorieIntake += A[i];
            if (i >= k - 1) {
                if (calorieIntake < lower) {
                    calories -= 1;
                } else if (calorieIntake > upper) {
                    calories += 1;
                }
                calorieIntake -= A[i - (k - 1)];
            }
        }
        return calories;
    }

    // [2, 4, 6, 8, 10]
    public int dietPlanPerformanceBrute(int[] A, int k, int lower, int upper) {
        int calories = 0;
        for (int i = 0; i <= A.length - k; i++) {
            int calorieIntake = 0;
            for (int j = i; j < i + k; j++) {
                calorieIntake += A[j];
            }

            if (calorieIntake < lower) {
                calories -= 1;
            } else if (calorieIntake > upper) {
                calories += 1;
            }
        }

        return calories;
    }
}

/*
    Problem Statement: You are given an array calories representing daily calorie intake,
    an integer k (length of the consecutive sequence), and two integers lower and upper (calorie thresholds).
    For each consecutive sequence of k days, calculate the total calories T.
    If T < lower, lose 1 point. If T > upper, gain 1 point. Otherwise, no change.
    Start with 0 points and return the final total points.

    Came up with approach but couldn't write logic using single loop
    Was thinking about while loop rather than if condition
    Couldn't come up with condition on how to get access to first element and subtract

    Input: calories = [2, 4, 6, 8, 10], k = 2, lower = 7, upper = 9
    Expected Output: 2
*/

