package com.samples.edittext;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditorActivity extends Activity 
        implements OnClickListener {
    
    private float mTextSize = 20;
    private EditText mEdit;
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mEdit =(EditText)findViewById(R.id.edit_text);
        
        final Button buttonR = (Button)findViewById(R.id.button_r);
        final Button buttonB = (Button)findViewById(R.id.button_b);
        final Button buttonI = (Button)findViewById(R.id.button_i);
        final Button buttonPlus = (Button)findViewById(R.id.button_plus);
        final Button buttonMinus = (Button)findViewById(R.id.button_minus);
        
        buttonR.setOnClickListener(this);
        buttonB.setOnClickListener(this);       
        buttonI.setOnClickListener(this);     
        buttonPlus.setOnClickListener(this);      
        buttonMinus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.button_r:
            mEdit.setTypeface(null, Typeface.NORMAL);
            break;
        case R.id.button_b:
            mEdit.setTypeface(null, Typeface.BOLD);
            break;
        case R.id.button_i:
            mEdit.setTypeface(null, Typeface.ITALIC);
            break;
        case R.id.button_plus:
            if (mTextSize <= 72)
                mTextSize+=2;
            mEdit.setTextSize(mTextSize);
            break;
        case R.id.button_minus:
            if (mTextSize >= 20)
                mTextSize-=2;
            mEdit.setTextSize(mTextSize);
            break;
        }
    }
}