package com.samples.statusbarnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatusBarNotificationActivity extends Activity 
    implements View.OnClickListener {
    
    private Button callButton;
    private static final int NOTIFY_ID = 0x1001;
    private NotificationManager mNotifyMgr;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mNotifyMgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        
        callButton=(Button)findViewById(R.id.button);
        callButton.setOnClickListener(this);
    }
    
    public void onClick(View view) {
        int icon = R.drawable.android_happy;
        CharSequence tickerText = "Hello!";
        long when = System.currentTimeMillis();
        Context context = getApplicationContext();  
        CharSequence contentTitle = "Notification";
        CharSequence contentText = "Hi, I am Android!";
    
        Intent notificationIntent = new Intent(this, StatusBarNotificationActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
            
        Notification notification = new Notification(icon, tickerText, when);
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
            
        mNotifyMgr.notify(NOTIFY_ID, notification);
    }
}