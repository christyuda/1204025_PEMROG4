package id.ac.ulbi.sevenmorse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.ac.ulbi.sevenmorse.R;

public class FieldActivity extends AppCompatActivity {
    Button btnTambah, btnLihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        btnTambah = findViewById(R.id.btn_tambah);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FieldActivity.this,TambahActivity.class));
            }
        });

        btnLihat = findViewById(R.id.btn_view);
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FieldActivity.this,RoomDatabaseActivity.class));
            }
        });

    }

}