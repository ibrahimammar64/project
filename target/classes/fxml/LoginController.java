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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author ascom
 */
public class LoginController implements Initializable {


    @FXML
     TextField tf_username;
    @FXML
     TextField tf_password;
    @FXML
     Button button_login;
    @FXML
     Button button_sign_up;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         button_login.setOnAction(new EventHandler<ActionEvent>() {
       
       
        
        @Override
        public void handle(ActionEvent event) {

        DBUtils.loginUser(event,tf_username.getText(),tf_password.getText());
       
        }


        });
        button_sign_up.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {

            DBUtils.changeScene(event, "sign_up.fxml","Sign Up!",  null);

            }

            });
    }
        
    }    
    
