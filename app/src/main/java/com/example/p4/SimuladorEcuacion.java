package com.example.p4;

public class SimuladorEcuacion {

    public static class Solicitud {

        public float x2;
        public float x;
        public float num;

        public Solicitud(float x2, float x, float num) {
            this.x2 = x2;
            this.x = x;
            this.num = num;
        }
    }

    public double calcular(Solicitud solicitud) {

        double res;

        try {

            Thread.sleep(2000);

        }catch (InterruptedException e) {}

        res = (solicitud.x * solicitud.x) - (4 * solicitud.x2 * solicitud.num);

        res = Math.sqrt(res);

        res = - solicitud.x + res;

        res = res / (2 * solicitud.x2);

        return res;
    }
}
