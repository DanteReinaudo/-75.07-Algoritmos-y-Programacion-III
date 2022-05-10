package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.BloqueArriba;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueArribaTest {

    @Test
    public void ejecutarElBloqueMueveHaciaArribaAlPersonaje() {
        BloqueArriba bloque = new BloqueArriba();
        Personaje personaje = new Personaje();
        bloque.ejecutar(personaje);
        Posicion coordenadas = new Posicion(0,-1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void ejecutarInvertidoElBloqueMueveHaciaAbajoAlPersonaje() {
        BloqueArriba bloque = new BloqueArriba();
        Personaje personaje = new Personaje();
        bloque.ejecutarInvertido(personaje);
        Posicion coordenadas = new Posicion(0,1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void elNombreDelBloqueEsElCorrecto() {
        BloqueArriba bloque = new BloqueArriba();
        assertEquals(bloque.obtenerNombre(), "Arriba");
    }


}