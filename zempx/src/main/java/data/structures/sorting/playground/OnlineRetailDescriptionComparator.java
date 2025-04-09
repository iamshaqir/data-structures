package com.ms.data.structures.sorting.playground;

import java.util.Comparator;

public class OnlineRetailDescriptionComparator implements Comparator<OnlineRetail> {
    @Override
    public int compare(OnlineRetail o1, OnlineRetail o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getDescription(), o2.getDescription());
    }


}
