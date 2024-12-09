package com.ottman.javaspringdemo.logFeature;

import java.util.Comparator;

/**
 * Comparator for {@link Log}s which sorts them by {@link Log#timestamp} descending
 */
public class LogSortTimeDescendingComparator implements Comparator<Log> {

    @Override
    public int compare(Log prod1, Log prod2) {
        return prod2.timestamp.compareTo(prod1.timestamp);
    }
}
