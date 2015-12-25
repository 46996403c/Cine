package com.example.oscarxiii.cine;


import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.oscarxiii.cine.json.PelisPiojo;
import com.example.oscarxiii.cine.json.Result;
import com.example.oscarxiii.cine.provider.pelisprovider.PelisproviderColumns;
import com.example.oscarxiii.cine.provider.pelisprovider.PelisproviderContentValues;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

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
/*    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    cineInterface servicio = retrofit.create(cineInterface.class);*/
    Retrofit retrofit;
    cineInterface servicio;
    private final Context contexto;
    //UpdatePelisTarea updatePelis = new UpdatePelisTarea();
    private final Handler handler;

    public PelisApi(Context context) {
        super();
        this.contexto = context;
        handler = new Handler(context.getMainLooper());
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        servicio = retrofit.create(cineInterface.class);
    }

    /**
     * Metodo donde se muestran las peliculas mas vistas, se hace una llamada desde la interfaz
     * @param //adaptador
     */
    //public void getPeliculesMesVistes(final ArrayAdapter<Result> adaptador) {
    public void getPeliculesMesVistes(SimpleCursorAdapter adaptador) {
    //public void getPeliculesMesVistes() {
        Call<PelisPiojo> llamada = servicio.getPeliculesMesVistes();
        llamada.enqueue(new Callback<PelisPiojo>() {
            @Override
            public void onResponse(Response<PelisPiojo> respuesta, Retrofit retrofit) {
                if (respuesta.isSuccess()) {
                    toast("Empezando sincronització");
                    PelisPiojo apiData = respuesta.body();
                    // System.out.println("RESULTADO OK" + apiData.getMovies().toString());
                    //adaptador.clear();
                    long sincoTime = System.currentTimeMillis();
                    /*
                    for (Movie peli : apiData.getMovies()) {
                        adaptador.add(peli.getTitle());
                    }
                    */
                    ArrayList<ContentValues> listaValores = new ArrayList<>();
                    ContentValues[] bulkParaInsertar;
                    List<ContentValues> listaValoresCV = new ArrayList<>();
                    for (Result peli : apiData.getResults()) {
                        //adaptador.add(peli);
                        PelisproviderContentValues valores = new PelisproviderContentValues();
                        valores.putTituloPeli(peli.getTitle());
                        valores.putFechaPeli(peli.getReleaseDate());
                        valores.putPopuPli(peli.getPopularity());
                        valores.putSinopsisPeli(peli.getOverview());
                        valores.putPosterPeli(peli.getPosterPath());
                        valores.putSincroTime(sincoTime);
                        valores.putListPelis(listaValores);
                        //Insertamos la pelicula
                        //contexto.getContentResolver().insert(PelisproviderColumns.CONTENT_URI, valores.values());
                        Picasso.with(contexto).load(peli.getPosterPath()).fetch();
                        listaValores.add(valores.values());
                        listaValoresCV.add(valores.values());
                    }
                    //Insertamos todas las peliculas
                    //contexto.getContentResolver().bulkInsert(PelisproviderColumns.CONTENT_URI, listaValores.toArray(new ContentValues[listaValores.size()]));
                    //updatePelis.execute();
                    bulkParaInsertar = new ContentValues[listaValoresCV.size()];
                    listaValoresCV.toArray(bulkParaInsertar);
                    contexto.getContentResolver().bulkInsert(PelisproviderColumns.CONTENT_URI, bulkParaInsertar);
                    toast("Sincronitzacion terminada con exito.");
                } else {
                    toast("No se ha podido sincronizar");
                    System.out.println("RESULTADO FAIL: " + respuesta.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("RESULTADO FAIL --> onFailure");
            }
        });
    }

    //public void getPeliculesMesVistesIngles(final ArrayAdapter<Result> adaptador) {
    public void getPeliculesMesVistesIngles(SimpleCursorAdapter adaptador) {
    //public void getPeliculesMesVistesIngles() {
        Call<PelisPiojo> llamada = servicio.getPeliculesMesVistesIngles();
        llamada.enqueue(new Callback<PelisPiojo>() {
            @Override
            public void onResponse(Response<PelisPiojo> respuesta, Retrofit retrofit) {
                if (respuesta.isSuccess()) {
                    toast("Empezando sincronització");
                    PelisPiojo apiData = respuesta.body();
                    // System.out.println("RESULTADO OK" + apiData.getMovies().toString());
                    //adaptador.clear();
                    long sincoTime = System.currentTimeMillis();
                    /*
                    for (Movie peli : apiData.getMovies()) {
                        adaptador.add(peli.getTitle());
                    }
                    */
                    ArrayList<ContentValues> listaValores = new ArrayList<>();
                    ContentValues[] bulkParaInsertar;
                    List<ContentValues> listaValoresCV = new ArrayList<>();
                    for (Result peli : apiData.getResults()) {
                        //adaptador.add(peli);
                        PelisproviderContentValues valores = new PelisproviderContentValues();
                        valores.putTituloPeli(peli.getTitle());
                        valores.putFechaPeli(peli.getReleaseDate());
                        valores.putPopuPli(peli.getPopularity());
                        valores.putSinopsisPeli(peli.getOverview());
                        valores.putPosterPeli(peli.getPosterPath());
                        valores.putSincroTime(sincoTime);
                        valores.putListPelis(listaValores);
                        //Insertamos la pelicula
                        //contexto.getContentResolver().insert(PelisproviderColumns.CONTENT_URI, valores.values());
                        Picasso.with(contexto).load(peli.getPosterPath()).fetch();
                        listaValores.add(valores.values());
                        listaValoresCV.add(valores.values());
                    }
                    //Insertamos todas las peliculas
                    //contexto.getContentResolver().bulkInsert(PelisproviderColumns.CONTENT_URI, listaValores.toArray(new ContentValues[listaValores.size()]));
                    //updatePelis.execute();
                    bulkParaInsertar = new ContentValues[listaValoresCV.size()];
                    listaValoresCV.toArray(bulkParaInsertar);
                    contexto.getContentResolver().bulkInsert(PelisproviderColumns.CONTENT_URI, bulkParaInsertar);
                    toast("Sincronitzacion terminada con exito.");
                } else {
                    toast("No se ha podido sincronizar");
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
     * @param //adaptador
     */
    //public void getMillorsPelicules(final ArrayAdapter<Result> adaptador) {
    public void getMillorsPelicules(SimpleCursorAdapter adaptador) {
    //public void getMillorsPelicules() {
        Call<PelisPiojo> llamada = servicio.getMillorsPelicules();
        llamada.enqueue(new Callback<PelisPiojo>() {
            @Override
            public void onResponse(Response<PelisPiojo> respuesta, Retrofit retrofit) {
                if (respuesta.isSuccess()) {
                    toast("Empezando sincronització");
                    PelisPiojo apiData = respuesta.body();
                    // System.out.println("RESULTADO OK" + apiData.getMovies().toString());
                    long sincoTime = System.currentTimeMillis();
                    //adaptador.clear();
                    ArrayList<ContentValues> listaValores = new ArrayList<>();
                    ContentValues[] bulkParaInsertar;
                    List<ContentValues> listaValoresCV = new ArrayList<>();
                    for (Result peli : apiData.getResults()) {
                        //adaptador.add(peli);
                        PelisproviderContentValues valores = new PelisproviderContentValues();
                        valores.putTituloPeli(peli.getTitle());
                        valores.putFechaPeli(peli.getReleaseDate());
                        valores.putPopuPli(peli.getPopularity());
                        valores.putSinopsisPeli(peli.getOverview());
                        valores.putPosterPeli(peli.getPosterPath());
                        valores.putSincroTime(sincoTime);
                        valores.putListPelis(listaValores);
                        //Insertamos la pelicula
                        //contexto.getContentResolver().insert(PelisproviderColumns.CONTENT_URI, valores.values());
                        Picasso.with(contexto).load(peli.getPosterPath()).fetch();
                        listaValores.add(valores.values());
                        listaValoresCV.add(valores.values());
                    }
                    //Insertamos todas las peliculas
                    //contexto.getContentResolver().bulkInsert(PelisproviderColumns.CONTENT_URI, listaValores.toArray(new ContentValues[listaValores.size()]));
                    //updatePelis.execute();
                    bulkParaInsertar = new ContentValues[listaValoresCV.size()];
                    listaValoresCV.toArray(bulkParaInsertar);
                    contexto.getContentResolver().bulkInsert(PelisproviderColumns.CONTENT_URI, bulkParaInsertar);
                    toast("Sincronitzacion terminada con exito.");
                }else{
                    toast("No se ha podido sincronizar");
                    System.out.println("RESULTADO FAIL: "+ respuesta.errorBody().toString());
                }
            }
            @Override
            public void onFailure(Throwable t) {
                System.out.println("RESULTADO FAIL --> onFailure");
            }
        });
    }

    //public void getMillorsPeliculesIngles(final ArrayAdapter<Result> adaptador) {
    public void getMillorsPeliculesIngles(SimpleCursorAdapter adaptador){
    //public void getMillorsPeliculesIngles(){
        Call<PelisPiojo> llamada = servicio.getMillorsPeliculesIngles();
        llamada.enqueue(new Callback<PelisPiojo>() {
            @Override
            public void onResponse(Response<PelisPiojo> respuesta, Retrofit retrofit) {
                if (respuesta.isSuccess()) {
                    toast("Empezando sincronització");
                    PelisPiojo apiData = respuesta.body();
                    // System.out.println("RESULTADO OK" + apiData.getMovies().toString());
                    long sincoTime = System.currentTimeMillis();
                    //adaptador.clear();
                    ArrayList<ContentValues> listaValores = new ArrayList<>();
                    ContentValues[] bulkParaInsertar;
                    List<ContentValues> listaValoresCV = new ArrayList<>();
                    for (Result peli : apiData.getResults()) {
                        //adaptador.add(peli);
                        PelisproviderContentValues valores = new PelisproviderContentValues();
                        valores.putTituloPeli(peli.getTitle());
                        valores.putFechaPeli(peli.getReleaseDate());
                        valores.putPopuPli(peli.getPopularity());
                        valores.putSinopsisPeli(peli.getOverview());
                        valores.putPosterPeli(peli.getPosterPath());
                        valores.putSincroTime(sincoTime);
                        valores.putListPelis(listaValores);
                        //Insertamos la pelicula
                        //contexto.getContentResolver().insert(PelisproviderColumns.CONTENT_URI, valores.values());
                        Picasso.with(contexto).load(peli.getPosterPath()).fetch();
                        listaValores.add(valores.values());
                        listaValoresCV.add(valores.values());
                    }
                    //Insertamos todas las peliculas
                    //contexto.getContentResolver().bulkInsert(PelisproviderColumns.CONTENT_URI, listaValores.toArray(new ContentValues[listaValores.size()]));
                    //updatePelis.execute();
                    bulkParaInsertar = new ContentValues[listaValoresCV.size()];
                    listaValoresCV.toArray(bulkParaInsertar);
                    contexto.getContentResolver().bulkInsert(PelisproviderColumns.CONTENT_URI, bulkParaInsertar);
                    toast("Sincronitzacion terminada con exito.");
                } else {
                    toast("No se ha podido sincronizar");
                    System.out.println("RESULTADO FAIL: " + respuesta.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("RESULTADO FAIL --> onFailure");
            }
        });
    }
    private void borrarPelisViejas(long sincroTime) {
        contexto.getContentResolver().delete(
                PelisproviderColumns.CONTENT_URI,
                PelisproviderColumns.SINCRO_TIME + " < ?",
                new String[]{Long.toString(sincroTime)});
    }

    private void toast(final String text) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(contexto, text, Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * Interfaces donde se hace la llamada a los metodos segun la opcion que este seleccionada.
     */
    interface cineInterface {
        //url donde se pasa la api y los requisitos de visrualizacion
        @GET("discover/movie?sort_by=popularity.desc&api_key=c82d8a6c928270dc97f66357f99880a5&language=es&include_image_language=es")
        Call<PelisPiojo> getPeliculesMesVistes();

        @GET("discover/movie?sort_by=popularity.desc&api_key=c82d8a6c928270dc97f66357f99880a5&language=en&include_image_language=en")
        Call<PelisPiojo> getPeliculesMesVistesIngles();

        //url donde se pasa la api y los requisitos de visrualizacion
        @GET("movie/top_rated?api_key=c82d8a6c928270dc97f66357f99880a5&language=es&include_image_language=es")
        Call<PelisPiojo> getMillorsPelicules();

        @GET("movie/top_rated?api_key=c82d8a6c928270dc97f66357f99880a5&language=en&include_image_language=en")
        Call<PelisPiojo> getMillorsPeliculesIngles();

    }

   /* class UpdatePelisTarea extends AsyncTask {
        private AdaptadorPelis adaptador;
        @Override
        protected Object doInBackground(Object[] params) {
            long sincroTime = System.currentTimeMillis();
            getPeliculesMesVistes(adaptador);
            getPeliculesMesVistesIngles(adaptador);
            getMillorsPelicules(adaptador);
            getMillorsPeliculesIngles(adaptador);
            borrarPelisViejas(sincroTime);
            return null;
        }
    }*/

}



