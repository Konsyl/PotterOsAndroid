/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaservtest2604;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author 61515
 */
public class JavaServTest2604 extends Application  {

    /**
     * @param args the command line arguments
     */
      
    public  ControllerDoc controller;
    
    public static void main(String[] args) throws Exception {
  
     
       Application.launch(args);
       
  
  
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
       
        Parent root = loader.load();   	
        controller = (ControllerDoc)loader.getController();
        Serv sr=new Serv();
        sr.control=controller;
       sr.start();
        Scene scene = new Scene(root);
         scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
          primaryStage.setScene(scene);
        primaryStage.show();
        
      
    }
    
}
