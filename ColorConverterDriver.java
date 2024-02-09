package ColorPackage;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorConverterDriver extends JPanel {
	
	public void paintComponent(Graphics g) {
		Random rand = new Random();
		int a =0;
		int b= 0;
		int c = 20;
		int d = 20;
		
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;

	  /*  g2d.setColor(new Color(1, 0, 255, 255));
	    g2d.fillRect(0, 0, 20, 20); //(a , b, how wide it is, top to bottom (how long)
	    g2d.setColor(new Color(1, 255, 0, 255));
	    g2d.fillRect(0, 20, 20, 20); //(translate left/right, translate down, how wide it is, top to bottom (how long)
	    g2d.setColor(new Color(1, 0, 0, 255));
	    g2d.fillRect(20, 20, 20, 20);//translate to the right
	    g2d.setColor(new Color(1, 200, 150, 255));
	    g2d.fillRect(40, 20, 20, 20);*/
	    


	  
	    g2d.setColor(new Color(1, 255, 255, 0));
	    g2d.fillRect(40, 20, 20, 20);
	    Color[][] pixel = new Color[10][10];
	    for (int row=0; row<pixel.length; row++) {
	    	for (int col = 0; col < pixel[row].length; col++) {
	    		int x = rand.nextInt(256);
	    		int y = rand.nextInt(256);
	    		int z = rand.nextInt(256);
	    		pixel[row][col] = new Color (1, x, y, z);
	    		g2d.setColor(pixel[row][col]);
				g2d.fillRect(a, b, c, d);
	    		a+=20;
	    	}
	    	a=0;
	    	b+=20;
	    }
	    	
	}
	   

	  
	public static void main(String[] args) {
		int[] first = {0, 255, 255, 0, 0, 255, 0, 255, 192, 128, 128, 128, 0, 128, 0, 0};
	    int[] second = {0, 255, 0, 255, 0, 255, 255, 0, 192, 128, 0, 128, 128, 0, 128, 0};
	    int[] third = {0, 255, 0, 0, 255, 0, 255, 255, 192, 128, 0, 0, 0, 128, 128, 128};
        ColorConverter cc = new ColorConverter(4, 4, 1, first, second, third);
        cc.print();
        System.out.println("HSV:");
        cc.RGBtoHSV();
        cc.print();
        System.out.println("RGB");
        cc.HSVtoRGB();
        cc.print();
        
        
        ColorConverterDriver rects = new ColorConverterDriver();
        JFrame frame = new JFrame("Rectangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rects);
        frame.setSize(250, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

	}
}
