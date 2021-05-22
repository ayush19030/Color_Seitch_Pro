package sample;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.util.Duration;













public class Square extends Obstacle {
   private double width_i;
    private  double width_j;

    public Square(String type, double speed, int number, boolean is_dotted) {
        super(type, speed, number, is_dotted);
    }

public Square(){

}
    public double getWidth_i() {
        return width_i;
    }

    public double getWidth_j() {
        return width_j;
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


    public void setWidth_i(double width_i) {
        this.width_i = width_i;
    }

    public void setWidth_j(double width_j) {
        this.width_j = width_j;
    }

    @Override
    public void make_obstacle(Pane canvas, double y) {

        if (this.number==2){
            make_obstacle2(canvas, y);
            return;
        }

        setObstacle(new Group());
        Group squareObstacle = getObstacle();
        Path segment1 = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(220);
        moveTo.setY(320+y);

        LineTo lineTo = new LineTo();
        lineTo.setX(230);
        lineTo.setY(330+y);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(230);
        lineTo2.setY(170+y);

        LineTo lineTo3 = new LineTo();
        lineTo3.setX(220);
        lineTo3.setY(180+y);

        LineTo lineTo4 = new LineTo();
        lineTo4.setX(220);
        lineTo4.setY(320+y);

        segment1.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment1.setStroke(Color.RED);


        segment1.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4);


        Path segment2 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(220);
        moveTo.setY(180+y);

        lineTo = new LineTo();
        lineTo.setX(230);
        lineTo.setY(170+y);

        lineTo2 = new LineTo();
        lineTo2.setX(70);
        lineTo2.setY(170+y);

        lineTo3 = new LineTo();
        lineTo3.setX(80);
        lineTo3.setY(180+y);

        lineTo4 = new LineTo();
        lineTo4.setX(220);
        lineTo4.setY(180+y);

        segment2.setFill(Color.YELLOW);
        //path.setStrokeWidth(3);
        segment2.setStroke(Color.YELLOW);


        segment2.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4);


        Path segment3 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(80);
        moveTo.setY(180+y);

        lineTo = new LineTo();
        lineTo.setX(70);
        lineTo.setY(170+y);

        lineTo2 = new LineTo();
        lineTo2.setX(70);
        lineTo2.setY(330+y);

        lineTo3 = new LineTo();
        lineTo3.setX(80);
        lineTo3.setY(320+y);

        lineTo4 = new LineTo();
        lineTo4.setX(80);
        lineTo4.setY(180+y);

        segment3.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment3.setStroke(Color.DEEPSKYBLUE);


        segment3.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4);

        Path segment4 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(80);
        moveTo.setY(320+y);

        lineTo = new LineTo();
        lineTo.setX(70);
        lineTo.setY(330+y);

        lineTo2 = new LineTo();
        lineTo2.setX(230);
        lineTo2.setY(330+y);

        lineTo3 = new LineTo();
        lineTo3.setX(220);
        lineTo3.setY(320+y);

        lineTo4 = new LineTo();
        lineTo4.setX(80);
        lineTo4.setY(320+y);

        segment4.setFill(Color.DARKVIOLET);
        //path.setStrokeWidth(3);
        segment4.setStroke(Color.DARKVIOLET);


        segment4.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4);

        squareObstacle.getChildren().addAll(segment1, segment2, segment3, segment4);

        x_cord = 150;
        y_cord = 250+y;

        setWidth_i(10);
        setWidth_j(10);
        setHeight_min(170+y);
        setHeight_max(330+y);

        rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(4000));
        rotateTransition.setNode(squareObstacle);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);

        rotateTransition.play();
        canvas.getChildren().add(squareObstacle);



    }
    @Override
    public void make_obstacle2(Pane canvas, double y) {
        setObstacle(new Group());
        Group squareObstacle = getObstacle();
        Path segment1 = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(220);
        moveTo.setY(320+y);

        LineTo lineTo = new LineTo();
        lineTo.setX(230);
        lineTo.setY(330+y);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(230);
        lineTo2.setY(170+y);

        LineTo lineTo3 = new LineTo();
        lineTo3.setX(220);
        lineTo3.setY(180+y);

        LineTo lineTo4 = new LineTo();
        lineTo4.setX(220);
        lineTo4.setY(320+y);

        segment1.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment1.setStroke(Color.RED);


        segment1.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4);


        Path segment2 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(220);
        moveTo.setY(180+y);

        lineTo = new LineTo();
        lineTo.setX(230);
        lineTo.setY(170+y);

        lineTo2 = new LineTo();
        lineTo2.setX(70);
        lineTo2.setY(170+y);

        lineTo3 = new LineTo();
        lineTo3.setX(80);
        lineTo3.setY(180+y);

        lineTo4 = new LineTo();
        lineTo4.setX(220);
        lineTo4.setY(180+y);

        segment2.setFill(Color.YELLOW);
        //path.setStrokeWidth(3);
        segment2.setStroke(Color.YELLOW);


        segment2.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4);


        Path segment3 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(80);
        moveTo.setY(180+y);

        lineTo = new LineTo();
        lineTo.setX(70);
        lineTo.setY(170+y);

        lineTo2 = new LineTo();
        lineTo2.setX(70);
        lineTo2.setY(330+y);

        lineTo3 = new LineTo();
        lineTo3.setX(80);
        lineTo3.setY(320+y);

        lineTo4 = new LineTo();
        lineTo4.setX(80);
        lineTo4.setY(180+y);

        segment3.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment3.setStroke(Color.DEEPSKYBLUE);


        segment3.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4);

        Path segment4 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(80);
        moveTo.setY(320+y);

        lineTo = new LineTo();
        lineTo.setX(70);
        lineTo.setY(330+y);

        lineTo2 = new LineTo();
        lineTo2.setX(230);
        lineTo2.setY(330+y);

        lineTo3 = new LineTo();
        lineTo3.setX(220);
        lineTo3.setY(320+y);

        lineTo4 = new LineTo();
        lineTo4.setX(80);
        lineTo4.setY(320+y);

        segment4.setFill(Color.DARKVIOLET);
        //path.setStrokeWidth(3);
        segment4.setStroke(Color.DARKVIOLET);


        segment4.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4);

        Path segment5 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(370+y);

        lineTo = new LineTo();
        lineTo.setX(150);
        lineTo.setY(360+y);

        ArcTo arcto = new ArcTo();
        arcto.setX(260);
        arcto.setY(250+y);
        arcto.setRadiusX(110);
        arcto.setRadiusY(110);

        lineTo2 = new LineTo();
        lineTo2.setX(270);
        lineTo2.setY(250+y);

        ArcTo arcto2 = new ArcTo();
        arcto2.setX(150);
        arcto2.setY(370+y);
        arcto2.setRadiusX(120);
        arcto2.setRadiusY(120);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment5.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment5.setStroke(Color.RED);


        segment5.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);


        Path segment6 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(260);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(270);
        lineTo.setY(250+y);

        arcto = new ArcTo();
        arcto.setX(150);
        arcto.setY(130+y);
        arcto.setRadiusX(120);
        arcto.setRadiusY(120);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(140+y);

        arcto2 = new ArcTo();
        arcto2.setX(260);
        arcto2.setY(250+y);
        arcto2.setRadiusX(110);
        arcto2.setRadiusY(110);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment6.setFill(Color.YELLOW);
        //path.setStrokeWidth(3);
        segment6.setStroke(Color.YELLOW);


        segment6.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        Path segment7 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(150);
        moveTo.setY(140+y);

        lineTo = new LineTo();
        lineTo.setX(150);
        lineTo.setY(130+y);

        arcto = new ArcTo();
        arcto.setX(30);
        arcto.setY(250+y);
        arcto.setRadiusX(120);
        arcto.setRadiusY(120);


        lineTo2 = new LineTo();
        lineTo2.setX(40);
        lineTo2.setY(250+y);

        arcto2 = new ArcTo();
        arcto2.setX(150);
        arcto2.setY(140+y);
        arcto2.setRadiusX(110);
        arcto2.setRadiusY(110);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment7.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment7.setStroke(Color.DEEPSKYBLUE);

        segment7.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        Path segment8 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(40);
        moveTo.setY(250+y);

        lineTo = new LineTo();
        lineTo.setX(30);
        lineTo.setY(250+y);

        arcto = new ArcTo();
        arcto.setX(150);
        arcto.setY(370+y);
        arcto.setRadiusX(120);
        arcto.setRadiusY(120);

        lineTo2 = new LineTo();
        lineTo2.setX(150);
        lineTo2.setY(360+y);

        arcto2 = new ArcTo();
        arcto2.setX(40);
        arcto2.setY(250+y);
        arcto2.setRadiusX(110);
        arcto2.setRadiusY(110);
        arcto2.setLargeArcFlag(false);
        arcto2.setSweepFlag(true);

        segment8.setFill(Color.DARKVIOLET);
        //path.setStrokeWidth(3);
        segment8.setStroke(Color.DARKVIOLET);

        segment8.getElements().addAll(moveTo, lineTo, arcto, lineTo2, arcto2);

        squareObstacle.getChildren().addAll(segment1, segment2, segment3, segment4, segment5, segment6, segment7, segment8);

        x_cord = 150;
        y_cord = 250+y;

        setWidth_i(10);
        setWidth_j(10);
        setHeight_min(170+y);
        setHeight_max(330+y);

        rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.millis(4000));
        rotateTransition.setNode(squareObstacle);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);

        rotateTransition.play();
        canvas.getChildren().add(squareObstacle);

    }

    @Override
    public void make_obstacles3(Pane canvas, double y){
        setObstacle(new Group());
        Group squareObstacle = getObstacle();
        Path segment1 = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(220);
        moveTo.setY(320+y);

        LineTo lineTo = new LineTo();
        lineTo.setX(230);
        lineTo.setY(330+y);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(230);
        lineTo2.setY(170+y);

        LineTo lineTo3 = new LineTo();
        lineTo3.setX(220);
        lineTo3.setY(180+y);

        LineTo lineTo4 = new LineTo();
        lineTo4.setX(220);
        lineTo4.setY(320+y);

        segment1.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment1.setStroke(Color.DEEPSKYBLUE);


        segment1.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4);


        Path segment2 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(220);
        moveTo.setY(180+y);

        lineTo = new LineTo();
        lineTo.setX(230);
        lineTo.setY(170+y);

        lineTo2 = new LineTo();
        lineTo2.setX(70);
        lineTo2.setY(170+y);

        lineTo3 = new LineTo();
        lineTo3.setX(80);
        lineTo3.setY(180+y);

        lineTo4 = new LineTo();
        lineTo4.setX(220);
        lineTo4.setY(180+y);

        segment2.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment2.setStroke(Color.RED);


        segment2.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4);


        Path segment3 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(80);
        moveTo.setY(180+y);

        lineTo = new LineTo();
        lineTo.setX(70);
        lineTo.setY(170+y);

        lineTo2 = new LineTo();
        lineTo2.setX(70);
        lineTo2.setY(330+y);

        lineTo3 = new LineTo();
        lineTo3.setX(80);
        lineTo3.setY(320+y);

        lineTo4 = new LineTo();
        lineTo4.setX(80);
        lineTo4.setY(180+y);

        segment3.setFill(Color.DEEPSKYBLUE);
        //path.setStrokeWidth(3);
        segment3.setStroke(Color.DEEPSKYBLUE);


        segment3.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4);

        Path segment4 = new Path();

        moveTo = new MoveTo();
        moveTo.setX(80);
        moveTo.setY(320+y);

        lineTo = new LineTo();
        lineTo.setX(70);
        lineTo.setY(330+y);

        lineTo2 = new LineTo();
        lineTo2.setX(230);
        lineTo2.setY(330+y);

        lineTo3 = new LineTo();
        lineTo3.setX(220);
        lineTo3.setY(320+y);

        lineTo4 = new LineTo();
        lineTo4.setX(80);
        lineTo4.setY(320+y);

        segment4.setFill(Color.RED);
        //path.setStrokeWidth(3);
        segment4.setStroke(Color.RED);


        segment4.getElements().addAll(moveTo, lineTo, lineTo2, lineTo3, lineTo4);

        squareObstacle.getChildren().addAll(segment1, segment2, segment3, segment4);

        x_cord = 150;
        y_cord = 250+y;

        setWidth_i(10);
        setWidth_j(10);
        setHeight_min(170+y);
        setHeight_max(330+y);

        canvas.getChildren().add(squareObstacle);

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
