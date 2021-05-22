package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;

import java.io.Serializable;

public class SwitchColor implements Contact, Serializable {
   private Paint previousColor;
    private Paint newColor;
    private  Group Switch;
    private  boolean used;
    private double speed;
    private  double y;

    public Group getSwitch() {
        return Switch;
    }

    public void setSwitch(Group aSwitch) {
        Switch = aSwitch;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isUsed() {
        return used;
    }

    public SwitchColor(double speed) {
        this.speed = speed;
    }

    public switch_copy get_clone(){
        switch_copy tr= new switch_copy();
        tr.used= this.used;
        tr.speed = this.speed;

        return  tr;

    }
    public void setUsed(boolean used) {
        this.used = used;
    }

    public Paint getPreviousColor() {
        return previousColor;
    }

    public void setPreviousColor(Paint previousColor) {
        this.previousColor = previousColor;
    }

    public Paint getNewColor() {
        return newColor;
    }

    public void setNewColor(Paint newColor) {
        this.newColor = newColor;
    }

    public void makeSwitch(Pane canvas, double y){
        Switch = new Group();

        Path segment1 = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(70+y);

        LineTo lineTo = new LineTo();
        lineTo.setX(150);
        lineTo.setY(80+y);

        ArcTo arcto = new ArcTo();
        arcto.setX(160);
        arcto.setY(70+y);
        arcto.setRadiusX(10);
        arcto.setRadiusY(10);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(70+y);

        segment1.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment1.setStroke(Color.RED);

        segment1.getElements().addAll(moveTo, lineTo, arcto, lineTo2);

        Path segment2 = new Path();
        moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(70+y);

        lineTo = new LineTo();
        lineTo.setX(160);
        lineTo.setY(70+y);

        arcto = new ArcTo();
        arcto.setX(150);
        arcto.setY(60+y);
        arcto.setRadiusX(10);
        arcto.setRadiusY(10);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(70+y);

        segment2.setFill(Color.YELLOW);
        //path.setStrokeWidth(3);
        segment2.setStroke(Color.YELLOW);

        segment2.getElements().addAll(moveTo, lineTo, arcto, lineTo2);

        Path segment3 = new Path();
        moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(70+y);

        lineTo = new LineTo();
        lineTo.setX(150);
        lineTo.setY(60+y);

        arcto = new ArcTo();
        arcto.setX(140);
        arcto.setY(70+y);
        arcto.setRadiusX(10);
        arcto.setRadiusY(10);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(70+y);

        segment3.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment3.setStroke(Color.DEEPSKYBLUE);

        segment3.getElements().addAll(moveTo, lineTo, arcto, lineTo2);

        Path segment4 = new Path();
        moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(70+y);

        lineTo = new LineTo();
        lineTo.setX(140);
        lineTo.setY(70+y);

        arcto = new ArcTo();
        arcto.setX(150);
        arcto.setY(80+y);
        arcto.setRadiusX(10);
        arcto.setRadiusY(10);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(70+y);

        segment4.setFill(Color.DARKVIOLET);
        //path.setStrokeWidth(3);
        segment4.setStroke(Color.DARKVIOLET);

        segment4.getElements().addAll(moveTo, lineTo, arcto, lineTo2);

        Switch.getChildren().addAll(segment1,segment2, segment3, segment4);

        canvas.getChildren().add(Switch);
    }

    public void move_down() {
        this.Switch.setTranslateY(this.Switch.getTranslateY()+this.speed);
    }

    public int random(int min, int max){
        int range = max - min + 1;

        return (int)(Math.random() * range) + min;
    }

    public void switchToNewColor(){
        int x = random(1, 4);
        if (x==1){
            newColor = Color.RED;
        }
        else if (x==2){
            newColor = Color.YELLOW;
        }
        else if (x==3){
            newColor = Color.DEEPSKYBLUE;
        }
        else {
            newColor = Color.DARKVIOLET;
        }
        while (newColor.equals(previousColor)){
            x = random(1, 4);
            if (x==1){
                newColor = Color.RED;
            }
            else if (x==2){
                newColor = Color.YELLOW;
            }
            else if (x==3){
                newColor = Color.DEEPSKYBLUE;
            }
            else {
                newColor = Color.DARKVIOLET;
            }
        }
    }

    public void switchToNewColor2(){
        int x = random(1, 2);
        if (x==1){
            newColor = Color.RED;
        }
        else{
            newColor = Color.DEEPSKYBLUE;
        }
        while (newColor.equals(previousColor)){
            x = random(1, 2);
            if (x==1){
                newColor = Color.RED;
            }
            else{
                newColor = Color.DEEPSKYBLUE;
            }
        }
    }

    @Override
    public Paint isContact(Circle ball) {
        this.previousColor = ball.getFill();
        for (Node path: this.Switch.getChildren()){
            if (!used && ((Path) Shape.intersect(ball, (Path)path)).getElements().size()>0){
                if (Gameplay.mode==1){
                    switchToNewColor2();
                }
                else {
                    switchToNewColor();
                }
                ball.setFill(newColor);
                Switch.setVisible(false);
                used = true;
                return newColor;
            }
        }
        return previousColor;
    }
}