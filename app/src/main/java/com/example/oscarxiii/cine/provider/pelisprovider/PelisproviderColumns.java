package com.example.oscarxiii.cine.provider.pelisprovider;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.oscarxiii.cine.provider.PelisProvider;

/**
 * BBDD de peliculas.
 */
public class PelisproviderColumns implements BaseColumns {
    public static final String TABLE_NAME = "pelisprovider";
    public static final Uri CONTENT_URI = Uri.parse(PelisProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Titulo de la pelicula
     */
    public static final String TITULO_PELI = "titulo_peli";

    /**
     * Fecha de salida de la pelicula.
     */
    public static final String FECHA_PELI = "fecha_peli";

    /**
     * Popularidad de la pelicula
     */
    public static final String POPU_PLI = "popu_pli";

    /**
     * Sinopsis de la pelicula
     */
    public static final String SINOPSIS_PELI = "sinopsis_peli";

    /**
     * Poster de la pelicula
     */
    public static final String POSTER_PELI = "poster_peli";


    public static final String DEFAULT_ORDER = TABLE_NAME + "" +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            TITULO_PELI,
            FECHA_PELI,
            POPU_PLI,
            SINOPSIS_PELI,
            POSTER_PELI
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TITULO_PELI) || c.contains("." + TITULO_PELI)) return true;
            if (c.equals(FECHA_PELI) || c.contains("." + FECHA_PELI)) return true;
            if (c.equals(POPU_PLI) || c.contains("." + POPU_PLI)) return true;
            if (c.equals(SINOPSIS_PELI) || c.contains("." + SINOPSIS_PELI)) return true;
            if (c.equals(POSTER_PELI) || c.contains("." + POSTER_PELI)) return true;
        }
        return false;
    }

}
