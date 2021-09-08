package fr.eni.sortirapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import fr.eni.sortirapp.Bo.User;
import fr.eni.sortirapp.Bo.UserLogin;
import fr.eni.sortirapp.WebService.ReseauHelper;
import fr.eni.sortirapp.WebService.WebService;
import fr.eni.sortirapp.WebService.WebServiceSingleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    EditText et_email;
    EditText et_mdp;
    UserLogin userLogin;
    TextView tv_erreur;
    Button buttonLogin;
    private static final String TAG="Le hardy";

    SharedPreferences sp;
   public static  final String USER_DOSSIER="userCourant";
   public static  final String CLEF_USER="clef_user";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_email= findViewById(R.id.et_main_email);
        et_mdp= findViewById(R.id.et_main_mdp);
        tv_erreur= findViewById(R.id.tv_message_erreur);
        buttonLogin= findViewById(R.id.bu_main);
        sp= getSharedPreferences(USER_DOSSIER, MODE_PRIVATE);

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        if(!ReseauHelper.estConnecte(this)){
            et_email.setFocusable(false);
            et_mdp.setFocusable(false);
            tv_erreur.setVisibility(View.VISIBLE);
            buttonLogin.setEnabled(false);

        }
    }

    public void login(View view) {
        if(ReseauHelper.estConnecte(this)){
            if(check(et_email) && check(et_mdp)){
                userLogin= new UserLogin();
                userLogin.setEmail(et_email.getText().toString());
                userLogin.setPassword(et_mdp.getText().toString());
                Log.i(TAG, "login: "+userLogin.getEmail()+ " mdp: "+ userLogin.getPassword());
                Gson Gson = new Gson();
                Log.i(TAG, "login: "+ Gson.toJson(userLogin));
                Retrofit retrofit= WebServiceSingleton.getInstance();
                WebService wb= retrofit.create(WebService.class);
                Call<User> userCall = wb.login(userLogin);
                userCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                        if(response.isSuccessful()){
                            SharedPreferences.Editor editor= sp.edit();
                            editor.putString(CLEF_USER, Gson.toJson(response.body())).apply();
                            Intent intent= new Intent(view.getContext(),ListActivity.class);
                            startActivity(intent);
                        }else Toast.makeText(MainActivity.this, "Echec de login", Toast.LENGTH_SHORT).show();

                    }
    
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Echec de login", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "onFailure: "+t.getMessage() );
                        t.printStackTrace();
                    }
                });
            }else Toast.makeText(this, R.string.messageErreurConnexion, Toast.LENGTH_SHORT).show();
        }

    }

    public boolean check(EditText editText){
        return !editText.getText().toString().trim().equals("");
    }

}