package com.dhanurjan.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener { //implement "View.OnClickListener" and create method
    private TextView register;

    private EditText userName,password;
    private Button btnLogin;

    private DatabaseReference dbRef;

    private static String username,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);
        btnLogin = (Button)findViewById(R.id.loginBtn);

        register = (TextView) findViewById(R.id.goToRegister);
        register.setOnClickListener(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try{

                    dbRef = FirebaseDatabase.getInstance().getReference().child("User");

                    username = userName.getText().toString().trim();
                    pwd = password.getText().toString().trim();
                    dbRef.child(username).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            try {
                                User user = snapshot.getValue(User.class);

                                if(pwd.equals(user.getPassword())){

                                    Toast.makeText(getApplicationContext(),"LOGIN SUCCESSFUL",Toast.LENGTH_LONG).show();
                                    goToMain();

                                } else {
                                    Toast.makeText(getApplicationContext(),"LOGIN FAILED CHECK USER CREDENTIALS",Toast.LENGTH_LONG).show();

                                }
                            }catch(Exception e) {
                                e.printStackTrace();
                                Toast.makeText(getApplicationContext(),"LOGIN FAILED CHECK USER CREDENTIALS",Toast.LENGTH_LONG).show();
                            }


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getApplicationContext(),"DATABASE CONNECTION FAILED",Toast.LENGTH_LONG).show();

                        }
                    });


                }catch(Exception e) {

                    Toast.makeText(getApplicationContext(),"LOGIN FAILED",Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    private void goToMain()
    {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){ //to get the id onclick
            case  R.id.goToRegister: //goToRegister.id (if user click goToRegister)
                startActivity(new Intent(this, RegisterActivity.class)); //start new activity, class RegisterActivity
                break;

        }

    }
}