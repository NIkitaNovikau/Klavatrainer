package sample;

import java.util.Random;

public class TextCreator {

    private final String stringSymbolsEnglish = "dfjksal;vbnmtgyheruiqwopcx,.z/[]";
    private final int textSize = 10;

    public String shiftText(String text)
    {
        return text.substring(1);
    }

    public String newText(String levelString){
        String text = new String();
        int level = Integer.parseInt(levelString);
        for(int i = 0; i <= textSize; i++) {
            text += stringSymbolsEnglish.charAt(new Random().nextInt(level * 4));
        }
        return text;
    }

    public boolean gootTextForLevel(String levelString, String text)
    {
        int level = Integer.parseInt(levelString);
        if(text.indexOf(stringSymbolsEnglish.charAt((level*4) + 1)) != -1)
            return false;
        return true;
    }
}
