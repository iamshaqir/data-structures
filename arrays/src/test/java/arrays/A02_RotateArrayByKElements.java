package arrays;

public class A02_RotateArrayByKElements {

    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || n == 1) return;
        k = k % n;
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] A, int si, int ei) {
        while (si < ei) {
            swap(A, si, ei);
            si++;
            ei--;
        }
    }

    private void swap(int[] A, int si, int ei) {
        int temp = A[si];
        A[si] = A[ei];
        A[ei] = temp;
    }
}
