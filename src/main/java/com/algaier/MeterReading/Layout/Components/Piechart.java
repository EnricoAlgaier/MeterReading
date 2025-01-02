package com.algaier.MeterReading.Layout.Components;

import com.algaier.MeterReading.View.Dashboard.Dashboard;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class Piechart {
        private String title = "r";

        public Piechart(Dashboard dashboard) {


            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Category 1", 40);
            dataset.setValue("Category 2", 30);
            dataset.setValue("Category 3", 20);
            dataset.setValue("Category 4", 10);

            // JFreeChart erzeugen
            JFreeChart pieChart = ChartFactory.createPieChart(
                    this.title,    // Titel der Piechart
                    dataset,
                    true, true, false);

            // Plot-Style setzen
            PiePlot plot = (PiePlot) pieChart.getPlot();
            plot.setExplodePercent("Category 1", 0.10);

            // ChartPanel erzeugen
            ChartPanel panel = new ChartPanel(pieChart);


            dashboard.add(panel);



        }
    }