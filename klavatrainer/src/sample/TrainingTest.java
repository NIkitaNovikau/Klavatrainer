package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainingTest {

    @Test
    public void shiftTextTesting() {
        TextCreator textCreator = new TextCreator();
        assertEquals(textCreator.shiftText("asdf"),"sdf");
    }

    @Test
    public void textGeneraorTesting() {
        TextCreator textCreator = new TextCreator();
        String text = textCreator.newText("1");
        String text1 = textCreator.newText("3");
        assertTrue(textCreator.gootTextForLevel("1",text));
        assertTrue(textCreator.gootTextForLevel("3",text1));
    }
}