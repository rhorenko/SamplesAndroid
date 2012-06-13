package com.samples.contactlauncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactLauncherActivity extends Activity {
    
    private final static String ACTION_VIEW_CONTACTS = "com.samples.contact.VIEW_CONTACTS";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button btnLaunch = (Button)findViewById(R.id.btn_launch);
        btnLaunch.setOnClickListener(new View.OnClickListener() {       
            @Override
            public void onClick(View v) {
               startActivity(new Intent(ACTION_VIEW_CONTACTS));            
            }
        });
    }
}