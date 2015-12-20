package com.example.oscarxiii.cine.provider.pelisprovider;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.oscarxiii.cine.provider.base.AbstractSelection;

/**
 * Selection for the {@code pelisprovider} table.
 */
public class PelisproviderSelection extends AbstractSelection<PelisproviderSelection> {
    @Override
    protected Uri baseUri() {
        return PelisproviderColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PelisproviderCursor} object, which is positioned before the first entry, or null.
     */
    public PelisproviderCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PelisproviderCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PelisproviderCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PelisproviderCursor} object, which is positioned before the first entry, or null.
     */
    public PelisproviderCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PelisproviderCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PelisproviderCursor query(Context context) {
        return query(context, null);
    }


    public PelisproviderSelection id(long... value) {
        addEquals("pelisprovider." + PelisproviderColumns._ID, toObjectArray(value));
        return this;
    }

    public PelisproviderSelection idNot(long... value) {
        addNotEquals("pelisprovider." + PelisproviderColumns._ID, toObjectArray(value));
        return this;
    }

    public PelisproviderSelection orderById(boolean desc) {
        orderBy("pelisprovider." + PelisproviderColumns._ID, desc);
        return this;
    }

    public PelisproviderSelection orderById() {
        return orderById(false);
    }

    public PelisproviderSelection tituloPeli(String... value) {
        addEquals(PelisproviderColumns.TITULO_PELI, value);
        return this;
    }

    public PelisproviderSelection tituloPeliNot(String... value) {
        addNotEquals(PelisproviderColumns.TITULO_PELI, value);
        return this;
    }

    public PelisproviderSelection tituloPeliLike(String... value) {
        addLike(PelisproviderColumns.TITULO_PELI, value);
        return this;
    }

    public PelisproviderSelection tituloPeliContains(String... value) {
        addContains(PelisproviderColumns.TITULO_PELI, value);
        return this;
    }

    public PelisproviderSelection tituloPeliStartsWith(String... value) {
        addStartsWith(PelisproviderColumns.TITULO_PELI, value);
        return this;
    }

    public PelisproviderSelection tituloPeliEndsWith(String... value) {
        addEndsWith(PelisproviderColumns.TITULO_PELI, value);
        return this;
    }

    public PelisproviderSelection orderByTituloPeli(boolean desc) {
        orderBy(PelisproviderColumns.TITULO_PELI, desc);
        return this;
    }

    public PelisproviderSelection orderByTituloPeli() {
        orderBy(PelisproviderColumns.TITULO_PELI, false);
        return this;
    }

    public PelisproviderSelection fechaPeli(String... value) {
        addEquals(PelisproviderColumns.FECHA_PELI, value);
        return this;
    }

    public PelisproviderSelection fechaPeliNot(String... value) {
        addNotEquals(PelisproviderColumns.FECHA_PELI, value);
        return this;
    }

    public PelisproviderSelection fechaPeliLike(String... value) {
        addLike(PelisproviderColumns.FECHA_PELI, value);
        return this;
    }

    public PelisproviderSelection fechaPeliContains(String... value) {
        addContains(PelisproviderColumns.FECHA_PELI, value);
        return this;
    }

    public PelisproviderSelection fechaPeliStartsWith(String... value) {
        addStartsWith(PelisproviderColumns.FECHA_PELI, value);
        return this;
    }

    public PelisproviderSelection fechaPeliEndsWith(String... value) {
        addEndsWith(PelisproviderColumns.FECHA_PELI, value);
        return this;
    }

    public PelisproviderSelection orderByFechaPeli(boolean desc) {
        orderBy(PelisproviderColumns.FECHA_PELI, desc);
        return this;
    }

    public PelisproviderSelection orderByFechaPeli() {
        orderBy(PelisproviderColumns.FECHA_PELI, false);
        return this;
    }

    public PelisproviderSelection popuPli(Double... value) {
        addEquals(PelisproviderColumns.POPU_PLI, value);
        return this;
    }

    public PelisproviderSelection popuPliNot(Double... value) {
        addNotEquals(PelisproviderColumns.POPU_PLI, value);
        return this;
    }

    public PelisproviderSelection popuPliGt(double value) {
        addGreaterThan(PelisproviderColumns.POPU_PLI, value);
        return this;
    }

    public PelisproviderSelection popuPliGtEq(double value) {
        addGreaterThanOrEquals(PelisproviderColumns.POPU_PLI, value);
        return this;
    }

    public PelisproviderSelection popuPliLt(double value) {
        addLessThan(PelisproviderColumns.POPU_PLI, value);
        return this;
    }

    public PelisproviderSelection popuPliLtEq(double value) {
        addLessThanOrEquals(PelisproviderColumns.POPU_PLI, value);
        return this;
    }

    public PelisproviderSelection orderByPopuPli(boolean desc) {
        orderBy(PelisproviderColumns.POPU_PLI, desc);
        return this;
    }

    public PelisproviderSelection orderByPopuPli() {
        orderBy(PelisproviderColumns.POPU_PLI, false);
        return this;
    }

    public PelisproviderSelection sinopsisPeli(String... value) {
        addEquals(PelisproviderColumns.SINOPSIS_PELI, value);
        return this;
    }

    public PelisproviderSelection sinopsisPeliNot(String... value) {
        addNotEquals(PelisproviderColumns.SINOPSIS_PELI, value);
        return this;
    }

    public PelisproviderSelection sinopsisPeliLike(String... value) {
        addLike(PelisproviderColumns.SINOPSIS_PELI, value);
        return this;
    }

    public PelisproviderSelection sinopsisPeliContains(String... value) {
        addContains(PelisproviderColumns.SINOPSIS_PELI, value);
        return this;
    }

    public PelisproviderSelection sinopsisPeliStartsWith(String... value) {
        addStartsWith(PelisproviderColumns.SINOPSIS_PELI, value);
        return this;
    }

    public PelisproviderSelection sinopsisPeliEndsWith(String... value) {
        addEndsWith(PelisproviderColumns.SINOPSIS_PELI, value);
        return this;
    }

    public PelisproviderSelection orderBySinopsisPeli(boolean desc) {
        orderBy(PelisproviderColumns.SINOPSIS_PELI, desc);
        return this;
    }

    public PelisproviderSelection orderBySinopsisPeli() {
        orderBy(PelisproviderColumns.SINOPSIS_PELI, false);
        return this;
    }

    public PelisproviderSelection posterPeli(String... value) {
        addEquals(PelisproviderColumns.POSTER_PELI, value);
        return this;
    }

    public PelisproviderSelection posterPeliNot(String... value) {
        addNotEquals(PelisproviderColumns.POSTER_PELI, value);
        return this;
    }

    public PelisproviderSelection posterPeliLike(String... value) {
        addLike(PelisproviderColumns.POSTER_PELI, value);
        return this;
    }

    public PelisproviderSelection posterPeliContains(String... value) {
        addContains(PelisproviderColumns.POSTER_PELI, value);
        return this;
    }

    public PelisproviderSelection posterPeliStartsWith(String... value) {
        addStartsWith(PelisproviderColumns.POSTER_PELI, value);
        return this;
    }

    public PelisproviderSelection posterPeliEndsWith(String... value) {
        addEndsWith(PelisproviderColumns.POSTER_PELI, value);
        return this;
    }

    public PelisproviderSelection orderByPosterPeli(boolean desc) {
        orderBy(PelisproviderColumns.POSTER_PELI, desc);
        return this;
    }

    public PelisproviderSelection orderByPosterPeli() {
        orderBy(PelisproviderColumns.POSTER_PELI, false);
        return this;
    }
}
