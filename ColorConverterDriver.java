package ColorPackage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorConverterDriver extends JPanel {
	
	public void paintComponent(Graphics g) {
		
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;

	    g2d.setColor(new Color(1, 0, 255, 255));
	    g2d.drawRect(10, 15, 90, 60);


	    g2d.setColor(new Color(1, 0, 255, 255));
	    g2d.fillRect(250, 195, 90, 60);

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
