package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.BloqueIzquierda;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueIzquierdaTest {

    @Test
    public void ejecutarElBloqueMueveHaciaLaIzquierdaAlPersonaje() {
        BloqueIzquierda bloque = new BloqueIzquierda();
        Personaje personaje = new Personaje();
        bloque.ejecutar(personaje);
        Posicion coordenadas = new Posicion(-1,0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void ejecutarInvertidoElBloqueMueveHaciaLaDerechaAlPersonaje() {
        BloqueIzquierda bloque = new BloqueIzquierda();
        Personaje personaje = new Personaje();
        bloque.ejecutarInvertido(personaje);
        Posicion coordenadas = new Posicion(1,0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void elNombreDelBloqueEsElCorrecto() {
        BloqueIzquierda bloque = new BloqueIzquierda();
        assertEquals(bloque.obtenerNombre(), "Izquierda");
    }

}