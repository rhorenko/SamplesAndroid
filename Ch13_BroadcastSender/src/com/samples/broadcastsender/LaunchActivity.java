package com.samples.broadcastsender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaunchActivity extends Activity {
    
    private static String ACTION = "com.samples.media.PLAYER";
    private static final String TYPE = "type";
    private static final int ID_ACTION_PLAY = 0;
    private static final int ID_ACTION_STOP = 1;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button btnStart = (Button) findViewById(R.id.btn_start);
        final Button btnStop = (Button) findViewById(R.id.btn_stop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startService(new Intent(LaunchActivity.this, PlayService.class));
                Intent intent = new Intent(ACTION);
                intent.putExtra(TYPE, ID_ACTION_PLAY);
                sendBroadcast(intent);
            }
        });
      
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stopService(new Intent(LaunchActivity.this, PlayService.class));
                Intent intent = new Intent(ACTION);
                intent.putExtra(TYPE, ID_ACTION_STOP);
                sendBroadcast(intent);
            }
        });
     }
}