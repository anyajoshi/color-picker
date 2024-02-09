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

    }

    public void setHSV(int h, int s, int v) {
        hue = h;
        saturation = s;
        brightness = v;



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
    public void setBrightness(int v) {
        brightness = v;


    }


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

    private double calculateHue(){

        double rp = this.red/(double)MAX_COLOR;
        double gp = this.green/(double)MAX_COLOR;
        double bp = this.blue/(double)MAX_COLOR;

        double max = getMaximum(rp,gp,bp);
        double min = getMinimum(rp,gp,bp);
        double delta =  max- min;

        if(max == rp){
            return 60*((gp-bp)/delta%6);

        }
        if (max == gp){
            return 60*(bp-rp)/delta +2;
        }

        if (max == bp){
            return 60*(rp-gp)/delta +4;
        }
        return -1;


    }



    private double calculateSaturation(){

        double rp = this.red/(double)MAX_COLOR;
        double gp = this.green/(double)MAX_COLOR;
        double bp = this.blue/(double)MAX_COLOR;

       double  max = getMaximum(rp,gp,bp);
       double  min = getMinimum(rp,gp,bp);
        double delta =  max- min;

        if(max ==0){
            return 0;
        }
        if (max !=0){
            return delta/max;
        }
        return -1;


    }

    private double calculateBrightness(){


        double rp = this.red/(double)MAX_COLOR;
        double gp = this.green/(double)MAX_COLOR;
        double bp = this.blue/(double)MAX_COLOR;



        return  getMaximum(rp,gp,bp);


    }

    public Color RGBtoHSV(){

        hue = (int) calculateHue();
        saturation = (int) calculateSaturation();
        brightness = (int) calculateBrightness();

        return new Color(2,hue, saturation, brightness);
    }

    public Color HSVtoRGB(){
        double c = this.brightness * this.saturation;
        double y = this.hue/60%2 -1;
        if (y < 0){
            y *= -1;
        }
        double x = c * (1 - y );
        double m = this.brightness -c;
        double rp = 0, gp=0, bp=0;

        if(this.hue >=0 && this.hue <60){
            rp = c;
            gp=x;
            bp=0;
        }
        else if (this.hue >=60 && this.hue <120){
            rp =x;
            gp =c;
            bp =0;
        }
        else if (this.hue >=120 && this.hue <180){
            rp =0;
            gp =c;
            bp =x;
        }
        else if (this.hue >=180 && this.hue <240){
            rp =0;
            gp =x;
            bp =c;
        }
        else if (this.hue >=240 && this.hue <300){
            rp =x;
            gp =0;
            bp =c;
        }
        else if (this.hue >=300 && this.hue <360){
            rp =c;
            gp =0;
            bp =x;
        }
        double rt = (rp +m)*MAX_COLOR;
        if(rt>255){
            red = (int)rt;
        } else {
            if (rt * 10 % 10 != 0){
                red = (int)rt +1;
            }
        }

        double gt = (gp +m)*MAX_COLOR;
        if(gt>255){
            green = (int)gt;
        } else {
            if (gt * 10 % 10 != 0){
                green = (int)gt +1;
            }
        }

        double bt = (bp +m)*MAX_COLOR;
        if(bt>255){
            blue = (int)bt;
        } else {
            if (bt * 10 % 10 != 0){
                blue = (int)bt +1;
            }
        }

        return new Color(1, red, green, blue);
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
