package elements.lab4;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class Chart {
    LineChart<Number, Number> graph;

    public Chart(LineChart<Number, Number> graph){
        this.graph=graph;
    }

    public void setChart(double[][] dots,double[][] sourceFunction){
        XYChart.Series<Number,Number> sourceSeries = new XYChart.Series<>();
        graph.getData().clear();
        graph.setCreateSymbols(false);
        for(double []k:sourceFunction){
            sourceSeries.getData().add(new XYChart.Data<>(k[0], k[1]));
        }
        graph.getData().addAll(sourceSeries);

        for(double []k:dots){
            XYChart.Series<Number,Number> dSeries = new XYChart.Series<>();
            dSeries.getData().add((new XYChart.Data<>(k[0], k[1])));
            graph.getData().addAll(dSeries);
        }
    }
}
