package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static ScreenManager screenManager;

    @Override
    public void start(Stage primaryStage) throws Exception{

        screenManager = new ScreenManager();
        screenManager.showWindows("menu.fxml");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
