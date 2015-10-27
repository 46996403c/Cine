package com.example.oscarxiii.cine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class CineFragment extends Fragment {

    private ArrayList<String> items;
    private ArrayAdapter<String> adaptador;

    public CineFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cine, container,false);

        ListView listaPeli = (ListView) rootView.findViewById(R.id.listaPelis);
        items = new ArrayList<>();
        adaptador = new ArrayAdapter<>(
                getContext(),
                R.layout.lista_peliculas,
                R.id.tvTituloPelis,
                items
                );
        listaPeli.setAdapter(adaptador);
        return rootView;
    }
}