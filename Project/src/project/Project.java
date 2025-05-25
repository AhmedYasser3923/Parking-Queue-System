package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Project extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
         Image logo = new Image(getClass().getResourceAsStream("pngwing.com.png"));
         Scene scene = new Scene(root , 1000,777);
        String css = this.getClass().getResource("main.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.setTitle("Car Parking");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
