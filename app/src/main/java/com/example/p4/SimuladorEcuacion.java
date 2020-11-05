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

        void cuandoHayaErrorDeX2IgualACero(double x2Cero);

        void cuandoHayaErrorDeRaiz(int raizMinima);
    }

    public void calcular(Solicitud solicitud, Callback callback) {

        double res, sqrt;
        double x2Cero = 0;
        int raizMinima = 0;

        try {

            Thread.sleep(2000);

        } catch (InterruptedException e) {
        }

        res = (solicitud.x * solicitud.x) - 4 * solicitud.x2 * solicitud.num;

        sqrt = Math.sqrt(res);


        boolean error = false;

        if (solicitud.x2 == x2Cero) {
            callback.cuandoHayaErrorDeX2IgualACero(x2Cero);
            error = true;
        }

        if (res < raizMinima) {
            callback.cuandoHayaErrorDeRaiz(raizMinima);
            error = true;
        }

        if (!error) {

            res = -solicitud.x + sqrt;

            res = res / (2 * solicitud.x2);

            callback.cuandoEsteCalculadaLaEcuacion(res);

        }

    }
}
