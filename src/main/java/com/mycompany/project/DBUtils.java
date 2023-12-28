/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import fxml.LoggedinController;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





/**
 *
 * @author ascom
 */
public class DBUtils {
    public static void changeScene(ActionEvent event,String fxmlFile,String title,String username){
        
        Parent root = null;
        if(username!=null){
        try{
            FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
            root = loader.load();
            LoggedinController loggedinController =loader.getController();
            loggedinController.setUserIfo(username);
            
        }catch(IOException e){
            e.printStackTrace();
            
        } 
        }else{
            try{
              root =  FXMLLoader.load(DBUtils.class.getResource(fxmlFile));

            }catch(IOException e){
             e.printStackTrace();
            }
        }
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
       stage.setTitle(title);
       stage.setScene(new Scene(root,600,400));
       stage.show();
    }
        public static void signUpUser(ActionEvent event,String password,String username){
            Connection connection = null;
            PreparedStatement psInsert = null;
            PreparedStatement psCheckUserExists = null;
            ResultSet resultSet = null;
            try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-project","root","1234");
                psCheckUserExists = connection.prepareStatement("select * FROM users WHERE username = ?");
                psCheckUserExists.setString(1,username);
                resultSet = psCheckUserExists.executeQuery();
                if(resultSet.isBeforeFirst()){
                    System.out.print("User Already Exist!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("You Cannot Use This UserName");
                        alert.show();
                }else{
                    psInsert = connection.prepareStatement("INSERT INTO users (username,password VALUES(?,?)");
                    psInsert.setString(1, username);
                    psInsert.setString(2, password);
                    psInsert.executeUpdate();
                    changeScene(event,"loggedin.fxml","welcome!",username);
                    
                }
            }catch(SQLException e){
                e.printStackTrace();
            }finally{
                if(resultSet!=null){
                    try{
                        resultSet.close();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }
                 if(psCheckUserExists!=null){
                    try{
                        psCheckUserExists.close();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }
                 if(psInsert!=null){
                    try{
                        psInsert.close();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }
                 if(connection!=null){
                    try{
                        connection.close();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }   
            }
        }
public static void loginUser (ActionEvent event, String username, String password) {

                Connection connection = null;

                PreparedStatement preparedStatement = null;

                ResultSet resultSet = null;

                try {

                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-project","root","1234");

                preparedStatement= connection.prepareStatement("SELECT password FROM users WHERE username = ?");

                preparedStatement.setString(  1, username);

                resultSet= preparedStatement.executeQuery();

                if (!resultSet.isBeforeFirst()) {

                System.out.println("User not found in the database!");

                Alert alert = new Alert (Alert.AlertType.ERROR);

                alert.setContentText("Provided credentials are incorrect!");

                alert.show();

                }else{

                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if(retrievedPassword.equals(password)){
                        changeScene(event,"/fxml/loggedin.fxml","welcome!",username);
                    }else{
                        System.out.print("password did not match!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("the provided credentials are incorrect");
                        alert.show();
                    }
                }

                }

                } catch (SQLException e) {

                e.printStackTrace();
                }finally{
                    if(connection!=null){
                    try{
                        connection.close();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }
                    if(preparedStatement!=null){
                    try{
                        preparedStatement.close();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }  
                    if(resultSet!=null){
                    try{
                        resultSet.close();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }  
                    
                }
        }
}
