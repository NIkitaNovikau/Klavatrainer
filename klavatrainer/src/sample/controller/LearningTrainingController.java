package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.GUI.ScreenManager;

import java.io.*;
import java.util.Random;
public class LearningTrainingController {
    @FXML
    Button menuButton, referenceButton, startButton;

    @FXML
    ComboBox levelChoice;

    @FXML
    TextArea textArea, inputArea;

    @FXML
    ImageView keyboardImage;

    private int mistakes = 0;
    private final String stringSymbolsEnglish = "dfjksal;vbnmtgyheruiqwopcx,.z/[]";
    private final String stringSymbolsRussian = "ваолыфджимтьепнрукгшйцщзсчбюя.хъ";
    private final int textSize = 10;
    private int writedSymbols = 0;
    private String text;
    private String colorPart;

    @FXML
    public void initialize()
    {
        text = new String();
        colorPart = new String();
        startButton.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() +";");
        menuButton.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() +";");
        referenceButton.setStyle("-fx-text-fill: " + ScreenManager.getGuiInformation().getFontColor() +";");
        levelChoice.getItems().setAll("level1", "level2", "level3", "level4", "level5", "level6", "level7");
        levelChoice.getSelectionModel().selectFirst();
        textArea.setEditable(false);
        inputArea.setEditable(false);
        this.inputArea.textProperty().addListener((observable, oldValue, newValue) -> this.write(oldValue, newValue) );
        File imageFile = new File("E:\\3Kurs\\ЖРЦПО\\klavatrainer-master\\klavatrainer\\keyboard.png");
        Image image = new Image(imageFile.toURI().toString());
        keyboardImage.setImage(image);
    }

    private void write(String oldValue, String newValue)
    {
        if(startButton.getText() == "Stop") {
            if (oldValue.length() < newValue.length()) {
                if (newValue.substring(newValue.length() - 1).equalsIgnoreCase(text.substring(0, 1))) {
                    colorPart += this.text.substring(0, 1);
                    shiftText();
                    textArea.setText(this.text + "\n");
                    writedSymbols++;
                    if(text.length() == 0)
                    {
                        int result;
                        if(mistakes < textSize)
                            result = 100 - (mistakes % textSize)*10;
                        else
                            result = 0;
                        textArea.setText("Number of mistakes - " + Integer.toString(mistakes)
                                + "\nCorrect " + Integer.toString(result) + "%");
                        startButton.setText("Start");
                        writedSymbols = 0;
                        mistakes = 0;
                        if(result >= 80)
                            levelChoice.getSelectionModel().selectNext();
                        inputArea.setText("");
                        inputArea.setEditable(false);
                    }
                }
                else
                {
                    incMistakes();
                    String badText = inputArea.getText();
                    inputArea.setText(badText.substring(0, badText.length() - 1));
                }
            }
        }
    }
    @FXML
    public void startTraining(ActionEvent event) throws IOException {
        if (startButton.getText().equalsIgnoreCase("Start")) {
            startButton.setText("Stop");
            generateText();
            textArea.setText(this.text + "\n");
            inputArea.setEditable(true);
            inputArea.requestFocus();

            // Load and set the image using resource loading
            try {
                InputStream stream = getClass().getResourceAsStream("/keyboard.png");
                if (stream != null) {
                    Image image = new Image(stream);
                    keyboardImage.setImage(image);
                } else {
                    System.out.println("Failed to load the image. Make sure the image is in the correct location.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            startButton.setText("Start");
        }
    }


    public void showMenu(ActionEvent event) throws IOException {
        Stage stage = (Stage) menuButton.getScene().getWindow();
        ScreenManager.closeWindows(stage);
        ScreenManager.showWindows("fxml\\menu.fxml");
    }


    public void shiftText()
    {
        this.text = this.text.substring(1);
    }

    public void generateText()
    {
        this.text = "";
        String levelString = levelChoice.getValue().toString().replaceAll("level", "");
        int level = Integer.parseInt(levelString);
        for(int i = 0; i <= textSize; i++) {
            this.text += stringSymbolsEnglish.charAt(new Random().nextInt(level * 4));
        }
    }

    public void showReference(ActionEvent event) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\3Kurs\\ЖРЦПО\\klavatrainer-master\\klavatrainer\\src\\reference.txt"), "UTF-8"));
        String currentLine;
        while((currentLine = bufferedReader.readLine()) != null)
        {
            textArea.setText(currentLine);
        }
    }

    public void incMistakes()
    {
        this.mistakes++;
    }

    public void setNewLevel(){
        levelChoice.getSelectionModel().selectNext();
    }



}
