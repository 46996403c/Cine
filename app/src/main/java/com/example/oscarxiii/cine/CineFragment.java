package com.example.oscarxiii.cine;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.content.CursorLoader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.oscarxiii.cine.json.Result;
import com.example.oscarxiii.cine.provider.pelisprovider.PelisproviderColumns;

import java.util.ArrayList;

public class CineFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor>{
    private ArrayList<Result> items;
    //private AdaptadorPelis adaptador;
    private SimpleCursorAdapter adaptador;
    private SwipeRefreshLayout msgRefreshCF;

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

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());

        if (pref.getString("ver_poster_lista_peliculas", "0").equals("0") || pref.getString("ver_poster_lista_peliculas", "0").equals("1")){
            View rootView = inflater.inflate(R.layout.fragment_cine, container,false);
            ListView listaPeli = (ListView) rootView.findViewById(R.id.listaPelis);

            items = new ArrayList<>();
            //adaptador = new AdaptadorPelis(getContext(),R.layout.lista_peliculas,items);
            adaptador = new SimpleCursorAdapter(
                    getContext(),
                    R.layout.lista_peliculas,
                    null,
                    new String[] {
                            PelisproviderColumns.POSTER_PELI,
                            PelisproviderColumns.TITULO_PELI,
                            PelisproviderColumns.POPU_PELI
                    },
                    new int[] {
                            R.id.ivPoster,
                            R.id.tvTituloPelis,
                            R.id.tvPelisPopus
                    },
                    0
            );
            //Inicialitzem el Loader
            getLoaderManager().initLoader(0, null, this);
            listaPeli.setAdapter(adaptador);

            listaPeli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> padre, View vista, int posicion, long id) {
                    Intent intento = new Intent(getContext(), Detalles.class);
                    //intento.putExtra("item", adaptador.getItem(posicion));
                    intento.putExtra("movie_id", id);
                    startActivity(intento);
                }
            });
            msgRefreshCF = (SwipeRefreshLayout) rootView.findViewById(R.id.msgRefresh);
            msgRefreshCF.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    refresh();
                }
            });
            return rootView;

        } else if(pref.getString("ver_poster_lista_peliculas", "0").equals("2")){
            View rootView = inflater.inflate(R.layout.fragment_cine, container,false);
            GridView listaPeli = (GridView) rootView.findViewById(R.id.gridPelis);

            items = new ArrayList<>();
            //adaptador = new AdaptadorPelis(getContext(),R.layout.grid_peliculas,items);
            adaptador = new SimpleCursorAdapter(
                    getContext(),
                    R.layout.lista_peliculas,
                    null,
                    new String[] {
                            PelisproviderColumns.POSTER_PELI,
                            PelisproviderColumns.TITULO_PELI,
                            PelisproviderColumns.POPU_PELI
                    },
                    new int[] {
                            R.id.ivPoster,
                            R.id.tvTituloPelis,
                            R.id.tvPelisPopus
                    },
                    0
            );
            listaPeli.setAdapter(adaptador);

            listaPeli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> padre, View vista, int posicion, long id) {
                    Intent intento = new Intent(getContext(), Detalles.class);
                    //intento.putExtra("item", adaptador.getItem(posicion));
                    intento.putExtra("movie_id", id);
                    startActivity(intento);
                }
            });
            msgRefreshCF = (SwipeRefreshLayout) rootView.findViewById(R.id.msgRefresh);
            msgRefreshCF.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    refresh();
                }
            });
            return rootView;
        }
        return null;
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
        msgRefreshCF.setRefreshing(true);
        PelisApi apiPelis = new PelisApi(getContext());
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        if (pref.getString("lista_categorias", "0").equals("1") && pref.getString("lista_idiomas", "0").equals("1")){
            apiPelis.getPeliculesMesVistes(adaptador);
        }else if (pref.getString("lista_categorias", "0").equals("1") && pref.getString("lista_idiomas", "0").equals("0")){
            apiPelis.getPeliculesMesVistesIngles(adaptador);
        }else if (pref.getString("lista_categorias", "0").equals("0") && pref.getString("lista_idiomas", "0").equals("1")){
            apiPelis.getMillorsPelicules(adaptador);
        }else if (pref.getString("lista_categorias", "0").equals("0") && pref.getString("lista_idiomas", "0").equals("0")){
            apiPelis.getMillorsPeliculesIngles(adaptador);
        }
        msgRefreshCF.setRefreshing(false);

    }
    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }

    @Override
    public android.support.v4.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getContext(), PelisproviderColumns.CONTENT_URI, null, null, null, null);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onLoadFinished(android.support.v4.content.Loader<Cursor> loader, Cursor data) {
        adaptador.swapCursor(data);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onLoaderReset(android.support.v4.content.Loader<Cursor> loader) {
        adaptador.swapCursor(null);
    }
}