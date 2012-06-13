package com.samples.filesrw;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class EditorActivity extends Activity {
    
    public static final int IDM_OPEN = 101;
    public static final int IDM_SAVE = 102;
    public static final int IDM_EXIT = 103;
    
    private final static String FILENAME = "file.txt";   
    private EditText mEdit;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        
        mEdit = (EditText)findViewById(R.id.edit);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, IDM_OPEN, Menu.NONE, "Open")
            .setIcon(R.drawable.ic_menu_open)
            .setAlphabeticShortcut('o');
        menu.add(Menu.NONE, IDM_SAVE, Menu.NONE, "Save")
            .setIcon(R.drawable.ic_menu_save)
            .setAlphabeticShortcut('s');
        menu.add(Menu.NONE, IDM_EXIT, Menu.NONE, "Exit")
            .setIcon(R.drawable.ic_menu_exit)
            .setAlphabeticShortcut('x');

        return(super.onCreateOptionsMenu(menu));
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case IDM_OPEN:
                openFile(FILENAME);
                break;
            case IDM_SAVE:
                saveFile(FILENAME);
                break;
            case IDM_EXIT:
                finish();
                break;
            default:
                return false;
        }
        return true;
    }
    
    private void openFile(String fileName) {
        try {
            InputStream inStream = openFileInput(FILENAME);
            
            if (inStream != null) {
                InputStreamReader tmp = 
                    new InputStreamReader(inStream);
                BufferedReader reader = new BufferedReader(tmp);
                String str;
                StringBuffer buffer = new StringBuffer();
                    
                while ((str = reader.readLine()) != null) {
                    buffer.append(str + "\n");
                }
                    
                inStream.close();
                mEdit.setText(buffer.toString());
            }
        }
        catch (Throwable t) {
            Toast.makeText(getApplicationContext(), 
                  "Exception: " + t.toString(), Toast.LENGTH_LONG)
                .show();
        }     
    }
    
    private void saveFile(String FileName) {
        try {
            OutputStreamWriter outStream = 
               new OutputStreamWriter(openFileOutput(FILENAME, 0));
            
            outStream.write(mEdit.getText().toString());
            outStream.close();      
        }
        catch (Throwable t) {
            Toast.makeText(getApplicationContext(), 
                  "Exception: " + t.toString(), Toast.LENGTH_LONG)
                .show();
        }
    }
}