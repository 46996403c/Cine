package com.example.oscarxiii.cine.provider.pelisprovider;

import android.database.Cursor;
import android.support.annotation.Nullable;

import com.example.oscarxiii.cine.provider.base.AbstractCursor;

import java.util.Date;

/**
 * Cursor wrapper for the {@code pelisprovider} table.
 */
public class PelisproviderCursor extends AbstractCursor implements PelisproviderModel {
    public PelisproviderCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PelisproviderColumns._ID);
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
        String res = getStringOrNull(PelisproviderColumns.TITULO_PELI);
        return res;
    }

    /**
     * Fecha de salida de la pelicula.
     * Can be {@code null}.
     */
    @Nullable
    public String getFechaPeli() {
        String res = getStringOrNull(PelisproviderColumns.FECHA_PELI);
        return res;
    }

    /**
     * Popularidad de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    public Double getPopuPeli() {
        Double res = getDoubleOrNull(PelisproviderColumns.POPU_PELI);
        return res;
    }

    /**
     * Sinopsis de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    public String getSinopsisPeli() {
        String res = getStringOrNull(PelisproviderColumns.SINOPSIS_PELI);
        return res;
    }

    /**
     * Poster de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    public String getPosterPeli() {
        String res = getStringOrNull(PelisproviderColumns.POSTER_PELI);
        return res;
    }

    /**
     * Sincronizacion
     * Get the {@code sincro_time} value.
     * Can be {@code null}.
     */
    @Nullable
    public Date getSincroTime() {
        Date res = getDateOrNull(PelisproviderColumns.SINCRO_TIME);
        return res;
    }

    /**
     * Get the {@code list_peli} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getListPeli() {
        String res = getStringOrNull(PelisproviderColumns.LIST_PELI);
        return res;
    }
}
