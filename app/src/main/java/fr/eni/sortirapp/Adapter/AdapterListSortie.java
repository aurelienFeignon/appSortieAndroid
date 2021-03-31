package fr.eni.sortirapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.eni.sortirapp.Bo.Sortie;
import fr.eni.sortirapp.R;

public class AdapterListSortie extends RecyclerView.Adapter<AdapterListSortie.ViewHolder> {

    private List<Sortie> listSortie;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNomSortie;
        public TextView tvNomDescritption;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNomSortie = itemView.findViewById(R.id.cardTvNomSortie);
            tvNomDescritption= itemView.findViewById(R.id.cardTvDescription);

        }
    }

    public AdapterListSortie(List<Sortie> listSortie) {
        this.listSortie = listSortie;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_accueil, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.tvNomSortie.setText(listSortie.get(position).getNom());
        holder.tvNomDescritption.setText(listSortie.get(position).getInfosSortie());
    }

    @Override
    public int getItemCount() {
        return listSortie.size();
    }


}
