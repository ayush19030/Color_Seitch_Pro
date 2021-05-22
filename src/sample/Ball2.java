package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.lang.model.type.NullType;
import java.io.Serializable;
import java.util.ArrayList;

public class Ball2 extends Position implements Serializable {
    Color color;
    double speed;
    Circle ball;
    int radius;
    int ops;
    boolean check;
    LongProperty lastUpdateTime ;
    AnimationTimer animationTimer ;
    String tr;
    public void set(){
        lastUpdateTime = new SimpleLongProperty();
    }

    public Ball2(Color color, double speed, int radius) {
        this.color = color;
        this.speed = speed;
        this.radius = radius;
        this.ops = 3;
    }
    public Ball2(String ty,  double speed, int radius) {
        tr=ty;
        this.speed = speed;
        this.radius = radius;
        this.ops = 4;
    }



    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle getBall() {
        return ball;
    }

    public void make_ball(double x, double y){
        ball = new Circle(radius, color);
        ball.setCenterX(x);
        ball.setCenterY(y);

        x_cord = x;
        y_cord = y;
        //ball.relocate(142, 450);
    }

    public double getY(){
        return ball.getCenterY();
    }

    public void move_up(Pane canvas, ArrayList<Obstacle> obstacles, ArrayList<Rewards> rewards, ArrayList<SwitchColor> switchColors, Stage primaryStage, Gameplay gm){

        setSpeed(50);


        if (animationTimer!=null) {
            animationTimer.stop();
        }
        animationTimer = new myTimer(obstacles, switchColors, rewards, canvas, primaryStage, gm);

        animationTimer.start();


    }



    public class myTimer  extends AnimationTimer implements  Serializable{
        ArrayList<Obstacle> obstacles;
        ArrayList<SwitchColor> switchColors;
        ArrayList<Rewards> rewards;
        Gameplay gm;
        Pane canvas;
        Stage primaryStage;
        int t =0;

        public myTimer(ArrayList<Obstacle> obstacles, ArrayList<SwitchColor> switchColors, ArrayList<Rewards> rewards, Pane canvas, Stage primaryStage, Gameplay gm) {
            this.obstacles = obstacles;
            this.switchColors = switchColors;
            this.rewards = rewards;
            this.canvas = canvas;
            this.gm = gm;
            this.primaryStage = primaryStage;
        }

        @Override
        public void handle(long l) {
            double elapsedSeconds = (l - lastUpdateTime.get()) / 1_000_000_000.0 ;

            double deltaY;

//            System.out.println(l/1000000000);
//            System.out.println(t);
            int size = obstacles.size();


            deltaY = 0;

            if(ball.getCenterY()<=300) {

                for (int i = 0; i < size; i++) {

                    obstacles.get(i).move_down();
                    rewards.get(i).move_down();
                    switchColors.get(i).move_down();

                    if ((i) % 3 == 0 && !obstacles.get(i).isUsed() && obstacles.get(i).getHeight_min() >= 600) {
                        obstacles.get(i).setUsed(true);
                        Text text = (Text)canvas.getChildren().get(1);
                        int score = Integer.parseInt(text.getText());
                        for (int j = 0; j <3 ; j++) {
                            int random = Gameplay.random(1,3);
                            int rand = Gameplay.random(1,2);
                            if (random==1){
                                if (score>5 && rand==2){
                                    Obstacle circle_obstacle = new circle("Circle", 2, 2, false);
                                    circle_obstacle.make_obstacles3(canvas, -ops * 350 + obstacles.get(0).translate);
                                    ops++;
                                    obstacles.add(circle_obstacle);
                                }
                                else {
                                    Obstacle circle_obstacle = new circle("Circle", 2, 1, false);
                                    circle_obstacle.make_obstacles3(canvas, -ops * 350 + obstacles.get(0).translate);
                                    ops++;
                                    obstacles.add(circle_obstacle);
                                }
                            }
                            else if (random==2){
                                if (score>10 && rand==2){
                                    Obstacle square = new Square("Square", 2, 2, false);
                                    square.make_obstacles3(canvas, -ops * 350 + obstacles.get(0).translate);
                                    ops++;
                                    obstacles.add(square);
                                }
                                else {
                                    Obstacle square = new Square("Square", 2, 1, false);
                                    square.make_obstacles3(canvas, -ops * 350 + obstacles.get(0).translate);
                                    ops++;
                                    obstacles.add(square);
                                }
                            }
                            else if (random==3){
                                if (rand==2){
                                    Obstacle line = new Line("Line", 2, 2, false);
                                    line.make_obstacles3(canvas, -ops * 350 + obstacles.get(0).translate);
                                    ops++;
                                    obstacles.add(line);
                                }
                                else {
                                    Obstacle line = new Line("Line", 2, 1, false);
                                    line.make_obstacles3(canvas, -ops * 350 + obstacles.get(0).translate);
                                    ops++;
                                    obstacles.add(line);
                                }
                            }
//                            else {
//                                if (score>10 && rand==2){
//                                    Obstacle triangle = new Triangle("Triangle", 1.75, 2, false);
//                                    triangle.make_obstacles3(canvas, -ops * 350 + obstacles.get(0).translate);
//                                    ops++;
//                                    obstacles.add(triangle);
//                                }
//                                else {
//                                    Obstacle triangle = new Triangle("Triangle", 1.75, 1, false);
//                                    triangle.make_obstacles3(canvas, -ops * 350 + obstacles.get(0).translate);
//                                    ops++;
//                                    obstacles.add(triangle);
//                                }
//                            }
                        }


                        for (int j = obstacles.size() - 3; j < obstacles.size(); j++) {
                            Rewards star = new Rewards(2);
                            star.makeStar(canvas, obstacles.get(j).y_cord);
                            rewards.add(star);
                            SwitchColor switchColor = new SwitchColor(2);
                            switchColor.makeSwitch(canvas, -j * 350 + obstacles.get(0).translate+50);
                            switchColors.add(switchColor);
                        }
                    }

                }
            }
            else {
                deltaY= -2;
            }

//            System.out.println(deltaY);

            if (deltaY<=10 && deltaY>=-10) {
                if (ball.getCenterY()-ball.getRadius()<=0){
                    ball.setCenterY(ball.getCenterY()+ 2);
                }
                else {
                    ball.setCenterY(ball.getCenterY() + deltaY);
                }
            }
//            System.out.println(deltaY);
            for (int i = 0; i <size ; i++) {
//                System.out.println();
                if (!ball.getFill().equals(obstacles.get(i).isContact(ball))){
                    if (!check) {
//                        System.out.println(check);
                        check =true;
//                        System.out.println(gm.score);
                        gm.takeSnapShot2(primaryStage, getY() + 20);
                    }
                    animationTimer.stop();
                }
                switchColors.get(i).isContact(ball);
                Paint paint = rewards.get(i).isContact(ball);
                if (paint!=null){
                    Text text = (Text)canvas.getChildren().get(1);
                    gm.score2++;
                    gm.stars2++;
                    if (gm.highScore2<gm.score2){
                        gm.highScore2 = gm.score2;
                    }
                    text.setText(Integer.parseInt(text.getText())+1+"");
                }

            }

            if (ball.getCenterY() - ball.getRadius() >= 600){

                ball.setCenterY(ball.getCenterY()+20);
                if (!check) {
                    check =true;
                    gm.takeSnapShot(primaryStage, getY() + 20);

                }

                animationTimer.stop();
            }

            lastUpdateTime.set(l);

        }
    }



}
