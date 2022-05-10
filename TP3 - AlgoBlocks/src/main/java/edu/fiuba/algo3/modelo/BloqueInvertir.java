package edu.fiuba.algo3.modelo;

public class BloqueInvertir extends ConjuntoBloques {

    @Override
    public Pizarra ejecutar(Personaje personaje) {
        return super.ejecutarInvertido(personaje);
    }

    @Override
    public Pizarra ejecutarInvertido(Personaje personaje) {
        return super.ejecutar(personaje);
    }

    @Override
    public String obtenerNombre() {
        return "Invertir Comportamiento";
    }
}