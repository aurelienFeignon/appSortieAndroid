package fr.eni.sortirapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import fr.eni.sortirapp.Adapter.AdapterListSortie;
import fr.eni.sortirapp.Bo.Sortie;
import fr.eni.sortirapp.WebService.WebService;
import fr.eni.sortirapp.WebService.WebServiceSingleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterListSortie adapterListSortie;
    private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        addButton= findViewById(R.id.list_floting_button);
        recyclerView = findViewById(R.id.rwListArticle);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Retrofit retrofit= WebServiceSingleton.getInstance();
        WebService wb= retrofit.create(WebService.class);
        Call<List<Sortie>> listCall= wb.getSortie();
        listCall.enqueue(new Callback<List<Sortie>>() {
            @Override
            public void onResponse(Call<List<Sortie>> call, Response<List<Sortie>> response) {
                adapterListSortie = new AdapterListSortie(response.body(),getBaseContext());
                recyclerView.setAdapter(adapterListSortie);
            }

            @Override
            public void onFailure(Call<List<Sortie>> call, Throwable t) {

            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(), AddActivity.class);
                startActivity(intent);
            }
        });

    }
}