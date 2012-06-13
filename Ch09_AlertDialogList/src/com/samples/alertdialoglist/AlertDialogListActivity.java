package com.samples.alertdialoglist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogListActivity extends Activity {

    private final int IDD_COLOR = 0;
    final CharSequence[] mColors = {"Red", "Green", "Blue"};
    
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
            
            builder.setItems(mColors, 
                    new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {
                    Toast.makeText(getApplicationContext(), "Color: " +
                            mColors[item], Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            });
            
            builder.setCancelable(false);
            return builder.create();
        default:
            return null;
        }
    }
} 
