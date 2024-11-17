package com.cryptoclient.application.views.dashboard.components;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {

    private JLabel contentTitle;
    private ChartPanel chartPanel;

    public Content() {
        this.setLayout(new BorderLayout());

        // Content title
        this.setContentTitle(new JLabel("Sélectionnez une crypto pour afficher son cours"));
        this.getContentTitle().setFont(new Font("Arial", Font.PLAIN, 20));
        this.getContentTitle().setHorizontalAlignment(JLabel.CENTER);
        this.add(this.getContentTitle(), BorderLayout.CENTER);

        // Chart
        //this.loadChartPanel();
    }

    public JFreeChart createChart() {
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries series = new TimeSeries("Cours de la crypto");
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Cours de la crypto", // title
                "Temps", // x
                "Prix", // y
                dataset, // Data
                true, // Legend
                true, // Tooltips
                false // URL
        );
        return chart;
    }

    public void loadChartPanel() {
        this.setChartPanel(new ChartPanel(this.createChart()));
        this.add(this.getChartPanel(), BorderLayout.SOUTH);
    }

    public ChartPanel getChartPanel() {
        return chartPanel;
    }

    public void setChartPanel(ChartPanel chartPanel) {
        this.chartPanel = chartPanel;
    }

    public JLabel getContentTitle() {
        return this.contentTitle;
    }

    public void setContentTitle(JLabel contentTitle) {
        this.contentTitle = contentTitle;
    }
}
