package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private Button buttonLab3_2;

    @FXML
    private Button buttonLab4;

    @FXML
    void initialize() {
        buttonLab3_2.setOnAction(actionEvent -> {
            try {
                Stage stageNow = (Stage) buttonLab3_2.getScene().getWindow();
                stageNow.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../samples/lab3.2.fxml"));
                OpenNewSample(fxmlLoader,"Lab3_2");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonLab4.setOnAction(actionEvent -> {
            try {
                Stage stageNow = (Stage) buttonLab4.getScene().getWindow();
                stageNow.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../samples/lab4.fxml"));
                OpenNewSample(fxmlLoader,"Lab4");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void OpenNewSample(FXMLLoader fxmlLoader,String name) throws IOException {
        Parent lab4 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle(name);
        stage.setScene(new Scene(lab4));
        stage.show();
    }
}
