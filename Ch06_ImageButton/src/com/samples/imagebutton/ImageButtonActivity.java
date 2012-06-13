package com.samples.imagebutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ImageButtonActivity extends Activity {
    
    ImageButton button;
    boolean mPlay = true;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        button = (ImageButton)findViewById(R.id.ImageButton01);
        button.setImageResource(R.drawable.play);
        
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mPlay)
                    button.setImageResource(R.drawable.pause);
                else
                    button.setImageResource(R.drawable.play);       
                mPlay = !mPlay;
            }
        });
    }
}