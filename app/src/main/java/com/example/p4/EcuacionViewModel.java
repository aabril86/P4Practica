package com.example.p4;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EcuacionViewModel extends AndroidViewModel {

    Executor executor;
    SimuladorEcuacion simulador;
    MutableLiveData<Double> resultat = new MutableLiveData<>();

    public EcuacionViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simulador = new SimuladorEcuacion();
    }

    public void calcular(float x2, float x, float num) {

        final SimuladorEcuacion.Solicitud solicitud = new SimuladorEcuacion.Solicitud(x2,x,num);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                double ecuacioResultat = simulador.calcular(solicitud);
                resultat.postValue(ecuacioResultat);
            }
        });
    }
}
