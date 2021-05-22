package sample;
import com.sun.javafx.scene.paint.GradientUtils;
import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gameplay implements Serializable {
    Scene mainMenu, loadPrevGame, pauseGame, game, endgame, paused_game, game_loaded, game2;

   private int out;
    private  int out2;
    int highScore2;
    int stars2;
    int score;
    int score2;
    int highScore;
    int stars;
    double translate;

    int revive=1;
    static int mode =1;
    Ball ball;
    Ball2 ball2;
    boolean moved;
    ArrayList<Obstacle> obstacles;
    ArrayList<Rewards> rewards;
    ArrayList<SwitchColor> switchColors;
    ArrayList<String> saved_games = new ArrayList<>();


    {
        try {

            saved_games = (ArrayList<String>) Mangment.load_game_save();


        } catch (Exception e) {
            saved_games.add("No Game Saved");
            saved_games.add("No Game Saved");
            saved_games.add("No Game Saved");
            saved_games.add("No Game Saved");
            saved_games.add("No Game Saved");
            try {
                Mangment.save_game_save(saved_games);

            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
        System.out.println(saved_games);
    }


    public double getTranslate() {
        return translate;
    }

    public void setTranslate(double translate) {
        this.translate = translate;
    }

    public Scene getGame() {
        return game;
    }

    public Ball getBall() {
        return ball;
    }

    public Scene getMainMenu() {
        return mainMenu;
    }

    public Scene getPauseGame() {
        return pauseGame;
    }

    public Scene getLoadPrevGame() {
        return loadPrevGame;
    }
    public void make(Stage primary){
        Button button1= new Button("Classic");
        Button button2= new Button("Spartns");
        button1.setMaxWidth(Double.MAX_VALUE);
        button2.setMaxWidth(Double.MAX_VALUE);
        button1.setStyle("-fx-font-size:40; -fx-background-color: transparent; -fx-text-fill: blue");
        button2.setStyle("-fx-font-size:40; -fx-background-color: transparent; -fx-text-fill: green");
Pane canvas = new Pane();
button1.setTranslateX(60);
        button2.setTranslateX(58);
        button1.setTranslateY(300);
        button2.setTranslateY(380);


        Image image = new Image("file:url.png");
        ImageView imageView= new ImageView(image);
        imageView.setPreserveRatio(true);

        imageView.setTranslateX(50);
        imageView.setTranslateY(70);
        imageView.setFitWidth(200);
        imageView.setFitHeight(250);
        canvas.getChildren().addAll(imageView, button1, button2);
        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);

        Background background = new Background(background_fill);
        canvas.setBackground(background);
button1.setOnAction(event -> {
    start_new_game(primary);
    primary.setScene(game);
});
        button2.setOnAction(event -> {
            start_new_game2(primary);
            primary.setScene(game2);
        });


        Scene tt= new Scene(canvas, 300, 600);
        primary.setScene(tt);


    }

    public void main_menu(Stage primaryStage){
        Button button1= new Button("GAME MODES");
        Button button2= new Button("Load Game");
        Button button3= new Button("Exit Game");

        button1.setMaxWidth(Double.MAX_VALUE);
        button2.setMaxWidth(Double.MAX_VALUE);
        button3.setMaxWidth(Double.MAX_VALUE);
        button1.setPrefHeight(2);
        button2.setPrefHeight(2);
        button3.setPrefHeight(2);

        button1.setStyle("-fx-font-size:35; -fx-background-color: transparent; -fx-text-fill: blue");
        button2.setStyle("-fx-font-size:35; -fx-background-color: transparent; -fx-text-fill: green");
        button3.setStyle("-fx-font-size:36; -fx-background-color: transparent; -fx-text-fill: red");

        TilePane tileButtons = new TilePane(Orientation.VERTICAL);
        tileButtons.setVgap(0.0);
        tileButtons.getChildren().addAll(button1, button2, button3);
        tileButtons.setAlignment(Pos.CENTER);

        button1.setOnAction(e -> {
make(primaryStage);
            //
//                        this.start_new_game(primaryStage);
//
//
//            primaryStage.setScene(game);
//            this.start_new_game2(primaryStage);
//            primaryStage.setScene(game2);
        });
        button2.setOnAction(e ->{
                load_previous_game(primaryStage);
                primaryStage.setScene(loadPrevGame);});
        button3.setOnAction(e -> exit_game());
        VBox layout = new VBox(0);

        Image image = new Image("file:url.png");
        ImageView imageView= new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setX(200);
        imageView.setTranslateX(20);
        imageView.setTranslateY(30);
        imageView.setFitWidth(300);
        imageView.setFitHeight(250);
        ImageView imageView2= new ImageView(new Image("file:img2.png"));
        imageView2.setFitWidth(100);
        imageView2.setFitHeight(50);
        imageView2.setTranslateX(100);
        imageView2.setPreserveRatio(true);

        layout.getChildren().addAll(imageView2,imageView,tileButtons);
        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);

        Background background = new Background(background_fill);
        layout.setBackground(background);

        mainMenu = new Scene(layout, 300, 600);




    }

    public  void makegame(SaveData data, Stage primaryStage) {

        try {
            highScore=(int)Mangment.load_game_score();
            stars=(int)Mangment.load_game_star();
        } catch (Exception e) {
            e.printStackTrace();
        }
        score= data.getSrt();
        Pane canvas = new Pane();
        Button button = new Button();
        Text text = new Text();
        text.setText(""+score);
        text.setFont(new Font(20));
        text.setFill(Color.WHITE);
        text.setX(250);
        text.setY(40);
        button.setPrefSize(50,60);
        Image img3 = new Image("file:ty.png");

        ImageView view3 = new ImageView(img3);
        view3.setPreserveRatio(true);
        view3.setFitWidth(50);

        view3.setFitHeight(40);
        button.setGraphic(view3);

        button.setStyle("-fx-background-color: transparent;");


        canvas.getChildren().addAll(button, text);
        Ball load_ball = data.getBall();
        ArrayList<obstacle_copy> load_obstacles = data.getObstacles();
        ArrayList<rewards_copy> load_rewards = data.getRewards();
        ArrayList<switch_copy> load_switch = data.getSwitchColors();
        obstacles=new ArrayList<>();
        rewards= new ArrayList<>();
        switchColors = new ArrayList<>();
        String yt= load_ball.tr;
        if (yt.equals("RED")){
        ball = new Ball(Color.RED, load_ball.speed, load_ball.radius);}


        if (yt.equals("YELLOW")){
            ball = new Ball(Color.YELLOW, load_ball.speed, load_ball.radius);}

        if (yt.equals("DEEPSKYBLUE")){
            ball = new Ball(Color.DEEPSKYBLUE, load_ball.speed, load_ball.radius);}

        if (yt.equals("DARKVIOLET")){
            ball = new Ball(Color.DARKVIOLET, load_ball.speed, load_ball.radius);}






        ball.ops = load_ball.ops;
        ball.make_ball(150, data.getCor());
        System.out.println(data.getCor() +"==========================");
        ball.set();



        canvas.setOnMouseClicked(e -> ball.move_up(canvas, obstacles, rewards, switchColors, primaryStage, this) );
        canvas.getChildren().add(ball.getBall());
        for (int i = 0; i < load_obstacles.size(); i++) {
            obstacle_copy Ob1 = load_obstacles.get(i);

            if (Ob1.type.equals("Circle")) {
                Obstacle circle_obstacle = new circle("Circle", Ob1.speed, Ob1.number, false);
                circle_obstacle.make_obstacle(canvas, Ob1.y);
                circle_obstacle.x_cord=Ob1.x_cord;
                circle_obstacle.y_cord=Ob1.y_cord;
                circle_obstacle.translate=Ob1.translate;
                obstacles.add(circle_obstacle);
            }
            if ( Ob1.type.equals("Square")){
                Obstacle circle_obstacle = new Square("Square", Ob1.speed, Ob1.number, false);
                circle_obstacle.make_obstacle(canvas, Ob1.y);
                circle_obstacle.x_cord=Ob1.x_cord;
                circle_obstacle.y_cord=Ob1.y_cord;
                circle_obstacle.translate=Ob1.translate;
                obstacles.add(circle_obstacle);
            }


            if ( Ob1.type.equals("Triangle")){
                Obstacle circle_obstacle = new Triangle("Triangle", Ob1.speed, Ob1.number, false);
                circle_obstacle.make_obstacle(canvas, Ob1.y);
                circle_obstacle.x_cord=Ob1.x_cord;
                circle_obstacle.y_cord=Ob1.y_cord;
                circle_obstacle.translate=Ob1.translate;
                obstacles.add(circle_obstacle);
            }
            if ( Ob1.type.equals("Line")){
                Obstacle circle_obstacle = new Line("Line", Ob1.speed, Ob1.number, false);
                circle_obstacle.make_obstacle(canvas, Ob1.y);
                circle_obstacle.x_cord=Ob1.x_cord;
                circle_obstacle.y_cord=Ob1.y_cord;
                circle_obstacle.translate=Ob1.translate;
                obstacles.add(circle_obstacle);
            }
            System.out.println(load_rewards);
            rewards_copy r1= load_rewards.get(i);
            switch_copy s1 = load_switch.get(i);


            Rewards star = new Rewards(r1.speed);
            star.makeStar(canvas, r1.y);
            star.setUsed(r1.used);
            if (star.isUsed()){
                star.star.setVisible(false);
            }
            star.x_cord=r1.x_cord;
            star.y_cord=r1.y_cord;

            rewards.add(star);

            SwitchColor switchColor = new SwitchColor(s1.speed);
            switchColor.makeSwitch(canvas,s1.y);
            switchColor.setUsed(s1.used);
            if (switchColor.isUsed()){
                switchColor.getSwitch().setVisible(false);
            }

            switchColors.add(switchColor);

        }

        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        canvas.setBackground(background);


        button.setOnAction(e -> {

            double laest_ball_cord= ball.ball.getCenterY();
            score = Integer.parseInt(text.getText());
            if (score>highScore){
                highScore = score;
            }
            //stars += score;
            try {
                Mangment.save_game_star(stars);
                Mangment.save_game_score(score);
            } catch (Exception ee) {
                ee.printStackTrace();
            }

            if (ball.animationTimer!=null) {
                ball.animationTimer.stop();
            }
            pause(primaryStage, laest_ball_cord);
            primaryStage.setScene(pauseGame);

        });
        game_loaded = new Scene(canvas, 300, 600);

    }


    public void load_previous_game(Stage primaryStage){

        ComboBox comboBox = new ComboBox();
        for (int i = 0; i < saved_games.size(); i++) {
if(saved_games.get(i).equals("No Game Saved")){

            }
else {
    comboBox.getItems().add(saved_games.get(i));
}
        }
        comboBox.setEditable(true);
        comboBox.setTranslateX(50);
        comboBox.setOnAction((event) -> {
            int selectedIndex = comboBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = comboBox.getSelectionModel().getSelectedItem();
            String value = (String) comboBox.getValue();
            try {

                if ( value.equals("No Game Saved")){
                    start_new_game(primaryStage);
                    primaryStage.setScene(game);
                }
                else{

                    SaveData data = (SaveData) Mangment.load_game(value);
                    System.out.println("Game Opened");
                    makegame(data, primaryStage);
                    primaryStage.setScene(game_loaded);}
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
            System.out.println("   ComboBox.getValue(): " + comboBox.getValue());
        });

        Label label= new Label("      SELECT GAME TO PLAY");
        label.setTextFill(Color.web("#990000"));
        label.setPrefWidth(300);
        label.setPrefHeight(100);
        label.setFont(new Font("Arial",20));
        Button button= new Button("BACK");
        button.setOnAction(e -> primaryStage.setScene(mainMenu));
        button.setStyle("-fx-base : red;");
        button.setStyle("-fx-background-color: transparent;");
//        button.setStyle("-fx-text-fill: #990000");
        button.setPrefSize(100,50);




        Button button1= new Button(saved_games.get(saved_games.size()-1));
        Button button2= new Button(saved_games.get(saved_games.size()-2));
        Button button3= new Button(saved_games.get(saved_games.size()-3));
        Button button4= new Button(saved_games.get(saved_games.size()-4));
        Button button5= new Button(saved_games.get(saved_games.size()-5));




        Image img51 = new Image("file:back.png");
        ImageView view51 = new ImageView(img51);

        view51.setFitWidth(30);
        view51.setFitHeight(30);
        button.setGraphic(view51);

        Image img2 = new Image("file:play1.png");
        ImageView view2 = new ImageView(img2);

        view2.setFitWidth(30);
        view2.setFitHeight(30);

        ImageView view3= new ImageView(img2);

        view3.setFitWidth(30);
        view3.setFitHeight(30);

        ImageView view4 = new ImageView(img2);

        view4.setFitWidth(30);
        view4.setFitHeight(30);
        ImageView view5 = new ImageView(img2);

        view5.setFitWidth(30);
        view5.setFitHeight(30);
        ImageView view6 = new ImageView(img2);

        view6.setFitWidth(30);
        view6.setFitHeight(30);

        button1.setPrefSize(200,60);
        button2.setPrefSize(200,60);
        button3.setPrefSize(200,60);
        button4.setPrefSize(200,60);
        button5.setPrefSize(200,60);

        button1.setStyle("-fx-base : #990000;");
        button2.setStyle("-fx-base : #990000;");
        button3.setStyle("-fx-base : #990000;");
        button4.setStyle("-fx-base : #990000;");
        button5.setStyle("-fx-base : #990000;");

        button1.setGraphic(view3);
        button2.setGraphic(view2);
        button3.setGraphic(view4);
        button4.setGraphic(view5);
        button5.setGraphic(view6);

        button1.setOnMouseClicked((MouseEvent e) -> {
            try {

                if ( button1.getText().equals("No Game Saved")){
                    start_new_game(primaryStage);
                    primaryStage.setScene(game);
                }
                else{

                SaveData data = (SaveData) Mangment.load_game(button1.getText());
                System.out.println("Game Opened");
                makegame(data, primaryStage);
                primaryStage.setScene(game_loaded);}
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        button2.setOnMouseClicked((MouseEvent e) -> {
            try {
                if ( button2.getText().equals("No Game Saved")){
                    start_new_game(primaryStage);
                    primaryStage.setScene(game);
                }
                else {
                SaveData data = (SaveData) Mangment.load_game(button2.getText());
                System.out.println("Game Opened");
                makegame(data, primaryStage);
                primaryStage.setScene(game_loaded);
            }}
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        button3.setOnMouseClicked((MouseEvent e) -> {

            try {
                if ( button3.getText().equals("No Game Saved")){
                    start_new_game(primaryStage);
                    primaryStage.setScene(game);
                }
                else {
                SaveData data = (SaveData) Mangment.load_game(button3.getText());
                System.out.println("Game Opened");
                makegame(data, primaryStage);
                primaryStage.setScene(game_loaded);
            }}
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        button4.setOnMouseClicked((MouseEvent e) -> {
            try {
                if ( button4.getText().equals("No Game Saved")){
                    start_new_game(primaryStage);
                    primaryStage.setScene(game);
                }
                else {
                SaveData data = (SaveData) Mangment.load_game(button4.getText());
                System.out.println("Game Opened");
                makegame(data, primaryStage);
                primaryStage.setScene(game_loaded);
            }}
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        button5.setOnMouseClicked((MouseEvent e) -> {
            try {
                if ( button5.getText().equals("No Game Saved")){
                    start_new_game(primaryStage);
                    primaryStage.setScene(game);
                }
                SaveData data = (SaveData) Mangment.load_game(button5.getText());
                System.out.println("Game Opened");
                makegame(data, primaryStage);
                primaryStage.setScene(game_loaded);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        TilePane tileButtons = new TilePane(Orientation.VERTICAL);
        tileButtons.setPadding(new Insets(20, 10, 20, 0));
        tileButtons.setHgap(50.0);

        tileButtons.setVgap(8.0);
        tileButtons.getChildren().addAll(button1, button2, button3,button4,button5);
        tileButtons.setAlignment(Pos.CENTER);


        VBox layout= new VBox();

        layout.getChildren().addAll(button, label,comboBox,  tileButtons);

        loadPrevGame = new Scene(layout,300,600);
    }

    public int revive(){
        int required = (int)Math.pow(2, out-1)*2;
        System.out.println("Stars"+stars);
        if (required<=stars){
            return required;
        }
        return 0;
    }
    public int revive2(){
        int required = (int)Math.pow(2, out2-1)*1;
        System.out.println(required+"----------");
        System.out.println("Stars"+stars);
        if (required<=stars2){
            return required;
        }
        return 0;
    }




    public void pause(Stage primaryStage, double yuu){
        Label label= new Label("    Score:"+score+"\n" +
                "    High Score:"+highScore);
        label.setTextFill(Color.web("#990000"));
        label.setPrefWidth(300);
        label.setPrefHeight(60);
        label.setFont(new Font("Arial",24));
        label.setStyle("-fx-font-weight: bold");

        Button button1= new Button("Save Game");





        Button button2= new Button(" Resume");

        Button button3= new Button("MainMenu");
        Button button4 = new Button("New Game");


        button1.setOnAction(e ->{
           ask_name(primaryStage, yuu);
        });

        button2.setOnAction(e ->{
    my_screen(primaryStage, ball ,yuu );
    primaryStage.setScene(paused_game);
        });

        button3.setOnAction(e -> primaryStage.setScene(mainMenu));
        button4.setOnAction(e ->{
            this.start_new_game(primaryStage);
            primaryStage.setScene(game);
        });

        button1.setPrefSize(150,40);
        button2.setPrefSize(150,40);
        button3.setPrefSize(150,40);
        button4.setPrefSize(150,40);



        button1.setStyle("-fx-base : #990000;");
        button2.setStyle("-fx-base : #990000;");
        button3.setStyle("-fx-base : #990000;");
        button4.setStyle("-fx-base : #990000;");

        Image img2 = new Image("file:play1.png");
        ImageView view2 = new ImageView(img2);

        view2.setFitWidth(30);
        view2.setFitHeight(30);
        button4.setGraphic(view2);



        Image img5 = new Image("file:back.png");
        ImageView view5 = new ImageView(img5);

        view5.setFitWidth(30);
        view5.setFitHeight(30);
        button3.setGraphic(view5);


        Image img4 = new Image("file:download.png");
        ImageView view4 = new ImageView(img4);

        view4.setFitWidth(30);
        view4.setFitHeight(30);
        button1.setGraphic(view4);


        Image img3 = new Image("file:ty.png");
        ImageView view3 = new ImageView(img3);

        view3.setFitWidth(30);
        view3.setFitHeight(30);
        button2.setGraphic(view3);

        TilePane tileButtons = new TilePane(Orientation.VERTICAL);
        tileButtons.setPadding(new Insets(20, 10, 20, 0));
        tileButtons.setVgap(10);
        tileButtons.getChildren().addAll(label, button2, button4,button3, button1);
        tileButtons.setAlignment(Pos.CENTER);

        VBox layout= new VBox();

        layout.getChildren().addAll( tileButtons);
//
        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
//
        Background background = new Background(background_fill);
        layout.setBackground(background);

        pauseGame = new Scene(layout,300,500);
    }

public void ask_name(Stage primary, double yuu){
        Pane canvas = new Pane();

    Text text = new Text();
    text.setText("Save your Game");
    text.setFont(new Font(40));
    text.setFill(Color.RED);
    text.setX(50);
    text.setY(120);
    canvas.getChildren().add(text);
    TextField ytu= new TextField();
    ytu.setTranslateX(120);
    ytu.setTranslateY(140);

    Button b = new Button("Save");
    b.setTranslateX(60);
    b.setTranslateY(190);
    b.setPrefSize(80,80);

    Image img5 = new Image("file:download.png");
    ImageView view5 = new ImageView(img5);

    view5.setFitWidth(30);
    view5.setFitHeight(30);
    b.setGraphic(view5);
//    b.setStyle("-fx-font-size:15; -fx-background-color: transparent; -fx-text-fill: blue");
b.setOnAction(event -> {
    SaveData data= new SaveData();
    Ball balls = new Ball(ball.ball.getFill().toString(), ball.speed, ball.radius);
    balls.ops=ball.ops;

    ArrayList<obstacle_copy> saved_obstacle= new ArrayList<>();
    for (int i = 0; i <obstacles.size() ; i++) {
        saved_obstacle.add( obstacles.get(i).get_clone());
    }

    ArrayList<rewards_copy> saverewards = new ArrayList<>();
    for (int i = 0; i <rewards.size() ; i++) {
        saverewards.add( rewards.get(i).get_clone());
    }

    ArrayList<switch_copy> saved_switch= new ArrayList<>();
    for (int i = 0; i < switchColors.size(); i++) {
        switch_copy ttt= switchColors.get(i).get_clone();
        ttt.y=saved_obstacle.get(i).y;
        saved_switch.add(ttt);
    }


    data.feed_data(balls, saved_obstacle,saved_switch, saverewards,yuu , score);
    String trrr= null;
    System.out.println("ayush"+ytu.getText()+"garg");
    if (ytu.getText().equals("")){
        trrr="random";
    }
    else {
        trrr=ytu.getText();
    }
    try {




        Mangment.save_game(data, trrr);
        saved_games.add(trrr);
        Mangment.save_game_save(saved_games);
        System.out.println("maheeee");
        primary.setScene(mainMenu);

    } catch (Exception exception) {
        exception.printStackTrace();
    }


main_menu(primary);
    primary.setScene(mainMenu);



});
    Button et= new Button("Back");
    et.setTranslateX(250);
    et.setTranslateY(190);
et.setPrefSize(80,80);

    Image img51 = new Image("file:back.png");
    ImageView view51 = new ImageView(img51);

    view51.setFitWidth(30);
    view51.setFitHeight(30);
    et.setGraphic(view51);
  //  e.setStyle("-fx-font-size:35; -fx-background-color: transparent; -fx-text-fill: blue");
et.setOnAction(e -> {
pause(primary,yuu);
primary.setScene(pauseGame);
//main_menu(primary);
//primary.setScene(mainMenu);
});

canvas.getChildren().addAll(ytu, b, et);
    BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(background_fill);
    canvas.setBackground(background);


    Scene thisu= new Scene(canvas, 400, 400 );
    primary.setScene(thisu);

}


    public void my_screen(Stage primaryStage,Ball balls,   double latest_ball_cord){
        try {
            highScore=(int)Mangment.load_game_score();
            stars=(int)Mangment.load_game_star();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(balls+" "+ ball);
        ball = new Ball((Color) balls.ball.getFill(), balls.speed, balls.radius);
        ball.ops=balls.ops;
        ball.make_ball(150,latest_ball_cord);
        ball.set();

        Pane canvas = new Pane();
        Button button = new Button();
        Text text = new Text();
        text.setText(""+score);
        text.setFont(new Font(20));
        text.setFill(Color.WHITE);
        text.setX(250);
        text.setY(40);
        button.setPrefSize(50,60);
        Image img3 = new Image("file:ty.png");
        ImageView view3 = new ImageView(img3);

        view3.setFitWidth(50);
        view3.setFitHeight(40);
        button.setGraphic(view3);

        button.setStyle("-fx-background-color: transparent;");
        canvas.getChildren().addAll(button, text);

        canvas.setOnMouseClicked(e -> ball.move_up(canvas, obstacles, rewards, switchColors, primaryStage, this) );
        canvas.getChildren().add(ball.getBall());
        for (int i = 0; i < obstacles.size(); i++) {
            canvas.getChildren().addAll(obstacles.get(i).obstacle, rewards.get(i).star, switchColors.get(i).getSwitch());
        }

        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        canvas.setBackground(background);

        button.setOnAction(e -> {


            double latet_ball_cord= ball.ball.getCenterY();




//

            this.score = Integer.parseInt(text.getText());
            if (this.score>this.highScore){
                this.highScore = this.score;
            }
            //this.stars += score;
            try {
                Mangment.save_game_star(stars);
                Mangment.save_game_score(highScore);
            } catch (Exception ee) {
                ee.printStackTrace();
            }


            if (ball.animationTimer!=null) {
                ball.animationTimer.stop();
            }
            pause(primaryStage, latet_ball_cord);
            primaryStage.setScene(pauseGame);

        });


        paused_game= new Scene(canvas, 300, 600);

    }

    public static int random(int min, int max){

        int range = max - min + 1;

        return (int)(Math.random() * range) + min;
    }

    public void takeSnapShot(Stage primary, double yoyo){

        try {
            Mangment.save_game_score(highScore);
            //stars+=score;
            Mangment.save_game_star(stars);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out++;

        Scene scene= primary.getScene();
        Pane canvas= new Pane();

        WritableImage writableImage =
                new WritableImage((int)scene.getWidth(), (int)scene.getHeight());
        scene.snapshot(writableImage);

        File file = new File("snapshot.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            System.out.println("snapshot saved: " + file.getAbsolutePath());
        }



        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        Image image = new Image("file:snapshot.png");
        ImageView imageView= new ImageView(image);

        imageView.setX(20);
        imageView.setY(40);
        imageView.setFitWidth(370);
        imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);

        canvas.getChildren().add(imageView);


        Text text = new Text();
        text.setText("Your Score: "+score);
        text.setFont(new Font(40));
        text.setFill(Color.RED);
        text.setX(250);
        text.setY(100);
        canvas.getChildren().add(text);

        Text text2 = new Text();
        text2.setText("HighScore: "+highScore);
        text2.setFont(new Font(40));
        text2.setFill(Color.RED);
        text2.setX(250);
        text2.setY(180);
        canvas.getChildren().add(text2);

        Text text3 = new Text();
        text3.setText("Total Stars: "+stars);
        text3.setFont(new Font(40));
        text3.setFill(Color.RED);
        text3.setX(250);
        text3.setY(260);
        canvas.getChildren().add(text3);
        int required = revive();

        if (required>0 && revive==1) {

            Button revive = new Button("Revive");
            revive.setTranslateX(250);
            revive.setTranslateY(300);
            revive.setPrefSize(200, 40);
            Image img5 = new Image("file:revive.png");
            ImageView view5 = new ImageView(img5);

            view5.setFitWidth(30);
            view5.setFitHeight(30);
            revive.setGraphic(view5);
            revive.setStyle("-fx-font-size:35; -fx-background-color: transparent; -fx-text-fill: black");
            revive.setOnAction(event -> {
//            System.out.println(ball);
                stars-=required;
                try {
                    Mangment.save_game_star(stars);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                my_screen(primary, ball, yoyo);
                primary.setScene(paused_game);

            });

            canvas.getChildren().add(revive);
        }




        Button exit= new Button("Exit ");
        exit.setTranslateX(250);
        exit.setTranslateY(370);
        exit.setPrefSize(200,40);
        Image img51 = new Image("file:back.png");
        ImageView view51 = new ImageView(img51);

        view51.setFitWidth(30);
        view51.setFitHeight(30);
        exit.setGraphic(view51);
        exit.setStyle("-fx-font-size:35; -fx-background-color: transparent; -fx-text-fill: blue");
        exit.setOnAction(event -> {
//            if (score>highScore){
//                highScore = score;
//            }
      //      stars += score;
            try {
                Mangment.save_game_score(highScore);
                Mangment.save_game_star(stars);
            } catch (Exception exception) {
                exception.printStackTrace();
            }



            main_menu(primary);
            primary.setScene(mainMenu);


        });













        canvas.getChildren().add(exit);





        Scene ty = new Scene(canvas,500, 500 );

        primary.setScene(ty);

        System.out.println("done");





    }

    public void start_new_game(Stage primaryStage) {
        out = 0;
        revive=1;
        try {
            highScore=(int)Mangment.load_game_score();
            stars=(int) Mangment.load_game_star();
        } catch (Exception e) {
            e.printStackTrace();
        }

        obstacles = new ArrayList<>();
        rewards = new ArrayList<>();
        switchColors = new ArrayList<>();
        score = 0;
        Pane canvas = new Pane();
        Button button = new Button();
        Text text = new Text();
        text.setText(""+score);
        text.setFont(new Font(20));
        text.setFill(Color.WHITE);
        text.setX(250);
        text.setY(40);
        button.setPrefSize(50,60);
        Image img3 = new Image("file:ty.png");

        ImageView view3 = new ImageView(img3);
        view3.setPreserveRatio(true);
        view3.setFitWidth(50);
        view3.setFitHeight(40);
        button.setGraphic(view3);

        button.setStyle("-fx-background-color: transparent;");


        canvas.getChildren().addAll(button, text);

        int random = random(1,4);
        Color color;
        if (random==1){
            color = Color.RED;
        }
        else if (random==2){
            color = Color.YELLOW;
        }
        else if (random==3){
            color = Color.DEEPSKYBLUE;
        }
        else {
            color = Color.DARKVIOLET;
        }

        ball = new Ball(color, 50, 8);
        ball.make_ball(150,450);
        ball.set();

        canvas.setOnMouseClicked(e -> {
//            Media media = new Media("file:s1.mpeg");
//            MediaPlayer mediaPlayer = new MediaPlayer(media);
//            mediaPlayer.play();
            ball.move_up(canvas, obstacles, rewards, switchColors, primaryStage, this);
        });
        canvas.getChildren().add(ball.getBall());

        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        canvas.setBackground(background);

        Obstacle circle_obstacle = new circle("Circle", 1.75, 1, false);
        circle_obstacle.make_obstacle(canvas, 0);

        Obstacle square = new Square("Square", 1.75, 1, false);
        square.make_obstacle(canvas, -350);

        Obstacle line = new Line("Line", 1.75, 1, false);
        line.make_obstacle(canvas,-700);

        Obstacle triangle = new Triangle("Triangle", 1.75, 1, false);
        triangle.make_obstacle(canvas, -1050);

        obstacles.add(circle_obstacle);
        obstacles.add(square);
        obstacles.add(line);
        obstacles.add(triangle);

        for (int i = 0; i <4 ; i++) {
            Rewards star = new Rewards(1.75);
            star.makeStar(canvas, obstacles.get(i).y_cord);
            rewards.add(star);
            SwitchColor switchColor = new SwitchColor(1.75);
            switchColor.makeSwitch(canvas,-i*350);
            switchColors.add(switchColor);
        }

        button.setOnAction(e -> {



            double latest_ball_cord= ball.ball.getCenterY();
            System.out.println(latest_ball_cord);


            score = Integer.parseInt(text.getText());
            if (score>highScore){
                highScore = score;
            }
            //stars += score;
            try {
                Mangment.save_game_score(highScore);
                Mangment.save_game_star(stars);
            } catch (Exception exception) {
                exception.printStackTrace();
            }


            System.out.println(latest_ball_cord+"njdhcjfnjdhf");

            if (ball.animationTimer!=null) {
                ball.animationTimer.stop();
            }
            pause(primaryStage, latest_ball_cord);
            primaryStage.setScene(pauseGame);

        });

        game = new Scene(canvas, 300, 600);
    }



    public void endGame(Stage primaryStage){
        Label label= new Label("    Score:30\n" +
                "    High Score:130");
        label.setTextFill(Color.web("#990000"));
        label.setPrefWidth(300);
        label.setPrefHeight(60);
        label.setFont(new Font("Arial",24));
        label.setStyle("-fx-font-weight: bold");

        Button button1= new Button("New Game");
        Button button2= new Button("Revive");

        Button button3= new Button("MainMenu");


        button1.setOnAction(e -> {



            this.start_new_game(primaryStage);
            primaryStage.setScene(game);
        });
        button2.setOnAction(e -> {
            if (stars>10){
                primaryStage.setScene(pauseGame);
            }
        });
        button3.setOnAction(e -> primaryStage.setScene(mainMenu));


        button1.setPrefSize(150,40);
        button2.setPrefSize(150,40);
        button3.setPrefSize(150,40);


        button1.setStyle("-fx-base : #990000;");
        button2.setStyle("-fx-base : #990000;");
        button3.setStyle("-fx-base : #990000;");

        Image img2 = new Image("file:play1.png");
        ImageView view2 = new ImageView(img2);

        view2.setFitWidth(30);
        view2.setFitHeight(30);
        button1.setGraphic(view2);



        Image img5 = new Image("file:back.png");
        ImageView view5 = new ImageView(img5);

        view5.setFitWidth(30);
        view5.setFitHeight(30);
        button3.setGraphic(view5);


        Image img4 = new Image("file:download.png");
        ImageView view4 = new ImageView(img4);

        view4.setFitWidth(30);
        view4.setFitHeight(30);
        button1.setGraphic(view4);


        Image img3 = new Image("file:ty.png");
        ImageView view3 = new ImageView(img3);

        view3.setFitWidth(30);
        view3.setFitHeight(30);
        button2.setGraphic(view3);

        TilePane tileButtons = new TilePane(Orientation.VERTICAL);
        tileButtons.setPadding(new Insets(20, 10, 20, 0));
        tileButtons.setVgap(10);
        tileButtons.getChildren().addAll(label, button2, button1,button3);
        tileButtons.setAlignment(Pos.CENTER);

        VBox layout= new VBox();

        layout.getChildren().addAll( tileButtons);
//
        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
//
        Background background = new Background(background_fill);
        layout.setBackground(background);

        endgame = new Scene(layout,300,400);
    }
    public void takeSnapShot2(Stage primary, double yoyo){


        out2++;

        Scene scene= primary.getScene();
        Pane canvas= new Pane();

        WritableImage writableImage =
                new WritableImage((int)scene.getWidth(), (int)scene.getHeight());
        scene.snapshot(writableImage);

        File file = new File("snapshot.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            System.out.println("snapshot saved: " + file.getAbsolutePath());
        }



        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        Image image = new Image("file:snapshot.png");
        ImageView imageView= new ImageView(image);

        imageView.setX(20);
        imageView.setY(40);
        imageView.setFitWidth(370);
        imageView.setFitHeight(400);
        imageView.setPreserveRatio(true);

        canvas.getChildren().add(imageView);




        Text text3 = new Text();
        text3.setText("Total Stars: "+stars2);
        text3.setFont(new Font(40));
        text3.setFill(Color.RED);
        text3.setX(250);
        text3.setY(200);
        canvas.getChildren().add(text3);
        int required = revive2();

        if (required>0 ) {

            Button revive = new Button("Revive");
            revive.setTranslateX(250);
            revive.setTranslateY(300);
            revive.setPrefSize(200, 40);
            Image img5 = new Image("file:revive.png");
            ImageView view5 = new ImageView(img5);

            view5.setFitWidth(30);
            view5.setFitHeight(30);
            revive.setGraphic(view5);
            revive.setStyle("-fx-font-size:35; -fx-background-color: transparent; -fx-text-fill: black");
            revive.setOnAction(event -> {
//            System.out.println(ball);


                my_screen2(primary, ball2, yoyo);


            });

            canvas.getChildren().add(revive);
        }




        Button exit= new Button("Exit ");
        exit.setTranslateX(250);
        exit.setTranslateY(370);
        exit.setPrefSize(200,40);
        Image img51 = new Image("file:back.png");
        ImageView view51 = new ImageView(img51);

        view51.setFitWidth(30);
        view51.setFitHeight(30);
        exit.setGraphic(view51);
        exit.setStyle("-fx-font-size:35; -fx-background-color: transparent; -fx-text-fill: blue");
        exit.setOnAction(event -> {
//            if (score>highScore){
//                highScore = score;
//            }
            //      stars += score;




            main_menu(primary);
            primary.setScene(mainMenu);


        });













        canvas.getChildren().add(exit);





        Scene ty = new Scene(canvas,500, 500 );

        primary.setScene(ty);

        System.out.println("done");





    }
    public void my_screen2(Stage primaryStage,Ball2 balls,   double latest_ball_cord){

       Ball2  ball2 = new Ball2((Color) balls.ball.getFill(), balls.speed, balls.radius);
        ball2.ops=balls.ops;
        ball2.make_ball(150,latest_ball_cord);
        ball2.set();

        Pane canvas = new Pane();
        Button button = new Button();
        Text text = new Text();
        text.setText(""+score2);
        text.setFont(new Font(20));
        text.setFill(Color.WHITE);
        text.setX(250);
        text.setY(40);
        button.setPrefSize(50,60);
        Image img3 = new Image("file:ty.png");
        ImageView view3 = new ImageView(img3);

        view3.setFitWidth(50);
        view3.setFitHeight(40);
        button.setGraphic(view3);

        button.setStyle("-fx-background-color: transparent;");
        canvas.getChildren().addAll(button, text);

        canvas.setOnMouseClicked(e -> ball2.move_up(canvas, obstacles, rewards, switchColors, primaryStage, this) );
        canvas.getChildren().add(ball2.getBall());
        for (int i = 0; i < obstacles.size(); i++) {
            canvas.getChildren().addAll(obstacles.get(i).obstacle, rewards.get(i).star, switchColors.get(i).getSwitch());
        }

        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        canvas.setBackground(background);

        button.setOnAction(e -> {


            double latet_ball_cord= ball.ball.getCenterY();




//






            if (ball.animationTimer!=null) {
                ball.animationTimer.stop();
            }
            pause2(primaryStage, latet_ball_cord);


        });


        Scene paused_game2= new Scene(canvas, 300, 600);
primaryStage.setScene(paused_game2);
    }

    public void pause2(Stage primaryStage, double yuu){
        Label label= new Label("    Score:"+score2);
        label.setTextFill(Color.web("#990000"));
        label.setPrefWidth(300);
        label.setPrefHeight(60);
        label.setFont(new Font("Arial",24));
        label.setStyle("-fx-font-weight: bold");







        Button button2= new Button(" Resume");

        Button button3= new Button("MainMenu");
        Button button4 = new Button("New Game");



        button2.setOnAction(e ->{
            my_screen2(primaryStage, ball2 ,yuu );

        });

        button3.setOnAction(e -> primaryStage.setScene(mainMenu));
        button4.setOnAction(e ->{
            this.start_new_game2(primaryStage);
            primaryStage.setScene(game2);
        });


        button2.setPrefSize(150,40);
        button3.setPrefSize(150,40);
        button4.setPrefSize(150,40);



        button2.setStyle("-fx-base : #990000;");
        button3.setStyle("-fx-base : #990000;");
        button4.setStyle("-fx-base : #990000;");

        Image img2 = new Image("file:play1.png");
        ImageView view2 = new ImageView(img2);

        view2.setFitWidth(30);
        view2.setFitHeight(30);
        button4.setGraphic(view2);



        Image img5 = new Image("file:back.png");
        ImageView view5 = new ImageView(img5);

        view5.setFitWidth(30);
        view5.setFitHeight(30);
        button3.setGraphic(view5);


        Image img4 = new Image("file:download.png");
        ImageView view4 = new ImageView(img4);

        view4.setFitWidth(30);
        view4.setFitHeight(30);



        Image img3 = new Image("file:ty.png");
        ImageView view3 = new ImageView(img3);

        view3.setFitWidth(30);
        view3.setFitHeight(30);
        button2.setGraphic(view3);

        TilePane tileButtons = new TilePane(Orientation.VERTICAL);
        tileButtons.setPadding(new Insets(20, 10, 20, 0));
        tileButtons.setVgap(10);
        tileButtons.getChildren().addAll(label, button2, button4,button3);
        tileButtons.setAlignment(Pos.CENTER);

        VBox layout= new VBox();

        layout.getChildren().addAll( tileButtons);
//
        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
//
        Background background = new Background(background_fill);
        layout.setBackground(background);

   Scene     pauseGame2 = new Scene(layout,300,500);
        primaryStage.setScene(pauseGame2);
    }


    public void start_new_game2(Stage primaryStage) {
//
        out2=0;

        moved = false;
        obstacles = new ArrayList<>();
        rewards = new ArrayList<>();
        switchColors = new ArrayList<>();
        score2 = 0;

        Pane canvas = new Pane();
        Button button = new Button();
        Text text = new Text();
        text.setText(""+score2);
        text.setFont(new Font(20));
        text.setFill(Color.WHITE);
        text.setX(250);
        text.setY(40);
        button.setPrefSize(50,60);
        Image img3 = new Image("file:ty.png");

        ImageView view3 = new ImageView(img3);
        view3.setPreserveRatio(true);
        view3.setFitWidth(50);
        view3.setFitHeight(40);
        button.setGraphic(view3);

        button.setStyle("-fx-background-color: transparent;");


        canvas.getChildren().addAll(button, text);

        int random = random(1,2);
        Color color;
        if (random==1){
            color = Color.RED;
        }
        else{
            color = Color.DEEPSKYBLUE;
//            color = Color.HOTPINK;
        }

        ball2 = new Ball2(color, 50, 8);
        ball2.make_ball(150,500);
        ball2.set();



        BackgroundFill background_fill = new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        canvas.setBackground(background);

        Obstacle circle_obstacle = new circle("Circle", 2, 1, false);
        circle_obstacle.make_obstacles3(canvas, 0);

        Obstacle square = new Square("Square", 2, 1, false);
        square.make_obstacles3(canvas, -350);

        Obstacle line = new Line("Line", 2, 1, false);
        line.make_obstacles3(canvas,-700);

//        Obstacle triangle = new Triangle("Triangle", 1.75, 1, false);
//        triangle.make_obstacle(canvas, -1050);

        obstacles.add(circle_obstacle);
        obstacles.add(square);
        obstacles.add(line);
//        obstacles.add(triangle);

        for (int i = 0; i <3 ; i++) {
            Rewards star = new Rewards(2);
            star.makeStar(canvas, obstacles.get(i).y_cord);
            rewards.add(star);
            SwitchColor switchColor = new SwitchColor(2);
            switchColor.makeSwitch(canvas,-i*350+50);
            switchColors.add(switchColor);
        }

        canvas.setOnMouseClicked(e -> {
            if (!moved) {
                ball2.move_up(canvas, obstacles, rewards, switchColors, primaryStage, this);
                moved = true;
            }
            for (int i = 0; i <obstacles.size() ; i++) {
                obstacles.get(i).make_rotate();
            }
        });
        canvas.getChildren().add(ball2.getBall());

        button.setOnAction(e -> {



            double latest_ball_cord= ball2.ball.getCenterY();
            System.out.println(latest_ball_cord);


            score2 = Integer.parseInt(text.getText());
            if (score2>highScore2){
                highScore2 = score2;
            }



            if (ball2.animationTimer!=null) {
                ball2.animationTimer.stop();
            }
            pause2(primaryStage, latest_ball_cord);


        });

        game2 = new Scene(canvas, 300, 600);
    }

    public void exit_game(){
        Platform.exit();
        System.exit(0);
    }
}