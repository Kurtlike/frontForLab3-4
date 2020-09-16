package controllers;

import elements.lab3_2.Boxes;
import elements.lab3_2.Chart;
import elements.Logger;
import elements.lab3_2.XField;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mainMethods.Lab3.IOData;

public class Lab3_2Controller {
    @FXML
    private ChoiceBox<String> functionChoose;

    @FXML
    private TextField xCoord;

    @FXML
    private Button performButton;

    @FXML
    private TextArea logArea;

    @FXML
    private LineChart<Number, Number> graph;

    @FXML
    private NumberAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    public Button closeButton;
    @FXML
    private ChoiceBox<String> dataChoose;
    @FXML
    void initialize(){
        closeButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        });
        Logger logger=new Logger(logArea);
        Boxes boxes=new Boxes(functionChoose,dataChoose);

        Chart chart=new Chart(graph);
        performButton.setOnAction(actionEvent -> {
            XField xField=new XField(xCoord,logger);
            logger.setLogs();
            IOData data=new IOData(xField.getvalueOfXCoord(),boxes.getSelectedFunction(),boxes.getSelectedData());
            chart.setChart(data.getAnswer().getSourceFunction(),data.getAnswer().getNewPoints(),data.getAnswer().getDots());
            logger.setLog("y="+data.getAnswer().getAnswer());
        });
    }
}
