package org.mshaq.ds.shortest_path;

import java.util.*;

public class WordLadder2 {

    private static class BFS {

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            Set<String> set = new HashSet<>(wordList);

            List<String> ls = new ArrayList<>();
            ls.add(beginWord);

            Queue<List<String>> q = new LinkedList<>();
            q.add(ls);

            List<String> visitedWordsLevel = new ArrayList<>();
            visitedWordsLevel.add(beginWord);

            int level = 0;

            while (!q.isEmpty()) {
                List<String> top = q.poll();

                level = removeVisited(top, level, visitedWordsLevel, set);

                String lastWord = top.get(top.size() - 1);

                addToRes(endWord, lastWord, res, top);

                generateQ(lastWord, set, top, q, visitedWordsLevel);
            }
            return res;
        }

        private static void generateQ(String lastWord, Set<String> set,
                                      List<String> top, Queue<List<String>> q,
                                      List<String> visitedWordsLevel) {

            for (int i = 0; i < lastWord.length(); i++) {
                char[] wordArr = lastWord.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordArr[i] = ch;
                    String newWord = String.valueOf(wordArr);
                    if (set.contains(newWord)) {
                        top.add(newWord);

                        List<String> newList = new ArrayList<>(top);
                        q.add(newList);

                        // add newWord as visited for that level
                        visitedWordsLevel.add(newWord);

                        top.remove(top.size() - 1);
                    }
                }
            }
        }

        /**
         * if the last word of sequence matches the end word, we found sequence
         * validation is to make sure it does not add any other sequence after end word
         * if any sequences exists
         */
        private static void addToRes(String endWord, String lastWord,
                                     List<List<String>> res, List<String> top) {
            if (lastWord.equals(endWord)) {
                if (res.isEmpty()) {
                    res.add(top);
                } else if (res.get(0).size() == top.size()) {
                    res.add(top);
                }
            }
        }

        /**
         * Remove the visited words for each level,
         * Note we can only remove them after they have
         * visited specific level, if not we cannot include it in other sequence
         */
        private static int removeVisited(List<String> top, int level,
                                         List<String> visitedWordsLevel, Set<String> set) {
            if (top.size() > level) {
                for (String visited : visitedWordsLevel) {
                    set.remove(visited);
                }
                level++;
            }
            return level;
        }
    }
}
