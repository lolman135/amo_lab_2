package app.utils;

import java.util.List;

public record SortResult(List<Integer> sortedList, int operationCount, long duration) {
}
