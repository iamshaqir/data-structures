package com.mshaq.datastructures.tuf.set_a;

public class H_MissingNumber {

    public static int missingNumber(int[] A) {
        int xor = A.length;
        // aset^b^b = aset
        for (int i = 0; i < A.length; i++) {
            xor = xor ^ i ^ A[i];
        }
        return xor;
    }

    // Input: nums = [3,2,1,5,0]
    //Output: 4

    public static int missingNumberBe(int[] A) {
        int xor1 = 0;
        int xor2 = 0;

        int length = A.length;
        for (int i = 0; i < length - 1; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ A[i];
        }
        xor1 = xor1 ^ length;
        return xor1 ^ xor2;
    }

    public static int missingNumberBr(int[] A) {
        int bits = 0;
        for (int i = 1; i <= A.length; i++) {
            bits ^= i;
        }

        for (int i = 0; i < A.length; i++) {
            bits ^= A[i];
        }

        return bits;
    }


    public static void main(String[] args) {
        int[] A = {7, 6, 4, 2, 3, 5, 9, 0, 1};
        int missingNumber = missingNumber(A);
        System.out.println("Missing Number: " + missingNumber);
    }
}
