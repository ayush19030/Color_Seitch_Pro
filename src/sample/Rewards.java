package sample;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;

import java.io.PipedOutputStream;
import java.io.Serializable;

public class Rewards extends Position implements Contact, Serializable {
    boolean used;
    Group star = new Group();
    double speed;
    double y;

    public Group getStar() {
        return star;
    }

    public void setStar(Group star) {
        this.star = star;
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

    public Rewards(double speed) {
        this.speed = speed;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
    public rewards_copy get_clone(){
        rewards_copy tr= new rewards_copy();
        tr.used= this.used;
        tr.y = (this.y_cord+star.getTranslateY());
        tr.x_cord=this.x_cord;
        tr.y_cord=this.y_cord;
        tr.speed = this.speed;

        return  tr;

    }

    public void makeStar(Pane canvas, double y){
        Polygon polygon = new Polygon();
        double angle_inRadians = 72*(Math.PI/180);

        Double[] outerPoints = {0.0, -1.0, Math.sin(angle_inRadians), -Math.cos(angle_inRadians), Math.sin(2*angle_inRadians), -Math.cos(2*angle_inRadians), Math.sin(3*angle_inRadians), -Math.cos(3*angle_inRadians), Math.sin(4*angle_inRadians), -Math.cos(4*angle_inRadians)};

        Double[] points = new Double[20];

        Double[] innerPoints = {Math.sin(2*angle_inRadians), Math.cos(2*angle_inRadians), Math.sin(angle_inRadians), Math.cos(angle_inRadians), 0.0, 1.0, Math.sin(4*angle_inRadians), Math.cos(4*angle_inRadians), Math.sin(3*angle_inRadians), Math.cos(3*angle_inRadians)};
        for(int i=0; i<outerPoints.length; i++) {
            outerPoints[i] *= 14;
            innerPoints[i] *= 7;
        }
        for(int i=0; i<5; i++) {
            points[4*i] = outerPoints[2*i];
            points[4*i+1] = outerPoints[2*i+1];
            points[4*i+2] = innerPoints[2*i];
            points[4*i+3] = innerPoints[2*i+1];
        }
        polygon.getPoints().addAll(points);
        polygon.setFill(Color.ANTIQUEWHITE);

        polygon.setLayoutX(150);
        polygon.setLayoutY(y);

        x_cord = 150;
        y_cord = y;

        star.getChildren().add(polygon);


        canvas.getChildren().add(star);

    }

    public void move_down() {
        this.star.setTranslateY(this.star.getTranslateY()+speed);
    }

    @Override
    public Paint isContact(Circle ball) {

        if (!used && ((Path) Shape.intersect(ball, (Shape)star.getChildren().get(0))).getElements().size()>0){
            star.setVisible(false);
            used = true;
            return ball.getFill();
        }

        return null;
    }
}