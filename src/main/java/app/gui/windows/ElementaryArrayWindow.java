package app.gui.windows;

import javax.swing.*;
import java.awt.*;

public class ElementaryArrayWindow {
    private JTextArea arraysArea;
    private JButton sortButton;
    private JScrollPane scrollPane;
    private JPanel mainPanel;
    private JFrame frame;

    public ElementaryArrayWindow() {
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("Array Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);

        arraysArea = new JTextArea(15, 30);
        arraysArea.setLineWrap(true);
        arraysArea.setWrapStyleWord(true);
        arraysArea.setEditable(false);

        scrollPane = new JScrollPane(arraysArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 250));

        sortButton = new JButton("Sort arrays and display graphics");

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(sortButton, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
