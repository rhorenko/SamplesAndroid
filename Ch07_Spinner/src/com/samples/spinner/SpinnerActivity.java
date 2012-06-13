package com.samples.spinner;

import com.samples.spinner.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends Activity
    implements AdapterView.OnItemSelectedListener {
    
    TextView mLabel;
    
    final String[] mContacts = {
            "Jacob Anderson", "Emily Duncan", "Michael Fuller", 
            "Emma Greenman", "Joshua Harrison", "Madison Johnson",
            "Matthew Cotman", "Olivia Lawson", "Andrew Chapman", 
            "Michael Honeyman", "Isabella Jackson", "William Patterson", 
            "Joseph Godwin", "Samantha Bush", "Christopher Gateman"};
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        
        mLabel = (TextView)findViewById(R.id.TextView01);
        
        final Spinner spin = (Spinner)findViewById(R.id.Spinner01);
        spin.setOnItemSelectedListener(this);
        
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, mContacts);
        
        arrayAdapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);
    }
    
    public void onItemSelected(
        AdapterView<?> parent, View v, int position, long id) {
        mLabel.setText(mContacts[position]);
    }
    
    public void onNothingSelected(AdapterView<?> parent) {
        mLabel.setText("");
    }
}