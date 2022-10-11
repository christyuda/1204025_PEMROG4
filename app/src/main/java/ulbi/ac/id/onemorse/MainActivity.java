package ulbi.ac.id.onemorse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> userslist;
    private RecyclerView recyclerView;
    private Adapter.RecyclerViewClickListener listerner;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcyleview);
        userslist = new ArrayList<>();
        setUserInfo();
        setAdapter();
      

    }
    private void setAdapter(){
        setOnClickListener();
        Adapter adapter = new Adapter(userslist,listerner);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager((getApplicationContext()));
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
    private void setOnClickListener(){
        listerner = new Adapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),Detail_Activity.class);
                intent.putExtra("namamatkul", userslist.get(position).getNamamatkul());
                intent.putExtra("dikumpul", userslist.get(position).getDikumpul());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo(){
        userslist.add(new User("PEMROG","22-09-05"));
        userslist.add(new User("RPL","22-09-05"));
        userslist.add(new User("DATABASE","22-09-05"));
    }

}