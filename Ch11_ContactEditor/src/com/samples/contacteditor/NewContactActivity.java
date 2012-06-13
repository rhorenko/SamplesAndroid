package com.samples.contacteditor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewContactActivity extends Activity {

    private EditText mName; 
    private EditText mPhone;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_item);
        
        mName = (EditText)findViewById(R.id.edit_name);
        mPhone = (EditText)findViewById(R.id.edit_phone);
        
        final Button btnOK = (Button)findViewById(R.id.button_save);
        final Button btnCancel = (Button)findViewById(R.id.button_cancel);
        btnOK.setText(R.string.btn_create);

        btnOK.setOnClickListener(new View.OnClickListener() {         
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(ContactItem.NAME, mName.getText().toString()); 
                intent.putExtra(ContactItem.PHONE, mPhone.getText().toString());

                setResult(RESULT_OK, intent);
                finish();
            }
        });
        
        btnCancel.setOnClickListener(new View.OnClickListener() {         
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED); 
                finish();
            }
        });
    }   
}

