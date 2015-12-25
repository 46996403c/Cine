package com.example.oscarxiii.cine;

import android.content.Context;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.TaskParams;

/**
 * Created by Usuario on 25/12/2015.
 */
public class ServicioActualizadorPelis extends GcmTaskService {
    private AdaptadorPelis adaptador;
    public static void runNow(Context contexto){
        OneoffTask tarea = new OneoffTask.Builder()
                .setExecutionWindow(0, 1)
                .setPersisted(true)
                .setRequiredNetwork(OneoffTask.NETWORK_STATE_CONNECTED)
                .setRequiresCharging(false)
                .setService(ServicioActualizadorPelis.class)
                .setTag("actualziar_pelis_ahora")
                .setUpdateCurrent(true)
                .build();
        GcmNetworkManager.getInstance(contexto).schedule(tarea);
    }

    public static void runDaily(Context context) {
        PeriodicTask tareaDiaria = new PeriodicTask.Builder()
                .setPeriod(24 * 60 * 60)
                .setPersisted(true)
                .setRequiredNetwork(OneoffTask.NETWORK_STATE_CONNECTED)
                .setRequiresCharging(false)
                .setService(ServicioActualizadorPelis.class)
                .setUpdateCurrent(false)
                .setTag("actualziar_pelis_diariamente")
                .build();
        GcmNetworkManager.getInstance(context).schedule(tareaDiaria);
    }

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