package app.gui.windows;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraphicWindow {

    private final JFrame frame;
    private final List<Integer> elementsCountList;
    private final List<Integer> operationsCountList;
    private final List<Long> durationsList;

    public GraphicWindow(List<Long> durationsList, List<List<Integer>> lists, List<Integer> operationsCountList) {
        this.durationsList = durationsList;
        this.elementsCountList = lists.stream().map(List::size).collect(Collectors.toList());
        this.operationsCountList = operationsCountList;

        frame = new JFrame("Sorting Performance Analysis");
        frame.setSize(800, 600);
        frame.setLayout(new java.awt.GridLayout(1, 2));

        frame.add(createChartPanel("Operations per Elements", "Elements", "Operations",
                elementsCountList, operationsCountList));
        frame.add(createChartPanel("Time per Elements", "Elements", "Time (ns)",
                elementsCountList, durationsList));

        frame.setVisible(true);
    }

    private ChartPanel createChartPanel(String title, String xLabel, String yLabel, List<Integer> xData,
                                        List<? extends Number> yData) {
        XYSeries series = new XYSeries(title);
        for (int i = 0; i < xData.size(); i++) {
            series.add(xData.get(i).doubleValue(), yData.get(i).doubleValue());
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(title, xLabel, yLabel, dataset);
        return new ChartPanel(chart);
    }
}


