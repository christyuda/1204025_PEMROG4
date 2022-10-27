package id.ac.ulbi.sevenmorse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import id.ac.ulbi.sevenmorse.database.Appdatabase;
import id.ac.ulbi.sevenmorse.database.adapter.UserAdapter;
import id.ac.ulbi.sevenmorse.database.entitas.User;

public class RoomDatabaseActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btnTambah;
    private Appdatabase database;
    private UserAdapter userAdapter;
    private List<User> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_database);

        database = Appdatabase.getInstance(getApplicationContext());
        list.clear();
        list.addAll(database.userDao().getAll());
        userAdapter = new UserAdapter(getApplicationContext(),list);
        recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);



    }
    @Override
    protected void onStart(){
        super.onStart();
        list.clear();
        list.addAll(database.userDao().getAll());
        userAdapter.notifyDataSetChanged();

    }
}