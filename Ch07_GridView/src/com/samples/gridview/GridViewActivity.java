package com.samples.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class GridViewActivity extends Activity implements AdapterView.OnItemSelectedListener 
{
    private TextView mSelectText;
    DataAdapter mAdapter;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mSelectText=(TextView)findViewById(R.id.label);
        
        final GridView grid = (GridView)findViewById(R.id.grid);
        mAdapter = new DataAdapter(getApplicationContext(), android.R.layout.simple_list_item_1);
        grid.setAdapter(mAdapter);
        grid.setOnItemSelectedListener(this);
    }
  
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        mSelectText.setText("Selected items: " + mAdapter.GetItem(position));
    }
    
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        mSelectText.setText("Selected items: none");
    }
}