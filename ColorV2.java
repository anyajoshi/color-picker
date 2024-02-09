package ColorPackage;

public class Color {
	//Add your instance variables here
	private int red, green, blue, hue, saturation, brightness;
	private final int MAX_COLOR = 225;
	
	
	public Color(int type, int a, int b, int c) {
		if (type == 1) {
            red = a;
            green = b;
            blue = c;
        }
        else if (type == 2) {
            hue = a;
            saturation = b;
            brightness = c;
        }
        else {
            System.out.println("Invalid type");
        }



	}
	public void setRGB(int r, int g, int b) {
		red = r;
        green = g;
        blue = b;



	}
	public void setHSV(int h, int s, int b) {
		hue = h;
        saturation = s;
        brightness = b;

	}
	public void setRed(int r) {
		red = r;

	}
	public void setGreen(int g) {
		green = g;


	}
	public void setBlue(int b) {
        blue = b;
	}
	public void setHue(int h) {
		
		hue = h;

	}
	public void setSaturation(int s) {
		saturation = s;


	}
	public void setBrightness(int b) {
		brightness = b;


	}
	public int getRed() {
		return red;


	}
	public int getBlue() {
		return blue;


	}
	public int getGreen() {
		return green;

	}
	public int getHue() {
		return hue;


	}
	public int getSaturation() {
		
		return saturation;

	}
	public int getBrightness() {
		
		return brightness;

	}
	public int[] getRGB() {
		return new int[] {red, green, blue};

	}
	public int[] getHSV() {
		return new int[] {hue, saturation, brightness};


	}
	
	private double getMaximum(double one, double two, double three) {
		if (one >= two && one >= three) {
	           return one;
	       } else if (two >= one && two >= three) {
	           return two;
	       } else {
	           return three;
	       }

	}
	private double getMinimum(double one, double two, double three) {
		if (one <= two && one <= three) {
            return one;
        } else if (two <= one && two <= three) {
            return two;
        } else {
            return three;
        }


	}
	private void calculateHue(double r, double g, double b, double max, double min) {
		if (max == min) {
            hue = 0;
        }
        if (max == r) {
            hue = (int) (60 * (((g - b) / (max - min)) % 6));
        }
        if (max == g) {
            hue = (int) (60 * ((b - r) / (max - min)) + 2);
        }
        if (max == b) {
            hue = (int) (60 * ((r - g) / (max - min)) + 4);
        }
    }

	private void calculateSaturation(double r, double g, double b, double max, double min) {
		if (max == 0) {
            saturation = 0;
        }
        else {
            saturation = (int) ((max - min) / max);
        }


	}
	
	public Color RGBtoHSV() {
		double r = red / (double) MAX_COLOR;
        double g = green / (double) MAX_COLOR;
        double b = blue / (double) MAX_COLOR;
        double max = getMaximum(r, g, b);
        double min = getMinimum(r, g, b);
        calculateHue(r, g, b, max, min);
        calculateSaturation(r, g, b, max, min);
        brightness = (int) max;
        return new Color(2, hue, saturation, brightness);

	}
	public Color HSVtoRGB() {
		double c = brightness * saturation;
        double x = c * (1 - Math.abs((hue / 60) % 2 - 1));
        double m = brightness - c;
        double r = 0, g = 0, b = 0;
        if (hue >= 0 && hue < 60) {
            r = c;
            g = x;
            b = 0;
        }
        else if (hue >= 60 && hue < 120) {
            r = x;
            g = c;
            b = 0;
        }
        else if (hue >= 120 && hue < 180) {
            r = 0;
            g = c;
            b = x;
        }
        else if (hue >= 180 && hue < 240) {
            r = 0;
            g = x;
            b = c;
        }
        else if (hue >= 240 && hue < 300) {
            r = x;
            g = 0;
            b = c;
        }
        else if (hue >= 300 && hue < 360) {
            r = c;
            g = 0;
            b = x;
        }
        red = (int) ((r + m) * MAX_COLOR);
        green = (int) ((g + m) * MAX_COLOR);
        blue = (int) ((b + m) * MAX_COLOR);
        return new Color(1, red, green, blue);
	}
	
	public void printColor()
	{
		char c = 176;
		System.out.printf("%10s%3d%2s%3d%2s%3d%2s", "\tRGB = (" , red , ", " , green , ", " , blue , ")");
		System.out.printf("%10s%3d%2s%3d%2s%3d%2s", "HSV = (" , hue , (""+ c+", ")  , saturation , "%, " , brightness , "%)");
	}
}
