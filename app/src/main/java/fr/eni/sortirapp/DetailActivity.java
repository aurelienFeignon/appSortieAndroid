package fr.eni.sortirapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.List;

import fr.eni.sortirapp.Adapter.AdapterListSortie;
import fr.eni.sortirapp.Bo.Inscription;
import fr.eni.sortirapp.Bo.Sortie;
import fr.eni.sortirapp.Bo.User;
import fr.eni.sortirapp.WebService.WebService;
import fr.eni.sortirapp.WebService.WebServiceSingleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "le_hardy";
    TextView tvNom;
    TextView tvDescription;
    TextView tvParticipe;
    TextView tvDate;
    TextView tvNomLieu;
    TextView tvRueLieu;
    TextView tvCpLieu;
    TextView tvVilleLieu;
    TextView tvOrganisateur;
    Button button;
    User user;
    SharedPreferences sp;
    Retrofit retrofit;
    WebService wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNom= findViewById(R.id.detail_Tv_nom);
        tvDescription= findViewById(R.id.detail_Tv_descritpition);
        tvParticipe= findViewById(R.id.detail_Tv_participe);
        tvDate= findViewById(R.id.detail_Tv_date);
        tvNomLieu= findViewById(R.id.detail_Tv_Lieu_nom);
        tvRueLieu= findViewById(R.id.detail_Tv_Lieu_rue);
        tvCpLieu= findViewById(R.id.detail_Tv_Lieu_cp);
        tvVilleLieu= findViewById(R.id.detail_Tv_Lieu_ville);
        tvOrganisateur= findViewById(R.id.detail_Tv_Organisateur);
        button= findViewById(R.id.detail_bu_participe);

        retrofit= WebServiceSingleton.getInstance();
        wb= retrofit.create(WebService.class);
        Sortie sortie = new Gson().fromJson(getIntent().getStringExtra("sortie"), Sortie.class);
        sp= getSharedPreferences(MainActivity.USER_DOSSIER, Context.MODE_PRIVATE);
        String userString = sp.getString(MainActivity.CLEF_USER,"");
        if(!userString.equals("")){
            user= new Gson().fromJson(userString, User.class);
        }

        tvNom.setText(sortie.getNom());
        tvDescription.setText(sortie.getInfosSortie());
        if(AdapterListSortie.participe(sortie, user)){
            tvParticipe.setText("Je Participe");
        }else tvParticipe.setText("Je ne participe pas");
        tvDate.setText(AdapterListSortie.formatDate(sortie));
        tvNomLieu.setText(sortie.getLieu().getNom());
        tvRueLieu.setText(sortie.getLieu().getRue());
        tvCpLieu.setText(sortie.getLieu().getVille().getCodePostal());
        tvVilleLieu.setText(sortie.getLieu().getVille().getNom());
        Log.i(TAG, "onCreate: "+ sortie.getOrganisateur().getUsername());
        if(AdapterListSortie.verifOrganisateur(sortie,user)){
            tvOrganisateur.setText("Je suis l'organisateur");
        }else tvOrganisateur.setText("Organisateur "+sortie.getOrganisateur().getUsername());

        if(AdapterListSortie.participe(sortie,user))button.setText("Se desinscrire");
        else button.setText("S'inscrire");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (button.getText().toString()){
                    case "Se desinscrire": seDesinscrire(user,sortie);
                    case "S'inscrire":  inscrire(user,sortie);
                }
            }
        });

    }

    private void inscrire(User user, Sortie sortie) {
        Call<List<Sortie>> call=  wb.inscription(new Inscription(user.getId(),sortie.getId()));
        call.enqueue(new Callback<List<Sortie>>() {
            @Override
            public void onResponse(Call<List<Sortie>> call, Response<List<Sortie>> response) {
                if(response.isSuccessful()){
                    Intent intent= new Intent(DetailActivity.this,ListActivity.class);
                    startActivity(intent);
                }else Toast.makeText(DetailActivity.this, "echec", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Sortie>> call, Throwable t) {
                Toast.makeText(DetailActivity.this, "Probleme de connexion", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void seDesinscrire(User user, Sortie sortie) {
        Call<List<Sortie>> call=  wb.desinscipyion(new Inscription(user.getId(),sortie.getId()));
        call.enqueue(new Callback<List<Sortie>>() {
            @Override
            public void onResponse(Call<List<Sortie>> call, Response<List<Sortie>> response) {
                if(response.isSuccessful()){
                    Intent intent= new Intent(DetailActivity.this,ListActivity.class);
                    startActivity(intent);
                }else Toast.makeText(DetailActivity.this, "echec", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Sortie>> call, Throwable t) {
                Toast.makeText(DetailActivity.this, "Probleme de connexion", Toast.LENGTH_SHORT).show();
            }
        });

    }


}