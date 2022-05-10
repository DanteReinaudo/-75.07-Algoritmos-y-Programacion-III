package edu.fiuba.algo3.modelo;

public class LapizApoyado implements Lapiz {

    public void pintar(Trazo trazo, Pizarra pizarra) {
        pizarra.pintarTrazo(trazo);
    }
}