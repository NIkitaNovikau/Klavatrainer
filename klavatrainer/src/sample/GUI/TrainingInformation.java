package sample.GUI;

public class TrainingInformation {
    private static boolean showKeyboard;
    private static boolean showKeyboardIfMistake;
    private static String typeOfTraining;

    public TrainingInformation()
    {
        showKeyboard = true;
        showKeyboardIfMistake = false;
        typeOfTraining = "learning";
    }

    public void setShowKeyboard(boolean showKeyboard) {
        this.showKeyboard = showKeyboard;
    }

    public boolean getShowKeyboard()
    {
        return showKeyboard;
    }

    public void SetShowKeyboardIfMistake(boolean showKeyboardIfMistake) {
        this.showKeyboardIfMistake = showKeyboardIfMistake;
    }

    public boolean getShowKeyboardIfMistake()
    {
        return showKeyboardIfMistake;
    }

    public void setTypeOfTraining(String typeOfTraining) {
        this.typeOfTraining = typeOfTraining;
    }
    public String getTypeOfTraining()
    {
        return typeOfTraining;
    }
}
