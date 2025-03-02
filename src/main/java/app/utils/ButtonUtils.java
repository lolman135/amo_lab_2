package app.utils;

import app.calculations.Sorter;
import app.gui.windows.ElementaryArrayWindow;
import app.gui.windows.GraphicWindow;
import app.gui.windows.SortedArrayWindow;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ButtonUtils {

    private static List<List<Integer>> lists = new ArrayList<>();

    public static void submit(JTextField fromField, JTextField toField, JRadioButton randomGeneration) {
        lists.clear();

        if (randomGeneration.isSelected()) {
            generateRandomLists(fromField, toField);
        } else {
            parseFile();
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
            stringBuilder.append("Array " + number + ": " + result.getSortedList() + "\n\n");
            listOfSortedArrays.add(result.getSortedList());
            operationCounts.add(result.getOperationCount());
            durationList.add(result.getDuration());
            number++;
        }

        new SortedArrayWindow(stringBuilder.toString());
        new GraphicWindow(durationList, listOfSortedArrays, operationCounts);
    }

    private static void generateRandomLists(JTextField fromField, JTextField toField) {
        try {
            int from = Integer.parseInt(fromField.getText());
            int to = Integer.parseInt(toField.getText());
            int number = 1000;
            Random rand = new Random();
            for (int i = 0; i < 20; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < number; j++) {
                    list.add(rand.nextInt(to - from + 1) + from);
                }
                number += 100;
                lists.add(list);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input range", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void parseFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("files/arrays.txt"))) {
            String line;
            while ((line = br.readLine()) != null && lists.size() < 10) {
                String[] numbers = line.split("\\s+");
                List<Integer> list = new ArrayList<>();
                for (String num : numbers) {
                    list.add(Integer.parseInt(num));
                }
                lists.add(list);
            }
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

