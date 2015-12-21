package com.example.oscarxiii.cine;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.oscarxiii.cine.provider.pelisprovider.PelisproviderCursor;
import com.squareup.picasso.Picasso;


/**
 * Created by Usuario on 09/11/2015.
 */
public class AdaptadorPelis extends SimpleCursorAdapter {
    private final Context contexto;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public AdaptadorPelis(Context contexto, int recurso, Cursor c, String[] from, int[] to, int flags) {
        super(contexto, recurso, c, from, to, flags);
        this.contexto = contexto;
    }

    @Override
    public View getView(int posicion, View verPeli, ViewGroup verGrupo) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(contexto);

        // Obtenemos el objecto en la posicion correspondiente
        Cursor cursor = getCursor();
        PelisproviderCursor pelisCursor = new PelisproviderCursor(cursor);
        pelisCursor.moveToPosition(posicion);

        if(pref.getString("ver_poster_lista_peliculas", "0").equals("0") || pref.getString("ver_poster_lista_peliculas", "0").equals("1")){
            // Comprovamos si la View se esta reusando, si no es asi "inflamos" la View
            // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView#row-view-recycling
            if (verPeli == null) {
                LayoutInflater inflador = LayoutInflater.from(contexto);
                verPeli = inflador.inflate(R.layout.lista_peliculas, verGrupo, false);
            }

            // Unimos el codigo en las Views del Layout
            TextView tituloTV = (TextView) verPeli.findViewById(R.id.tvTituloPelis);
            TextView popuTV = (TextView) verPeli.findViewById(R.id.tvPelisPopus);
            TextView estrenoTV = (TextView) verPeli.findViewById(R.id.tvEstrenosPelis);
            ImageView posterIV = (ImageView) verPeli.findViewById(R.id.ivPoster);


            //Ponemos los datos de los objectos (provienen del JSON) en el layout
            tituloTV.setText(pelisCursor.getTituloPeli());
            popuTV.setText("Score: " + pelisCursor.getPopuPeli() + "%");
            estrenoTV.setText(pelisCursor.getFechaPeli());
            if (pref.getString("ver_poster_lista_peliculas", "0").equals("0")){
                Picasso.with(contexto).load(pelisCursor.getPosterPeli()).into(posterIV);
            }

            // Devolvemos la View con los datos para mostrarla
            return verPeli;
        }

        else if(pref.getString("ver_poster_lista_peliculas", "0").equals("2")){
            // Comprovamos si la View se esta reusando, si no es asi "inflamos" la View
            // https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView#row-view-recycling
            if (verPeli == null) {
                LayoutInflater inflador = LayoutInflater.from(contexto);
                verPeli = inflador.inflate(R.layout.grid_peliculas, verGrupo, false);
            }

            // Unimos el codigo en las Views del Layout
            ImageView posterIV = (ImageView) verPeli.findViewById(R.id.ivPoster);

            //Ponemos los datos de los objectos (provienen del JSON) en el layout
            Picasso.with(contexto).load(pelisCursor.getPosterPeli()).resize(480, 500).into(posterIV);

            // Devolvemos la View con los datos para mostrarla
            return verPeli;
        }
        return null;
    }
}
