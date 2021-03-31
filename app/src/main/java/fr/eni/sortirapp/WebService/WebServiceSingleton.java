package fr.eni.sortirapp.WebService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceSingleton {

    private static final  Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("http://10.0.2.2/api_sortir/public/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public WebServiceSingleton() {
    }

    public static Retrofit getInstance() {
        return retrofit;
    }
}
