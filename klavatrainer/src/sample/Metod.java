package sample;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author kam123ua
 */
public class Metod {

    private static GUIInformation guiInformation;
    private static TrainingInformation trainingInformation;

    public Metod()
    {
        guiInformation = new GUIInformation("green", "green", "36");
        trainingInformation = new TrainingInformation();
    }

    public static void showWindows(String str) throws IOException {
        Stage primaryStage = new Stage();
        Pane mainPane;
        mainPane = FXMLLoader.load(Main.class.getResource(str));
        mainPane.setStyle(guiInformation.getBackgroundColor());
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.setTitle("Trainer");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void closeWindows(Stage stage) {
        stage.close();
    }

    public static GUIInformation getGuiInformation()
    {
        return guiInformation;
    }



}