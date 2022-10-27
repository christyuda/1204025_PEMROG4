package id.ac.ulbi.sevenmorse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SharedPrefrence extends AppCompatActivity {


        EditText email, password;
        Button save,tampil;
        SharedPreferences sharedPrefrence;
        String emailstr, passwordstr;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_shared_prefrence);
            email = findViewById(R.id.email);
            password = findViewById(R.id.password);

            sharedPrefrence = getSharedPreferences("MyuserPref", Context.MODE_PRIVATE);
            save = findViewById(R.id.button);
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    emailstr = email.getText().toString();
                    passwordstr = password.getText().toString();

                    SharedPreferences.Editor editor = sharedPrefrence.edit();
                    editor.putString("email",emailstr);
                    editor.putString("password",passwordstr);
                    editor.commit();
                    Toast.makeText(SharedPrefrence.this, "data disimpan", Toast.LENGTH_SHORT).show();

                }
            });
            tampil = findViewById(R.id.button2);
            tampil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), ReadSharePreferences.class));
                }
            });

        }
    }