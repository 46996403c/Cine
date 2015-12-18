package com.example.oscarxiii.cine.provider.pelisprovidersource;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.oscarxiii.cine.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code pelisprovidersource} table.
 */
public class PelisprovidersourceContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PelisprovidersourceColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PelisprovidersourceSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PelisprovidersourceSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Titulo de la pelicula
     */
    public PelisprovidersourceContentValues putTituloPeli(@Nullable String value) {
        mContentValues.put(PelisprovidersourceColumns.TITULO_PELI, value);
        return this;
    }

    public PelisprovidersourceContentValues putTituloPeliNull() {
        mContentValues.putNull(PelisprovidersourceColumns.TITULO_PELI);
        return this;
    }

    /**
     * Fecha de salida de la pelicula.
     */
    public PelisprovidersourceContentValues putFechaPeli(@Nullable String value) {
        mContentValues.put(PelisprovidersourceColumns.FECHA_PELI, value);
        return this;
    }

    public PelisprovidersourceContentValues putFechaPeliNull() {
        mContentValues.putNull(PelisprovidersourceColumns.FECHA_PELI);
        return this;
    }

    /**
     * Popularidad de la pelicula
     */
    public PelisprovidersourceContentValues putPopuPli(@Nullable Double value) {
        mContentValues.put(PelisprovidersourceColumns.POPU_PLI, value);
        return this;
    }

    public PelisprovidersourceContentValues putPopuPliNull() {
        mContentValues.putNull(PelisprovidersourceColumns.POPU_PLI);
        return this;
    }

    /**
     * Sinopsis de la pelicula
     */
    public PelisprovidersourceContentValues putSinosisPeli(@Nullable String value) {
        mContentValues.put(PelisprovidersourceColumns.SINOSIS_PELI, value);
        return this;
    }

    public PelisprovidersourceContentValues putSinosisPeliNull() {
        mContentValues.putNull(PelisprovidersourceColumns.SINOSIS_PELI);
        return this;
    }

    /**
     * Poster de la pelicula
     */
    public PelisprovidersourceContentValues putPosterPeli(@Nullable String value) {
        mContentValues.put(PelisprovidersourceColumns.POSTER_PELI, value);
        return this;
    }

    public PelisprovidersourceContentValues putPosterPeliNull() {
        mContentValues.putNull(PelisprovidersourceColumns.POSTER_PELI);
        return this;
    }
}
