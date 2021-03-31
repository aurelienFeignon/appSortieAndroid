package fr.eni.sortirapp.WebService;

import java.util.List;

import fr.eni.sortirapp.Bo.Sortie;
import fr.eni.sortirapp.Bo.User;
import fr.eni.sortirapp.Bo.UserLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WebService {

    @POST("api/login/participant")
    Call<User> login(@Body UserLogin userLogin);

    @GET("api/sortie")
    Call<List<Sortie>> getSortie();
}
