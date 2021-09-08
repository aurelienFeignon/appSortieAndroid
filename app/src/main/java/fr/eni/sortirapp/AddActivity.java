package fr.eni.sortirapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import fr.eni.sortirapp.Adapter.AdapterSpinnerLieu;
import fr.eni.sortirapp.Adapter.AdapterSpinnerVille;
import fr.eni.sortirapp.Bo.AddSortie;
import fr.eni.sortirapp.Bo.Lieu;
import fr.eni.sortirapp.Bo.Sortie;
import fr.eni.sortirapp.Bo.User;
import fr.eni.sortirapp.Bo.Ville;
import fr.eni.sortirapp.Utile.Utile;
import fr.eni.sortirapp.WebService.WebService;
import fr.eni.sortirapp.WebService.WebServiceSingleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddActivity extends AppCompatActivity {

    TimePicker heure;
    Spinner selectVille;
    Spinner selectLieu;
    List<Ville> villes;
    AdapterSpinnerVille adapter;
    AdapterSpinnerLieu adapterSpinnerLieu;
    int idVille;
    int idLieu;
    private static final String TAG = "AddActivity";
    EditText etNom;
    EditText etDescription;
    CalendarView calendarView;
    TimePicker timePicker;
    User user;
    Retrofit retrofit;
    WebService wb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        heure = findViewById(R.id.add_tp_heure);
        heure.setIs24HourView(true);
        selectVille = findViewById(R.id.selectVille);
        selectLieu= findViewById(R.id.selectlieu);
        etNom= findViewById(R.id.add_et_nom);
        etDescription= findViewById(R.id.add_et_info_sortie);
        calendarView= findViewById(R.id.add_et_date_debut);
        timePicker= findViewById(R.id.add_tp_heure);
        user= Utile.getInstanceUser(this);



        retrofit = WebServiceSingleton.getInstance();
        wb = retrofit.create(WebService.class);
        Call<List<Ville>> listCall = wb.getVille();
        listCall.enqueue(new Callback<List<Ville>>() {
            @Override
            public void onResponse(Call<List<Ville>> call, Response<List<Ville>> response) {
                if (response.isSuccessful()) {
                    villes = response.body();
                    Log.i(TAG, "succes: " + villes.get(1).getNom());
                    adapter = new AdapterSpinnerVille(getBaseContext(), android.R.layout.simple_spinner_item, villes);
                    selectVille.setAdapter(adapter);
                    selectVille.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            Ville villeCourante= adapter.getItem(position);
                            if(villeCourante!=null){
                                idVille= villeCourante.getId();
                                setLieu(villeCourante);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else {
                    Log.i(TAG, "echec: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Ville>> call, Throwable t) {
                Toast.makeText(AddActivity.this, "Erreur de communication avec l'api", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setLieu(Ville villeCourante) {
        Log.i(TAG, "setLieu: " +villeCourante.getLieux().get(1).getNom());
        adapterSpinnerLieu= new AdapterSpinnerLieu(this, android.R.layout.simple_spinner_item, villeCourante.getLieux());
        selectLieu.setAdapter(adapterSpinnerLieu);
        selectLieu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Lieu lieu= adapterSpinnerLieu.getItem(position);
                idLieu= lieu.getId();
                Log.i(TAG, "onItemSelected: "+idLieu);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void addEvent(View view) {
        AddSortie sortie= new AddSortie();
        sortie.setNom(etNom.getText().toString());
        sortie.setInfosSortie(etDescription.getText().toString());
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(new Date(calendarView.getDate()));
        calendar.set(Calendar.HOUR_OF_DAY,timePicker.getHour());
        calendar.set(Calendar.MINUTE,timePicker.getMinute());
        Date date= calendar.getTime();
        sortie.setDateHeureDebut(date);
        sortie.setDateLimiteInscriptions(date);
        sortie.setIdCampus(user.getCampus().getId());
        sortie.setIdOrganisateur(user.getId());
        sortie.setDuree(120);
        sortie.setIdVille(String.valueOf(idVille));
        sortie.setIdLieu(String.valueOf(idLieu));
        sortie.setNbInscriptionMax(25);
        Call<Sortie> listCall = wb.ajouterSortie(sortie);
        listCall.enqueue(new Callback<Sortie>() {
            @Override
            public void onResponse(Call<Sortie> call, Response<Sortie> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AddActivity.this, "Ajout avec succèes", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(getBaseContext(), ListActivity.class);
                    startActivity(intent);
                }
                else {
                    try {
                        Log.i(TAG, "onResponse: "+ response.errorBody().string() );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Sortie> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t.getCause());

            }
        });


    }
}