package com.example.oscarxiii.cine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.oscarxiii.cine.json.Result;

import java.util.ArrayList;

public class CineFragment extends Fragment {
    private ArrayList<Result> items;
    private AdaptadorPelis adaptador;

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
        //items = new ArrayList<>(Arrays.asList(data));
        items = new ArrayList<>();
        adaptador = new AdaptadorPelis(getContext(),R.layout.lista_peliculas,items);
        listaPeli.setAdapter(adaptador);

        listaPeli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> padre, View vista, int posicion, long id) {
                Intent intento = new Intent(getContext(), Detalles.class);
                intento.putExtra("item", adaptador.getItem(posicion));
                startActivity(intento);
            }
        });

        return rootView;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.accionRefrescar) {
            refresh();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void refresh() {
        PelisApi apiPelis = new PelisApi();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        if (pref.getString("lista_categorias", "0").equals("1")){
            apiPelis.getPeliculesMesVistes(adaptador);
        }else if (pref.getString("lista_categorias", "0").equals("0")){
            apiPelis.getMillorsPelicules(adaptador);
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }
}