package fr.eni.sortirapp.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fr.eni.sortirapp.Bo.Lieu;

public class AdapterSpinnerLieu extends ArrayAdapter<Lieu> {

private Context context;
private List<Lieu> lieu;

    public AdapterSpinnerLieu(@NonNull Context context, int resource, @NonNull List<Lieu> objects) {
        super(context, resource, objects);
        this.lieu= objects;
        this.context= context;
    }


    @Override
public int getCount() {
        return lieu.size();
        }

@Nullable
@Override
public Lieu getItem(int position) {
        return lieu.get(position);
        }

@Override
public long getItemId(int position) {
        return position;
        }

@NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView tvNom= (TextView) super.getDropDownView(position, convertView, parent);
        tvNom.setText(lieu.get(position).getNom());

        return tvNom;
        }

@Override
public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView tvNom= (TextView) super.getDropDownView(position, convertView, parent);
        tvNom.setText(lieu.get(position).getNom());

        return tvNom;
        }
        }