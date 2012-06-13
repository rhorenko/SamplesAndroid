package com.samples.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DataAdapter extends ArrayAdapter<String>
{
    private static final String[] mContacts = {
               "J. Anderson", "E. Duncan", "M. Fuller", 
               "E. Greenman", "J. Harrison", "M. Johnson",
               "M. Cotman", "O. Lawson", "A. Chapman", 
               "M. Honeyman", "I. Jackson", "W. Patterson", 
               "J. Godwin", "S. Bush", "C. Gateman",
               "J. Anderson", "E. Duncan", "M. Fuller", 
               "E. Greenman", "J. Harrison", "M. Johnson",
               "M. Cotman", "O. Lawson", "A. Chapman", 
               "M. Honeyman", "I. Jackson", "W. Patterson", 
               "J. Godwin", "S. Bush", "C. Gateman" };
    Context mContext;
    DataAdapter(Context context, int resource) {
        super(context, resource, mContacts);
        this.mContext = context;
    }
        
    public View getView(int position, View convertView, ViewGroup parent) {
            TextView label = (TextView)convertView;
            
        if (convertView == null) {
            convertView = new TextView(mContext);
            label = (TextView)convertView;
        }
        label.setText(mContacts[position]);          
        return(convertView);
        }

    public String GetItem(int position) {
        return mContacts[position];
    }
}