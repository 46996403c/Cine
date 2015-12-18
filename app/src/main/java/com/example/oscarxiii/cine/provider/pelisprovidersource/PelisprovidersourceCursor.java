package com.example.oscarxiii.cine.provider.pelisprovidersource;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.oscarxiii.cine.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code pelisprovidersource} table.
 */
public class PelisprovidersourceCursor extends AbstractCursor implements PelisprovidersourceModel {
    public PelisprovidersourceCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PelisprovidersourceColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Titulo de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    public String getTituloPeli() {
        String res = getStringOrNull(PelisprovidersourceColumns.TITULO_PELI);
        return res;
    }

    /**
     * Fecha de salida de la pelicula.
     * Can be {@code null}.
     */
    @Nullable
    public String getFechaPeli() {
        String res = getStringOrNull(PelisprovidersourceColumns.FECHA_PELI);
        return res;
    }

    /**
     * Popularidad de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    public Double getPopuPli() {
        Double res = getDoubleOrNull(PelisprovidersourceColumns.POPU_PLI);
        return res;
    }

    /**
     * Sinopsis de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    public String getSinosisPeli() {
        String res = getStringOrNull(PelisprovidersourceColumns.SINOSIS_PELI);
        return res;
    }

    /**
     * Poster de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    public String getPosterPeli() {
        String res = getStringOrNull(PelisprovidersourceColumns.POSTER_PELI);
        return res;
    }
}
