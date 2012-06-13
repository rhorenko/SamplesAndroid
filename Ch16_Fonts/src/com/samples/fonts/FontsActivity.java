package com.samples.fonts;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class FontsActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        
        final TextView text1 = (TextView)findViewById(R.id.text1);
        text1.setTypeface(Typeface.createFromAsset(
        		getAssets(), "fonts/libertine_it.ttf"));
        
        final TextView text2 = (TextView)findViewById(R.id.text2);
        text2.setTypeface(Typeface.createFromAsset(
        		getAssets(), "fonts/abaddon.ttf"));
        
        final TextView text3 = (TextView)findViewById(R.id.text3);
        text3.setTypeface(Typeface.createFromAsset(
        		getAssets(), "fonts/apapa.ttf"));
        
        final TextView text4 = (TextView)findViewById(R.id.text4);
        text4.setTypeface(Typeface.createFromAsset(
        		getAssets(), "fonts/ayummyapology.ttf"));
        
	}
}
