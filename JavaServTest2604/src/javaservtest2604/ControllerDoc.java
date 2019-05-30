/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaservtest2604;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

/**
 *
 * @author 61515
 */
public class ControllerDoc implements Initializable {

        @FXML
        TextField mText;
        @FXML
        Canvas mCanvas;
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image =new Image("file:///D://JAVAPROJECT//JavaServTest2604//src//MyRes//1.jpg");
     
      
        mCanvas.getGraphicsContext2D().drawImage(image, 0,0,mCanvas.getWidth(),mCanvas.getHeight());
        
   
    }
   
}
