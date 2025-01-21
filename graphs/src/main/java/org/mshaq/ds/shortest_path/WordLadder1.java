package org.mshaq.ds.shortest_path;

import java.util.*;

public class WordLadder1 {

    private static class BFS {

        public int ladderLength(String startWord, String targetWord, List<String> wordList) {

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(startWord, 1));

            Set<String> set = new HashSet<>(wordList);
            set.remove(startWord);

            while (!q.isEmpty()) {
                Pair top = q.poll();
                String currentWord = top.word;
                int level = top.level;

                if (currentWord.equals(targetWord)) return level;

                for (int i = 0; i < currentWord.length(); i++) {
                    char[] topArr = currentWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        topArr[i] = ch;
                        String newWord = String.valueOf(topArr);
                        if (set.contains(newWord)) {
                            set.remove(newWord);
                            q.add(new Pair(newWord, level + 1));
                        }
                    }
                }
            }
            return 0;
        }

        static class Pair {
            String word;
            int level;

            public Pair(String word, int level) {
                this.word = word;
                this.level = level;
            }
        }
    }
}
