package com.example.oscarxiii.cine.provider.pelisprovidersource;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.oscarxiii.cine.provider.base.AbstractSelection;

/**
 * Selection for the {@code pelisprovidersource} table.
 */
public class PelisprovidersourceSelection extends AbstractSelection<PelisprovidersourceSelection> {
    @Override
    protected Uri baseUri() {
        return PelisprovidersourceColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PelisprovidersourceCursor} object, which is positioned before the first entry, or null.
     */
    public PelisprovidersourceCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PelisprovidersourceCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PelisprovidersourceCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PelisprovidersourceCursor} object, which is positioned before the first entry, or null.
     */
    public PelisprovidersourceCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PelisprovidersourceCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PelisprovidersourceCursor query(Context context) {
        return query(context, null);
    }


    public PelisprovidersourceSelection id(long... value) {
        addEquals("pelisprovidersource." + PelisprovidersourceColumns._ID, toObjectArray(value));
        return this;
    }

    public PelisprovidersourceSelection idNot(long... value) {
        addNotEquals("pelisprovidersource." + PelisprovidersourceColumns._ID, toObjectArray(value));
        return this;
    }

    public PelisprovidersourceSelection orderById(boolean desc) {
        orderBy("pelisprovidersource." + PelisprovidersourceColumns._ID, desc);
        return this;
    }

    public PelisprovidersourceSelection orderById() {
        return orderById(false);
    }

    public PelisprovidersourceSelection tituloPeli(String... value) {
        addEquals(PelisprovidersourceColumns.TITULO_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection tituloPeliNot(String... value) {
        addNotEquals(PelisprovidersourceColumns.TITULO_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection tituloPeliLike(String... value) {
        addLike(PelisprovidersourceColumns.TITULO_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection tituloPeliContains(String... value) {
        addContains(PelisprovidersourceColumns.TITULO_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection tituloPeliStartsWith(String... value) {
        addStartsWith(PelisprovidersourceColumns.TITULO_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection tituloPeliEndsWith(String... value) {
        addEndsWith(PelisprovidersourceColumns.TITULO_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection orderByTituloPeli(boolean desc) {
        orderBy(PelisprovidersourceColumns.TITULO_PELI, desc);
        return this;
    }

    public PelisprovidersourceSelection orderByTituloPeli() {
        orderBy(PelisprovidersourceColumns.TITULO_PELI, false);
        return this;
    }

    public PelisprovidersourceSelection fechaPeli(String... value) {
        addEquals(PelisprovidersourceColumns.FECHA_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection fechaPeliNot(String... value) {
        addNotEquals(PelisprovidersourceColumns.FECHA_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection fechaPeliLike(String... value) {
        addLike(PelisprovidersourceColumns.FECHA_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection fechaPeliContains(String... value) {
        addContains(PelisprovidersourceColumns.FECHA_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection fechaPeliStartsWith(String... value) {
        addStartsWith(PelisprovidersourceColumns.FECHA_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection fechaPeliEndsWith(String... value) {
        addEndsWith(PelisprovidersourceColumns.FECHA_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection orderByFechaPeli(boolean desc) {
        orderBy(PelisprovidersourceColumns.FECHA_PELI, desc);
        return this;
    }

    public PelisprovidersourceSelection orderByFechaPeli() {
        orderBy(PelisprovidersourceColumns.FECHA_PELI, false);
        return this;
    }

    public PelisprovidersourceSelection popuPli(Double... value) {
        addEquals(PelisprovidersourceColumns.POPU_PLI, value);
        return this;
    }

    public PelisprovidersourceSelection popuPliNot(Double... value) {
        addNotEquals(PelisprovidersourceColumns.POPU_PLI, value);
        return this;
    }

    public PelisprovidersourceSelection popuPliGt(double value) {
        addGreaterThan(PelisprovidersourceColumns.POPU_PLI, value);
        return this;
    }

    public PelisprovidersourceSelection popuPliGtEq(double value) {
        addGreaterThanOrEquals(PelisprovidersourceColumns.POPU_PLI, value);
        return this;
    }

    public PelisprovidersourceSelection popuPliLt(double value) {
        addLessThan(PelisprovidersourceColumns.POPU_PLI, value);
        return this;
    }

    public PelisprovidersourceSelection popuPliLtEq(double value) {
        addLessThanOrEquals(PelisprovidersourceColumns.POPU_PLI, value);
        return this;
    }

    public PelisprovidersourceSelection orderByPopuPli(boolean desc) {
        orderBy(PelisprovidersourceColumns.POPU_PLI, desc);
        return this;
    }

    public PelisprovidersourceSelection orderByPopuPli() {
        orderBy(PelisprovidersourceColumns.POPU_PLI, false);
        return this;
    }

    public PelisprovidersourceSelection sinosisPeli(String... value) {
        addEquals(PelisprovidersourceColumns.SINOSIS_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection sinosisPeliNot(String... value) {
        addNotEquals(PelisprovidersourceColumns.SINOSIS_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection sinosisPeliLike(String... value) {
        addLike(PelisprovidersourceColumns.SINOSIS_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection sinosisPeliContains(String... value) {
        addContains(PelisprovidersourceColumns.SINOSIS_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection sinosisPeliStartsWith(String... value) {
        addStartsWith(PelisprovidersourceColumns.SINOSIS_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection sinosisPeliEndsWith(String... value) {
        addEndsWith(PelisprovidersourceColumns.SINOSIS_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection orderBySinosisPeli(boolean desc) {
        orderBy(PelisprovidersourceColumns.SINOSIS_PELI, desc);
        return this;
    }

    public PelisprovidersourceSelection orderBySinosisPeli() {
        orderBy(PelisprovidersourceColumns.SINOSIS_PELI, false);
        return this;
    }

    public PelisprovidersourceSelection posterPeli(String... value) {
        addEquals(PelisprovidersourceColumns.POSTER_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection posterPeliNot(String... value) {
        addNotEquals(PelisprovidersourceColumns.POSTER_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection posterPeliLike(String... value) {
        addLike(PelisprovidersourceColumns.POSTER_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection posterPeliContains(String... value) {
        addContains(PelisprovidersourceColumns.POSTER_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection posterPeliStartsWith(String... value) {
        addStartsWith(PelisprovidersourceColumns.POSTER_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection posterPeliEndsWith(String... value) {
        addEndsWith(PelisprovidersourceColumns.POSTER_PELI, value);
        return this;
    }

    public PelisprovidersourceSelection orderByPosterPeli(boolean desc) {
        orderBy(PelisprovidersourceColumns.POSTER_PELI, desc);
        return this;
    }

    public PelisprovidersourceSelection orderByPosterPeli() {
        orderBy(PelisprovidersourceColumns.POSTER_PELI, false);
        return this;
    }
}
