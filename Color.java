package color;

public class Color {
	private final int MAX_COLOR = 225;
	   private int red;
	   private int green;
	   private int blue;
	   private int hue;
	   private int saturation;
	   private int brightness;

	   public Color(int type, int value1, int value2, int value3) {
	       if (type == 1) {
	           setRGB(value1, value2, value3);
	       } else if (type == 2) {
	           setHSV(value1, value2, value3);
	       }
	   }


	   public void setRGB(int r, int g, int b) {
	       red = r;
	       green = g;
	       blue = b;
	       RGBtoHSV();
	   }

	   public void setHSV(int h, int s, int v) {
	       h = hue;
	       s = saturation;
	       v = brightness;

	       HSVtoRGB();

	   }

	   public void setRed(int r) {
	       red = r;

	       RGBtoHSV();
	   }

	   public void setGreen(int g) {
	       green = g;

	       RGBtoHSV();
	   }

	   public void setBlue(int b) {
	       blue = b;

	       RGBtoHSV();
	   }

	   public void setHue(int h) {
	       hue = h;

	       HSVtoRGB();
	   }
	   public void setSaturation(int s) {
	       saturation = s;

	       HSVtoRGB();
	   }
	   public void setBrightness(int v) {
	       brightness = v;

	       HSVtoRGB();
	   }

	   public int[] getRGB(){
	       return new int[]{red,green,blue};
	   }

	   public int[] getHSV(){
	       return new int[]{hue,saturation,brightness};
	   }

	   private double getMaximum(double d1, double d2, double d3) {
	       if (d1 >= d2 && d1 >= d3) {
	           return d1;
	       } else if (d2 >= d1 && d2 >= d3) {
	           return d2;
	       } else {
	           return d3;
	       }

	   }

	       private double getMinimum(double d1, double d2, double d3) {
	           if (d1 <= d2 && d1 <= d3) {
	               return d1;
	           } else if (d2 <= d1 && d2 <= d3) {
	               return d2;
	           } else {
	               return d3;
	           }

	       }

	       private double calculateHue(double r, double g, double b, double max, double min){

	           double rp = r/(double)MAX_COLOR;
	           double gp = g/(double)MAX_COLOR;
	           double bp = b/(double)MAX_COLOR;

	           max = getMaximum(rp,gp,bp);
	           min = getMinimum(rp,gp,bp);
	           double delta =  max- min;

	           if(max == rp){
	              return 60*(gp-bp)/delta%6;

	           }
	           if (max == gp){
	               return 60*(bp-rp)/delta +2;
	           }

	           if (max == bp){
	               return 60*(rp-gp)/delta +4;
	           }
	           return -1;


	       }



	   private double calculateSaturation(double r, double g, double b, double max, double min){

	       double rp = r/(double)MAX_COLOR;
	       double gp = g/(double)MAX_COLOR;
	       double bp = b/(double)MAX_COLOR;

	       max = getMaximum(rp,gp,bp);
	       min = getMinimum(rp,gp,bp);
	       double delta =  max- min;

	       if(max ==0){
	           return 0;
	       }
	       if (max !=0){
	           return delta/max;
	       }
	       return -1;


	   }

	   private double calculateBrightness(double r, double g, double b, double max, double min){

	       double rp = r/(double)MAX_COLOR;
	       double gp = g/(double)MAX_COLOR;
	       double bp = b/(double)MAX_COLOR;

	       max = getMaximum(rp,gp,bp);
	       min = getMinimum(rp,gp,bp);

	      return max;


	   }

	   public void RGBtoHSV(){
	       double r = red / (double) MAX_COLOR;
	       double g = green / (double) MAX_COLOR;
	       double b = blue / (double) MAX_COLOR;

	       double max = getMaximum(r, g, b);
	       double min = getMinimum(r, g, b);

	       hue = (int) calculateHue(r, g, b, max, min);
	       saturation = (int) (calculateSaturation(r, g, b, max, min) * 100); 
	       brightness = (int) (calculateBrightness(r, g, b, max, min) * 100);
	   }

	   public void HSVtoRGB(){
	       double r = red / (double) MAX_COLOR;
	       double g = green / (double) MAX_COLOR;
	       double b = blue / (double) MAX_COLOR;

	       double max = getMaximum(r, g, b);
	       double min = getMinimum(r, g, b);

	       hue = (int) calculateHue(r, g, b, max, min);
	       saturation = (int) (calculateSaturation(r, g, b, max, min) * 100);  // Convert to percentage
	       brightness = (int) (calculateBrightness(r, g, b, max, min) * 100);
	   }

	   public void printColor()
	   {
	       char c = 176;
	       System.out.printf("%10s%3d%2s%3d%2s%3d%2s", "\tRGB = (" ,
	      red , ", " , green , ", " , blue , ")");
	       System.out.printf("%10s%3d%2s%3d%2s%3d%2s", "HSV = (" , hue
	           , (""+ c+", ") , saturation , "%, " , brightness ,
	        "%)\n");
	   }

	}



