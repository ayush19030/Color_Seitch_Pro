package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;  // the code is too good to  run

import java.io.Serializable;

public class Main extends Application implements Serializable {
    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Color Switch");
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        Gameplay gameplay = new Gameplay();
        gameplay.main_menu(primaryStage);
        //gameplay.load_previous_game(primaryStage);

        //gameplay.start_new_game(primaryStage);
        //gameplay.endGame(primaryStage);

        primaryStage.setScene(gameplay.mainMenu);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
