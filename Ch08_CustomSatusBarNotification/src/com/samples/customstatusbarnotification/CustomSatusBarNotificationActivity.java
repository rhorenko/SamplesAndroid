package com.samples.customstatusbarnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class CustomSatusBarNotificationActivity extends Activity 
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
        CharSequence text = "Hi, I am Android! This is custom Notification.";    
        
        Intent notificationIntent = new Intent(this, CustomSatusBarNotificationActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
                
        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.custom_layout);
        contentView.setImageViewResource(R.id.image, R.drawable.android3d);
        contentView.setTextViewText(R.id.text, text);
                
        Notification notification = new Notification(icon, tickerText, when);
        notification.contentIntent = contentIntent;
        notification.contentView = contentView;
                
        mNotifyMgr.notify(NOTIFY_ID, notification);
    }
}