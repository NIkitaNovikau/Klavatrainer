package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;

public class SpeedTrainingController {

    @FXML
    Button menuButton, startButton;

    @FXML
    TextArea textArea, inputArea;

    @FXML
    ComboBox levelChoice;

    public String text;
    public int lenghtOfText;
    public long start, finish, time;

    @FXML
    public void initialize()
    {
        text = new String();
        levelChoice.getItems().setAll("test", "text1", "text2", "text3");
        levelChoice.getSelectionModel().selectFirst();
        textArea.setEditable(false);
        inputArea.setEditable(false);
        this.inputArea.textProperty().addListener((observable, oldValue, newValue) -> this.write(oldValue, newValue) );
    }

    public void showReference(ActionEvent event) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("A:\\trirpolabs\\tritpo\\klavatrainer\\src\\reference.txt"), "UTF-8"));
        String currentLine;
        while((currentLine = bufferedReader.readLine()) != null)
        {
            textArea.setText(currentLine);
        }
    }

    public void showMenu(ActionEvent event) throws IOException {
        Stage stage = (Stage) menuButton.getScene().getWindow();
        ScreenManager.closeWindows(stage);
        ScreenManager.showWindows("menu.fxml");
    }

    public void startTraining(ActionEvent event) throws IOException {
        if(startButton.getText().equalsIgnoreCase("Start")) {
            startButton.setText("Stop");
            setText();
            //textArea.setText(this.text + "\n");
            inputArea.setEditable(true);
            inputArea.requestFocus();
            start = System.currentTimeMillis();
        }
        else
        {
            startButton.setText("Start");
        }
    }

    public void setText() throws IOException {
        text = "";
        String fileName = levelChoice.getValue().toString();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("A:\\trirpolabs\\tritpo\\klavatrainer\\src\\" + fileName + ".txt"), "UTF-8"));
        String currentLine;
        textArea.setText("");
        while((currentLine = bufferedReader.readLine()) != null)
        {
            text += currentLine + "\n";
        }
        text.substring(0, text.length() - 1);
        textArea.setText(text);
        lenghtOfText = text.length();
    }

    private void write(String oldValue, String newValue) {
        if(startButton.getText() == "Stop") {
            if (oldValue.length() < newValue.length()) {
                if (!newValue.substring(newValue.length() - 1).equalsIgnoreCase(text.substring(0, 1))) {
                    String badText = inputArea.getText();
                    inputArea.setText(badText.substring(0, badText.length() - 1));
                }
                if (newValue.substring(newValue.length() - 1).equalsIgnoreCase(text.substring(0, 1)))
                {
                    shiftText();
                    textArea.setText(this.text + "\n");
                    if(text.length() == 0)
                    {
                        finish = System.currentTimeMillis();
                        int result;
                        time = (finish - start) / 1000;
                        result = lenghtOfText / (int) time;
                        textArea.setText("Your speed - " + result + " letters per second");
                        startButton.setText("Start");
                        inputArea.setText("");
                        inputArea.setEditable(false);
                    }
                }
            }
        }
    }

    public void shiftText()
    {
        this.text = this.text.substring(1);
    }
}
