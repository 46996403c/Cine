package com.example.oscarxiii.cine;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscarxiii.cine.provider.pelisprovider.PelisproviderColumns;
import com.example.oscarxiii.cine.provider.pelisprovider.PelisproviderCursor;
import com.squareup.picasso.Picasso;

public class DetallesFragment extends Fragment {
    private TextView titulo;
    private TextView data;
    private TextView popularity;
    private TextView descripcio;
    private ImageView poster;

    public DetallesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalles, container, false);
        //Intent i = getActivity().getIntent();
        //Result item = (Result) i.getSerializableExtra("item");

        titulo = (TextView) view.findViewById(R.id.tvTituloPelis);
        data = (TextView) view.findViewById(R.id.tvEstrenosPelis);
        popularity = (TextView) view.findViewById(R.id.tvPelisPopus);
        descripcio = (TextView) view.findViewById(R.id.tvDescripcion);
        poster = (ImageView) view.findViewById(R.id.ivPoster);

        Long movie_id = getActivity().getIntent().getLongExtra("movie_id", -1);
        Cursor cursorPelis = getContext().getContentResolver().query(
                PelisproviderColumns.CONTENT_URI,
                null,
                PelisproviderColumns._ID + " = ?",
                new String[]{String.valueOf(movie_id)},
                "_id"
                );
        PelisproviderCursor pelisCursor = new PelisproviderCursor(cursorPelis);
        pelisCursor.moveToNext();

        //Toast.makeText(getContext(), item.getOriginalTitle(), Toast.LENGTH_LONG).show();
        Toast.makeText(getContext(), pelisCursor.getTituloPeli(), Toast.LENGTH_LONG).show();

        //titulo.setText("Titulo: " + item.getTitle());
        titulo.setText("Titulo: " + pelisCursor.getTituloPeli());
        //data.setText("Fecha de salida: "+item.getReleaseDate());
        data.setText("Fecha de salida: " + pelisCursor.getFechaPeli());
        //popularity.setText("Popularidad: "+item.getPopularity() + " %");
        popularity.setText("Popularidad: "+pelisCursor.getPopuPeli() + " %");
        //descripcio.setText("Sinopsis: "+item.getOverview());
        descripcio.setText("Sinopsis: " + pelisCursor.getSinopsisPeli());
        //final String urlPoster = "http://image.tmdb.org/t/p/";
        //final String definicionPoster = "w780";
        //Picasso.with(getContext()).load(urlPoster+definicionPoster+item.getPosterPath()).into(poster);
        Picasso.with(getContext()).load(pelisCursor.getPosterPeli()).into(poster);
        return view;
    }
}