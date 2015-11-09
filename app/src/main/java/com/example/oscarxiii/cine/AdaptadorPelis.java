package com.example.oscarxiii.cine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oscarxiii.cine.json.PelisPiojo;

import java.util.List;


import java.util.List;


/**
 * Created by Usuario on 09/11/2015.
 */
public class AdaptadorPelis extends ArrayAdapter<PelisPiojo>{
    public AdaptadorPelis(Context contexto, int recurso, List<PelisPiojo> objectos) {
        super(contexto, recurso, objectos);
    }

    @Override
    public View getView(int posicion, View verPeli, ViewGroup verGrupo) {

        // Obtenim l'objecte en la posició corresponent
        PelisPiojo pelicula = getItem(posicion);
        //Log.w("XXXX", movie.toString());

        // Mirem a veure si la View s'està reusant, si no es així "inflem" la View
        // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView#row-view-recycling
        if (verPeli == null) {
            LayoutInflater inflador = LayoutInflater.from(getContext());
            verPeli = inflador.inflate(R.layout.lista_peliculas, verGrupo, false);
        }

        // Unim el codi en les Views del Layout
        TextView tituloTV = (TextView) verPeli.findViewById(R.id.tvTitle);
        TextView popuTV = (TextView) verPeli.findViewById(R.id.tvCriticsScore);
        TextView estrenoTV = (TextView) verPeli.findViewById(R.id.tvCast);

        // Fiquem les dades dels objectes (provinents del JSON) en el layout
        tituloTV.setText(pelicula.getTitle());
        popuTV.setText("Score: " + pelicula.getRatings().getCriticsScore() + "%");
        estrenoTV.setText(pelicula.getCast());


        // Retornem la View replena per a mostrarla
        return verPeli;
    }
}
