package color;

public class ColorConverterDriver {
public static void main(String[] args) {
		int [] red = new int[]
	ColorConverter obj1 = new ColorConverter(1, 0, 255, 255);
		Color obj2 = new Color(1, 0, 255, 0);
		Color obj3 = new Color(1, 0, 0, 255);
		
		int[] hsv1 = obj1.getRGB();
		int[] hsv2 = obj2.getRGB();
		int[] hsv3 = obj3.getRGB();
		System.out.println(hsv1);
		System.out.println(hsv2);
		System.out.println(hsv3);
		
	}
}


