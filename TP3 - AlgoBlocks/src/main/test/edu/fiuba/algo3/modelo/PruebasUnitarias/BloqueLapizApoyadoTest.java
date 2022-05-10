package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloqueLapizApoyadoTest {

    @Test
    public void ejecutarElBloqueLapizApoyadoPintaSobreLaPizarra() {
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        Personaje personaje = new Personaje();
        bloqueLapiz.ejecutar(personaje);
        bloqueDerecha.ejecutar(personaje);
        Pizarra pizarra = new Pizarra();
        Trazo trazo = new Trazo(new Posicion(0,0), new Posicion(1,0));
        pizarra.pintarTrazo(trazo);
        assertEquals(bloqueLapiz.ejecutar(personaje), pizarra);
    }

    @Test
    public void ejecutarInvertidoElBloqueLapizApoyadoNoPintaSobreLaPizarra() {
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        Personaje personaje = new Personaje();
        bloqueDerecha.ejecutar(personaje);
        Pizarra pizarra = new Pizarra();
        assertEquals(bloqueLapiz.ejecutarInvertido(personaje) ,pizarra);
    }

    @Test
    public void elNombreDelBloqueEsElCorrecto() {
        BloqueLapizApoyado bloque = new BloqueLapizApoyado();
        assertEquals(bloque.obtenerNombre(), "Apoyar Lapiz");
    }

}