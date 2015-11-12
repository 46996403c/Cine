package com.example.oscarxiii.cine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscarxiii.cine.json.Result;

public class DetallesFragment extends Fragment {
    private TextView titulo;
    private TextView data;
    private TextView popularity;
    private TextView descripcio;

    public DetallesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalles, container, false);
        Intent i = getActivity().getIntent();
        Result item = (Result) i.getSerializableExtra("item");

        titulo = (TextView) view.findViewById(R.id.tvTituloPelis);
        data = (TextView) view.findViewById(R.id.tvEstrenosPelis);
        popularity = (TextView) view.findViewById(R.id.tvPelisPopus);
        descripcio = (TextView) view.findViewById(R.id.tvDescripcion);

        Toast.makeText(getContext(), item.getOriginalTitle(), Toast.LENGTH_LONG).show();

        titulo.setText("Titulo: "+item.getTitle());
        data.setText("Fecha de salida: "+item.getReleaseDate());
        popularity.setText("Popularidad: "+item.getPopularity() + " %");
        descripcio.setText("Sinopsis: "+item.getOverview());

        return view;
    }
}