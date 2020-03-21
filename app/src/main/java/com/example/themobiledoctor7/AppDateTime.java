package com.example.themobiledoctor7;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DateFormat;
import java.util.Calendar;

public class AppDateTime<currentDate> extends AppCompatActivity {

    private TextView textViewDate;
    private TextView textViewTime;
    private TimePickerDialog timePickerDialog;
    private DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_date_time);
        //////////////////////////////////////////////////////////////////////////////////////////
        //DATEPICKER[ACTUALLY WORKS]
        Button btn_datepicker = findViewById(R.id.btn_datepicker);
        btn_datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call PickDate for Date
                PickDate();
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////
        //TIMEPICKER[ACTUALLY WORKS]
        Button btn_timepick = findViewById(R.id.btn_timepicker);
        btn_timepick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call PickTime for Time
                PickTime();
            }
        });
        textViewDate = findViewById(R.id.tv_dateshow);
        textViewTime = findViewById(R.id.tv_timeshow);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView txtvewd= findViewById(R.id.tv_date);
        txtvewd.setText(currentDate);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////
    Calendar calendar = Calendar.getInstance();
    private void PickDate() {
        final java.util.Calendar calendar = java.util.Calendar.getInstance();
        datePickerDialog = new DatePickerDialog( AppDateTime.this, new DatePickerDialog.OnDateSetListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int dayOfMonth) {
                String date = dayOfMonth+"/"+(month+1)+"/"+year;
                /// here set date value in txtview
                textViewDate.setText(date);
            }
        },calendar.get( java.util.Calendar.YEAR),calendar.get( java.util.Calendar.MONTH ),calendar.get( java.util.Calendar.DAY_OF_MONTH ) );
        datePickerDialog.show();

    }

    private void PickTime(){
        timePickerDialog = new TimePickerDialog(AppDateTime.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String time = hourOfDay + ":"+minute;
                textViewTime.setText(time);
                /// here set time value in txtview


            }
        },calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), true );

        timePickerDialog.show();
    }

}
