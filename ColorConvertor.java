package color;

public class ColorConverter {
		   //Add instance variables here
		   private Color[][] myColors;
		  
		   public ColorConverter(int rows, int cols, int type, int[] first, int[] second, int[] third)
		   {
		       myColors = new Color[rows][cols];
		       int index = 0;
		       if (type == 1) {
		           for (int row = 0; row < myColors.length; row++) {
		               for (int col = 0; col < myColors[row].length; col++){
		                   myColors[row][col] = new Color(type, first[index], second[index], third[index]);
		                   index++;
		               }
		           }
		       }
		      






		   }
		  
		   public Color[][] RGBtoHSV() {
		       Color[][] rgbToHsv = new Color[myColors.length][myColors[0].length];
		       for (int row = 0; row < rgbToHsv.length; row++) {
		           for (int col = 0; col < rgbToHsv[row].length; col++){
		               rgbToHsv[row][col].RGBtoHSV();
		           }
		       }
		       return rgbToHsv;








		   }
		   public Color[][] HSVtoRGB() {
		       Color[][] hsvToRgb = new Color[myColors.length][myColors[0].length];
		       for (int row = 0; row < myColors.length; row++) {
		           for (int col = 0; col < myColors[row].length; col++){
		        	   hsvToRgb[row][col].HSVtoRGB();
		           }
		       }
		       return hsvToRgb;




		   }
		   public void print() {
			   for (int row = 0; row < myColors.length; row++) {
		           for (int col = 0; col < myColors[row].length; col++){
		        	   myColors[row][col].printColor();
		           }
		       }



		   }
		}




