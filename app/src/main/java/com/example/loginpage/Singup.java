package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Singup extends AppCompatActivity {

    TextInputLayout fullname_var,username_var,email_var,phoneNumber_var,password_var;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singup);

        fullname_var=findViewById(R.id.fullname_fieldd);
        username_var=findViewById(R.id.username_field);
        email_var=findViewById(R.id.email_fieldd);
        phoneNumber_var=findViewById(R.id.phone_number_field);
        password_var=findViewById(R.id.Password_field);



    }

    public void loginButtonClick(View view) {
        Intent intent = new Intent(getApplicationContext(), login.class);
        startActivity(intent);
        finish();
    }


    public void registerBtnonclick(View view) {
        String fullname_=fullname_var.getEditText().getText().toString();
        String username_=username_var.getEditText().getText().toString();
        String email_=email_var.getEditText().getText().toString();
        String phonenumber_=phoneNumber_var.getEditText().getText().toString();
        String password_=password_var.getEditText().getText().toString();

        if (!fullname_.isEmpty()){
            fullname_var.setError(null);
            fullname_var.setErrorEnabled(false);
            if (!username_.isEmpty()){
                username_var.setError(null);
                username_var.setErrorEnabled(false);
                if (!email_.isEmpty()){
                    email_var.setError(null);
                    email_var.setErrorEnabled(false);
                    if (!phonenumber_.isEmpty()){
                        phoneNumber_var.setError(null);
                        phoneNumber_var.setErrorEnabled(false);
                       if (!password_.isEmpty()){
                           password_var.setError(null);
                           password_var.setErrorEnabled(false);
                           if (email_.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){

                              firebaseDatabase = FirebaseDatabase.getInstance();
                              reference = firebaseDatabase.getReference("datauser");

                               String fullname_s=fullname_var.getEditText().getText().toString();
                               String username_s=username_var.getEditText().getText().toString();
                               String email_s=email_var.getEditText().getText().toString();
                               String phonenumber_s=phoneNumber_var.getEditText().getText().toString();
                               String password_s=password_var.getEditText().getText().toString();

                               storingdata storingdatass=new storingdata(fullname_s, username_s, email_s,phonenumber_s,password_s);

                               reference.child(username_s).setValue(storingdatass);

                               Toast.makeText(getApplicationContext(), "Regiterd successfully", Toast.LENGTH_SHORT).show();

                               Intent intent=new Intent(getApplicationContext(),DeshBord.class);
                               startActivity(intent);
                               finish();
                           }else {
                             email_var.setError("Invalid email");
                           }

                       }else {
                           password_var.setError("Please enter the password");
                       }
                    }else {
                        phoneNumber_var.setError("Please enter the phone number");
                    }
                }else {
                    email_var.setError("Please enter the email address");
                }

            }else {
               username_var.setError("Please enter the username");
            }
        }else {
            fullname_var.setError("Please enter the full name");
        }

    }
}