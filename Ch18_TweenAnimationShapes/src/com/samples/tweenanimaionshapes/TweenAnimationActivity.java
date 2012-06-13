package com.samples.tweenanimaionshapes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class TweenAnimationActivity extends Activity implements AnimationListener{

    private ImageView mImage;
    Animation animation = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);   
        
        mImage = (ImageView)findViewById(R.id.image);
        mImage.setImageResource(R.drawable.shape);
    }
       
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, R.anim.alpha, Menu.NONE, "Alpha")
            .setAlphabeticShortcut('a');
        menu.add(Menu.NONE, R.anim.scale, Menu.NONE, "Scale")
            .setAlphabeticShortcut('s');
        menu.add(Menu.NONE, R.anim.translate, Menu.NONE, "Translate")
            .setAlphabeticShortcut('t');
        menu.add(Menu.NONE, R.anim.rotate, Menu.NONE, "Rotate")
            .setAlphabeticShortcut('r');
        menu.add(Menu.NONE, R.anim.total, Menu.NONE, "Total")
            .setAlphabeticShortcut('o');

        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {             
        animation = AnimationUtils.loadAnimation(
        		this, item.getItemId());
        animation.setAnimationListener(this);
        
        mImage.startAnimation(animation); 
        return true;
    }

	@Override
	public void onAnimationEnd(Animation animation) {
		mImage.setVisibility(View.INVISIBLE);
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		mImage.setVisibility(View.VISIBLE);
	}

	@Override
	public void onAnimationStart(Animation animation) {
		mImage.setVisibility(View.VISIBLE);
	}
}