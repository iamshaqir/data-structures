package com.ms.data.structures.sorting.playground;

import java.util.List;

public class MergeSortComparable {

    static {
        LoadCsv.loadcsv("D:\\ws.intellijIDE\\data-structures\\src\\main\\java\\com\\ms\\data\\structures\\sorting\\playground\\online-retail-dataset.csv");
    }
    public void mergeSort(List<OnlineRetail> retailList, int si, int ei) {
        if (si < ei) {
            int mi = si + (ei - si) / 2;
            mergeSort(retailList, si, mi);
            mergeSort(retailList, mi + 1, ei);
            merge(retailList, si, mi, ei);
        }
    }

    private void merge(List<OnlineRetail> retailList, int si, int mi, int ei) {
        OnlineRetail[] tempRetailList = new OnlineRetail[ei - si + 1];

        int tempIdx = 0;
        int srcArrIdx = si;
        int destArrIdx = mi + 1;

        while (srcArrIdx <= mi && destArrIdx <= ei) {
            if ((retailList.get(srcArrIdx).compareTo(retailList.get(destArrIdx))) > 0) {
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
