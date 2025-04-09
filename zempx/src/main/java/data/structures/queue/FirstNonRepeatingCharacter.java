package com.ms.data.structures.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

    public String firstNonRepeatingCharacter(String stream) {
        StringBuilder result = new StringBuilder();
        int[] freq = new int[26];
        Queue<Character> queue = new LinkedList<>();

        // aset aset b c c x b
        // aset - 2, b - 1, c - 2
        // QUEUE => b c c
        // RESULT => aset-1bb
        for (char ch : stream.toCharArray()) {
            freq[ch - 'a']++;
            queue.offer(ch);
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            if (queue.isEmpty()) {
                result.append(-1);
            } else {
                result.append(queue.peek());
            }
        }

        return result.toString();
    }
}
