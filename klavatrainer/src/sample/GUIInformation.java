package sample;

public class GUIInformation
{

    private static String backgroundColor;
    private static String fontColor;
    private static String fontSize;


    public GUIInformation(String backgroundColor, String fontColor, String size)
    {
        this.backgroundColor = backgroundColor;
        this.fontColor = backgroundColor;
        this.fontSize = size;
    }

    public String getBackgroundColor()
    {
        return this.backgroundColor;
    }

    public void setBackgroundColor(String color)
    {
        this.backgroundColor = color;
    }

    public String getFontColor() { return this.fontColor; }

    public void setFontColor(String color)
    {
        this.fontColor = color;
    }

    public String getFontSize() { return this.fontSize; }

    public void setFontSize(String size)
    {
        this.fontSize = size;
    }
}
