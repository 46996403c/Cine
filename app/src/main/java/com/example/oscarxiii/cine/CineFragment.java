package com.example.oscarxiii.cine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class CineFragment extends Fragment {
    private ArrayList<String> items;
    private ArrayAdapter<String> adaptador;

    public CineFragment() {
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_refresh, menu);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cine, container,false);

        ListView listaPeli = (ListView) rootView.findViewById(R.id.listaPelis);
        items = new ArrayList<>();
        String[] data = {
                " ",
                /*
                "300",
                "Enemigo a las puertas",
                "El padrino",
                "El padrino. Parte II",
                "Inglorius Bastards",
                "Inception",
                "EL club de la ducha"
                */
        };
        items = new ArrayList<>(Arrays.asList(data));
        adaptador = new ArrayAdapter<>(
                getContext(),
                R.layout.lista_peliculas,
                R.id.tvTituloPelis,
                items
                );
        listaPeli.setAdapter(adaptador);
        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.accionRefrescar) {
            refresh();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void refresh() {
        PelisApi apiPelis = new PelisApi();

        apiPelis.getPeliculesMesVistes(adaptador);
    }
    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }
}