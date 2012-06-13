package com.samples.radiobutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.TextView;

public class RadioButtonDemo extends Activity {
    
    private TextView mLabel;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final RadioButton radio1 = (RadioButton)findViewById(R.id.radio1);
        final RadioButton radio2 = (RadioButton)findViewById(R.id.radio2);
        final RadioButton radio3 = (RadioButton)findViewById(R.id.radio3);
        
        mLabel = (TextView)findViewById(R.id.text);
        
        radio1.setOnClickListener(radioButtonClick);
        radio2.setOnClickListener(radioButtonClick);
        radio3.setOnClickListener(radioButtonClick);
    }
    
    OnClickListener radioButtonClick = new OnClickListener() {
        public void onClick(View v) {
            // Perform action on clicks
            RadioButton rb = (RadioButton)v;
            mLabel.setText("Select: " + rb.getText());
        }
    };
}