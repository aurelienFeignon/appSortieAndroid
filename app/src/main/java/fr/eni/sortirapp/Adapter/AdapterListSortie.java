package fr.eni.sortirapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import fr.eni.sortirapp.Bo.Sortie;
import fr.eni.sortirapp.Bo.User;
import fr.eni.sortirapp.DetailActivity;
import fr.eni.sortirapp.MainActivity;
import fr.eni.sortirapp.R;
import fr.eni.sortirapp.Utile.Utile;

import static android.content.ContentValues.TAG;

public class AdapterListSortie extends RecyclerView.Adapter<AdapterListSortie.ViewHolder> {

    private List<Sortie> listSortie;
    private User user;
    private SharedPreferences sp;



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvNomSortie;
        public TextView tvNomDescritption;
        public TextView tvParticipation;
        public TextView tvOrganisateur;
        public TextView tvCompteur;
        public TextView tvDate;
        public Button btnDetail;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNomSortie = itemView.findViewById(R.id.cardTvNomSortie);
            tvNomDescritption= itemView.findViewById(R.id.cardTvDescription);
            tvParticipation= itemView.findViewById(R.id.cardTvParticipation);
            tvOrganisateur= itemView.findViewById(R.id.cardTvOrganisation);
            tvCompteur= itemView.findViewById(R.id.cardTvCompteur);
            tvDate= itemView.findViewById(R.id.cardTvDate);
            btnDetail= itemView.findViewById(R.id.cardBtnDetail);
            btnDetail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent= new Intent(v.getContext(), DetailActivity.class);
            intent.putExtra("sortie", new Gson().toJson(listSortie.get(ViewHolder.this.getAdapterPosition())));
            itemView.getContext().startActivity(intent);
        }
    }

    public AdapterListSortie(List<Sortie> listSortie, Context context) {

        this.listSortie = listSortie;
        user= Utile.getInstanceUser(context);
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
     if(participe(listSortie.get(position), user)){
         holder.tvParticipation.setVisibility(View.VISIBLE);
     }
     if(verifOrganisateur(listSortie.get(position),user)){
         holder.tvOrganisateur.setVisibility(View.VISIBLE);
     }
     holder.tvCompteur.setText(compteur(listSortie.get(position)));
     holder.tvDate.setText(formatDate(listSortie.get(position)));

    }

    @Override
    public int getItemCount() {
        return listSortie.size();
    }

    public static boolean participe(Sortie sortie, User user) {
        if(sortie.getParticipants() != null){
            for (User participant: sortie.getParticipants() ) {
                if(participant.getId()== user.getId()){
                    return true;
                }
            }
        }return false;
    }

    public static String compteur(Sortie sortie) {
        StringBuilder sb= new StringBuilder();
        sb.append("Participant: ");
        if (sortie.getParticipants()!= null){
            sb.append(sortie.getParticipants().size());
        }else sb.append(0);
        sb.append('/').append(sortie.getNbInscriptionMax());
        return sb.toString();
    }

    public static String formatDate(Sortie sortie){
        if(sortie.getDateHeureDebut().before(new Date())){
            return "Evenement passé";

        }else{
            DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);
            return format.format(sortie.getDateHeureDebut());
        }
    }

    public static boolean verifOrganisateur(Sortie sortie, User user){
        if (sortie.getOrganisateur().getId()== user.getId()) return true;
        else return false;
    }


}
