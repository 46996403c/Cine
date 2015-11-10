package com.example.oscarxiii.cine;


import android.widget.ArrayAdapter;

import com.example.oscarxiii.cine.json.PelisPiojo;
import com.example.oscarxiii.cine.json.Result;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;

public class PelisApi {
    //https://api.themoviedb.org/3/movie/550?api_key=c82d8a6c928270dc97f66357f99880a5
    final String BASE_URL = "https://api.themoviedb.org/3/"; //Base de url donde se pasa la informacion de la api
    final String API_KEY = "c82d8a6c928270dc97f66357f99880a5";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    cineInterface servicio = retrofit.create(cineInterface.class);

    public PelisApi() {
        super();
    }

    /**
     * Metodo donde se muestran las peliculas mas vistas, se hace una llamada desde la interfaz
     * @param adaptador
     */
    public void getPeliculesMesVistes(final ArrayAdapter<Result> adaptador) {
        Call<PelisPiojo> llamada = servicio.getPeliculesMesVistes();
        llamada.enqueue(new Callback<PelisPiojo>() {
            @Override
            public void onResponse(Response<PelisPiojo> respuesta, Retrofit retrofit) {
                if (respuesta.isSuccess()) {
                    PelisPiojo apiData = respuesta.body();
                    // System.out.println("RESULTADO OK" + apiData.getMovies().toString());
                    adaptador.clear();
                    /*
                    for (Movie peli : apiData.getMovies()) {
                        adaptador.add(peli.getTitle());
                    }
                    */
                    for (Result peli : apiData.getResults()) {
                        adaptador.add(peli);
                    }
                } else {
                    System.out.println("RESULTADO FAIL: " + respuesta.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("RESULTADO FAIL --> onFailure");
            }
        });
    }
    /**
     * Metodo donde se muestran las peliculas mejor valoradas, se hace una llamada desde la interfaz
     * @param adaptador
     */
    public void getMillorsPelicules(final ArrayAdapter<Result> adaptador) {
        Call<PelisPiojo> llamada = servicio.getMillorsPelicules();
        llamada.enqueue(new Callback<PelisPiojo>() {
            @Override
            public void onResponse(Response<PelisPiojo> respuesta, Retrofit retrofit) {
                if (respuesta.isSuccess()) {
                    PelisPiojo apiData = respuesta.body();
                    // System.out.println("RESULTADO OK" + apiData.getMovies().toString());
                    adaptador.clear();
                    for (Result peli : apiData.getResults()){
                        adaptador.add(peli);
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

/**
 * Interfaces donde se hace la llamada a los metodos segun la opcion que este seleccionada.
 */
interface cineInterface {
    //url donde se pasa la api y los requisitos de visrualizacion
    @GET("discover/movie?sort_by=popularity.desc&api_key=c82d8a6c928270dc97f66357f99880a5")
    Call<PelisPiojo> getPeliculesMesVistes();

    //url donde se pasa la api y los requisitos de visrualizacion
    @GET("movie/top_rated?api_key=c82d8a6c928270dc97f66357f99880a5")
    Call<PelisPiojo> getMillorsPelicules();
}