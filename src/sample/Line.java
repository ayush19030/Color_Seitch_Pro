package sample;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Line extends Obstacle {
    double width_i;
    double width_j;

    public Line(String type, double speed, int number, boolean is_dotted) {
        super(type, speed, number, is_dotted);
    }

    public Line() {

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
        sq.number=this.number;
        sq.x_cord=this.x_cord;
        sq.y_cord=this.y_cord;
        sq.translate=this.translate;

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
        Group lineObstacle = getObstacle();
        Path segment1 = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(90);
        moveTo.setY(250+y);

        LineTo lineTo = new LineTo();
        lineTo.setX(95);
        lineTo.setY(245+y);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(160);
        lineTo2.setY(245+y);

        ArcTo arcto = new ArcTo();
        arcto.setX(160);
        arcto.setY(255+y);
        arcto.setRadiusX(5);
        arcto.setRadiusY(5);
        arcto.setLargeArcFlag(false);
        arcto.setSweepFlag(true);


        LineTo lineTo3 = new LineTo();
        lineTo3.setX(95);
        lineTo3.setY(255+y);

        LineTo lineTo4 = new LineTo();
        lineTo4.setX(90);
        lineTo4.setY(250+y);

        segment1.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment1.setStroke(Color.RED);


        segment1.getElements().addAll(moveTo, lineTo, lineTo2, arcto, lineTo3, lineTo4);


        Path segment2 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(90);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(85);
        lineTo.setY(245+y);

        lineTo2 = new LineTo();
        lineTo2.setX(85);
        lineTo2.setY(180+y);

        arcto = new ArcTo();
        arcto.setX(95);
        arcto.setY(180+y);
        arcto.setRadiusX(5);
        arcto.setRadiusY(5);
        arcto.setLargeArcFlag(false);
        arcto.setSweepFlag(true);


        lineTo3 = new LineTo();
        lineTo3.setX(95);
        lineTo3.setY(245+y);

        lineTo4 = new LineTo();
        lineTo4.setX(90);
        lineTo4.setY(250+y);

        segment2.setFill(Color.YELLOW);
        //path.setStrokeWidth(3);
        segment2.setStroke(Color.YELLOW);


        segment2.getElements().addAll(moveTo, lineTo, lineTo2, arcto, lineTo3, lineTo4);


        Path segment3 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(90);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(85);
        lineTo.setY(255+y);

        lineTo2 = new LineTo();
        lineTo2.setX(20);
        lineTo2.setY(255+y);

        arcto = new ArcTo();
        arcto.setX(20);
        arcto.setY(245+y);
        arcto.setRadiusX(5);
        arcto.setRadiusY(5);
        arcto.setLargeArcFlag(false);
        arcto.setSweepFlag(true);


        lineTo3 = new LineTo();
        lineTo3.setX(85);
        lineTo3.setY(245+y);

        lineTo4 = new LineTo();
        lineTo4.setX(90);
        lineTo4.setY(250+y);

        segment3.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment3.setStroke(Color.DEEPSKYBLUE);


        segment3.getElements().addAll(moveTo, lineTo, lineTo2, arcto, lineTo3, lineTo4);

        Path segment4 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(90);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(95);
        lineTo.setY(255+y);

        lineTo2 = new LineTo();
        lineTo2.setX(95);
        lineTo2.setY(320+y);

        arcto = new ArcTo();
        arcto.setX(85);
        arcto.setY(320+y);
        arcto.setRadiusX(5);
        arcto.setRadiusY(5);
        arcto.setLargeArcFlag(false);
        arcto.setSweepFlag(true);


        lineTo3 = new LineTo();
        lineTo3.setX(85);
        lineTo3.setY(255+y);

        lineTo4 = new LineTo();
        lineTo4.setX(90);
        lineTo4.setY(250+y);

        segment4.setFill(Color.DARKVIOLET);
        //path.setStrokeWidth(3);
        segment4.setStroke(Color.DARKVIOLET);


        segment4.getElements().addAll(moveTo, lineTo, lineTo2, arcto, lineTo3, lineTo4);

        lineObstacle.getChildren().addAll(segment1, segment2, segment3, segment4);

        x_cord = 150;
        y_cord = 250+y;

        setWidth_i(10);
        setWidth_j(10);
        setHeight_min(245+y);
        setHeight_max(320+y);

        rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(5000));
        rotateTransition.setNode(lineObstacle);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);


        rotateTransition.play();


        canvas.getChildren().add(lineObstacle);
    }

    @Override
    public void make_obstacle2(Pane canvas, double y) {
        int x = 120;
        setObstacle(new Group());
        Group lineObstacle = getObstacle();
        Path segment1 = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(90+x);
        moveTo.setY(250+y);

        LineTo lineTo = new LineTo();
        lineTo.setX(95+x);
        lineTo.setY(245+y);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(160+x);
        lineTo2.setY(245+y);

        ArcTo arcto = new ArcTo();
        arcto.setX(160+x);
        arcto.setY(255+y);
        arcto.setRadiusX(5);
        arcto.setRadiusY(5);
        arcto.setLargeArcFlag(false);
        arcto.setSweepFlag(true);


        LineTo lineTo3 = new LineTo();
        lineTo3.setX(95+x);
        lineTo3.setY(255+y);

        LineTo lineTo4 = new LineTo();
        lineTo4.setX(90+x);
        lineTo4.setY(250+y);

        segment1.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment1.setStroke(Color.RED);


        segment1.getElements().addAll(moveTo, lineTo, lineTo2, arcto, lineTo3, lineTo4);


        Path segment2 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(90+x);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(85+x);
        lineTo.setY(245+y);

        lineTo2 = new LineTo();
        lineTo2.setX(85+x);
        lineTo2.setY(180+y);

        arcto = new ArcTo();
        arcto.setX(95+x);
        arcto.setY(180+y);
        arcto.setRadiusX(5);
        arcto.setRadiusY(5);
        arcto.setLargeArcFlag(false);
        arcto.setSweepFlag(true);


        lineTo3 = new LineTo();
        lineTo3.setX(95+x);
        lineTo3.setY(245+y);

        lineTo4 = new LineTo();
        lineTo4.setX(90+x);
        lineTo4.setY(250+y);

        segment2.setFill(Color.YELLOW);
        //path.setStrokeWidth(3);
        segment2.setStroke(Color.YELLOW);


        segment2.getElements().addAll(moveTo, lineTo, lineTo2, arcto, lineTo3, lineTo4);


        Path segment3 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(90+x);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(85+x);
        lineTo.setY(255+y);

        lineTo2 = new LineTo();
        lineTo2.setX(20+x);
        lineTo2.setY(255+y);

        arcto = new ArcTo();
        arcto.setX(20+x);
        arcto.setY(245+y);
        arcto.setRadiusX(5);
        arcto.setRadiusY(5);
        arcto.setLargeArcFlag(false);
        arcto.setSweepFlag(true);


        lineTo3 = new LineTo();
        lineTo3.setX(85+x);
        lineTo3.setY(245+y);

        lineTo4 = new LineTo();
        lineTo4.setX(90+x);
        lineTo4.setY(250+y);

        segment3.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment3.setStroke(Color.DEEPSKYBLUE);


        segment3.getElements().addAll(moveTo, lineTo, lineTo2, arcto, lineTo3, lineTo4);

        Path segment4 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(90+x);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(95+x);
        lineTo.setY(255+y);

        lineTo2 = new LineTo();
        lineTo2.setX(95+x);
        lineTo2.setY(320+y);

        arcto = new ArcTo();
        arcto.setX(85+x);
        arcto.setY(320+y);
        arcto.setRadiusX(5);
        arcto.setRadiusY(5);
        arcto.setLargeArcFlag(false);
        arcto.setSweepFlag(true);


        lineTo3 = new LineTo();
        lineTo3.setX(85+x);
        lineTo3.setY(255+y);

        lineTo4 = new LineTo();
        lineTo4.setX(90+x);
        lineTo4.setY(250+y);

        segment4.setFill(Color.DARKVIOLET);
        //path.setStrokeWidth(3);
        segment4.setStroke(Color.DARKVIOLET);


        segment4.getElements().addAll(moveTo, lineTo, lineTo2, arcto, lineTo3, lineTo4);

        lineObstacle.getChildren().addAll(segment1, segment2, segment3, segment4);

        x_cord = 150;
        y_cord = 250+y;

        setWidth_i(10);
        setWidth_j(10);
        setHeight_min(245+y);
        setHeight_max(320+y);

        rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(5000));
        rotateTransition.setNode(lineObstacle);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);


        rotateTransition.play();


        canvas.getChildren().add(lineObstacle);
    }

    @Override
    public void make_obstacles3(Pane canvas, double y){
        setObstacle(new Group());
        Group lineObstacle = getObstacle();
        Path segment1 = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(90);
        moveTo.setY(250+y);

        LineTo lineTo = new LineTo();
        lineTo.setX(95);
        lineTo.setY(245+y);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(160);
        lineTo2.setY(245+y);

        ArcTo arcto = new ArcTo();
        arcto.setX(160);
        arcto.setY(255+y);
        arcto.setRadiusX(5);
        arcto.setRadiusY(5);
        arcto.setLargeArcFlag(false);
        arcto.setSweepFlag(true);


        LineTo lineTo3 = new LineTo();
        lineTo3.setX(95);
        lineTo3.setY(255+y);

        LineTo lineTo4 = new LineTo();
        lineTo4.setX(90);
        lineTo4.setY(250+y);

        segment1.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment1.setStroke(Color.RED);


        segment1.getElements().addAll(moveTo, lineTo, lineTo2, arcto, lineTo3, lineTo4);


        Path segment2 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(90);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(85);
        lineTo.setY(245+y);

        lineTo2 = new LineTo();
        lineTo2.setX(85);
        lineTo2.setY(180+y);

        arcto = new ArcTo();
        arcto.setX(95);
        arcto.setY(180+y);
        arcto.setRadiusX(5);
        arcto.setRadiusY(5);
        arcto.setLargeArcFlag(false);
        arcto.setSweepFlag(true);


        lineTo3 = new LineTo();
        lineTo3.setX(95);
        lineTo3.setY(245+y);

        lineTo4 = new LineTo();
        lineTo4.setX(90);
        lineTo4.setY(250+y);

        segment2.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment2.setStroke(Color.DEEPSKYBLUE);


        segment2.getElements().addAll(moveTo, lineTo, lineTo2, arcto, lineTo3, lineTo4);


        Path segment3 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(90);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(85);
        lineTo.setY(255+y);

        lineTo2 = new LineTo();
        lineTo2.setX(20);
        lineTo2.setY(255+y);

        arcto = new ArcTo();
        arcto.setX(20);
        arcto.setY(245+y);
        arcto.setRadiusX(5);
        arcto.setRadiusY(5);
        arcto.setLargeArcFlag(false);
        arcto.setSweepFlag(true);


        lineTo3 = new LineTo();
        lineTo3.setX(85);
        lineTo3.setY(245+y);

        lineTo4 = new LineTo();
        lineTo4.setX(90);
        lineTo4.setY(250+y);

        segment3.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment3.setStroke(Color.RED);


        segment3.getElements().addAll(moveTo, lineTo, lineTo2, arcto, lineTo3, lineTo4);

        Path segment4 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(90);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(95);
        lineTo.setY(255+y);

        lineTo2 = new LineTo();
        lineTo2.setX(95);
        lineTo2.setY(320+y);

        arcto = new ArcTo();
        arcto.setX(85);
        arcto.setY(320+y);
        arcto.setRadiusX(5);
        arcto.setRadiusY(5);
        arcto.setLargeArcFlag(false);
        arcto.setSweepFlag(true);


        lineTo3 = new LineTo();
        lineTo3.setX(85);
        lineTo3.setY(255+y);

        lineTo4 = new LineTo();
        lineTo4.setX(90);
        lineTo4.setY(250+y);

        segment4.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment4.setStroke(Color.DEEPSKYBLUE);


        segment4.getElements().addAll(moveTo, lineTo, lineTo2, arcto, lineTo3, lineTo4);

        lineObstacle.getChildren().addAll(segment1, segment2, segment3, segment4);

        x_cord = 150;
        y_cord = 250+y;

        setWidth_i(10);
        setWidth_j(10);
        setHeight_min(245+y);
        setHeight_max(320+y);


        canvas.getChildren().add(lineObstacle);
    }

    @Override
    public void make_rotate(){
        rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(500));
        rotateTransition.setNode(obstacle);
        rotateTransition.setByAngle(90);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(false);
        rotateTransition.play();
    }


    @Override
    public void move_down() {
        this.getObstacle().setTranslateY(this.getObstacle().getTranslateY()+this.getSpeed());
        this.setHeight_max(this.getHeight_max() + this.getSpeed());
        this.setHeight_min(this.getHeight_min() + this.getSpeed());
        this.translate += this.getSpeed();
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