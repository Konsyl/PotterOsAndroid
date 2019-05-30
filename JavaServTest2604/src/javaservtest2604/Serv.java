/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaservtest2604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;


/**
 *
 * @author 61515
 */
public class Serv extends Thread {
    
    List<Socket> playerList;
    boolean endGame=false;
    PrintWriter[] bfList=new PrintWriter[2];
    BufferedReader[] bfRList=new BufferedReader[2];
    boolean flag=false;
    int serverPort = 5000;
    ServerSocket serverSocket ;
    ControllerDoc control;
  
 

    @Override
  public void run(){
      
         
      
     
      
      
      
        try {
            serverSocket=new ServerSocket(serverPort);
        } catch (IOException ex) {
            Logger.getLogger(Serv.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("Всё плохо");
        };

      playerList=new ArrayList<Socket>();
    
      while(true){
        
         if(!flag){
            try {
                
                   System.out.print("Начал Ловить ");
                Socket server = serverSocket.accept();
             
                     playerList.add(server);
                     
                     
                     if(playerList.size()==1){
                      bfRList[0] = new BufferedReader(new InputStreamReader(server.getInputStream()));
                      String line =   bfRList[0].readLine();
                      System.out.print(line);
                      bfList[0] = new PrintWriter(server.getOutputStream(), true);
                      bfList[0].println("Thank you for connecting to " + server.getLocalSocketAddress() + " Goodbye!");
                        System.out.print(" поймал1 ");
                      
                        
                        flag=true;//потом убрать
                     }
                     if(playerList.size()==2){
                         
                     bfRList[1] = new BufferedReader(new InputStreamReader(server.getInputStream()));
                  //   String line =   bfRList[1].readLine();
                     bfList[1] = new PrintWriter(server.getOutputStream(), true);
                      bfList[1].println("Thank you for connecting to " + server.getLocalSocketAddress() + " Goodbye!");
                         System.out.print("поймал2 ");
                      flag=true;
                     }               
            } catch (IOException ex) {
                
                System.out.print("не работаю ");
            }
         }
         else{ //Игра
     //    System.out.print("|");
         try{
            //  System.out.print("слушаю|");
       //  if(bfRList[0].ready()){
   String  INSTR=bfRList[0].readLine();
     String[] str=INSTR.split(";");
     // System.out.println(INSTR);
     
    String strX=str[0];
    String strY=str[1];
  
      System.out.println(strX+" "+strY);
    double Dx=new Double(strX);
    double Dy=new Double(strY);  
    int x=(int)Dx;
    int y=(int)Dy;
       
        Platform.runLater(()->control.mCanvas.getGraphicsContext2D().fillOval(x,y , 2, 2));
        
         //bfRList[1]
         
     
     
         //}
         }
         catch(Exception e){  System.out.println("Error");}
       /* while(endGame)    
        {
             
        } */

         }
            
          
        }
    }
    
}
