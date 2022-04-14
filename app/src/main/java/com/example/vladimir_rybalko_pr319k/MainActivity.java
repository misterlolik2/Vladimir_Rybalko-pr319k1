package com.example.vladimir_rybalko_pr319k;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity  {
    private int seconds;
    private int seconds1;
    private int seconds2;
    private int seconds3;
    private boolean running;
    private boolean running1;
    private boolean running2;
    private boolean running3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
        runTimer1();
        runTimer2();
        runTimer3();
    }


    public void OnClickReset(View view) {
        running = false;
        seconds = 0;
        running1 = false;
        seconds1 = 0;
        running2 = false;
        seconds2 = 0;
        running3 = false;
        seconds3 = 0;
    }

      private void runTimer() {
        final TextView TextView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
             int hours =seconds/3600;
             int minutes = (seconds%3600)/60;
             int secon = seconds%60;

             String time = String.format("%d:%02d:%02d", hours, minutes, secon);
             TextView.setText(time);
             if(running){
                 seconds++;
             }
             handler.postDelayed(this,1000);
            }
        });
        }

    private void runTimer1() {
        final TextView TextView = (TextView)findViewById(R.id.time_view2);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours =seconds1/3600;
                int minutes = (seconds1%3600)/60;
                int secon = seconds1%60;

                String time = String.format("%d:%02d:%02d", hours, minutes, secon);
                TextView.setText(time);
                if(running1){
                    seconds1++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
    private void runTimer2() {
        final TextView TextView = (TextView)findViewById(R.id.time_view3);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours =seconds2/3600;
                int minutes = (seconds2%3600)/60;
                int secon = seconds2%60;

                String time = String.format("%d:%02d:%02d", hours, minutes, secon);
                TextView.setText(time);
                if(running2){
                    seconds2++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
    private void runTimer3() {
        final TextView TextView = (TextView)findViewById(R.id.time_view4);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours =seconds3/3600;
                int minutes = (seconds3%3600)/60;
                int secon = seconds3%60;

                String time = String.format("%d:%02d:%02d", hours, minutes, secon);
                TextView.setText(time);
                if(running3){
                    seconds3++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }

    public void OnClickStart(View view) {
        running = true;
    }
    public void OnClickStart1(View view) {
        running1 = true;
    }
    public void OnClickStart2(View view) {
        running2 = true;
    }
    public void OnClickStart3(View view) {
        running3 = true;
    }

    public void OnClickStop(View view) {
        running = false;
        running1 = false;
        running2 = false;
        running3 = false;
    }
/*
    @Override
    public void onClick(View view) {
        switch ()

    }

 */
}