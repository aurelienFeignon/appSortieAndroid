package fr.eni.sortirapp.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.List;

import fr.eni.sortirapp.Bo.Ville;
import fr.eni.sortirapp.R;

public class AdapterSpinnerVille extends ArrayAdapter<Ville> {

    private Context context;
    private List<Ville> villes;

    public AdapterSpinnerVille(@NonNull Context context, int resource, @NonNull List<Ville> objects) {
        super(context, resource, objects);
        this.context= context;
        this.villes= objects;
    }

    @Override
    public int getCount() {
        return villes.size();
    }

    @Nullable
    @Override
    public Ville getItem(int position) {
        return villes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView tvNom= (TextView) super.getDropDownView(position, convertView, parent);
        tvNom.setText(villes.get(position).getNom());

        return tvNom;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView tvNom= (TextView) super.getDropDownView(position, convertView, parent);
        tvNom.setText(villes.get(position).getNom());

        return tvNom;
    }
}