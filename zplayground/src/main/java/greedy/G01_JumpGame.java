package greedy;

/**
 * Leetcode: <a href="https://leetcode.com/problems/jump-game/">Jump Game</a>
 */
public class G01_JumpGame {

    public boolean canJump(int[] nums) {
        int jump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > jump) return false;
            jump = Math.max(jump, nums[i] + i);
        }
        return true;
    }

    // Input: nums = [2,3,1,1,4] - true
    // Input: nums = [3,2,1,0,4] - false
    public static boolean jump(int[] A) {
        int goal = A.length - 1;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] + i >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }

    public static void main(String[] args) {
        int[] G = {3, 2, 1, 0, 4};
        boolean jump = jump(G);
        System.out.println("Can Jump: " + jump);
    }
}
