package com.samples.togglebutton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.TextView;

public class ToggleButtonActivity extends Activity 
    implements CompoundButton.OnCheckedChangeListener {
    
    ToggleButton mButton;
    TextView mLabel;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mButton = (ToggleButton)findViewById(R.id.button);
        mButton.setOnCheckedChangeListener(this);
        
        mLabel = (TextView)findViewById(R.id.text);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) 
            mLabel.setText("Button checked");
        else 
            mLabel.setText("Button unchecked");
    }
}
