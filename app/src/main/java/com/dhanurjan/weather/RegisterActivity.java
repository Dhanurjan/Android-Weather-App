package com.dhanurjan.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener { //implement "View.OnClickListener" and create method
//    private FirebaseAuth mAuth;

    private EditText editTextEmail, editTextPassword,username;
    private Button register;
//    private ProgressBar progressBar;
    private TextView goToLogin;
    DatabaseReference dbRef;

    User user;

    public static String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        goToLogin = (TextView) findViewById(R.id.goToLogin);
        goToLogin.setOnClickListener(this);

//        mAuth = FirebaseAuth.getInstance();

        register = findViewById(R.id.registerBtn);
        editTextEmail = findViewById(R.id.emailAddress);
        editTextPassword = findViewById(R.id.password);
        username = findViewById(R.id.userName);

//        progressBar = findViewById(R.id.progressBar);

        user = new User();
        dbRef = FirebaseDatabase.getInstance().getReference().child("User");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    user.setEmail(editTextEmail.getText().toString().trim());
                    user.setPassword(editTextPassword.getText().toString().trim());
                    user.setUsername(username.getText().toString().trim());
                    key = username.getText().toString().trim();

                    dbRef.child(key).setValue(user);

                    Toast.makeText(getApplicationContext(),"REGISTRATION SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    goBackLogin();

                }catch(Exception e) {
                    e.printStackTrace();

                    Toast.makeText(getApplicationContext(),"REGISTRATION FAILED",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void goBackLogin()
    {
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){ //to get the id onclick
            case R.id.goToLogin: //resourse.id (if user click goToRegister)
                startActivity(new Intent(this, LoginActivity.class)); //start new activity, class LoginActivity
                break;
//            case R.id.registerBtn:
//                register();
//                break;
        }

    }

//    private void register() {
//        String email = editTextEmail.getText().toString().trim(); // get values
//        String password = editTextPassword.getText().toString().trim();
//
//        if (email.isEmpty()) {
//            editTextEmail.setError("Email is required!");
//            editTextEmail.requestFocus();
//            return;
//        }
//
//        if (password.isEmpty()) {
//            editTextPassword.setError("Password is required!");
//            editTextPassword.requestFocus();
//            return;
//        }
//
//        if (password.length() < 6) {
//            editTextPassword.setError("Minimum password length should be 6 characters!");
//            editTextPassword.requestFocus();
//            return;
//        }
//
//        progressBar.setVisibility(View.VISIBLE);
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            User user = new User(email);
//
//                            FirebaseDatabase.getInstance().getReference("Users")
//                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful()) {
//                                        Toast.makeText(RegisterActivity.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
//                                        progressBar.setVisibility(View.VISIBLE);
//                                    }else {
//                                        Toast.makeText(RegisterActivity.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
//                                        progressBar.setVisibility(View.GONE);
//                                    }
//
//                                }
//                            });
//                        } else {
//                            Toast.makeText(RegisterActivity.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
//                            progressBar.setVisibility(View.GONE);
//                        }
//                    }
//                });
//    }
}