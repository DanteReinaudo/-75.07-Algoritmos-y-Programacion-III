package edu.fiuba.algo3.modelo;

public class BloqueIzquierda implements Bloque {

    @Override
    public Pizarra ejecutar(Personaje personaje) {
        return personaje.moverHaciaLaIzquierda();
    }

    @Override
    public Pizarra ejecutarInvertido(Personaje personaje) {
        return personaje.moverHaciaLaDerecha();
    }

    @Override
    public String obtenerNombre() {
        return "Izquierda";
    }
}