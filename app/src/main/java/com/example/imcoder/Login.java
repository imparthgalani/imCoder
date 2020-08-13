package com.example.imcoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText mEmail,mPassword;
    Button mLoginBtn;
    TextView mCreateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail      =   findViewById(R.id.edtEmail);
        mPassword   =   findViewById(R.id.edtPassword);
        mLoginBtn   =   findViewById(R.id.btnLogin);
        mCreateBtn=   findViewById(R.id.txtSignup);
        mAuth = FirebaseAuth.getInstance();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email    =   mEmail.getText().toString().trim();
                String password =   mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mEmail.setError("Email is Required.");
                    return;
                }
                if (password.length() <6){
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                final Task<AuthResult> authResultTask = mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Login.this, "Login in Succesfully.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        }else{
                            Toast.makeText(Login.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Registration.class));
            }
        });

    }
}