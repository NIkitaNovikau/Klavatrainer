package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsController {

    @FXML
    Button saveButton, menuButton, backgroundDownloadButton;

    @FXML
    ComboBox fontColoreChoice, fontSizeChoice, backgroundColorChoice, trainingChoice;

    @FXML
    RadioButton showKeyboard, hintKeyboard;

    @FXML
    public void initialize()
    {
        /*saveButton.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() + ";");
        menuButton.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() + ";");*/
        //backgroundDownloadButton.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() + ";");
        backgroundColorChoice.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() + ";");
        fontColoreChoice.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() + ";");
        fontSizeChoice.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() + ";");
        trainingChoice.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() + ";");
        fontSizeChoice.getItems().setAll("36");
        fontSizeChoice.getSelectionModel().selectFirst();
        //fontColoreChoice.getItems().setAll("green", "blue");
        fontColoreChoice.getSelectionModel().selectFirst();
        backgroundColorChoice.getItems().setAll("green", "blue", "red", "black", "yellow");
        backgroundColorChoice.getSelectionModel().select(ScreenManager.getGuiInformation().getBackgroundColor());
        trainingChoice.getItems().setAll("learning", "speed");
        trainingChoice.getSelectionModel().select(ScreenManager.getTrainingInformation().getTypeOfTraining());
    }

    public void downloadImage()
    {

    }

    public void showMenu() throws IOException {
        Stage stage = (Stage) menuButton.getScene().getWindow();
        ScreenManager.closeWindows(stage);
        ScreenManager.showWindows("menu.fxml");
    }

    public void saveSettings() throws IOException {
        ScreenManager.getGuiInformation().setBackgroundColor(backgroundColorChoice.getValue().toString());
        //ScreenManager.getGuiInformation().setFontColor(fontColoreChoice.getValue().toString());
        ScreenManager.getTrainingInformation().setTypeOfTraining(trainingChoice.getValue().toString());
        Stage stage = (Stage) menuButton.getScene().getWindow();
        ScreenManager.closeWindows(stage);
        ScreenManager.showWindows("settings.fxml");
    }

}
