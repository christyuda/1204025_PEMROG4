package ulbi.ac.id.onemorse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private ArrayList<User> userslist;
    private RecyclerViewClickListener listener;
    public Adapter(ArrayList<User> userslist, RecyclerViewClickListener listener){
        this.userslist = userslist;
        this.listener = listener;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView matkul, dateline;

        public MyViewHolder(final View view){
            super(view);
            matkul = view.findViewById(R.id.textView2);
            dateline = view.findViewById(R.id.tgl);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition() );
        }
    }
    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        String mtkul = userslist.get(position).getNamamatkul();
        holder.matkul.setText(mtkul);
        String dateline = userslist.get(position).getDikumpul();
        holder.dateline.setText(dateline);

    }

    @Override
    public int getItemCount() {
        return userslist.size();
    }
    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
