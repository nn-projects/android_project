package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    EditText etUserNameRegister;
    EditText etPasswordRegister;
    EditText etConfirmPassword;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUserNameRegister = findViewById(R.id.editTextUserName);
        etPasswordRegister = findViewById(R.id.editTextPassword);
        etConfirmPassword = findViewById(R.id.editTextConfirmPassword);

   }

        public void onSignUpButtonClick (View view){
            if(etPasswordRegister.getText().toString().equals(etConfirmPassword.getText().toString())){
                SharedPreferences sP=getSharedPreferences(KEYS.FILE_NAME,MODE_PRIVATE);
                SharedPreferences.Editor editor=sP.edit();
                editor.putString(KEYS.KEY_USERNAME,etUserNameRegister.getText().toString());
                editor.putString(KEYS.KEY_PASSWORD,etPasswordRegister.getText().toString());
                editor.apply();
                Toast.makeText(this,"Registration Successfully!",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this,"Invalid username or passwords",Toast.LENGTH_SHORT).show();
            }
        }

    public void onSignInButtonClick(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
