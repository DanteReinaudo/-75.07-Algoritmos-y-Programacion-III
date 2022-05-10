package edu.fiuba.algo3.modelo;

public class BloqueLapizLevantado implements Bloque {

    @Override
    public Pizarra ejecutar(Personaje personaje) {
        return personaje.levantarLapiz();
    }

    @Override
    public Pizarra ejecutarInvertido(Personaje personaje) {
        return personaje.apoyarLapiz();
    }

    @Override
    public String obtenerNombre() {
        return "Levantar Lapíz";
    }
}