package fr.eni.sortirapp.Utile;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import fr.eni.sortirapp.Bo.User;
import fr.eni.sortirapp.MainActivity;

public class   Utile {


    public static User getInstanceUser(Context context)
    {
        SharedPreferences sp= context.getSharedPreferences(MainActivity.USER_DOSSIER, Context.MODE_PRIVATE);
        String userString = sp.getString(MainActivity.CLEF_USER,"");
        if(userString!=""){
            User user= new Gson().fromJson(userString, User.class);
        return user;
        }
        return null;
    }

}
