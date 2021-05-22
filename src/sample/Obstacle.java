package sample;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.collections.ObservableArray;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.Serializable;

abstract public class Obstacle extends Position implements Contact, Cloneable, Serializable {
    String type;
    double speed;
    int number;
    boolean is_dotted;
    double height_min;
    double height_max;
    double translate;
    boolean used;
    RotateTransition rotateTransition;
    double y;

    public double getTranslate() {
        return translate;
    }

    public void setTranslate(double translate) {
        this.translate = translate;
    }

    public RotateTransition getRotateTransition() {
        return rotateTransition;
    }

    public void setRotateTransition(RotateTransition rotateTransition) {
        this.rotateTransition = rotateTransition;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    Group obstacle;


public  Obstacle(){}


    public Obstacle(String type, double speed, int number, boolean is_dotted) {
        this.type = type;
        this.speed = speed;
        this.number = number;
        this.is_dotted = is_dotted;
    }

    public boolean isUsed() {
        return used;
    }
abstract  public obstacle_copy get_clone();
    public void setUsed(boolean used) {
        this.used = used;
    }

    public void setObstacle(Group obstacle) {
        this.obstacle = obstacle;
    }

    public Group getObstacle() {
        return obstacle;
    }

    public double getHeight_min() {
        return height_min;
    }

    public void setHeight_min(double height_min) {
        this.height_min = height_min;
    }

    public double getHeight_max() {
        return height_max;
    }

    public void setHeight_max(double height_max) {
        this.height_max = height_max;
    }

    public boolean isContact(){
        return false;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isIs_dotted() {
        return is_dotted;
    }

    public void setIs_dotted(boolean is_dotted) {
        this.is_dotted = is_dotted;
    }

    abstract public void make_obstacle(Pane canvas, double y);
    abstract public void make_obstacle2(Pane canvas, double y);
    public void make_obstacles3(Pane canvas, double y){

    }
    public void make_rotate(){

    }
    abstract public void move_down();
}
