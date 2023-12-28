package fxml;

import com.mycompany.project.DBUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 
FXML Controller class*
@author ascom
*/
public class LoggedinController implements Initializable {

    @FXML
     Button button_logout;
    @FXML
     Label label_welcom;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           button_logout.setOnAction( new EventHandler<ActionEvent> (){

            @Override
            public void handle(ActionEvent event) {

                DBUtils.changeScene(event, "login.fxml", "log in!", null);
            }
        });
    }
    public void setUserIfo(String username){
        label_welcom.setText("hi "+username+"!");
    }

}
