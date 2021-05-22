package sample;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.Serializable;
class circle extends Obstacle implements Serializable {
    double width_i;
    double width_j;

    public circle(String type, double speed, int number, boolean is_dotted) {
        super(type, speed, number, is_dotted);
    }

    public circle() {

    }

    public double getWidth_i() {
        return width_i;
    }

    public void setWidth_i(double width_i) {
        this.width_i = width_i;
    }

    public double getWidth_j() {
        return width_j;
    }

    public void setWidth_j(double width_j) {
        this.width_j = width_j;
    }
    public  obstacle_copy get_clone(){
        obstacle_copy sq= new obstacle_copy();
        sq.type= this.type;
        sq.speed=this.speed;
        sq.x_cord=this.x_cord;
        sq.y_cord=this.y_cord;
        sq.translate=this.translate;
        sq.number=this.number;
        sq.is_dotted=this.is_dotted;
        sq.y= (this.y_cord-250+obstacle.getTranslateY());
        return  sq;



    }

    @Override
    public void make_obstacle(Pane canvas, double y) {

        if (this.number==2){
            make_obstacle2(canvas, y);
            return;
        }
        setObstacle(new Group());
        Group circleObstacle = getObstacle();
        Path segment1 = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(330+y);

        LineTo lineTo = new LineTo();
        lineTo.setX(150);
        lineTo.setY(320+y);

        ArcTo arcto = new ArcTo();
        arcto.setX(220);
        arcto.setY(250+y);
        arcto.setRadiusX(70);
        arcto.setRadiusY(70);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(230);
        lineTo2.setY(250+y);

        ArcTo arcto2 = new ArcTo();
        arcto2.setX(150);
        arcto2.setY(330+y);
        arcto2.setRadiusX(80);
        arcto2.setRadiusY(80);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment1.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment1.setStroke(Color.RED);


        segment1.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);


        Path segment2 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(220);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(230);
        lineTo.setY(250+y);

        arcto = new ArcTo();
        arcto.setX(150);
        arcto.setY(170+y);
        arcto.setRadiusX(80);
        arcto.setRadiusY(80);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(180+y);

        arcto2 = new ArcTo();
        arcto2.setX(220);
        arcto2.setY(250+y);
        arcto2.setRadiusX(70);
        arcto2.setRadiusY(70);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment2.setFill(Color.YELLOW);
        //path.setStrokeWidth(3);
        segment2.setStroke(Color.YELLOW);


        segment2.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        Path segment3 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(180+y);

        lineTo = new LineTo();
        lineTo.setX(150);
        lineTo.setY(170+y);

        arcto = new ArcTo();
        arcto.setX(70);
        arcto.setY(250+y);
        arcto.setRadiusX(80);
        arcto.setRadiusY(80);


        lineTo2 = new LineTo();
        lineTo2.setX(80);
        lineTo2.setY(250+y);

        arcto2 = new ArcTo();
        arcto2.setX(150);
        arcto2.setY(180+y);
        arcto2.setRadiusX(70);
        arcto2.setRadiusY(70);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment3.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment3.setStroke(Color.DEEPSKYBLUE);

        segment3.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        Path segment4 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(80);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(70);
        lineTo.setY(250+y);

        arcto = new ArcTo();
        arcto.setX(150);
        arcto.setY(330+y);
        arcto.setRadiusX(80);
        arcto.setRadiusY(80);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(320+y);

        arcto2 = new ArcTo();
        arcto2.setX(80);
        arcto2.setY(250+y);
        arcto2.setRadiusX(70);
        arcto2.setRadiusY(70);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment4.setFill(Color.DARKVIOLET);
        //path.setStrokeWidth(3);
        segment4.setStroke(Color.DARKVIOLET);


        segment4.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        circleObstacle.getChildren().addAll(segment1, segment2, segment3, segment4);

        x_cord = 150;
        y_cord = 250+y;

        setWidth_i(10);
        setWidth_j(10);
        setHeight_min(170+y);
        setHeight_max(330+y);

        rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(4000));
        rotateTransition.setNode(circleObstacle);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);

        rotateTransition.play();

        canvas.getChildren().add(circleObstacle);
    }

    @Override
    public void make_obstacle2(Pane canvas, double y) {
        setObstacle(new Group());
        Group circleObstacle = getObstacle();
        Path segment1 = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(330+y);

        LineTo lineTo = new LineTo();
        lineTo.setX(150);
        lineTo.setY(320+y);

        ArcTo arcto = new ArcTo();
        arcto.setX(220);
        arcto.setY(250+y);
        arcto.setRadiusX(70);
        arcto.setRadiusY(70);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(230);
        lineTo2.setY(250+y);

        ArcTo arcto2 = new ArcTo();
        arcto2.setX(150);
        arcto2.setY(330+y);
        arcto2.setRadiusX(80);
        arcto2.setRadiusY(80);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment1.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment1.setStroke(Color.RED);


        segment1.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);


        Path segment2 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(220);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(230);
        lineTo.setY(250+y);

        arcto = new ArcTo();
        arcto.setX(150);
        arcto.setY(170+y);
        arcto.setRadiusX(80);
        arcto.setRadiusY(80);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(180+y);

        arcto2 = new ArcTo();
        arcto2.setX(220);
        arcto2.setY(250+y);
        arcto2.setRadiusX(70);
        arcto2.setRadiusY(70);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment2.setFill(Color.YELLOW);
        //path.setStrokeWidth(3);
        segment2.setStroke(Color.YELLOW);


        segment2.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        Path segment3 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(180+y);

        lineTo = new LineTo();
        lineTo.setX(150);
        lineTo.setY(170+y);

        arcto = new ArcTo();
        arcto.setX(70);
        arcto.setY(250+y);
        arcto.setRadiusX(80);
        arcto.setRadiusY(80);


        lineTo2 = new LineTo();
        lineTo2.setX(80);
        lineTo2.setY(250+y);

        arcto2 = new ArcTo();
        arcto2.setX(150);
        arcto2.setY(180+y);
        arcto2.setRadiusX(70);
        arcto2.setRadiusY(70);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment3.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment3.setStroke(Color.DEEPSKYBLUE);

        segment3.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        Path segment4 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(80);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(70);
        lineTo.setY(250+y);

        arcto = new ArcTo();
        arcto.setX(150);
        arcto.setY(330+y);
        arcto.setRadiusX(80);
        arcto.setRadiusY(80);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(320+y);

        arcto2 = new ArcTo();
        arcto2.setX(80);
        arcto2.setY(250+y);
        arcto2.setRadiusX(70);
        arcto2.setRadiusY(70);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment4.setFill(Color.DARKVIOLET);
        //path.setStrokeWidth(3);
        segment4.setStroke(Color.DARKVIOLET);


        segment4.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        Path segment5 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(360+y);

        lineTo = new LineTo();
        lineTo.setX(150);
        lineTo.setY(350+y);

        arcto = new ArcTo();
        arcto.setX(250);
        arcto.setY(250+y);
        arcto.setRadiusX(100);
        arcto.setRadiusY(100);

        lineTo2 = new LineTo();
        lineTo2.setX(260);
        lineTo2.setY(250+y);

        arcto2 = new ArcTo();
        arcto2.setX(150);
        arcto2.setY(360+y);
        arcto2.setRadiusX(110);
        arcto2.setRadiusY(110);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment5.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment5.setStroke(Color.RED);


        segment5.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);


        Path segment6 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(250);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(260);
        lineTo.setY(250+y);

        arcto = new ArcTo();
        arcto.setX(150);
        arcto.setY(140+y);
        arcto.setRadiusX(110);
        arcto.setRadiusY(110);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(150+y);

        arcto2 = new ArcTo();
        arcto2.setX(250);
        arcto2.setY(250+y);
        arcto2.setRadiusX(100);
        arcto2.setRadiusY(100);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment6.setFill(Color.YELLOW);
        //path.setStrokeWidth(3);
        segment6.setStroke(Color.YELLOW);


        segment6.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        Path segment7 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(150+y);

        lineTo = new LineTo();
        lineTo.setX(150);
        lineTo.setY(140+y);

        arcto = new ArcTo();
        arcto.setX(40);
        arcto.setY(250+y);
        arcto.setRadiusX(110);
        arcto.setRadiusY(110);


        lineTo2 = new LineTo();
        lineTo2.setX(50);
        lineTo2.setY(250+y);

        arcto2 = new ArcTo();
        arcto2.setX(150);
        arcto2.setY(150+y);
        arcto2.setRadiusX(100);
        arcto2.setRadiusY(100);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment7.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment7.setStroke(Color.DEEPSKYBLUE);

        segment7.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        Path segment8 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(50);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(40);
        lineTo.setY(250+y);

        arcto = new ArcTo();
        arcto.setX(150);
        arcto.setY(360+y);
        arcto.setRadiusX(110);
        arcto.setRadiusY(110);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(350+y);

        arcto2 = new ArcTo();
        arcto2.setX(50);
        arcto2.setY(250+y);
        arcto2.setRadiusX(100);
        arcto2.setRadiusY(100);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment8.setFill(Color.DARKVIOLET);
        //path.setStrokeWidth(3);
        segment8.setStroke(Color.DARKVIOLET);


        segment8.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

//        Group group1 = new Group();
//        Group group2 = new Group();
//        group1.getChildren().addAll(segment1, segment2, segment3, segment4);
//        group2.getChildren().addAll(segment5, segment6, segment7, segment8);
//        circleObstacle.getChildren().addAll(group1, group2);
        circleObstacle.getChildren().addAll(segment1, segment2, segment3, segment4, segment5, segment6, segment7, segment8);

        x_cord = 150;
        y_cord = 250+y;

        setWidth_i(10);
        setWidth_j(10);
        setHeight_min(170+y);
        setHeight_max(330+y);

        rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(4000));
        rotateTransition.setNode(circleObstacle);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);

        rotateTransition.play();

//        RotateTransition rotateTransition2 = new RotateTransition();
//        rotateTransition2.setDuration(Duration.millis(4000));
//        rotateTransition2.setNode(group2);
//        rotateTransition2.setByAngle(360);
//        rotateTransition2.setCycleCount(Timeline.INDEFINITE);
//        rotateTransition2.setAutoReverse(false);
//
//        rotateTransition2.play();

        canvas.getChildren().add(circleObstacle);
    }

    @Override
    public void make_obstacles3(Pane canvas, double y){
        setObstacle(new Group());
        Group circleObstacle = getObstacle();
        Path segment1 = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(330+y);

        LineTo lineTo = new LineTo();
        lineTo.setX(150);
        lineTo.setY(320+y);

        ArcTo arcto = new ArcTo();
        arcto.setX(220);
        arcto.setY(250+y);
        arcto.setRadiusX(70);
        arcto.setRadiusY(70);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(230);
        lineTo2.setY(250+y);

        ArcTo arcto2 = new ArcTo();
        arcto2.setX(150);
        arcto2.setY(330+y);
        arcto2.setRadiusX(80);
        arcto2.setRadiusY(80);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment1.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment1.setStroke(Color.RED);


        segment1.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);


        Path segment2 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(220);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(230);
        lineTo.setY(250+y);

        arcto = new ArcTo();
        arcto.setX(150);
        arcto.setY(170+y);
        arcto.setRadiusX(80);
        arcto.setRadiusY(80);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(180+y);

        arcto2 = new ArcTo();
        arcto2.setX(220);
        arcto2.setY(250+y);
        arcto2.setRadiusX(70);
        arcto2.setRadiusY(70);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment2.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment2.setStroke(Color.DEEPSKYBLUE);


        segment2.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        Path segment3 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(180+y);

        lineTo = new LineTo();
        lineTo.setX(150);
        lineTo.setY(170+y);

        arcto = new ArcTo();
        arcto.setX(70);
        arcto.setY(250+y);
        arcto.setRadiusX(80);
        arcto.setRadiusY(80);


        lineTo2 = new LineTo();
        lineTo2.setX(80);
        lineTo2.setY(250+y);

        arcto2 = new ArcTo();
        arcto2.setX(150);
        arcto2.setY(180+y);
        arcto2.setRadiusX(70);
        arcto2.setRadiusY(70);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment3.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment3.setStroke(Color.DEEPSKYBLUE);

        segment3.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        Path segment4 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(80);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(70);
        lineTo.setY(250+y);

        arcto = new ArcTo();
        arcto.setX(150);
        arcto.setY(330+y);
        arcto.setRadiusX(80);
        arcto.setRadiusY(80);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(320+y);

        arcto2 = new ArcTo();
        arcto2.setX(80);
        arcto2.setY(250+y);
        arcto2.setRadiusX(70);
        arcto2.setRadiusY(70);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment4.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment4.setStroke(Color.RED);


        segment4.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        circleObstacle.getChildren().addAll(segment1, segment2, segment3, segment4);

        x_cord = 150;
        y_cord = 250+y;

        setWidth_i(10);
        setWidth_j(10);
        setHeight_min(170+y);
        setHeight_max(330+y);



        canvas.getChildren().add(circleObstacle);
    }

    @Override
    public void make_rotate(){
        rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(500));
        rotateTransition.setNode(obstacle);
        rotateTransition.setByAngle(180);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
    }

    @Override
    public void move_down() {

        this.getObstacle().setTranslateY(this.getObstacle().getTranslateY()+this.getSpeed());
        this.translate += this.getSpeed();
        this.setHeight_max(this.getHeight_max() + this.getSpeed());
        this.setHeight_min(this.getHeight_min() + this.getSpeed());
    }

    @Override
    public Paint isContact(Circle ball) {
        for (Node path: this.getObstacle().getChildren()){
            if (((Path)Shape.intersect(ball, (Path)path)).getElements().size()>0){
                return ((Path) path).getFill();
            }
        }
        return ball.getFill();
    }
}