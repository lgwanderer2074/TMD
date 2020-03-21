package com.example.themobiledoctor7;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DateFormat;
import java.util.Calendar;



import androidx.annotation.NonNull;

import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class MainActivity extends AppCompatActivity {
    EditText ed_email;
    EditText ed_code;
    Button btn_login;

    public static String EMAIL;
    EditText et1,et2;
    ProgressBar progressBar;
    Button btn1;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_Register = findViewById(R.id.tv_Register);

        tv_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Register.class);
                startActivity(intent2);
            }
        });



        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.tv_date);
        textViewDate.setText(currentDate);
        //////////////////////////////////////////////////////////////////////////////////////

        et1=findViewById(R.id.et_email);
        et2=findViewById(R.id.et_password);
        progressBar=findViewById(R.id.progressBar);
        btn1=findViewById(R.id.btn_login);

        fAuth=FirebaseAuth.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EMAIL=et1.getText().toString().trim();
                String password=et2.getText().toString().trim();

                if(TextUtils.isEmpty(EMAIL)) {
                    et1.setError("Email is required.");
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    et2.setError("Password is required.");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                fAuth.signInWithEmailAndPassword(EMAIL,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Logged In Successfully.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Specialty.class));
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Error!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);

                        }

                    }
                });
            }
        });
    }

}
