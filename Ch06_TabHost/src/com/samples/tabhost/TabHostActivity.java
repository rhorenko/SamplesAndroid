package com.samples.tabhost;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class TabHostActivity extends Activity {
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);

        TabHost tabs=(TabHost)findViewById(R.id.tabhost);       
        tabs.setup();
    
        TabHost.TabSpec spec=tabs.newTabSpec("tag1");
        
        spec.setContent(R.id.tabPage1);
        spec.setIndicator("Document 1");
        tabs.addTab(spec);
        
        spec=tabs.newTabSpec("tag2");
        spec.setContent(R.id.tabPage2);
        spec.setIndicator("Document 2");
        tabs.addTab(spec);
        
        tabs.setCurrentTab(0);
    }
}