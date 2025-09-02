package arrays;

public class A01_MaxConsecutiveOnes {

    int[] A = {1, 1, 0, 0, 1, 1, 1, 0};

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = -1;
        int reset = 0;
        for (int num : nums) {
            if (num == 0) {
                reset = 0;
                continue;
            }
            maxOnes = Math.max(maxOnes, ++reset);
        }
        return maxOnes;
    }
}
