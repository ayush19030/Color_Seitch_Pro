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

public class Ball extends Position implements Serializable {
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

    public Ball(Color color, double speed, int radius) {
        this.color = color;
        this.speed = speed;
        this.radius = radius;
        this.ops = 4;
    }
   public Ball(String ty,  double speed, int radius) {
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

        Text text = (Text)canvas.getChildren().get(1);
        int score = Integer.parseInt(text.getText());


//        System.out.println(ball.getCenterX());
//        System.out.println(ball.getCenterY());

        if (score!=0 && score%50==0 && !check) {
            check = true;
            for (int i = 0; i < obstacles.size(); i++) { ;
//                obstacles.get(i).rotateTransition.setDuration(Duration.millis(Double.parseDouble(obstacles.get(i).rotateTransition.getDuration()+"")+100));
                obstacles.get(i).setNumber(obstacles.get(i).getNumber()+1);
            }
        }
        if ( score%50==1){
            check = false;
        }

        if (score!=0 && score%30==0 && !check) {
            check = true;
            for (int i = 0; i < obstacles.size(); i++) { ;
                obstacles.get(i).rotateTransition.setDuration(Duration.millis(Double.parseDouble(obstacles.get(i).rotateTransition.getDuration()+"")+100));
//                obstacles.get(i).setNumber(obstacles.get(i).getNumber()+1);
            }
        }
        if ( score%30==1){
            check = false;
        }

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

            if (t<=40)
            {
//                System.out.println("achbaskcjbas");
//                System.out.println(t);

//                deltaY = -0.5;
                deltaY = -getSpeed()*elapsedSeconds;
//                if (ball.getCenterY()<=250) {
//                    deltaY/= 4;
//                }


                if(ball.getCenterY()<=380) {

                    for (int i = 0; i < size; i++) {

                        obstacles.get(i).move_down();
                        rewards.get(i).move_down();
                        switchColors.get(i).move_down();
//                        if (deltaY==0){
//                            obstacles.get(i).move_down();
//                            rewards.get(i).move_down();
//                            switchColors.get(i).move_down();
//                        }
//

//                    if (obstacles.get(i).getHeight_min()>600){
//                        System.out.println(obstacles.get(i).obstacle.getTranslateY()+" "+(this.obstacles.get(i).getY_cord()));
//                        this.obstacles.get(i).getObstacle().setTranslateY(700 - (this.obstacles.get(i).getY_cord()) -1400);
//                        obstacles.get(i).setY_cord(700 - (this.obstacles.get(i).getY_cord()) -1400);
//                        obstacles.get(i).setHeight_min(700 - (this.obstacles.get(i).getY_cord()) -1400 - 130 );
//
//                        rewards.get(i).star.setVisible(true);
//                        rewards.get(i).setUsed(false);
//                        rewards.get(i).star.setTranslateY(700- rewards.get(i).getY_cord() - 1400);
//                        rewards.get(i).setY_cord(700 - rewards.get(i).getY_cord() -1400);
//                    }
//
//                    if (switchColors.get(i).Switch.getTranslateY()>600){
//                        switchColors.get(i).Switch.setVisible(true);
//                        switchColors.get(i).setUsed(false);
//                        switchColors.get(i).Switch.setTranslateY(700- rewards.get(i).getY_cord() - 1400);
//                    }

                        if ((i) % 4 == 0 && !obstacles.get(i).isUsed() && obstacles.get(i).getHeight_min() >= 600) {
                            obstacles.get(i).setUsed(true);
                            for (int j = 0; j <4 ; j++) {
                                int random = Gameplay.random(1,4);
                                int rand = Gameplay.random(1,3);
//                                System.out.println(random+" "+rand);
                                if (random==1){
                                    if (gm.score>5 && rand>1){
                                        Obstacle circle_obstacle = new circle("Circle", 1.75, 2, false);
                                        circle_obstacle.make_obstacle2(canvas, -ops * 350 + obstacles.get(0).translate);
                                        ops++;
                                        obstacles.add(circle_obstacle);
                                    }
                                    else {
                                        Obstacle circle_obstacle = new circle("Circle", 1.75, 1, false);
                                        circle_obstacle.make_obstacle(canvas, -ops * 350 + obstacles.get(0).translate);
                                        ops++;
                                        obstacles.add(circle_obstacle);
                                    }
                                }
                                else if (random==2){
                                    if (gm.score>10 && rand>1){
                                        Obstacle square = new Square("Square", 1.75, 2, false);
                                        square.make_obstacle2(canvas, -ops * 350 + obstacles.get(0).translate);
                                        ops++;
                                        obstacles.add(square);
                                    }
                                    else {
                                        Obstacle square = new Square("Square", 1.75, 1, false);
                                        square.make_obstacle(canvas, -ops * 350 + obstacles.get(0).translate);
                                        ops++;
                                        obstacles.add(square);
                                    }
                                }
                                else if (random==3){
                                    if (rand>1){
                                        Obstacle line = new Line("Line", 1.75, 2, false);
                                        line.make_obstacle2(canvas, -ops * 350 + obstacles.get(0).translate);
                                        ops++;
                                        obstacles.add(line);
                                    }
                                    else {
                                        Obstacle line = new Line("Line", 1.75, 1, false);
                                        line.make_obstacle(canvas, -ops * 350 + obstacles.get(0).translate);
                                        ops++;
                                        obstacles.add(line);
                                    }
                                }
                                else {
                                    if (gm.score>10 && rand>1){
                                        Obstacle triangle = new Triangle("Triangle", 1.75, 2, false);
                                        triangle.make_obstacle2(canvas, -ops * 350 + obstacles.get(0).translate);
                                        ops++;
                                        obstacles.add(triangle);
                                    }
                                    else {
                                        Obstacle triangle = new Triangle("Triangle", 1.75, 1, false);
                                        triangle.make_obstacle(canvas, -ops * 350 + obstacles.get(0).translate);
                                        ops++;
                                        obstacles.add(triangle);
                                    }
                                }
                            }


                            for (int j = obstacles.size() - 4; j < obstacles.size(); j++) {
                                Rewards star = new Rewards(1.75);
                                star.makeStar(canvas, obstacles.get(j).y_cord);
                                rewards.add(star);
                                SwitchColor switchColor = new SwitchColor(1.75);
                                switchColor.makeSwitch(canvas, -j * 350 + obstacles.get(0).translate);
                                switchColors.add(switchColor);
                            }
                        }

                    }
                }
                else {
                    deltaY*= 2;
                }
            }
            else {
//                System.out.println(getSpeed()+" "+elapsedSeconds);
//                setSpeed(50);
                setSpeed(getSpeed()+1);
                deltaY = getSpeed()*elapsedSeconds ;
//                deltaY = 0.5;
            }
            t++;
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
                        int y;
                        if (ball.getCenterY()>350){
                            Circle b = new Circle(ball.getRadius(), ball.getFill());
                            b.setCenterX(ball.getCenterX());
                            b.setCenterY(ball.getCenterY());
                            y = -10;
                            while (!b.getFill().equals(obstacles.get(i).isContact(b))){
                                b.setTranslateY(b.getTranslateY()+y);
                                y-=10;
                            }
                            y-=40;
                        }
                        else {
                            Circle b = new Circle(ball.getRadius(), ball.getFill());
                            b.setCenterX(ball.getCenterX());
                            b.setCenterY(ball.getCenterY());
                            y = 10;
                            while (!b.getFill().equals(obstacles.get(i).isContact(b))){
                                b.setTranslateY(b.getTranslateY()+y);
                                y+=10;
                            }
                            y+=40;
                        }
                        gm.takeSnapShot(primaryStage, getY() + y);
                    }
                    animationTimer.stop();
                }
                switchColors.get(i).isContact(ball);
                Paint paint = rewards.get(i).isContact(ball);
                if (paint!=null){
                    Text text = (Text)canvas.getChildren().get(1);
                    gm.score++;
                    gm.stars++;
                    if (gm.highScore<gm.score){
                        gm.highScore = gm.score;
                    }
                    text.setText(Integer.parseInt(text.getText())+1+"");
                }
//                switchColors.get(i).move_down();
            }

            if (ball.getCenterY() - ball.getRadius() >= 600){
//                System.out.println("fcxhcgvjj");
//                System.out.println("ho tu chaye tha");
                ball.setCenterY(ball.getCenterY()+20);
                if (!check) {
                    check =true;
                    gm.revive = 0;
                    gm.takeSnapShot(primaryStage, getY() + 20);

                }
//                return;
                animationTimer.stop();
            }
//            ball.setCenterY(ball.getCenterY() + deltaY);
//            if (getSpeed()<0){
//                for (int i = 0; i <3 ; i++) {
//                    obstacles.get(i).move_down();
//                    rewards.get(i).move_down();
//                    switchColors.get(i).move_down();
//                }
//            }
//            if (getSpeed()<1){
//                setSpeed(getSpeed()+0.05);
//            }
//            System.out.println(getSpeed());
//            ball.setCenterY(ball.getCenterY()+ getSpeed());




            lastUpdateTime.set(l);

        }
    }



}
