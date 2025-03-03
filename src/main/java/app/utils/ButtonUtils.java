package app.utils;

import app.calculations.Sorter;
import app.gui.windows.ElementaryArrayWindow;
import app.gui.windows.GraphicWindow;
import app.gui.windows.SortedArrayWindow;

import javax.swing.*;
import java.util.*;

public class ButtonUtils {

    private static List<List<Integer>> lists = new ArrayList<>();

    public static void submit(JTextField fromField, JTextField toField, JRadioButton randomGeneration) {
        lists.clear();

        if (randomGeneration.isSelected()) {
            ArrayUtils.generateRandomLists(lists, fromField, toField);
        } else {
            ArrayUtils.parseFile(lists);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int number = 1;
        for (List<Integer> list : lists) {
            stringBuilder.append("Array " + number + ": " + list + "\n\n");
            number++;
        }

        new ElementaryArrayWindow(stringBuilder.toString());
    }

    public static void doSort(){
        List<List<Integer>> listOfSortedArrays = new ArrayList<>();
        List<Integer> operationCounts = new ArrayList<>();
        List<Long> durationList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int number = 1;

        for (List<Integer> list : lists) {
            SortResult result = Sorter.sort(list);
            stringBuilder.append("Array " + number + ": " + result.sortedList() + "\n\n");
            listOfSortedArrays.add(result.sortedList());
            operationCounts.add(result.operationCount());
            durationList.add(result.duration());
            number++;
        }

        new SortedArrayWindow(stringBuilder.toString());
        new GraphicWindow(durationList, listOfSortedArrays, operationCounts);
    }
}

