package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.BloqueDerecha;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueDerechaTest {

    @Test
    public void ejecutarElBloqueMueveHaciaLaDerechaAlPersonaje() {
        BloqueDerecha bloque = new BloqueDerecha();
        Personaje personaje = new Personaje();
        bloque.ejecutar(personaje);
        Posicion coordenadas = new Posicion(1,0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void ejecutarInvertidoElBloqueMueveHaciaLaIzquierdaAlPersonaje() {
        BloqueDerecha bloque = new BloqueDerecha();
        Personaje personaje = new Personaje();
        bloque.ejecutarInvertido(personaje);
        Posicion coordenadas = new Posicion(-1,0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void elNombreDelBloqueEsElCorrecto() {
        BloqueDerecha bloque = new BloqueDerecha();
        assertEquals(bloque.obtenerNombre(), "Derecha");
    }

}