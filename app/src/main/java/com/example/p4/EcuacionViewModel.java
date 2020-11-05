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

    public void calcular(double x2, double x, double num) {

        final SimuladorEcuacion.Solicitud solicitud = new SimuladorEcuacion.Solicitud(x2,x,num);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                simulador.calcular(solicitud, new SimuladorEcuacion.Callback() {
                    @Override
                    public void cuandoEsteCalculadaLaEcuacion(double ecuacioResultat) {
                        resultat.postValue(ecuacioResultat);
                    }
                });
            }
        });
    }
}
