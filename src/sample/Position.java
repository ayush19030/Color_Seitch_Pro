package sample;

import java.io.Serializable;

public class Position implements Serializable {
    protected double x_cord;
    protected double y_cord;

    public double getX_cord() {
        return x_cord;
    }

    public void setX_cord(double x_cord) {
        this.x_cord = x_cord;
    }

    public double getY_cord() {
        return y_cord;
    }

    public void setY_cord(double y_cord) {
        this.y_cord = y_cord;
    }

    public Position get_cord(){
        return this;
    }

    public void set_cord(double x, double y){
        this.x_cord = x;
        this.y_cord = y;
    }
}
