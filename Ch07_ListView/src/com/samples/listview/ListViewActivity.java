package com.samples.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends ListActivity {
    
    private TextView mTextView;
    
    String[] mContacts = {
        "Jacob Anderson", "Emily Duncan", "Michael Fuller", 
        "Emma Greenman", "Joshua Harrison", "Madison Johnson",
        "Matthew Cotman", "Olivia Lawson", "Andrew Chapman", 
        "Daniel Honeyman", "Isabella Jackson", "William Patterson", 
        "Joseph Godwin", "Samantha Bush", "Christopher Gateman"}; 
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mContacts));
        mTextView = (TextView)findViewById(R.id.textSelect);
    }
    
    public void onListItemClick(
            ListView parent, View v, int position, long id) {
        mTextView.setText("Select: " + mContacts[position] + " " + position + " " + id);
    }
}