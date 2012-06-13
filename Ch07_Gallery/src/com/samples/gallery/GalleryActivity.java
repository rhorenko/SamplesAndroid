package com.samples.gallery;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class GalleryActivity extends Activity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        final Gallery g = (Gallery) findViewById(R.id.Gallery01);
        g.setAdapter(new ImageAdapter(this));
        
        final TextView label = (TextView)findViewById(R.id.TextView01);
        label.setText("Slide 1 from " + g.getAdapter().getCount());
        
        g.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                label.setText("Slide " + ++pos + " from " + parent.getCount());
            }
        });
    }
}