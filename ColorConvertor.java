

import java.awt.*;

public class ColorConverter {
    //Add instance variables here
    private Color[][] myColors;

    public ColorConverter(int rows, int cols, int type, int[] first, int[] second, int[] third)
    {
        myColors = new Color[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                myColors[i][j] = new Color(type, first[count], second[count], third[count++]);
            }
        }
    }


    public Color[][] RGBtoHSV() {
        for (int i = 0; i < myColors.length; i++) {
            for (int j = 0; j < myColors[i].length; j++) {
                myColors[i][j] = myColors[i][j].RGBtoHSV();
            }
        }
        return myColors;
    }
    public Color[][] HSVtoRGB() {
        for (int i = 0; i < myColors.length; i++) {
            for (int j = 0; j < myColors[i].length; j++) {
                myColors[i][j] = myColors[i][j].HSVtoRGB();
            }
        }
        return myColors;
    }

    public void print() {
        for (int i = 0; i < myColors.length; i++) {
            for (int j = 0; j < myColors[i].length; j++) {
                myColors[i][j].printColor();
                System.out.println();
            }
        }
    }
}
