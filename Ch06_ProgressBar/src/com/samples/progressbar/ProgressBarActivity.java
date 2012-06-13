package com.samples.progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarActivity extends Activity {  
    
    ProgressBar mProgressBar;
    boolean mIsRunning = false;
    Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mProgressBar = (ProgressBar)findViewById(R.id.progress);
        final Button ButtonStart = (Button)findViewById(R.id.button_start);
        final Button ButtonStop = (Button)findViewById(R.id.button_stop);
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                mProgressBar.incrementProgressBy(1);
            }
        };
        
        ButtonStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onStart();
            }        
        });
        ButtonStop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onStop();
            }        
        });
    }
    
    public void onStart() {
        super.onStart();
        mProgressBar.setProgress(0);
        
        Thread background = new Thread(new Runnable() {
           public void run() {
               while (mIsRunning) {
                   try {
                       Thread.sleep(100);
                   } 
                   catch (InterruptedException e) {
                       Log.e("ERROR", "Thread Interrupted");
                   }
                   mHandler.sendMessage(mHandler.obtainMessage());
               }
            }
        });
        mIsRunning = true;
        background.start();
    }
    
    public void onStop() {
        super.onStop();
        mIsRunning = false;
    }
}