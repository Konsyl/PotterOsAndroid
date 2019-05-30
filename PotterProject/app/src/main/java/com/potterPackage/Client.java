package com.potterPackage;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class Client {
    BufferedReader  fromServer;
//    PrintWriter toServer1;
public Socket socket;
   public  PrintWriter toServerG;

    protected PrintWriter connect(String strings) {
        int serverPort = 5000;
        try {
            socket = new Socket("192.168.43.73", serverPort);
            socket.setSoTimeout(500000);

            try { toServerG = new PrintWriter(socket.getOutputStream(), true);
                // Отправка данных на сервер
              //  toServerG.println("Hello from TEST");

                // Ответ сервера
               // toServer1=toServer;
             //   toServer1.print("sss");
                BufferedReader fromServer;
                fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = fromServer.readLine();

            return toServerG;
            }catch(UnknownHostException ex){}
        //    if(fromServer!=null)
          //  fromServer.close();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            try {
                if (e instanceof SocketTimeoutException) {
                    throw new SocketTimeoutException();
                } else {
                    e.printStackTrace();
                }
            } catch (SocketTimeoutException ste) {
                System.out.println("Turn off the client by timeout");
            }
        }
return null;
       // return toServer1;
    }

    public void SendMessage(String message){


    //if(toServerG!=null){
        try {
            toServerG = new PrintWriter(socket.getOutputStream(), true);
            toServerG.println(message);
        }catch(IOException E){}
            // }




    }

}
