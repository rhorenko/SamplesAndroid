package com.samples.tweenanimationlayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class TweenAnimationAcctivity extends Activity {
    private LinearLayout layout;
    private Animation animation;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        layout = (LinearLayout)findViewById(R.id.layout_anim);
    
        animation =  AnimationUtils.loadAnimation(this, R.anim.circle);
        
        layout.startAnimation(animation);
        final Button btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                layout.startAnimation(animation);
            }
        });
    }
}