package com.example.themobiledoctor7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;


public class Specialty extends AppCompatActivity {

    Button btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.tv_date);
        textViewDate.setText(currentDate);
        ///////////////////////////////////////////////////////////////////////////////////////////
        btn_confirm = findViewById(R.id.btn_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent3 = new Intent(Specialty.this, AppDateTime.class);
                startActivity(intent3);


            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
    }
}