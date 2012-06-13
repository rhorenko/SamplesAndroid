package com.samples.preferences;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.NumberKeyListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class EditorActivity extends Activity {
    
    static final int IDM_OPEN = 101;
    static final int IDM_SAVE = 102;
    static final int IDM_PREF = 103;
    static final int IDM_EXIT = 104;
    
    private final static String FILENAME = "file.txt";   
    private EditText mEdit;
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        
        mEdit = (EditText)findViewById(R.id.edit);      
    }
    
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = 
            PreferenceManager.getDefaultSharedPreferences(this);
        
        // читаем установленное значение из CheckBox Preference
        if (prefs.getBoolean(getString(R.string.pr_openmode), false)) {
            openFile(FILENAME);
        }
        
        int color = Color.BLACK;
        if (prefs.getBoolean(getString(R.string.pr_color_red), false)) {
            color += Color.RED;
        }
        if (prefs.getBoolean(getString(R.string.pr_color_green), false)) {
            color += Color.GREEN;
        }
        if (prefs.getBoolean(getString(R.string.pr_color_blue), false)) {
            color += Color.BLUE;
        }
        float fSize = Float.parseFloat(
                prefs.getString(getString(R.string.pr_size), "20"));

        String regular = prefs.getString(getString(R.string.pr_style), "");
        int typeface = Typeface.NORMAL;
        
        if (regular.contains("Bold")) {
            typeface += Typeface.BOLD;
        }
        if (regular.contains("Italic")) {
            typeface += Typeface.ITALIC;
        }
        
        mEdit.setTextSize(fSize);
        mEdit.setTextColor(color);
        mEdit.setTypeface(null, typeface);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, IDM_OPEN, Menu.NONE, "Open")
            .setIcon(R.drawable.ic_menu_open)
            .setAlphabeticShortcut('o');
        menu.add(Menu.NONE, IDM_SAVE, Menu.NONE, "Save")
            .setIcon(R.drawable.ic_menu_save)
            .setAlphabeticShortcut('s');
        menu.add(Menu.NONE, IDM_PREF, Menu.NONE, "Settings")
            .setIcon(R.drawable.ic_menu_preferences)
            .setAlphabeticShortcut('t');
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
            case IDM_PREF:
                Intent i = new Intent();
                i.setClass(this, PreferencesActivity.class);
                startActivity(i);
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
    
    class FloatKeyListener extends NumberKeyListener {
        private static final String CHARS="0123456789-.";
        
        protected char[] getAcceptedChars() {
            return(CHARS.toCharArray()); 
        }
    }
}