public class Color {
    private final int MAX_COLOR = 255;
    private int red;
    private int green;
    private int blue;
    private int hue;
    private int saturation;
    private int brightness;
    /**
     * @author Anya Joshi
     * @param type
     * @param value1
     * @param value2
     * @param value3
     */
    public Color(int type, int value1, int value2, int value3) {
        if (type == 1) {
            setRGB(value1, value2, value3);
        } else if (type == 2) {
            setHSV(value1, value2, value3);
        }
    }

    /**
     * @author Anya Joshi
     * @param r
     * @param g
     * @param b
     */
    public void setRGB(int r, int g, int b) {
        red = r;
        green = g;
        blue = b;

    }
    /**
     * @author Anya Joshi
     * @param h
     * @param s
     * @param v
     */
    public void setHSV(int h, int s, int v) {
        hue = h;
        saturation = s;
        brightness = v;



    }
    /**
     * @author Anya Joshi
     * @param r
     */
    public void setRed(int r) {
        red = r;


    }
    /**
     * @author Anya Joshi
     * @param g
     */
    public void setGreen(int g) {
        green = g;


    }
    /**
     * @author Anya Joshi
     * @param b
     */
    public void setBlue(int b) {
        blue = b;


    }
    /**
     * @author Anya Joshi
     * @param h
     */
    public void setHue(int h) {
        hue = h;


    }
    /**
     * @author Anya Joshi
     * @param s
     */
    public void setSaturation(int s) {
        saturation = s;


    }
    /**
     * @author Anya Joshi
     * @param v
     */
    public void setBrightness(int v) {
        brightness = v;


    }

    /**
     * @author Anya Joshi
     * @return
     */
    public int getRed(){
        return red;
    }

    public int getBlue(){
        return blue;
    }
    public int getGreen(){
        return green;
    }
    public int getHue(){
        return hue;
    }
    public int getSaturation(){
        return saturation;
    }
    public int getBrightness(){
        return brightness;
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

        double rp = r/MAX_COLOR;
        double gp = g/MAX_COLOR;
        double bp = b/MAX_COLOR;

        max = getMaximum(rp,gp,bp);
        min = getMinimum(rp,gp,bp);

        double delta =  max- min;

        if(delta==0){
            return 0;
        }
        double hue = 0;
        if(max == rp){
            hue = 60*(((gp-bp)/delta)%6);
        }
        if (max == gp){
            hue= 60*((bp-rp)/delta +2);
        }
        if (max == bp){
            hue =  60*((rp-gp)/delta +4);
        }

        if(hue<0 ){
            hue += 360;
        } else if (hue>=360){
            hue -= 360;
        }
        return hue;


    }



    private double calculateSaturation(double r, double g, double b, double max, double min){

        double rp = r/(double)MAX_COLOR;
        double gp = r/(double)MAX_COLOR;
        double bp = r/(double)MAX_COLOR;


        double delta =  max- min;

        if(max ==0){
            return 0;
        }
        if (max !=0){
            return delta/max*100;
        }
        return -1;


    }

    private double calculateBrightness(){


        double rp = this.red/(double)MAX_COLOR;
        double gp = this.green/(double)MAX_COLOR;
        double bp = this.blue/(double)MAX_COLOR;



        return  getMaximum(rp,gp,bp)*100;


    }

    public Color RGBtoHSV(){
        double r = this.red;
        double g = this.green;
        double b = this.blue;
        double max = getMaximum(r,g,b);
        double min= getMinimum(r,g,b);
        hue = (int) calculateHue(r,g,b,max,min);
        saturation = (int) calculateSaturation(r,g,b,max,min);
        brightness = (int) calculateBrightness();

        //return new Color(2,hue, saturation, brightness);
        return this;
    }

    public Color HSVtoRGB(){
        double h= this.hue;
        double s = this.saturation/(double)100;
        double v = this.brightness/(double)100;
        double c = v * s;
        double y = (h/60)%2 - 1;
        if (y < 0){
            y = y * -1;
        }
        double x = c * (1 - y );


        double m = v - c;
        double rp = 0, gp=0, bp=0;

        if(h >=0 && h <60){
            rp = c;
            gp=x;
            bp=0;
        }
        else if (h >=60 && h < 120){
            rp =x;
            gp =c;
            bp =0;
        }
        else if (h >=120 && h <180){
            rp =0;
            gp =c;
            bp =x;
        }
        else if (h >=180 && h <240){
            rp =0;
            gp =x;
            bp =c;
        }
        else if (h >= 240 && h <300){
            rp =x;
            gp =0;
            bp =c;
        }
        else if (h  >=300 && h <360){
            rp =c;
            gp =0;
            bp =x;
        }
        double rt = (rp +m)*MAX_COLOR;
        if(rt>255){
            red = (int)rt;
        } else {
            //if (rt * 10 % 10 != 0){
             //   red = (int)rt +1;
            //}
            red = (int)(rt + 0.99);
        }

        double gt = (gp +m)*MAX_COLOR;
        if(gt>255){
            green = (int)gt;
        } else {
            //if (gt * 10 % 10 != 0){
             //   green = (int)gt +1;
            //}
            green = (int)(gt + 0.99);
        }

        double bt = (bp +m)*MAX_COLOR;
        if(bt>255){
            blue = (int)bt;
        } else {
            //if (bt * 10 % 10 != 0){
            //    blue = (int)bt +1;
            //}
            blue = (int)(bt +0.99);
        }

        return this;
        //return new Color(1, red, green, blue);
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



    public static void main (String args[]){
        System.out.println("TESTING");
        //Color c = new Color(1,0,128,128);
        //c.RGBtoHSV();
        //c.printColor();

        Color c = new Color (2,0,0,75);
        c.HSVtoRGB();
        c.printColor();

    }
}
