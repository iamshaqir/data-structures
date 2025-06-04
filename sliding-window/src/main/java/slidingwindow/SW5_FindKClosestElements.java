package slidingwindow;

import java.util.*;

import static java.lang.Math.abs;

/**
 * TUF: <a href="https://takeuforward.org/plus/dsa/problems/k-nearest-integers">K Nearest Integers</a>
 */
public class SW5_FindKClosestElements {

    // Time Complexity: O(log N + K), where N is the length of arr. O(log N) for binary search and O(K) for collecting the results.
    public List<Integer> findClosestOptimal(int[] A, int k, int x) {
        int start = 0, end = A.length - k;

        while (start < end) {

            int middle = start + (end - start) / 2;
            if (x - A[middle] > A[middle + k] - x) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        return Arrays.stream(A, start, start + k)
                .boxed()
                .toList();
    }

    // Time Complexity: O(N log K), where N is the length of arr and K is the desired number of elements.
    public List<Integer> findClosestBetter(int[] A, int k, int x) {
        Queue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            return diffA != diffB
                    ? Integer.compare(diffB, diffA)
                    : Integer.compare(b, a);
        });

        for (int element : A) {
            priorityQueue.add(element);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        List<Integer> resultList = new ArrayList<>(priorityQueue);
        Collections.sort(resultList);
        return resultList;
    }

    // Time Complexity: O(N log N), where N is the length of arr.
    public List<Integer> findClosestBrute(int[] A, int k, int x) {
        List<Element> elements = new ArrayList<>();
        for (int element : A) {
            elements.add(new Element(element, abs(element - x)));
        }
        elements.sort(Comparator.comparing((Element::distance)).thenComparing(Element::value));

        return elements.stream()
                .limit(k)
                .map(Element::value)
                .sorted()
                .toList();
    }

    public record Element(int value, int distance) {
    }
}

/*
    Input: arr = [4, 1, 3, 2, 5], k = 3, x = 3
    Expected Output: [2, 3, 4]

    Input: arr = [1, 2, 3, 4, 5], k = 4, x = 3
    Expected Output: [1, 2, 3, 4]

    Input: arr = [10, 20, 30, 40], k = 2, x = 5
    Expected Output: [10, 20]

    Input: arr = [5, 2, 8, 1, 7], k = 5, x = 4
    Expected Output: [1, 2, 5, 7, 8]
 */
