package com.example.oscarxiii.cine.provider.pelisprovidersource;

import com.example.oscarxiii.cine.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * BBDD de peliculas.
 */
public interface PelisprovidersourceModel extends BaseModel {

    /**
     * Titulo de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    String getTituloPeli();

    /**
     * Fecha de salida de la pelicula.
     * Can be {@code null}.
     */
    @Nullable
    String getFechaPeli();

    /**
     * Popularidad de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    Double getPopuPli();

    /**
     * Sinopsis de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    String getSinosisPeli();

    /**
     * Poster de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    String getPosterPeli();
}
