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
    public static final String POPU_PELI = "popu_peli";

    /**
     * Sinopsis de la pelicula
     */
    public static final String SINOPSIS_PELI = "sinopsis_peli";

    /**
     * Poster de la pelicula
     */
    public static final String POSTER_PELI = "poster_peli";

    /**
     * Sincronizacion
     */
    public static final String SINCRO_TIME = "sincro_time";

    /**
     * Actualizacion BBDD en pelisList
     */
    public static final String LIST_PELI = "list_peli";


    public static final String DEFAULT_ORDER = TABLE_NAME + "" +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            TITULO_PELI,
            FECHA_PELI,
            POPU_PELI,
            SINOPSIS_PELI,
            POSTER_PELI,
            SINCRO_TIME,
            LIST_PELI
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TITULO_PELI) || c.contains("." + TITULO_PELI)) return true;
            if (c.equals(FECHA_PELI) || c.contains("." + FECHA_PELI)) return true;
            if (c.equals(POPU_PELI) || c.contains("." + POPU_PELI)) return true;
            if (c.equals(SINOPSIS_PELI) || c.contains("." + SINOPSIS_PELI)) return true;
            if (c.equals(POSTER_PELI) || c.contains("." + POSTER_PELI)) return true;
            if (c.equals(SINCRO_TIME) || c.contains("." + SINCRO_TIME)) return true;
            if (c.equals(LIST_PELI) || c.contains("." + LIST_PELI)) return true;
        }
        return false;
    }

}
