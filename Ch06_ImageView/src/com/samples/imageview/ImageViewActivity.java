package com.samples.imageview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final ImageView image = (ImageView)findViewById(R.id.image2);
        image.setImageResource(R.drawable.androidmarker);
    }
}