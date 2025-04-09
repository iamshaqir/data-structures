package com.mshaq.datastructures.tuf.set_b;

public class E_MaximumProductSubArray {

    public int maxProductBrute(int[] A) {

        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int currProduct = A[i];
            for (int j = i + 1; j < A.length; j++) {
                maxProduct = Math.max(maxProduct, currProduct);
                currProduct = currProduct * A[j];
            }
        }

        return maxProduct;
    }

    public int maxProduct(int[] A) {

        int n = A.length;
        int prefix = 1, suffix = 1, maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            prefix = prefix * A[i];
            suffix = suffix * A[n - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }

    // Input: nums = [2,3,-2,4,1,3,-2,-5]
    // Output: 6
}
