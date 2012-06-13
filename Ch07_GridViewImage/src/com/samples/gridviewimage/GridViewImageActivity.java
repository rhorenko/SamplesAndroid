package com.samples.gridviewimage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class GridViewImageActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private TextView mSelectText;
    private ImageAdapter mAdapter;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mSelectText=(TextView)findViewById(R.id.label);
        
        final GridView grid = (GridView)findViewById(R.id.grid);
        mAdapter = new ImageAdapter(getApplicationContext());
        grid.setAdapter(mAdapter);
        grid.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(
            AdapterView<?> parent, View v, int position, long id) {
        mSelectText.setText("Selected items ID: " + mAdapter.getItemId(position));
    }
    
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        mSelectText.setText("Selected items: none");
    }
}