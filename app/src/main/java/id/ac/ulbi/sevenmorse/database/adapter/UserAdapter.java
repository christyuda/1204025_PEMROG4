package id.ac.ulbi.sevenmorse.database.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ulbi.sevenmorse.R;
import id.ac.ulbi.sevenmorse.database.entitas.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewAdapter> {

    private List<User> list;
    private Context context;


    public  UserAdapter(Context context, List<User> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent,false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
        holder.tvnpm.setText(list.get(position).NPM);
        holder.tvnama.setText(list.get(position).NAMA);
        holder.tvkelas.setText(list.get(position).KELAS);
        holder.tvprodi.setText(list.get(position).PRODI);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView tvnpm, tvnama,tvkelas,tvprodi;
        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            tvnpm = itemView.findViewById(R.id.tvnpm);
            tvnama = itemView.findViewById(R.id.tvnama);
            tvkelas = itemView.findViewById(R.id.tvkelas);
            tvprodi = itemView.findViewById(R.id.tvprodi);

        }
    }
}