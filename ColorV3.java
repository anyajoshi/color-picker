public class Color {
    private final int MAX_COLOR = 255;
    private int red;
    private int green;
    private int blue;
    private int hue;
    private int saturation;
    private int brightness;
    /**
     * constructor for the color class
     * @author Anya Joshi
     * @param type - 1 for rgb to hsv and 2 for hsv to rgb
     * @param value1 - red or hue
     * @param value2 - green or saturation
     * @param value3 - blue or brightness
     */
    public Color(int type, int value1, int value2, int value3) {
        if (type == 1) {
            setRGB(value1, value2, value3);
        } else if (type == 2) {
            setHSV(value1, value2, value3);
        }
    }

    /**
     * Sets RGB values
     * @author Anya Joshi
     * @param r - numerical red value
     * @param g - numerical green value
     * @param b- numerical blue value
     */
    public void setRGB(int r, int g, int b) {
        red = r;
        green = g;
        blue = b;

    }
    /**
     * Sets HSV values
     *
     *  @author Anya Joshi
     * @param h - numerical hue value
     * @param s - numerical saturation value
     * @param v- numerical brightness value
     */
    public void setHSV(int h, int s, int v) {
        hue = h;
        saturation = s;
        brightness = v;



    }
    /**
     * Sets red value
     *  @author Anya Joshi
     * @param r- numerical red value
     */
    public void setRed(int r) {
        red = r;


    }
    /**
     * sets Green value
     * @author Anya Joshi
     * @param g- numerical green value
     */
    public void setGreen(int g) {
        green = g;


    }
    /**
     * Sets Blue value
     * @author Anya Joshi
     * @param b- numerical blue value
     */
    public void setBlue(int b) {
        blue = b;


    }
    /**
     * sets hue value
     *  @author Anya Joshi
     * @param h- numerical Hue value
     */
    public void setHue(int h) {
        hue = h;


    }
    /**
     * sets saturation value
     *  @author Anya Joshi
     * @param s- numerical saturation value
     */
    public void setSaturation(int s) {
        saturation = s;


    }
    /**
     * sets brightness value
     *  @author Anya Joshi
     * @param v- numerical brightness value
     */
    public void setBrightness(int v) {
        brightness = v;


    }

    /**
     * gets red value
     * @author Anya Joshi
     * @return red - numerical red value
     */
    public int getRed(){
        return red;
    }
    /**
     * gets blue value
     * @author Anya Joshi
     * @return blue - numerical blue value
     */
    public int getBlue(){
        return blue;
    }
    /**
     * gets green value
     * @author Anya Joshi
     * @return green - numerical green value
     */
    public int getGreen(){
        return green;
    }
    /**
     * gets hue value
     *  @author Anya Joshi
     * @return hue - numerical hue value
     */
    public int getHue(){
        return hue;
    }
    /**
     * get saturation value
     * @author Anya Joshi
     * @return saturation - numerical saturation value
     */
    public int getSaturation(){
        return saturation;
    }
    /**
     * get brightness value
     * @author Anya Joshi
     * @return brightness - numerical brightness value
     */
    public int getBrightness(){
        return brightness;
    }
    /**
     *
     * @author Anya Joshi
     * @return new int[] - array of rgb values
     */

    public int[] getRGB(){
        return new int[]{red,green,blue};
    }
    /**
     *  @author Anya Joshi
     * @return new int[] - array of hsv values
     */

    public int[] getHSV(){
        return new int[]{hue,saturation,brightness};
    }
    /**
     *  @author Anya Joshi
     * @param d1 - first double value
     * @param d2 - second double value
     * @param d3 - third double value
     * @return - max double value out of d1,d2,and d3
     */
    private double getMaximum(double d1, double d2, double d3) {
        if (d1 >= d2 && d1 >= d3) {
            return d1;
        } else if (d2 >= d1 && d2 >= d3) {
            return d2;
        } else {
            return d3;
        }

    }
    /**
     * @author Anya Joshi
     * @param d1 - first double value
     * @param d2 - second double value
     * @param d3 - third double value
     * @return - minimum double value out of d1,d2,and d3
     */
    private double getMinimum(double d1, double d2, double d3) {
        if (d1 <= d2 && d1 <= d3) {
            return d1;
        } else if (d2 <= d1 && d2 <= d3) {
            return d2;
        } else {
            return d3;
        }

    }

    /**
     *  @author Anya Joshi
     * @param r - numerical red value
     * @param g - numerical green value
     * @param b - numerical blue value
     * @param max - max value
     * @param min- min value
     * @return hue - the calculated hue value
     */
    private double calculateHue(double r, double g, double b, double max, double min){

        double rp = r/MAX_COLOR;
        double gp = g/MAX_COLOR;
        double bp = b/MAX_COLOR;

        //max = getMaximum(rp,gp,bp);
        //min = getMinimum(rp,gp,bp);

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

    /**
     * @author Anya Joshi
     * @param r - numerical red value
     * @param g - numerical green value
     * @param b - numerical blue value
     * @param max - max value
     * @param min- min value
     * @return hue - the calculated saturation value
     */

    private double calculateSaturation(double r, double g, double b, double max, double min){



        double delta =  max- min;

        if(max ==0){
            return 0;
        }
        if (max !=0){
            return delta/max*100;
        }
        return -1;


    }


    /**
     * @author Anya Joshi
     *
     * @return The updated Color object with HSV values.
     */
    public Color RGBtoHSV(){
        double r = this.red;
        double g = this.green;
        double b = this.blue;
        double max = getMaximum(r/MAX_COLOR,g/MAX_COLOR,b/MAX_COLOR);
        double min= getMinimum(r/MAX_COLOR,g/MAX_COLOR,b/MAX_COLOR);
        hue = (int) calculateHue(r,g,b,max,min);
        saturation = (int) calculateSaturation(r,g,b,max,min);
        brightness = (int) (max*100);

        return this;
    }
    /**
     * @author Anya Joshi
     *
     * @return The updated Color object with RGB values.
     */
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

            red = (int)(rt + 0.99);
        }

        double gt = (gp +m)*MAX_COLOR;
        if(gt>255){
            green = (int)gt;
        } else {

            green = (int)(gt + 0.99);
        }

        double bt = (bp +m)*MAX_COLOR;
        if(bt>255){
            blue = (int)bt;
        } else {

            blue = (int)(bt +0.99);
        }

        return this;

    }

    /**
     * @author Anya Joshi
     *
     * prints RGB and HSV values of the color
     */
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
