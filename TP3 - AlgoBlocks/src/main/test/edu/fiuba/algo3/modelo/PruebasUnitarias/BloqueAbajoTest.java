package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.BloqueAbajo;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueAbajoTest {

    @Test
    public void ejecutarElBloqueMueveHaciaAbajoAlPersonaje() {
        BloqueAbajo bloque = new BloqueAbajo();
        Personaje personaje = new Personaje();
        bloque.ejecutar(personaje);
        Posicion coordenadas = new Posicion(0,1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }


    @Test
    public void ejecutarInvertidoElBloqueMueveHaciaArribaAlPersonaje() {
        BloqueAbajo bloque = new BloqueAbajo();
        Personaje personaje = new Personaje();
        bloque.ejecutarInvertido(personaje);
        Posicion coordenadas = new Posicion(0,-1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void elNombreDelBloqueEsElCorrecto() {
        BloqueAbajo bloque = new BloqueAbajo();
        assertEquals(bloque.obtenerNombre(), "Abajo");
    }

}