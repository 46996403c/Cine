package com.example.oscarxiii.cine;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;

/**
 * Created by Usuario on 25/12/2015.
 */
public class ServicioActualizadorPelis extends GcmTaskService {
    private AdaptadorPelis adaptador;
    @Override
    public int onRunTask(TaskParams taskParams) {
        PelisApi apiClient = new PelisApi(this);
        apiClient.getMillorsPelicules(adaptador);
        apiClient.getMillorsPeliculesIngles(adaptador);
        apiClient.getPeliculesMesVistes(adaptador);
        apiClient.getPeliculesMesVistesIngles(adaptador);

        return 0;
    }
}