package app.utils;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayUtils {

    public static void generateRandomLists(List<List<Integer>> lists, JTextField fromField, JTextField toField) {
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

    public static void parseFile(List<List<Integer>> lists) {
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
