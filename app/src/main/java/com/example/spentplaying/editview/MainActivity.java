package com.example.spentplaying.editview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String f_name = "Keng";
    private String l_name = "Chang";
    private String e_mail = "jordan820926@gmail.com";
    static final int Result = 0 ;
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
        setContentView(R.layout.activity_main);
        setview();
        Button btn = (Button) findViewById(R.id.btn_edit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Edit.class);
                intent.putExtra("f_name",f_name);
                intent.putExtra("l_name",l_name);
                intent.putExtra("email",e_mail);
                startActivityForResult(intent,0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            f_name = data.getStringExtra("f_name");
            l_name = data.getStringExtra("l_name");
            e_mail = data.getStringExtra("email");
            setview();
        }
    }
}
