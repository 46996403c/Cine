package com.example.oscarxiii.cine;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oscarxiii.cine.json.Result;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Usuario on 09/11/2015.
 */
public class AdaptadorPelis extends ArrayAdapter<Result>{
    public AdaptadorPelis(Context contexto, int recurso, List<Result> objectos) {
        super(contexto, recurso, objectos);
    }

    @Override
    public View getView(int posicion, View verPeli, ViewGroup verGrupo) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());

        // Obtenemos el objecto en la posicion correspondiente
        Result pelicula = getItem(posicion);

        if(pref.getString("ver_poster_lista_peliculas", "0").equals("0") || pref.getString("ver_poster_lista_peliculas", "0").equals("1")){
            // Comprovamos si la View se esta reusando, si no es asi "inflamos" la View
            // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView#row-view-recycling
            if (verPeli == null) {
                LayoutInflater inflador = LayoutInflater.from(getContext());
                verPeli = inflador.inflate(R.layout.lista_peliculas, verGrupo, false);
            }

            // Unimos el codigo en las Views del Layout
            TextView tituloTV = (TextView) verPeli.findViewById(R.id.tvTituloPelis);
            TextView popuTV = (TextView) verPeli.findViewById(R.id.tvPelisPopus);
            TextView estrenoTV = (TextView) verPeli.findViewById(R.id.tvEstrenosPelis);
            ImageView posterIV = (ImageView) verPeli.findViewById(R.id.ivPoster);


            //Ponemos los datos de los objectos (provienen del JSON) en el layout
            tituloTV.setText(pelicula.getTitle());
            popuTV.setText("Score: " + pelicula.getPopularity() + "%");
            estrenoTV.setText(pelicula.getReleaseDate());
            if (pref.getString("ver_poster_lista_peliculas", "0").equals("0")){
                final String urlPoster = "http://image.tmdb.org/t/p/";
                final String definicionPoster = "w780";
                Picasso.with(getContext()).load(urlPoster+definicionPoster+pelicula.getPosterPath()).into(posterIV);
            }

            // Devolvemos la View con los datos para mostrarla
            return verPeli;
        }

        else if(pref.getString("ver_poster_lista_peliculas", "0").equals("2")){
            // Comprovamos si la View se esta reusando, si no es asi "inflamos" la View
            // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView#row-view-recycling
            if (verPeli == null) {
                LayoutInflater inflador = LayoutInflater.from(getContext());
                verPeli = inflador.inflate(R.layout.grid_peliculas, verGrupo, false);
            }

            // Unimos el codigo en las Views del Layout
            ImageView posterIV = (ImageView) verPeli.findViewById(R.id.ivPoster);

            //Ponemos los datos de los objectos (provienen del JSON) en el layout
            final String urlPoster = "http://image.tmdb.org/t/p/";
            final String definicionPoster = "w780";
            Picasso.with(getContext()).load(urlPoster+definicionPoster+pelicula.getPosterPath()).into(posterIV);

            // Devolvemos la View con los datos para mostrarla
            return verPeli;
        }

        return null;





    }
}
