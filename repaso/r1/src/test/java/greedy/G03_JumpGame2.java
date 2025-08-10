package greedy;

import org.junit.jupiter.api.Test;

public class G03_JumpGame2 {

    int[] A = {3, 2, 3, 1, 0, 4};
    int[] A2 = {2, 3, 1, 1, 4};
    int[] A1 = {2, 3, 0, 1, 4};

    @Test
    void jump() {
        int jumps = jump(A);
        System.out.println("Jumps: " + jumps);
    }

    public int jump(int[] A) {
        int jumps = 0;
        int left = 0, right = 0;
        int farthest = Integer.MIN_VALUE;

        while (right < A.length - 1) {

            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, A[i] + i);
            }

            if (farthest > A.length - 1) {
                jumps++;
                break;
            }

            left = right + 1;
            right = farthest;
            jumps += 1;
        }

        return jumps;
    }
}
