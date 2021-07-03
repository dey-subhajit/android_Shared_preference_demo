package com.example.sharedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_user_name, et_pwd;
    Button btn_user_name, btn_pwd,btn_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_user_name = findViewById(R.id.et_user_name);
        et_pwd = findViewById(R.id.et_pwd);

        btn_user_name = findViewById(R.id.btn_user_name);
        btn_pwd = findViewById(R.id.btn_pwd);
        btn_clear = findViewById(R.id.btn_clear);

        btn_user_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_user_name.getText().toString();
                String pwd = et_pwd.getText().toString();
                SharedPreferences sf = getSharedPreferences("user", MODE_PRIVATE);
                SharedPreferences.Editor sfe = sf.edit();
                sfe.putString("username", username);
                sfe.putString("password", pwd);
                sfe.commit();
            }
        });

        btn_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sf = getSharedPreferences("user", MODE_PRIVATE);
                et_user_name.setText(sf.getString("username", ""));
                et_pwd.setText(sf.getString("password", ""));
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sf = getSharedPreferences("user", MODE_PRIVATE);
                SharedPreferences.Editor sfe = sf.edit();
                sfe.clear();
                sfe.commit();

                et_user_name.setText(sf.getString("username", ""));
                et_pwd.setText(sf.getString("password", ""));
            }
        });
    }
}