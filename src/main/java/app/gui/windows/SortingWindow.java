package app.gui.windows;

import app.utils.ButtonUtils;

import javax.swing.*;
import java.awt.*;

public class SortingWindow {

    private JFrame frame;
    private JLabel algoTypeLabel, messageLabel, fromLabel, toLabel;
    private JTextField fromTextField, toTextField;
    private JRadioButton randomGeneration, fileInput;
    private ButtonGroup inputGroup;
    private JButton submitButton;

    public SortingWindow() {
        initialize();
    }

    private void initialize(){
        frame = new JFrame("Sorting");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        algoTypeLabel = new JLabel("Merge sort");
        algoTypeLabel.setFont(new Font(null, Font.BOLD, 19));
        algoTypeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        messageLabel = new JLabel("Enter range of arrays generating");
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(Box.createVerticalStrut(5));
        topPanel.add(algoTypeLabel);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(messageLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        randomGeneration = new JRadioButton("Random generation", true);
        fileInput = new JRadioButton("Read from file");
        inputGroup = new ButtonGroup();
        inputGroup.add(randomGeneration);
        inputGroup.add(fileInput);

        JPanel radioPanel = new JPanel();
        radioPanel.add(randomGeneration);
        radioPanel.add(fileInput);

        fromLabel = new JLabel("from:");
        toLabel = new JLabel("to:");
        fromTextField = new JTextField(8);
        toTextField = new JTextField(8);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(fromLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(fromTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(toLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(toTextField, gbc);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> ButtonUtils.submit(fromTextField, toTextField, randomGeneration));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(submitButton, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(inputPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(resultPanel);

        JPanel downPanel = new JPanel();
        downPanel.setLayout(new GridLayout(2, 1));
        downPanel.add(radioPanel);
        downPanel.add(buttonPanel);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(downPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
