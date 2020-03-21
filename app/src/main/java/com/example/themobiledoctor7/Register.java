package com.example.themobiledoctor7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.MissingFormatArgumentException;

public class Register extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7;
    Button b1;
    TextView tv2;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e1=findViewById(R.id.et_Fname);
        e2=findViewById(R.id.et_Lname);
        e3=findViewById(R.id.et_Phone);
        e4=findViewById(R.id.et_bday);
        e5=findViewById(R.id.et_email2);
        e6=findViewById(R.id.et_pass1);
        e7=findViewById(R.id.et_pass2);

        b1=findViewById(R.id.btn_register);



        fAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);
        tv2=findViewById(R.id.tv_Hacc);
        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fName=e1.getText().toString().trim();
                final String sName=e2.getText().toString().trim();
                final String phoneN=e3.getText().toString().trim();
                final String id=e4.getText().toString().trim();
                final String email=e5.getText().toString().trim();
                final String password=e6.getText().toString().trim();
                String repass=e7.getText().toString().trim();

                if(TextUtils.isEmpty(fName)) {
                    e1.setError("First Name is required.");
                    return;
                }



                if(TextUtils.isEmpty(sName)) {
                    e2.setError("Second Name is required.");
                    return;
                }

                if(TextUtils.isEmpty(phoneN)) {
                    e3.setError("Phone Number is required.");
                    return;
                }

                if(TextUtils.isEmpty(id)) {
                    e4.setError("ID Number is required.");
                    return;
                }

                if(TextUtils.isEmpty(email)) {
                    e5.setError("Email is required.");
                    return;
                }

                if(TextUtils.isEmpty(password)) {
                    e6.setError("Password is required.");
                    return;
                }

                if(TextUtils.isEmpty(repass)) {
                    e7.setError("Re-Enter your password.");
                    return;
                }
                if(!password.equals(repass)) {
                    e7.setError("Passwords do not match.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            MainActivity.EMAIL=email;
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("Patients");
                            Patient p=new Patient(fName,sName,phoneN,id,email,password);
                            myRef.push().setValue(p);

                            Toast.makeText(Register.this, "User Created.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else{
                            Toast.makeText(Register.this, "Error!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////
        TextView tv_Hacc = findViewById(R.id.tv_Hacc);

        tv_Hacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////
        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent2);
            }
        });






    }
}
