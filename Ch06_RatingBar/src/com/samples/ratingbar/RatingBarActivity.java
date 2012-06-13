package com.samples.ratingbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class RatingBarActivity extends Activity {

    private static final int NUM_STARS = 5;
    
    private float mStep = 0.5f;
    private float mRating = 1.0f;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        
        final RatingBar ratingBar1 = (RatingBar)findViewById(R.id.rating);
        final Button buttonUp = (Button)findViewById(R.id.button_up);
        final Button buttonDown = (Button)findViewById(R.id.button_down);
        final TextView label = (TextView)findViewById(R.id.text_value);
        
        ratingBar1.setNumStars(NUM_STARS);
        ratingBar1.setRating(mRating);
        ratingBar1.setStepSize(0.5f);
        label.setText(String.valueOf(mRating));

        buttonUp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mRating += mStep;
                if (mRating > NUM_STARS) 
                    mRating = NUM_STARS;
                ratingBar1.setRating(mRating);
            }      
        });
        
        buttonDown.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mRating -= mStep;
                if (mRating < 0) 
                    mRating = 0;
                ratingBar1.setRating(mRating);
            }      
        });
        
        ratingBar1.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                    boolean fromUser) {
                label.setText(String.valueOf(ratingBar1.getRating())); 
                mRating = ratingBar1.getRating();
            }
        });
    }
} 

