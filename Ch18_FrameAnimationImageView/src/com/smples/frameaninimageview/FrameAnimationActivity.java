package com.smples.frameaninimageview;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimationActivity extends Activity {
	private final static int DURATION = 300;
    private AnimationDrawable mAnimation = null;
    private ImageView mImage;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {      
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mImage = (ImageView)findViewById(R.id.image);
        
        final Button btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                start();
            }
        });
            
        final Button btnStop = (Button) findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stop();
            }
        });     
    }
    
    private void start()
    {
         BitmapDrawable frame1 = 
           (BitmapDrawable)getResources().getDrawable(R.drawable.android1); 
         BitmapDrawable frame2 = 
           (BitmapDrawable)getResources().getDrawable(R.drawable.android2); 
         BitmapDrawable frame3 = 
           (BitmapDrawable)getResources().getDrawable(R.drawable.android3); 
         
         mAnimation = new AnimationDrawable();
         mAnimation.setOneShot(false);
         mAnimation.addFrame(frame1, DURATION);
         mAnimation.addFrame(frame2, DURATION);
         mAnimation.addFrame(frame3, DURATION);
         
         mImage.setBackgroundDrawable(mAnimation);
         
         mAnimation.setVisible(true,true);
         mAnimation.start();
    }
    private void stop()
    {
        mAnimation.stop();
        mAnimation.setVisible(false,false);
    }
}