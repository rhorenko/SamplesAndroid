package com.samples.transition;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class TransitionActivity extends Activity 
        implements OnClickListener {
	
    private ImageView image; 
	private TransitionDrawable mTransition;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		image = (ImageView)findViewById(R.id.image);
		image.setOnClickListener(this);
		
		Resources res = this.getResources();	
	    mTransition = (TransitionDrawable)res.getDrawable(R.drawable.transition);
    }
    
	@Override
	public void onClick(View v) {
		image.setImageDrawable(mTransition);	
		mTransition.startTransition(1000);
	}
}