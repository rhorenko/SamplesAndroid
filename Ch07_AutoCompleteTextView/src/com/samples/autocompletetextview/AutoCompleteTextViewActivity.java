package com.samples.autocompletetextview;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteTextViewActivity extends Activity
    implements TextWatcher {
    TextView mText;
    AutoCompleteTextView mAutoComplete;
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
        
        mText = (TextView)findViewById(R.id.text);
        mAutoComplete=(AutoCompleteTextView)findViewById(
            R.id.auto_complete);
        mAutoComplete.addTextChangedListener(this);
        
        mAutoComplete.setAdapter(new ArrayAdapter<String>(this, 
            android.R.layout.simple_dropdown_item_1line, mContacts));
    }
    
    public void onTextChanged(
        CharSequence s, int start, int before, int count) {
        mText.setText(mAutoComplete.getText());
    }
    
    public void beforeTextChanged(
        CharSequence s, int start, int count, int after) {
    }
    
    public void afterTextChanged(Editable s) {

    }
}