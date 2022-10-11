package ulbi.ac.id.onemorse;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Detail_Activity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        TextView nameTxt = findViewById(R.id.namatugas);
        TextView kumpulTxt = findViewById(R.id.dikumpul);

        String namamatkul = "Matkul not set";
        String kumpulkan = "kumpul not set";

        Bundle extras = getIntent().getExtras();
        if (extras!= null){
            namamatkul = extras.getString("namamatkul");
            kumpulkan = extras.getString("dikumpul");
        }

        nameTxt.setText(namamatkul);
        kumpulTxt.setText(kumpulkan);




    }
}
