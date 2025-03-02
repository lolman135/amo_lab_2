package app.gui.menu;


import app.gui.windows.SortingWindow;

import javax.swing.*;
import java.awt.*;

public class Menu {
    private JFrame frame;
    private JButton startButton;
    private JLabel label, nameLabel, groupLabel, numberLabel;

    public Menu() {
        initializeComponents();
    }

    private void initializeComponents() {
        frame = new JFrame("Sorting Menu");
        frame.setSize(270, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        label = new JLabel("Menu");
        nameLabel = new JLabel("Kusovskyi Kyrylo Leonidovych");
        groupLabel = new JLabel("Group: ІО-31");
        numberLabel = new JLabel("Number at group and variant: 12");

        startButton = new JButton("Start work");


        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font(null, Font.BOLD, 19));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setFont(new Font(null, Font.PLAIN, 12));
        groupLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        groupLabel.setFont(new Font(null, Font.PLAIN, 12));
        numberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        numberLabel.setFont(new Font(null, Font.PLAIN, 12));

        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(e -> new SortingWindow());

        panel.add(Box.createVerticalStrut(5));
        panel.add(label);
        panel.add(Box.createVerticalStrut(20));
        panel.add(startButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(Box.createVerticalStrut(20));
        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(groupLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(numberLabel);

        frame.add(panel);
    }

    public void draw() {
        frame.setVisible(true);
    }
}