//package sample;
//
//public class ss {
//}
//
//package javafxsnapshot;
//
//        import java.io.File;
//        import java.io.IOException;
//        import java.util.logging.Level;
//        import java.util.logging.Logger;
//        import javafx.application.Application;
//        import javafx.embed.swing.SwingFXUtils;
//        import javafx.event.ActionEvent;
//        import javafx.event.EventHandler;
//        import javafx.scene.Scene;
//        import javafx.scene.control.Button;
//        import javafx.scene.image.WritableImage;
//        import javafx.scene.layout.StackPane;
//        import javafx.stage.Stage;
//        import javax.imageio.ImageIO;
//
///**
// *
// * @web http://java-buddy.blogspot.com
// */
//public class JavaFXSnapshot extends Application {
//
//    @Override
//    public void start(Stage primaryStage) {
//
//        StackPane root = new StackPane();
//        Scene scene = new Scene(root, 300, 250);
//
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//                takeSnapShot(scene);
//
//            }
//        });
//
//        root.getChildren().add(btn);
//
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    private void takeSnapShot(Scene scene){
//        WritableImage writableImage =
//                new WritableImage((int)scene.getWidth(), (int)scene.getHeight());
//        scene.snapshot(writableImage);
//
//        File file = new File("snapshot.png");
//        try {
//            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
//            System.out.println("snapshot saved: " + file.getAbsolutePath());
//        } catch (IOException ex) {
//            Logger.getLogger(JavaFXSnapshot.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//}
