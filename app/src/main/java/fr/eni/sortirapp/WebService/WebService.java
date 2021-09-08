package fr.eni.sortirapp.WebService;

import java.util.List;

import fr.eni.sortirapp.Bo.AddSortie;
import fr.eni.sortirapp.Bo.Inscription;
import fr.eni.sortirapp.Bo.Sortie;
import fr.eni.sortirapp.Bo.User;
import fr.eni.sortirapp.Bo.UserLogin;
import fr.eni.sortirapp.Bo.Ville;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface WebService {

    @POST("api/login/participant")
    Call<User> login(@Body UserLogin userLogin);

    @GET("api/sortie")
    Call<List<Sortie>> getSortie();

    @PUT("api/sortie/deinscription")
    Call<List<Sortie>> desinscipyion(@Body Inscription inscription);

    @PUT("api/sortie/inscription")
    Call<List<Sortie>> inscription(@Body Inscription inscription);

    @POST("api/sortie")
    Call<Sortie> ajouterSortie(@Body AddSortie addSortie);

    @GET("api/villes")
    Call<List<Ville>> getVille();
}
