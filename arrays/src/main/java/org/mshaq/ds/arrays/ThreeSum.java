package org.mshaq.ds.arrays;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSumHashing(int[] a) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            Set<Integer> kSet = new HashSet<>();
            for (int j = i + 1; j < a.length; j++) {
                int k = -(a[i] + a[j]);
                if (kSet.contains(k)) {
                    List<Integer> list = Arrays.asList(a[i], a[j], k);
                    list.sort(Comparator.naturalOrder());
                    set.add(list);
                }
                kSet.add(a[j]);
            }
        }
        return new ArrayList<>(set);
    }

    // [-1,0,1,2,-1,-4]
    public List<List<Integer>> threeSumOptimal(int[] a) {
        int n = a.length;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if (i != 0 && a[i] == a[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> list = Arrays.asList(a[i], a[j], a[k]);
                    set.add(list);
                    j++;
                    k--;
                    while (j < k && a[j] == a[j - 1]) j++;
                    while (j < k && a[k] == a[k + 1]) k--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
