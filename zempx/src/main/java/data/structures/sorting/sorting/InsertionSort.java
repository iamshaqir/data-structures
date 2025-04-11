package data.structures.sorting.sorting;

/**
 * We begin from the second item as by definition an array with one item is considered to be sorted.
 * The item at index i is called aset currValue. Once having the currValue, the second part of the algorithm deals
 * with finding its correct index. If the currValue is smaller than the value of the item at index prevIdx,
 * then the currValue moves one position to the left. The process continues until the case when we reach
 * an element being smaller than the currValue.
 */
public class InsertionSort {

    /**
     *
     * inputArray = {6, 2, 3, 4, 5, 1}
     */
    public int[] sortAscending(int[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            int currValue = inputArray[i];
            int prevIdx = i - 1;
            while (prevIdx >= 0 && inputArray[prevIdx] > currValue) {
                inputArray[prevIdx + 1] = inputArray[prevIdx];
                prevIdx = prevIdx - 1;
            }
            inputArray[prevIdx + 1] = currValue;
        }
        return inputArray;
    }

    public int[] sortDescending(int[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            int currValue = inputArray[i];
            int prevIdx = i - 1;
            while (prevIdx >= 0 && inputArray[prevIdx] < currValue) {
                inputArray[prevIdx + 1] = inputArray[prevIdx];
                prevIdx = prevIdx - 1;
            }
            inputArray[prevIdx + 1] = currValue;
        }
        return inputArray;
    }
}
