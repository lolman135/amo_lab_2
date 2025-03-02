package app.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class SortResult {
    private final List<Integer> sortedList;
    private final int operationCount;
    private final long duration;
}
