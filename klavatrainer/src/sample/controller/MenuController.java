package sample.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.GUI.ScreenManager;

import java.io.IOException;

public class MenuController {

    @FXML
    Button startButton, exitButton, settingButton;

    @FXML
    public void initialize()
    {
        startButton.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() +";");
        exitButton.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() +";");
        settingButton.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() +";");
    }

    public void showTraining(ActionEvent event) throws IOException {
        Stage stage = (Stage) startButton.getScene().getWindow();
        ScreenManager.closeWindows(stage);
        if(ScreenManager.getTrainingInformation().getTypeOfTraining().equalsIgnoreCase("learning"))
            ScreenManager.showWindows("fxml\\learningTraining.fxml");
        else
            ScreenManager.showWindows("fxml\\speedTraining.fxml");
    }

    public void showSettings(ActionEvent event) throws IOException {
        Stage stage = (Stage) startButton.getScene().getWindow();
        ScreenManager.closeWindows(stage);
        ScreenManager.showWindows("fxml\\settings.fxml");
    }

    public void exit(ActionEvent event)
    {
        Platform.exit();
    }
}
