package edu.fiuba.algo3.modelo;

public class BloqueLapizApoyado implements Bloque {

    @Override
    public Pizarra ejecutar(Personaje personaje) {
        return personaje.apoyarLapiz();
    }

    @Override
    public Pizarra ejecutarInvertido(Personaje personaje) {
        return personaje.levantarLapiz();
    }

    @Override
    public String obtenerNombre() {
        return "Apoyar Lapiz";
    }
}