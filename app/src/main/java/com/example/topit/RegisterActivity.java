package com.example.topit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.topit.util.InputDataValidator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button RegButton;
    private EditText Email, Password;
    private TextView mTextView;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    private InputDataValidator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() !=null){
            finish();
            Intent intent = new Intent(RegisterActivity.this, NavDrawerActivity.class);
            startActivity(intent);
        }
        progressDialog = new ProgressDialog(this);
        RegButton = (Button) findViewById(R.id.regButton);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        mTextView = (TextView) findViewById(R.id.textView);

        RegButton.setOnClickListener(this);
        mTextView.setOnClickListener(this);

    }

    private void registerUser(){
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!validator.isEmailValid(email))
        {
            Toast.makeText(this, "Please enter valid email", Toast.LENGTH_LONG).show();
            return;

        }
        if(!validator.isPasswordValid(password)){
            Toast.makeText(this, "Please enter valid password", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Registration failed... please try again", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {
        if(v == RegButton){
            registerUser();
        }
        if(v == mTextView)
        {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }

    }
}
