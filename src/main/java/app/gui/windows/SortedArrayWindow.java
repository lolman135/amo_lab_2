package app.gui.windows;

import javax.swing.*;
import java.awt.*;

public class SortedArrayWindow {

    private JTextArea arraysArea;
    private JScrollPane scrollPane;
    private JPanel mainPanel;
    private JFrame frame;
    private String arraysText;

    public SortedArrayWindow(String arraysText) {
        this.arraysText = arraysText;
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("Sorted Array");
        frame.setSize(400, 350);

        arraysArea = new JTextArea(15, 30);
        arraysArea.setLineWrap(true);
        arraysArea.setWrapStyleWord(true);
        arraysArea.setEditable(false);
        arraysArea.setText(arraysText);

        scrollPane = new JScrollPane(arraysArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 250));


        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
