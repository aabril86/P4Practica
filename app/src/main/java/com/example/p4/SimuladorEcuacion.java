package com.example.p4;

import android.telecom.Call;

public class SimuladorEcuacion {

    public static class Solicitud {

        public double x2;
        public double x;
        public double num;

        public Solicitud(double x2, double x, double num) {
            this.x2 = x2;
            this.x = x;
            this.num = num;
        }
    }

    interface Callback {
        void cuandoEsteCalculadaLaEcuacion(double resultat);
    }

    public void calcular(Solicitud solicitud, Callback callback) {

        double res;

        try {

            Thread.sleep(2000);

        }catch (InterruptedException e) {}

        res = (solicitud.x * solicitud.x) - 4 * solicitud.x2 * solicitud.num;

        res = Math.sqrt(res);

        res = - solicitud.x + res;

        res = res / (2 * solicitud.x2);

        callback.cuandoEsteCalculadaLaEcuacion(res);
    }
}
