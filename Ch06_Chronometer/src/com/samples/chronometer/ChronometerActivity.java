package com.samples.chronometer;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;

public class ChronometerActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button buttonStart = (Button)findViewById(R.id.button_start);
        final Button buttonStop = (Button)findViewById(R.id.button_stop);
        final Button buttonReset = (Button)findViewById(R.id.button_reset);        
        final Chronometer mChronometer = (Chronometer)findViewById(R.id.chronometer);
        
        buttonStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometer.start();       
            }     
        });
        
        buttonStop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometer.stop();       
            }     
        });   
       
        buttonReset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometer.setBase(SystemClock.elapsedRealtime());     
            }     
        });
    }
}