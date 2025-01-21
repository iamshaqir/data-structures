package org.mshaq.ds.playground;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * calculate the difference between the two largest elements,
 * and repeat until the list is empty or contains a single element.
 */
public class SortAndReduce {

    public static void processListUntilEmpty(List<Integer> list) {

        // Step 1: Sort the list in ascending order
        list.sort(Comparator.naturalOrder());
        while (list.size() > 1) {
            // Step 2: Find the largest and second-largest numbers
            int largest = list.remove(list.size() - 1);
            int secondLargest = list.remove(list.size() - 1);
            if (largest == secondLargest) {
                continue;
            }
            // Step 3: Compute the difference between the two largest numbers
            int difference = largest - secondLargest;
            addDiffInSortedOrder(list, difference);
        }
        int res = (!list.isEmpty()) ? list.get(0) : 0;
        System.out.println("Result: " + res);
    }

    private static void addDiffInSortedOrder(List<Integer> list, int difference) {
        // Find the correct position to insert the difference to maintain sorted order
        int position = Collections.binarySearch(list, difference);

        // If binarySearch returns a negative value, it means the element is not found,
        // it returns the next position with '-' sign, we can insert at [pos - 1].
        // Convert the negative index into the insertion point
        if (position < 0) {
            position = -(position + 1);
        }
        // Insert the element at the calculated position
        list.add(position, difference);
    }
}
