package sample;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author kam123ua
 */
public class  ScreenManager {

    private static GUIInformation guiInformation;
    private static TrainingInformation trainingInformation;

    public ScreenManager()
    {
        guiInformation = new GUIInformation("blue", "blue", "36");
        trainingInformation = new TrainingInformation();
    }

    public static void showWindows(String str) throws IOException {
        Stage primaryStage = new Stage();
        Pane mainPane;
        mainPane = FXMLLoader.load(Main.class.getResource(str));
        mainPane.setStyle("-fx-background-color: " + guiInformation.getBackgroundColor() + ";");
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

    public static TrainingInformation getTrainingInformation() { return trainingInformation;}

}