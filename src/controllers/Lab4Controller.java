package controllers;

import elements.lab4.Boxes;
import elements.lab4.Chart;
import elements.Logger;
import elements.lab4.Fields;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainMethods.Lab4.IOData;

public class Lab4Controller {
    @FXML
    private Button closeButton;

    @FXML
    private LineChart<Number, Number> graph;

    @FXML
    private NumberAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private TextArea logArea;

    @FXML
    private ChoiceBox<String> functionChoose;

    @FXML
    private TextField xCoord;

    @FXML
    private Button performButton;

    @FXML
    private TextField yCoord;

    @FXML
    private TextField xEnd;

    @FXML
    private TextField accuracy;

    @FXML
    void initialize(){
        closeButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        });
        Logger logger=new Logger(logArea);
        Boxes boxes=new Boxes(functionChoose);

        Chart chart=new Chart(graph);
        performButton.setOnAction(actionEvent -> {
            Fields fields=new Fields(xCoord,yCoord,accuracy,xEnd,logger);
            IOData ioData=new IOData(fields.getvalueOfXCoord(),fields.getvalueOfYCoord(),fields.getValueOfAccuracy(),fields.getValueOfXEnd(),boxes.getSelectedFunction());
            chart.setChart(ioData.getAnswer().getDotsForInterpolate(),ioData.getAnswer().getSourceFunction());
            logger.setLogs();
        });
    }
}
