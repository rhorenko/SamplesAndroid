package com.samples.toastnotification;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends Activity implements View.OnClickListener {
    
    private Button mButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
        mButton = (Button)findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }
    
    public void onClick(View view) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, 
            "This is Toast Notification", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}