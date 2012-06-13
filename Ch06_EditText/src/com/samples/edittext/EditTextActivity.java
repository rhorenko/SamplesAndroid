package com.samples.edittext;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EditTextActivity extends Activity { 
    TextView mText;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}