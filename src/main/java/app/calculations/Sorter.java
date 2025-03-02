package app.calculations;

import app.utils.SortResult;

import java.util.List;
import java.util.ArrayList;

public class Sorter {

    private static int operationCount;

    public static SortResult sort(List<Integer> list) {
        operationCount = 0;
        long startTime = System.nanoTime();
        List<Integer> sortedList = mergeSort(list);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        return new SortResult(sortedList, operationCount, duration);
    }

    public static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() < 2) return list;
        int mid = list.size() / 2;
        List<Integer> left = new ArrayList<>(list.subList(0, mid));
        List<Integer> right = new ArrayList<>(list.subList(mid, list.size()));
        return merge(mergeSort(left), mergeSort(right));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>(left.size() + right.size());
        int i1 = 0, i2 = 0;
        while (i1 < left.size() && i2 < right.size()) {
            operationCount++;
            if (left.get(i1) < right.get(i2)) {
                merged.add(left.get(i1++));
            } else {
                merged.add(right.get(i2++));
            }
        }
        while (i1 < left.size()) {
            merged.add(left.get(i1++));
            operationCount++;
        }
        while (i2 < right.size()) {
            merged.add(right.get(i2++));
            operationCount++;
        }
        return merged;
    }
}
