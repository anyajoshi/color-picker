public class ColorConvertor {
    //Add instance variables here
    private Color[][] myColors;
	
	public ColorConverter(int rows, int cols, int type, int[] first, int[] second, int[] third)
	{
		myColors = new Color[rows][cols];
        if (type == 1) {
            for (int row = 0; row < myColors.length; i++) {
                for (int col = 0; col < myColors[row].length; col++){
                    myColors[row][col] = new Color(myColors.getRGB());
                }
            }
        }



	}
	
	public Color[][] RGBtoHSV() {
		Color[][] rgbToHsv = new Color[myColors.length][myColors[0].length];
		for (int row = 0; row < myColors.length; i++) {
			for (int col = 0; col < myColors[row].length; col++){
				rgbToHsv[row][col] = myColors.RGBtoHSV();
			}
		}
		return rgbToHsv;




	}
	public Color[][] HSVtoRGB() {
		Color[][] hsvToRgb = new Color[myColors.length][myColors[0].length];
		for (int row = 0; row < myColors.length; i++) {
			for (int col = 0; col < myColors[row].length; col++){
				rgbToHsv[row][col] = myColors.HSVtoRGB();
			}
		}
		return hsvToRgb;


	}
	public void print() {
		myColors.printColor();


	}
}

    
}
