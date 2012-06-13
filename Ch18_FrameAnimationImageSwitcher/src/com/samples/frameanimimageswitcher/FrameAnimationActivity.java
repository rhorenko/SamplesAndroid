package com.samples.frameanimimageswitcher;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import android.widget.Gallery.LayoutParams;

public class FrameAnimationActivity extends Activity {
    private boolean mIsRunning;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final ImageSwitcher switcher = 
            (ImageSwitcher)findViewById(R.id.switcher);
        switcher.setVisibility(View.VISIBLE);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                ImageView image = new ImageView(
                        FrameAnimationActivity.this);
                image.setBackgroundColor(0xFF000000);
                image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                image.setLayoutParams(new ImageSwitcher.LayoutParams(
                    LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
                return image;
            }
        });
        
        // обработчик кнопки запуска анимации
        final Button btnStart = (Button)findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStart();
            }
        });
        
        // обработчик кнопки остановки анимации
        final Button btnStop = (Button)findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStop();
            }
        });

    }

    public void onStart() {
        super.onStart();
        final ImageSwitcher switcher = 
            (ImageSwitcher)findViewById(R.id.switcher);

        Thread thread = new Thread() {
            final int interval = 300;
            final int imgId[] = { 
                    R.drawable.android1,
                    R.drawable.android2, 
                    R.drawable.android3 };
            @Override
            public void run() {
                while (mIsRunning) {
                    for (int cur = 0; cur < imgId.length; cur++) {
                        synchronized (this) {
                            final int curIdx = cur;
                            mHandler.post(new Runnable() {
                                public void run() {
                                    switcher.setImageResource(
                                            imgId[curIdx]);
                                }
                            });
                            try {
                                wait(interval);
                            } 
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }        
            }
        };
        mIsRunning = true;
        thread.start();
    }
    
    public void onStop() {
        super.onStop();
        mIsRunning = false;
    }
}