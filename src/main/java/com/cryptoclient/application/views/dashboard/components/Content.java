package com.cryptoclient.application.views.dashboard.components;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

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
    }

    /**
     * Crée un graphique interactif à partir des données fournies.
     *
     * @param cryptocurrencyName Le nom de la cryptomonnaie
     * @param data               Les données JSON contenant les prix et les heures
     * @return JFreeChart configuré et stylisé
     */
    private JFreeChart createChart(String cryptocurrencyName, JSONArray data) {
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries series = new TimeSeries("Cours de la crypto : " + cryptocurrencyName);

        for (int i = 0; i < data.length(); i++) {
            // Récupérer l'objet JSON
            JSONObject obj = data.getJSONObject(i);

            // Convertir l'heure en RegularTimePeriod
            String time = obj.getString("time_close");
            Instant instant = Instant.parse(time);
            Date date = Date.from(instant);
            RegularTimePeriod period = new Hour(date);

            // Ajouter le prix au TimeSeries
            double price = obj.getDouble("rate_close");
            series.add(period, price);
        }

        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Cours de la cryptomonnaie : " + cryptocurrencyName, // Titre
                "Temps", // Label X
                "Prix (EUR)", // Label Y
                dataset, // Dataset
                true, // Affiche la légende
                true, // Activer les tooltips
                false // Pas de URLs
        );

        // Appliquer un style personnalisé
        customizeChart(chart);

        return chart;
    }

    /**
     * Applique un style personnalisé au graphique, y compris un curseur dynamique sur la courbe.
     *
     * @param chart Le graphique à styliser
     */
    private void customizeChart(JFreeChart chart) {
        XYPlot plot = chart.getXYPlot();

        // Couleur de fond
        plot.setBackgroundPaint(new Color(240, 240, 240)); // Blanc cassé
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        // Marges
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));

        // Styliser la courbe
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
        renderer.setSeriesPaint(0, new Color(0, 102, 204)); // Bleu vif
        renderer.setSeriesStroke(0, new BasicStroke(2.0f)); // Épaisseur de la ligne

        // Ajouter un curseur dynamique limité à la courbe
        renderer.setDefaultToolTipGenerator(new StandardXYToolTipGenerator(
                "Temps : {1}, Prix : {2}",
                new SimpleDateFormat("yyyy-MM-dd HH:mm"), new DecimalFormat("0.00")));

        plot.setRenderer(renderer);

        // Personnalisation des axes
        plot.getDomainAxis().setLabelPaint(Color.DARK_GRAY);
        plot.getDomainAxis().setTickLabelPaint(Color.DARK_GRAY);
        plot.getRangeAxis().setLabelPaint(Color.DARK_GRAY);
        plot.getRangeAxis().setTickLabelPaint(Color.DARK_GRAY);

        // Titre
        chart.getTitle().setPaint(Color.DARK_GRAY);
        chart.getTitle().setFont(new Font("Arial", Font.BOLD, 16));
    }

    /**
     * Charge un graphique interactif dans le panneau.
     *
     * @param cryptocurrencyName Le nom de la cryptomonnaie
     * @param data               Les données JSON pour la courbe
     */
    public void loadChartPanel(String cryptocurrencyName, JSONArray data) {
        // Supprimer l'ancien graphique s'il existe
        if (this.getChartPanel() != null) {
            this.getChartPanel().setVisible(false);
            this.remove(this.getChartPanel());
        }

        JFreeChart chart = this.createChart(cryptocurrencyName, data);

        // Configurer le ChartPanel avec des options interactives
        this.setChartPanel(new ChartPanel(chart));
        this.getChartPanel().setMouseWheelEnabled(true); // Zoom avec la molette
        this.getChartPanel().setHorizontalAxisTrace(true); // Suivi horizontal
        this.getChartPanel().setVerticalAxisTrace(true); // Suivi vertical

        this.add(this.getChartPanel(), BorderLayout.SOUTH);

        // Rafraîchir la vue
        this.revalidate();
        this.repaint();
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
