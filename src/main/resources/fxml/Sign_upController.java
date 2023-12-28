/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml;

import com.mycompany.project.DBUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author ascom
 */
public class Sign_upController implements Initializable {


    @FXML
     TextField tf_username;
    @FXML
     TextField tf_password;
    @FXML
     Button button_sign_up;
    @FXML
     Button button_login;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button_sign_up.setOnAction(new EventHandler<ActionEvent>() {

            

            @Override
            public void handle(ActionEvent event) {


            if (!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty()) {

            DBUtils.signUpUser (event, tf_password.getText(),tf_username.getText());

            } else

            System.out.println("Please fill in all information");

            Alert alert = new Alert(Alert. AlertType.ERROR);

            alert.setContentText("Please fill in all information to sign up!");

            alert.show();

            }

            });
        button_login.setOnAction(new EventHandler<ActionEvent>(){
            @Override

            public void handle(ActionEvent event) {

            DBUtils.changeScene(event, "loggedin.fxml","Sign Up!",  null);
            }

        });
    }
    
    
    
    }    
