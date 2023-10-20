package sample;

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

    public void setTypeOfTraining(String typeOfTraining) {
        this.typeOfTraining = typeOfTraining;
    }

    public String getTypeOfTraining()
    {
        return typeOfTraining;
    }
}
