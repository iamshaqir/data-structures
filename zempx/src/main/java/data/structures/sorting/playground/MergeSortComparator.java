package com.ms.data.structures.sorting.playground;

import java.util.Comparator;
import java.util.List;

public class MergeSortComparator {

    static {
        LoadCsv.loadcsv("D:\\ws.intellijIDE\\data-structures\\src\\main\\java\\com\\ms\\data\\structures\\sorting\\playground\\online-retail-dataset.csv");
    }
    public void mergeSort(List<OnlineRetail> retailList, int si, int ei, Comparator<OnlineRetail> comparator) {
        if (si < ei) {
            int mi = si + (ei - si) / 2;
            mergeSort(retailList, si, mi, comparator);
            mergeSort(retailList, mi + 1, ei, comparator);
            merge(retailList, si, mi, ei, comparator);
        }
    }

    private void merge(List<OnlineRetail> retailList, int si, int mi, int ei, Comparator<OnlineRetail> comparator) {
        OnlineRetail[] tempRetailList = new OnlineRetail[ei - si + 1];

        int tempIdx = 0;
        int srcArrIdx = si;
        int destArrIdx = mi + 1;

        while (srcArrIdx <= mi && destArrIdx <= ei) {
            if (comparator.compare(retailList.get(srcArrIdx), retailList.get(destArrIdx)) > 0) {
                tempRetailList[tempIdx++] = retailList.get(srcArrIdx++);
            } else {
                tempRetailList[tempIdx++] = retailList.get(destArrIdx++);
            }
        }

        while (srcArrIdx <= mi) {
            tempRetailList[tempIdx++] = retailList.get(srcArrIdx++);
        }

        while (destArrIdx <= ei) {
            tempRetailList[tempIdx++] = retailList.get(destArrIdx++);
        }

        for (int i = 0, j = si; i < tempRetailList.length; i++, j++) {
            retailList.set(j, tempRetailList[i]);
        }
    }
}
