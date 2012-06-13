package com.samples.broadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class PlayService extends Service {
    MediaPlayer mPlayer;
    
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    
    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show(); 
        mPlayer = MediaPlayer.create(this, R.raw.sample);
        mPlayer.setLooping(false);
    }

    @Override
    public void onDestroy() {
        mPlayer.stop();
    }
    
    @Override
    public void onStart(Intent intent, int startid) {
        mPlayer.start();
    }
}
