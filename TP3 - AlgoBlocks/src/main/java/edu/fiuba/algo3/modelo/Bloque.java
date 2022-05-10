package edu.fiuba.algo3.modelo;

public interface Bloque {

    Pizarra ejecutar(Personaje personaje);
    Pizarra ejecutarInvertido(Personaje personaje);
    String obtenerNombre();
}