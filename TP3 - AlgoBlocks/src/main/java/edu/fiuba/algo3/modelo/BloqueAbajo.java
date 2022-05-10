package edu.fiuba.algo3.modelo;

public class BloqueAbajo implements Bloque {

    @Override
    public Pizarra ejecutar(Personaje personaje) {
        return personaje.moverHaciaAbajo();
    }

    @Override
    public Pizarra ejecutarInvertido(Personaje personaje) {
        return personaje.moverHaciaArriba();
    }

    @Override
    public String obtenerNombre() {
        return "Abajo";
    }
}