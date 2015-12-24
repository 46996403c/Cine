package com.example.oscarxiii.cine.provider.pelisprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.oscarxiii.cine.provider.base.AbstractContentValues;

import java.util.ArrayList;
import java.util.Date;

/**
 * Content values wrapper for the {@code pelisprovider} table.
 */
public class PelisproviderContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PelisproviderColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PelisproviderSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param //contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PelisproviderSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Titulo de la pelicula
     */
    public PelisproviderContentValues putTituloPeli(@Nullable String value) {
        mContentValues.put(PelisproviderColumns.TITULO_PELI, value);
        return this;
    }

    public PelisproviderContentValues putTituloPeliNull() {
        mContentValues.putNull(PelisproviderColumns.TITULO_PELI);
        return this;
    }

    /**
     * Fecha de salida de la pelicula.
     */
    public PelisproviderContentValues putFechaPeli(@Nullable String value) {
        mContentValues.put(PelisproviderColumns.FECHA_PELI, value);
        return this;
    }

    public PelisproviderContentValues putFechaPeliNull() {
        mContentValues.putNull(PelisproviderColumns.FECHA_PELI);
        return this;
    }

    /**
     * Popularidad de la pelicula
     */
    public PelisproviderContentValues putPopuPli(@Nullable Double value) {
        mContentValues.put(PelisproviderColumns.POPU_PELI, value);
        return this;
    }

    public PelisproviderContentValues putPopuPliNull() {
        mContentValues.putNull(PelisproviderColumns.POPU_PELI);
        return this;
    }

    /**
     * Sinopsis de la pelicula
     */
    public PelisproviderContentValues putSinopsisPeli(@Nullable String value) {
        mContentValues.put(PelisproviderColumns.SINOPSIS_PELI, value);
        return this;
    }

    public PelisproviderContentValues putSinopsisPeliNull() {
        mContentValues.putNull(PelisproviderColumns.SINOPSIS_PELI);
        return this;
    }

    /**
     * Poster de la pelicula
     */
    public PelisproviderContentValues putPosterPeli(@Nullable String value) {
        mContentValues.put(PelisproviderColumns.POSTER_PELI, value);
        return this;
    }

    public PelisproviderContentValues putPosterPeliNull() {
        mContentValues.putNull(PelisproviderColumns.POSTER_PELI);
        return this;
    }

    /**
     * Sincronizacion
     */
    public PelisproviderContentValues putSincroTime(@Nullable Date value) {
        mContentValues.put(PelisproviderColumns.SINCRO_TIME, value == null ? null : value.getTime());
        return this;
    }

    public PelisproviderContentValues putSincroTimeNull() {
        mContentValues.putNull(PelisproviderColumns.SINCRO_TIME);
        return this;
    }

    public PelisproviderContentValues putSincroTime(@Nullable Long value) {
        mContentValues.put(PelisproviderColumns.SINCRO_TIME, value);
        return this;
    }

    /**
     * Actualizacion BBDD en pelisList
     * @param value
     */
    public PelisproviderContentValues putListPelis(@Nullable ArrayList<ContentValues> value) {
        mContentValues.put(PelisproviderColumns.LIST_PELI, String.valueOf(value));
        return this;
    }
    public PelisproviderContentValues putListPelisNull() {
        mContentValues.putNull(PelisproviderColumns.LIST_PELI);
        return this;
    }
}
