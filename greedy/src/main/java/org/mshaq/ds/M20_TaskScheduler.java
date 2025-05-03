package org.mshaq.ds;

import java.util.*;

/**
 * Leetcode: <a href="https://leetcode.com/problems/task-scheduler/description/">Task scheduler</a>
 *
 * <p>Input: tasks = ["A","A","A","B","B","B"], n = 2
 * <p>Output: 8
 * <p> Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 * <p>After completing task A, you must wait two intervals before doing A again.
 * <p>The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval,
 * you can do A again as 2 intervals have passed.
 */
public class M20_TaskScheduler {


    /**
     * Brute force approach
     * <p> Find frequencies of Characters Using Map
     * <p> Track cooldown using map, which keeps track of when current task will occur next
     * <p> Iterate through freq, if not present in cooldown or below cooldown, it is next task Remove
     * from freq and add in cool down for next turn
     */
    public static int leastIntervalB(char[] tasks, int n) {

        Map<Character, Integer> freq = new HashMap<>();
        int time = 0;
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        Map<Character, Integer> cooldown = new HashMap<>();

        while (!freq.isEmpty()) {
            char next = 0;
            for (Character task : freq.keySet()) {
                if (!freq.containsKey(task) || cooldown.get(task) <= time) {
                    next = task;
                    break;
                }
            }

            if (next != 0) {
                freq.put(next, freq.get(next) - 1);
                if (freq.get(next) == 0) freq.remove(next);
                cooldown.put(next, time + n + 1);
            }
            time += 1;
        }

        return time;
    }

    // TC: O(n log k) -> n = tasks, k -> unique tasks, offer/poll PQ will take log k
    public static int leastIntervalBE(char[] tasks, int n) {

        int time = 0;
        int[] freq = new int[26];
        for (char task : tasks) freq[task - 'A']++;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : freq) {
            if (count > 0) queue.offer(count);
        }

        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int cooldown = n + 1;

            while (!queue.isEmpty() && cooldown > 0) {
                Integer currCount = queue.poll();
                if (currCount > 1) tempList.add(currCount - 1);
                cooldown--;
                time += 1;
            }
            queue.addAll(tempList);
            if (queue.isEmpty()) break;
            time += cooldown;
        }
        return time;
    }


}
/*
  tasks = ['A','A','A','B','C','D'] n = 2
  tasks = ['A','A','A','A'] n = 3
 */