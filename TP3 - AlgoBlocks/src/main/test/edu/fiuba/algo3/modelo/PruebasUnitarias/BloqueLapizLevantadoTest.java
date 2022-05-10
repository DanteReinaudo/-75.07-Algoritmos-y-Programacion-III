package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueLapizLevantadoTest {

    @Test
    public void ejecutarElBloqueLapizLevantadoNoPintaSobreLaPizarra() {
        BloqueLapizLevantado bloqueLapiz = new BloqueLapizLevantado();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        Personaje personaje = new Personaje();
        bloqueDerecha.ejecutar(personaje);
        Pizarra pizarra = new Pizarra();
        assertEquals(bloqueLapiz.ejecutar(personaje), pizarra);
    }

    @Test
    public void ejecutarInvertidoElBloqueLapizLevantadoPintaSobreLaPizarra() {
        BloqueLapizLevantado bloqueLapiz = new BloqueLapizLevantado();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        Personaje personaje = new Personaje();
        bloqueLapiz.ejecutarInvertido(personaje);
        bloqueDerecha.ejecutar(personaje);
        Pizarra pizarra = new Pizarra();
        Trazo trazo  = new Trazo(new Posicion(0,0), new Posicion(1,0));
        pizarra.pintarTrazo(trazo);
        assertEquals(bloqueLapiz.ejecutarInvertido(personaje), pizarra);
    }

    @Test
    public void elNombreDelBloqueEsElCorrecto() {
        BloqueLapizLevantado bloque = new BloqueLapizLevantado();
        assertEquals(bloque.obtenerNombre(), "Levantar Lapíz");
    }


}