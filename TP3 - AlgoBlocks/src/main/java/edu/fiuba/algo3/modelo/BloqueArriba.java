package edu.fiuba.algo3.modelo;

public class BloqueArriba implements Bloque {

    @Override
    public Pizarra ejecutar(Personaje personaje) {
        return personaje.moverHaciaArriba();
    }

    @Override
    public Pizarra ejecutarInvertido(Personaje personaje) {
        return personaje.moverHaciaAbajo();
    }

    @Override
    public String obtenerNombre() {
        return "Arriba";
    }
}