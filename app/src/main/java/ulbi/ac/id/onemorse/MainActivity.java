package ulbi.ac.id.onemorse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> userslist;
    private RecyclerView recyclerView;
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
        Adapter adapter = new Adapter(userslist);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager((getApplicationContext()));
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo(){
        userslist.add(new User("PEMROG"));
        userslist.add(new User("RPL"));
        userslist.add(new User("DATABASE"));
    }

}