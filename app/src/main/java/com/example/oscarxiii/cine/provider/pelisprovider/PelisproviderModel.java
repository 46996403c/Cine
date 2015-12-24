package com.example.oscarxiii.cine.provider.pelisprovider;

import android.support.annotation.Nullable;

import com.example.oscarxiii.cine.provider.base.BaseModel;

import java.util.Date;

/**
 * BBDD de peliculas.
 */
public interface PelisproviderModel extends BaseModel {

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
    Double getPopuPeli();

    /**
     * Sinopsis de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    String getSinopsisPeli();

    /**
     * Poster de la pelicula
     * Can be {@code null}.
     */
    @Nullable
    String getPosterPeli();

    /**
     * Sincronizacion
     * Get the {@code sincro_time} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getSincroTime();

    /**
    * Actualizacion BBDD en pelisList
    * Get the {@code list_peli} value.
    * Can be {@code null}.
    */
    @Nullable
    String getListPeli();
}
