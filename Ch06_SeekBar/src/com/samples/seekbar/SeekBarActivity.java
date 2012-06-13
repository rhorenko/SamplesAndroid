package com.samples.seekbar;

import android.app.Activity;
import android.os.Bundle;
//import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarActivity extends Activity 
	implements SeekBar.OnSeekBarChangeListener {
    
	TextView mTextValue;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final SeekBar seekBar = (SeekBar)findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(this);
        
        mTextValue = (TextView)findViewById(R.id.text_value);
        mTextValue.setText("0");
    }

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		mTextValue.setText(String.valueOf(seekBar.getProgress())); 
	}
}