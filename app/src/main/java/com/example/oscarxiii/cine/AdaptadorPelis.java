package com.example.oscarxiii.cine;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.example.oscarxiii.cine.json.PelisPiojo;
import java.util.List;


/**
 * Created by Usuario on 09/11/2015.
 */
public class AdaptadorPelis extends ArrayAdapter<PelisPiojo>{
    public AdaptadorPelis(Context contexto, int recurso, List<PelisPiojo> objectos) {
        super(contexto, recurso, objectos);
    }

}
