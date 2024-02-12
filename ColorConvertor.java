

import java.awt.*;

public class ColorConverter {
    //Instance variable declaring 2D array myColors holding Color objects
    private Color[][] myColors;
    /**
	   * Constructor creates a 2-D array of the given number of rows and columns
	   * Constructor also populates the array by the given three arrays: first, second, third
	   * @author - Esha Shivakumar
	   * @param rows - number of rows
	   * @param cols - number of columns
	   * @param type - type of array (RGB/HSV integers)
	   * @param first - array of red integers or hue integers
	   * @param second - array of green integers or saturation integers
	   * @param third - array of blue integers or value integers
	   * 
	   */
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

    /**
	   * Calls the RGBtoHSV() method from color class to convert HSV to RGB
	   * @author - Esha Shivakumar
	   * @return - 2D array of color objects (myColors) where values are manipulated to HSV values 
	   * 
	   */
    public Color[][] RGBtoHSV() {
        for (int i = 0; i < myColors.length; i++) {
            for (int j = 0; j < myColors[i].length; j++) {
                myColors[i][j] = myColors[i][j].RGBtoHSV();
            }
        }
        return myColors;
    }
    
    /**
	   * Calls the HSVtoRGB() method from color class to convert HSV to RGB
	   * @author - Esha Shivakumar
	   * @return - 2D array of color objects (myColors) where values are manipulated to RGB values 
	   */
    public Color[][] HSVtoRGB() {
        for (int i = 0; i < myColors.length; i++) {
            for (int j = 0; j < myColors[i].length; j++) {
                myColors[i][j] = myColors[i][j].HSVtoRGB();
            }
        }
        return myColors;
    }

    
    /**
	   * Prints the 2D array of color objects (myColors) by calling printColor() method from Color class
	   * @author - Esha Shivakumar	   
	   */
    public void print() {
        for (int i = 0; i < myColors.length; i++) {
            for (int j = 0; j < myColors[i].length; j++) {
                myColors[i][j].printColor();
                System.out.println();
            }
        }
    }
}
