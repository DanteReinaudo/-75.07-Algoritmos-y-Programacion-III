package edu.fiuba.algo3.modelo;

public class BloqueRepetir extends ConjuntoBloques {

    private final int cantIteraciones;

    public BloqueRepetir(int cantIteraciones) {
        super();
        this.cantIteraciones = cantIteraciones;
    }

    @Override
    public Pizarra ejecutar(Personaje personaje) {
        Pizarra pizarra = new Pizarra();
        for (int i = 0; i < cantIteraciones; i++) {
            pizarra = super.ejecutar(personaje);
        }
        return pizarra;
    }

    @Override
    public Pizarra ejecutarInvertido(Personaje personaje) {
        Pizarra pizarra = new Pizarra();
        for (int i = 0; i < cantIteraciones; i++) {
            pizarra = super.ejecutarInvertido(personaje);
        }
        return pizarra;
    }

    @Override
    public String obtenerNombre() {
        return "RepetirX" + cantIteraciones;
    }
}