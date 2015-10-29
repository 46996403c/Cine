package com.example.oscarxiii.cine;


import android.widget.ArrayAdapter;

import com.example.oscarxiii.cine.json.ApiData;
import com.example.oscarxiii.cine.json.Movie;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

public class PelisApi {
    //https://api.themoviedb.org/3/movie/550?api_key=c82d8a6c928270dc97f66357f99880a5
    final String BASE_URL = "https://api.themoviedb.org/3/movie/550?api_key=";
    final String API_KEY = "c82d8a6c928270dc97f66357f99880a5";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    cineInterface servicio = retrofit.create(cineInterface.class);

    public PelisApi() {
        super();
    }

    public void getPeliculesMesVistes(final ArrayAdapter adaptador) {
        Call<ApiData> llamada = servicio.getPeliculesMesVistes("es", API_KEY);
        llamada.enqueue(new Callback<ApiData>() {
            @Override
            public void onResponse(Response<ApiData> respuesta, Retrofit retrofit) {
                if (respuesta.isSuccess()) {
                    ApiData apiData = respuesta.body();
                    System.out.println("RESULTADO OK" + apiData.getMovies().toString());
                    adaptador.clear();
                    for (Movie peli : apiData.getMovies()) {
                        adaptador.add(peli.getTitle());
                    }
                }
                else{
                    System.out.println("RESULTADO FAIL: "+ respuesta.errorBody().toString());
                }
            }
            @Override
            public void onFailure(Throwable t) {
                System.out.println("RESULTADO FAIL --> onFailure");
            }
        });
    }
}

interface cineInterface {
    @GET("lists/movies/box_office.json")
    Call<ApiData> getPeliculesMesVistes(
        @Query("country") String pais,
        @Query("apikey") String apiKey
);

    @GET("lists/movies/upcoming.json")
    Call<ApiData> getProximesEstrenes(
        @Query("country") String pais,
        @Query("apikey") String apiKey);
}