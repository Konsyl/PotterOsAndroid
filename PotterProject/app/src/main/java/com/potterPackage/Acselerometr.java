package com.potterPackage;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Acselerometr extends AppCompatActivity {

    TextView tv;
    PrintWriter toServ;
    Client client;
    SensorManager sensorManager;
    Sensor sensor;
    List<Float> listx=new ArrayList<>();
    List<Float> listy=new ArrayList<>();
    List<Float> listz=new ArrayList<>();
    float vx;
    float vy;
    float vz;
    float Gvx;
    float Gvy;
    float Gvz;
    boolean flag=true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        client = new Client();
        new Thread(new Runnable() {
            @Override
            public void run() {

                client.connect("типа порты потом");
                //   client.SendMessage("xpxpxpx");
            }
        }).start();
        //  Log.e("Вывел", "есть "+client.toServerG.toString());
        //  client.getClass();
        for(int i=0;i<10000000;i++);

        new Thread(new Runnable() {
            @Override
            public void run() {
                client.SendMessage(" первое тестовое сообщение");
            }
        }).start();

        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);

        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
         tv= (TextView) findViewById(R.id.textA);
tv.setText("hello");

        sensorManager.registerListener(listener,sensor, SensorManager.SENSOR_DELAY_NORMAL);



    }

    public Acselerometr(){
        //
    }

    SensorEventListener listener=new SensorEventListener(){


        @Override
        public void onSensorChanged(SensorEvent event) {
            if (flag) {

                float ax = 1.2f*event.values[0];
                float ay = 1.2f*event.values[1];
                float az = 1.2f*event.values[2];
                if(Gvx==0) {

                    Gvx = ax;
                    Gvy = ay;
                    Gvz = az;
                }
                if(Math.abs(Gvx-ax)>1.2){  vx += ax;  Gvx=ax; }

                if(Math.abs(Gvy-ay)>1.2){  vy += ay;  Gvy=ay; }

                if(Math.abs(Gvz-az)>1.2){   vz += az; Gvz=az; }



                listx.add(vx);
                listy.add(vy);
                listz.add(vz);

                tv.setText(String.valueOf(listx.get(listx.size()-1)));
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        client.SendMessage(String.valueOf(listx.get(listx.size()-1))+";"+String.valueOf(listy.get(listy.size()-1)));
                    }
                }).start();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    public class mybtclicklistener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            if(!flag){ flag=true;}

        }
    }
}
