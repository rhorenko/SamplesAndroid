package com.samples.checkbox;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
 
public class CheckBoxActivity extends Activity 
    implements CompoundButton.OnCheckedChangeListener {
    
    CheckBox cb;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        
        cb=(CheckBox)findViewById(R.id.CheckBox01);
        cb.setOnCheckedChangeListener(this);
    }
    
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) 
    {
        if (isChecked) 
            cb.setText("CheckBox ON");
        else 
            cb.setText("CheckBox OFF");
    }
}