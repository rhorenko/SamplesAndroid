package com.samples.resxml;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class ResXmlActivity extends ListActivity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        ArrayList<String> list = new ArrayList<String>();
          
        try {
            XmlPullParser parser = getResources().getXml(R.xml.contacts);

            while (parser.getEventType()!= XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG
                        && parser.getName().equals("contact")) {
                    list.add(parser.getAttributeValue(0) + " "
                            + parser.getAttributeValue(1) + "\n"
                            + parser.getAttributeValue(2));
                }
                parser.next();
            }
        }
        catch (Throwable t) {
            Toast.makeText(this, 
                    "Error loading XML document: " + t.toString(), 4000)
                .show();
        }
        
        setListAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, list));
    }
}