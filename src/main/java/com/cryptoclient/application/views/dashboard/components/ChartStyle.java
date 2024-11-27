package com.cryptoclient.application.views.dashboard.components;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;

import java.awt.*;

public class ChartStyle {

    public static void applyStyle(JFreeChart chart) {
        XYPlot plot = chart.getXYPlot();

        // Couleur de fond
        plot.setBackgroundPaint(Color.DARK_GRAY);

        // Couleur des lignes de quadrillage
        plot.setDomainGridlinePaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.WHITE);

        // Marges
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));

        // Courbe
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.CYAN);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);

        // Personnalisation des axes
        plot.getDomainAxis().setLabelPaint(Color.WHITE);
        plot.getDomainAxis().setTickLabelPaint(Color.WHITE);
        plot.getRangeAxis().setLabelPaint(Color.WHITE);
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE);

        // Titre du graphique
        chart.getTitle().setPaint(Color.WHITE);
        chart.getTitle().setFont(new Font("Arial", Font.BOLD, 16));
    }
}
