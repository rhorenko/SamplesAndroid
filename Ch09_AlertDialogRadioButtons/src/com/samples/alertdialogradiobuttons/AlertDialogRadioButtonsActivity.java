package com.samples.alertdialogradiobuttons;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogRadioButtonsActivity extends Activity {
    
    private final static int IDD_COLOR = 0;
    private final CharSequence[] mColors = {"Red", "Green", "Blue"};
    private int mResult;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button callButton = (Button)findViewById(R.id.button);
        
        // добавляем слушатель события для кнопки вызова диалога
        callButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(IDD_COLOR);  
            }  
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case IDD_COLOR:
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Pick a color");
            builder.setSingleChoiceItems(mColors, 0, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    //Toast.makeText(getApplicationContext(), "Color: " + mColors[item], Toast.LENGTH_SHORT).show();
                    mResult = item;
                }
            });
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Toast.makeText(getApplicationContext(), "Color: " + mColors[mResult], Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                    Toast.makeText(getApplicationContext(), "Dialog cancel", Toast.LENGTH_SHORT).show();
                    }
            });
            
            builder.setCancelable(false);
            return builder.create();
        default:
        return null;
        }
    }
}