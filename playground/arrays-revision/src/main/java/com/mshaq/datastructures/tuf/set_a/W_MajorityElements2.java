package com.mshaq.datastructures.tuf.set_a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Similar to Majority Elements 1
public class W_MajorityElements2 {

    static class Brute {
        public List<Integer> get(int[] A) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < A.length; i++) {
                if (list.isEmpty() || A[i] != list.get(0)) {
                    int count = 0;
                    for (int j = 0; j < A.length; j++) {
                        if (A[i] == A[j]) {
                            count += 1;
                        }
                    }

                    if (count > A.length / 3) {
                        list.add(A[i]);
                    }
                }
                if (list.size() == 2) break;
            }

            return list;
        }
    }

    // using HashMap
    static class Better {
        public List<Integer> get(int[] A) {
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();

            for (int element : A) {
                map.put(element, map.getOrDefault(element, 0) + 1);
                if (map.get(element) > A.length / 3) {
                    list.add(element);
                }

                if (list.size() == 2) break;
            }

            return list;
        }
    }

    // Using variables
    static class Optimal {
        public List<Integer> get(int[] A) {
            List<Integer> list = new ArrayList<>();

            int count1 = 0, count2 = 0;
            int majorityElement1 = Integer.MIN_VALUE, majorityElement2 = Integer.MIN_VALUE;

            for (int element : A) {
                if (count1 == 0 && element != majorityElement2) {
                    count1 = 1;
                    majorityElement1 = element;
                } else if (count2 == 0 && element != majorityElement1) {
                    count2 = 1;
                    majorityElement2 = element;
                } else if (majorityElement1 == element) {
                    count1++;
                } else if (majorityElement2 == element) {
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }

            count1 = 0;
            count2 = 0;
            for (int element : A) {
                if (element == majorityElement1) {
                    count1++;
                }
                if (element == majorityElement2) {
                    count2++;
                }
            }

            if (count1 > A.length / 3) {
                list.add(majorityElement1);
            }

            if (count2 > A.length / 3 && majorityElement1 != majorityElement2) {
                list.add(majorityElement2);
            }

            return list;
        }
    }
}
