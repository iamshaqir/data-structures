package org.mshaq.ds;

import java.math.BigInteger;
import java.util.Arrays;

public class M11_MinSumTwoNumbers {

    public static int minSum(int[] A) {
        Arrays.sort(A);

        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                even.append(A[i]);
            } else {
                odd.append(A[i]);
            }
        }

        int evenNum = Integer.parseInt(even.toString());
        int oddNum = Integer.parseInt(odd.toString());

        return evenNum + oddNum;
    }

    // Distribute digits alternately and build numbers
    public static int minSumWithInt(int[] A) {
        Arrays.sort(A);

        int even = 0;
        int odd = 0;

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                even = even * 10 + A[i];
            } else {
                odd = odd * 10 + A[i];
            }
        }
        return even + odd;
    }

    // using BigInteger
    public static int minSumWithBigInteger(int[] A) {
        Arrays.sort(A);

        BigInteger even = BigInteger.ZERO;
        BigInteger odd = BigInteger.ZERO;

        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                even = even.multiply(BigInteger.TEN).add(BigInteger.valueOf(A[i]));
            } else {
                odd = odd.multiply(BigInteger.TEN).add(BigInteger.valueOf(A[i]));
            }
        }
        return even.add(odd).intValue();
    }
}
