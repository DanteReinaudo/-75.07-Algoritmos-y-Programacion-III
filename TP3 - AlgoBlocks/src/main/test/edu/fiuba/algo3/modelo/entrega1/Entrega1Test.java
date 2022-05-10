package edu.fiuba.algo3.modelo.entrega1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1Test {

    @Test
    public void testElPersonajeSeMueveHaciaArribaConBloque() {
        Personaje personaje = new Personaje();
        BloqueArriba bloque = new BloqueArriba();
        bloque.ejecutar(personaje);
        Posicion coordenadas = new Posicion(0,-1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeSeMueveHaciaAbajoConBloque() {
        Personaje personaje = new Personaje();
        BloqueAbajo bloque = new BloqueAbajo();
        bloque.ejecutar(personaje);
        Posicion coordenadas = new Posicion(0,1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeSeMueveHaciaLaIzquierdaConBloque() {
        Personaje personaje = new Personaje();
        BloqueIzquierda bloque = new BloqueIzquierda();
        bloque.ejecutar(personaje);
        Posicion coordenadas = new Posicion(-1,0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeSeMueveHaciaLaDerechaConBloque() {
        Personaje personaje = new Personaje();
        BloqueDerecha bloque = new BloqueDerecha();
        bloque.ejecutar(personaje);
        Posicion coordenadas = new Posicion(1,0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testSeCreaPersonajeConElLapizLevantado() {
        Personaje personaje = new Personaje();
        BloqueArriba bloqueArriba = new BloqueArriba();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        bloqueArriba.ejecutar(personaje);
        bloqueDerecha.ejecutar(personaje);
        Pizarra pizarra = new Pizarra();
        assertEquals(bloqueDerecha.ejecutar(personaje),pizarra);
    }

    @Test
    public void testElPersonajeDibujaConElLapizAbajo() {
        Personaje personaje = new Personaje();
        BloqueLapizApoyado bloque = new BloqueLapizApoyado();
        BloqueArriba bloqueArriba = new BloqueArriba();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();

        bloque.ejecutar(personaje);
        bloqueArriba.ejecutar(personaje);
        bloqueDerecha.ejecutar(personaje);

        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo( new Posicion(0,0), new Posicion(0,-1));
        Trazo trazo2 = new Trazo( new Posicion(0,-1), new Posicion(1,-1));
        Trazo trazo3 = new Trazo( new Posicion(1,-1), new Posicion(2,-1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);
        pizarra.pintarTrazo(trazo3);

        assertEquals(bloqueDerecha.ejecutar(personaje), pizarra);
    }

    @Test
    public void testElPersonajeSeMuevePrimeroConElLapizArribaYDespuesConElLapizAbajo() {
        Personaje personaje = new Personaje();
        Pizarra pizarra = new Pizarra();

        BloqueAbajo bloqueAbajo = new BloqueAbajo();
        BloqueDerecha bloqueDerecha = new BloqueDerecha();
        bloqueAbajo.ejecutar(personaje);

        assertEquals(bloqueDerecha.ejecutar(personaje), pizarra);

        BloqueLapizApoyado bloqueApoyado = new BloqueLapizApoyado();
        bloqueApoyado.ejecutar(personaje);

        Trazo trazo = new Trazo(new Posicion(1,1) , new Posicion(2,1));
        pizarra.pintarTrazo(trazo);

        assertEquals(bloqueDerecha.ejecutar(personaje), pizarra);
    }


}
