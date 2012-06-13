package com.samples.multiautocompletetextview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ArrayAdapter;

public class MultiAutoCompleteTextViewActivity extends Activity {
   final String[] mContacts = {
        "Anderson, Jacob", "Duncan, Emily", "Fuller, Michael", 
        "Greenman, Emma", "Harrison, Joshua", "Johnson, Madison",
        "Cotman, Matthew", "Lawson, Olivia", "Chapman, Andrew", 
        "Honeyman, Michael", "Jackson, Isabella", "Patterson, William", 
        "Godwin, Joseph", "Bush, Samantha", "Gateman, Christopher"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line, mContacts);
        MultiAutoCompleteTextView textView = 
            (MultiAutoCompleteTextView)findViewById(
                    R.id.MultiAutoCompleteTextView01);
        textView.setAdapter(adapter);
        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}