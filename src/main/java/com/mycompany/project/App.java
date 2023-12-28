package com.mycompany.project;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Scene;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage.setTitle("hello");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}