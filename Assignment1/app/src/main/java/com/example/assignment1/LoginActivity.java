package com.example.assignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUserNameLogin;
    EditText etPasswordLogin;

    SharedPreferences sP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserNameLogin = findViewById(R.id.editTextUsername_1);
        etPasswordLogin = findViewById(R.id.editTextPassword_1);
        sP=getSharedPreferences(KEYS.FILE_NAME,MODE_PRIVATE);

        String savedUserName=sP.getString(KEYS.KEY_USERNAME,"");
        etUserNameLogin.setText(savedUserName);

    }

        public void onSignInClick (View view){

            String savedUserName=sP.getString(KEYS.KEY_USERNAME,"");
            String savedPassword=sP.getString(KEYS.KEY_PASSWORD,"");

            if((savedUserName.equals(etUserNameLogin.getText().toString())&&savedPassword.equals(etPasswordLogin.getText().toString()))){
                Intent intent=new Intent(this, DashboardActivity.class);
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }else{
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();

            }
        }

    public void onSignUpClick(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

}
