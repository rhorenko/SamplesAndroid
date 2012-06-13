package com.samples.simplevalues;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class SimpleValuesActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     
        final TextView textStrings = (TextView)findViewById(R.id.text_strings);
        String[] names = getResources().getStringArray(R.array.names);
        for(int i = 0; i < names.length; i++) {
            textStrings.append("Name[" + i + "]: "+ names[i] + "\n");
        } 
        
        final TextView textDigits = (TextView)findViewById(R.id.text_digits);
        int[] digits = getResources().getIntArray(R.array.digits);
        for(int i = 0; i < digits.length; i++) {
            textDigits.append("Digit[" + i + "]: "+ digits[i] + "\n");
        } 
        
        final TextView textStyle = (TextView)findViewById(R.id.text_style);
        
        textStyle.setText(
                getResources().getText(R.string.some_text));
        textStyle.setTextColor(
                getResources().getColor(R.color.textColor));
        textStyle.setTextSize(
                getResources().getDimension(R.dimen.textPointSize));
        textStyle.setBackgroundColor(
                getResources().getColor(R.color.backgroundColor));
        

        Window w = this.getWindow();
        w.setBackgroundDrawable((ColorDrawable)getResources().getDrawable(
                R.drawable.grayDrawable));

    }
}