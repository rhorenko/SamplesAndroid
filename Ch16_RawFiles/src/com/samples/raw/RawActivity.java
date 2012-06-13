package com.samples.raw;

import java.io.DataInputStream;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class RawActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final TextView text = (TextView)findViewById(R.id.text);
        
        InputStream iFile = getResources().openRawResource(R.raw.file);
        try {
            StringBuffer sBuffer = new StringBuffer();
            DataInputStream dataIO = new DataInputStream(iFile);
            String strLine = null;
            
            while((strLine=dataIO.readLine()) != null){
                    sBuffer.append(strLine+"\n");
            }

            dataIO.close();
            iFile.close();

            text.setText(sBuffer.toString());         
        } 
        catch (Exception e) {
            text.setText("Error loading file: " + e.getMessage());
        }   
    }
}