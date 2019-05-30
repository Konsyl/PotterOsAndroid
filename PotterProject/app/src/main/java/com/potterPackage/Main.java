package com.potterPackage;

import android.content.Intent;
import android.icu.text.DisplayContext;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class Main extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Acselerometr acs=new Acselerometr();
        startActivity(new Intent(this, acs.getClass() ));
      //  Log.e("Вывел", "есть "+toServ.toString());
    //    toServ.println("it works pleaz");
     //   Log.e("Вывел","Вывел");
    }

public static void stroka(){


}
}
