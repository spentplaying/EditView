package com.example.spentplaying.editview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit extends AppCompatActivity {
    private String f_name = "";
    private String l_name = "";
    private String e_mail = "";

    void setview(){
        EditText f_n = (EditText) findViewById(R.id.f_name);
        f_n.setText(f_name);
        EditText l_n = (EditText) findViewById(R.id.l_name);
        l_n.setText(l_name);
        EditText em = (EditText) findViewById(R.id.email);
        em.setText(e_mail);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        f_name = getIntent().getStringExtra("f_name");
        l_name = getIntent().getStringExtra("l_name");
        e_mail = getIntent().getStringExtra("email");
        setview();
        Button btn_cancel = (Button) findViewById(R.id.cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                setResult(RESULT_CANCELED,resultIntent);
                finish();
            }
        });
        Button btn_save = (Button) findViewById(R.id.save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                EditText tx_l = (EditText) findViewById(R.id.l_name);
                EditText tx_f = (EditText) findViewById(R.id.f_name);
                EditText tx_e = (EditText) findViewById(R.id.email);
                f_name = tx_f.getText().toString();
                l_name = tx_l.getText().toString();
                e_mail = tx_e.getText().toString();
                resultIntent.putExtra("f_name",f_name);
                resultIntent.putExtra("l_name",l_name);
                resultIntent.putExtra("email",e_mail);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
    }
}

