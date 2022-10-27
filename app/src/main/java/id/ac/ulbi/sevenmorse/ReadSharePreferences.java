package id.ac.ulbi.sevenmorse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ReadSharePreferences extends AppCompatActivity {

    TextView email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_share_preferences);
        email = findViewById(R.id.textView);
        password = findViewById(R.id.textView2);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyuserPref", Context.MODE_PRIVATE);

        String emailstr = sharedPreferences.getString("email","");
        String passwordstr = sharedPreferences.getString("password","");

        email.setText(emailstr);
        password.setText(passwordstr);

    }
}