package com.example.user.preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

       SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
       // SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String couleur = preferences.getString("FAVORITE_COLOR2","rouge");



        SharedPreferences prefs = this.getSharedPreferences("fichierReferences",Activity.MODE_PRIVATE);
        String couleur2 = prefs.getString("FAVORITE_COLOR","rouge");
       Toast.makeText(this,"nouveau fichier "+couleur2 + "fichier par défaut "+couleur,Toast.LENGTH_SHORT).show();

    }
}
