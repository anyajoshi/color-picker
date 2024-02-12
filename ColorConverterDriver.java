import java.io.File;
import java.util.Arrays;
import java.util.Random;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorConverterDriver extends JPanel {

    //instance variable for 2D array rectColors containing Color objects
    private Color[][] rectColors;
    /** Method initializes the dimensions and coordinates of initial pixel
     *  for grid
     *  super keyword is used to call the parent class of JPanel
     * @author Esha Shivakumar
     *  @param g object of Graphics class
     */
    public void paintComponent(Graphics g) {
        int a =0;
        int b= 0;
        int c = 60;
        int d = 60;

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new java.awt.Color(255, 255, 0));
        g2d.fillRect(40, 20, 40, 40);
        for (int row=0; row< rectColors.length; row++) {
            for (int col = 0; col < rectColors[row].length; col++) {
                java.awt.Color gridColor = new java.awt.Color(rectColors[row][col].getRed(),rectColors[row][col].getGreen(),rectColors[row][col].getBlue());
                g2d.setColor(gridColor) ;
                g2d.fillRect(a, b, c, d);
                a+=60;
            }
            a=0;
            b+=60;
        }

    }

    /** Main method. Creates a new object of ColorConverter class
     * @author Esha Shivakumar
     * Prints given RGB values to HSV and vice versa
     * Converts random RGB values to HSV using Random class
     * Displays a matrix of colors depending on rgb.txt values
     * Scanner class is used to provide a menu to the user to convert RGB to HSV or HSV to RGB
     * Error checking is included by alerting the user if the value they entered is valid or not
     */

    public static void main(String[] args) {

        //Setup RGB with given values
        int[] first = {0, 255, 255, 0, 0, 255, 0, 255, 192, 128, 128, 128, 0, 128, 0, 0};
        int[] second = {0, 255, 0, 255, 0, 255, 255, 0, 192, 128, 0, 128, 128, 0, 128, 0};
        int[] third = {0, 255, 0, 0, 255, 0, 255, 255, 192, 128, 0, 0, 0, 128, 128, 128};
        ColorConverter cc = new ColorConverter(4, 4, 1, first, second, third);
        //cc.print();

        System.out.println("==============");
        System.out.println("== Given RGB to HSV ==");
        System.out.println("==============");
        cc.RGBtoHSV();
        cc.print();

        System.out.println("==============");
        System.out.println("== Given HSV back to RGB ==");
        System.out.println("==============");
        cc.HSVtoRGB();
        cc.print();

        System.out.println("==============");
        System.out.println("== Random RGB to HSV ==");
        System.out.println("==============");

        //Show Random RGB to HSV
        Random rand = new Random();
        int[] redArray = new int[16];
        int[] greenArray = new int[16];
        int[] blueArray = new int[16];

        for(int i=0; i < 16; i++){
            redArray[i] = rand.nextInt(256);
            greenArray[i] = rand.nextInt(256);
            blueArray[i] = rand.nextInt(256);
        }

        ColorConverter ccRandomRGB = new ColorConverter(4, 4, 1, redArray, greenArray, blueArray);
        ccRandomRGB.RGBtoHSV();
        ccRandomRGB.print();

        System.out.println("==============");
        System.out.println("== Random HSV to RGB ==");
        System.out.println("==============");

        //Shows Random HSV to RGB
        int[] hueArray = new int[16];
        int[] saturationArray = new int[16];
        int[] brightnessArray = new int[16];

        for(int i=0; i < 16; i++){
            hueArray[i] = rand.nextInt(360);
            saturationArray[i] = rand.nextInt(101);
            brightnessArray[i] = rand.nextInt(101);
        }

        ColorConverter ccRandomHSV = new ColorConverter(4, 4, 2, hueArray, saturationArray, brightnessArray);
        ccRandomHSV.HSVtoRGB();
        ccRandomHSV.print();

        boolean valid = false;
        int type = 0;
        //Menu using Scanner class

        Scanner s = new Scanner(System.in);  // Create a Scanner object
        while (!valid){
            System.out.println("Enter Conversion Choice (1 for RGB-to-HSV or 2 for HSV-to-RGB)");
            type = s.nextInt();
            if(type != 1 && type != 2){
                System.out.println("Invalid entry");
            } else {
                valid = true;
            }
        }

        int size = 16;
        int[] x = new int[size];
        int[] y = new int[size];
        int[] z = new int[size];

        valid = false;
        while (!valid){
            System.out.println("Enter location of your data file");
            String dataFileLoc = s.next();
            boolean inputValid = true;
            try {
                File f = new File(dataFileLoc);
                Scanner dataScanner = new Scanner(f);
                for (int i=0;i<size;i++){
                    x[i]=dataScanner.nextInt();
                    if(type ==1 && (x[i] <0 || x[i] > 255)){
                        System.out.println("Invalid value for Red. Range 0-255");
                        inputValid = false;
                    } else if (type ==2 && (x[i] <0 || x[i] >= 360)){
                        System.out.println("Invalid value for Hue. Range 0-359 degrees");
                        inputValid = false;
                    }
                }

                for (int i=0;i<size;i++){
                    y[i]=dataScanner.nextInt();
                    if(type ==1 && (y[i] <0 || y[i] > 255)){
                        System.out.println("Invalid value for Green . Range 0-255");
                        inputValid = false;
                    } else if (type ==2 && (y[i] <0 || y[i] > 100)){
                        System.out.println("Invalid value for Saturation. Range 0-100 %");
                        inputValid = false;
                    }
                }

                for (int i=0;i<size;i++){
                    z[i]=dataScanner.nextInt();
                    if(type ==1 && (z[i] <0 || z[i] > 255)){
                        System.out.println("Invalid value for Blue. Range 0-255");
                        inputValid = false;
                    } else if (type ==2 && (z[i] <0 || z[i] > 100)){
                        System.out.println("Invalid value for Brightness. Range 0-100 %");
                        inputValid = false;
                    }
                }
                if(inputValid){
                    valid = true;
                }
            }
            //Catches file errors
            catch(Exception e){
                System.out.println("Something went wrong: " + e.toString());
                valid = false;
            }
        }

        System.out.println("==============");
        System.out.println("== User Input  ==");
        System.out.println("==============");

        ColorConverter userInputColors = new ColorConverter(size/4, 4, type, x, y, z);
        if(type==1){
            userInputColors.RGBtoHSV();
        } else {
            Color[][] rectColors = userInputColors.HSVtoRGB();
            ColorConverterDriver rects = new ColorConverterDriver();
            rects.rectColors = rectColors;
            JFrame frame = new JFrame("Rectangles");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(rects);
            //Shows a 250x250 matrix of colors by calling setSize() method in JFrame class
            frame.setSize(250, 250);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);


        }
        userInputColors.print();
    }
}
