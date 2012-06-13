package com.samples.tweenanimationview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class TweenAnimationActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        

    	final ImageView image = (ImageView) findViewById(R.id.image);
        final Button btnStart = (Button) findViewById(R.id.btn_start);
       
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Animation anim = AnimationUtils.loadAnimation(
            			getApplicationContext(), R.anim.interpolator);
            	image.startAnimation(anim);
            }
        });
    }
}
