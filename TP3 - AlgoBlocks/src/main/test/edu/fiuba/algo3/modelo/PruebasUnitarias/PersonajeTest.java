package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.Pizarra;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Trazo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonajeTest {

    @Test
    public void testElPersonajeMueveCorrectamenteLaPosicionALaDerecha() {
        Personaje personaje = new Personaje();
        personaje.moverHaciaLaDerecha();
        Posicion coordenadas = new Posicion(1,0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeMueveCorrectamenteLaPosicionALaIzquierda() {
        Personaje personaje = new Personaje();
        personaje.moverHaciaLaIzquierda();
        Posicion coordenadas = new Posicion(-1,0);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeMueveCorrectamenteLaPosicionHaciaArriba() {
        Personaje personaje = new Personaje();
        personaje.moverHaciaArriba();
        Posicion coordenadas = new Posicion(0,-1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void testElPersonajeMueveCorrectamenteLaPosicionHaciaAbajo() {
        Personaje personaje = new Personaje();
        personaje.moverHaciaAbajo();
        Posicion coordenadas = new Posicion(0,1);
        assertEquals(personaje.posicionActual(), coordenadas);
    }

    @Test
    public void elPersonajeSeMueveConLapizLevantadoyNoPintaLaPizarra() {
        Personaje personaje = new Personaje();
        personaje.levantarLapiz();
        personaje.moverHaciaLaDerecha();
        Pizarra pizarra = new Pizarra();
        assertEquals(personaje.obtenerPizarra(), pizarra);
    }

    @Test
    public void elPersonajeSeMueveConLapizApoyadoyPintaLaPizarra() {
        Personaje personaje = new Personaje();
        personaje.apoyarLapiz();
        personaje.moverHaciaLaDerecha();
        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(1,0)));
        assertEquals(personaje.obtenerPizarra(), pizarra);
    }

    @Test
    public void elPersonajeSeIncializaConPizarraVacia() {
        Personaje personaje = new Personaje();
        Pizarra pizarra = new Pizarra();
        assertEquals(personaje.obtenerPizarra(), pizarra);
    }

    @Test
    public void elPersonajeSeMueveCorrectamenteSobreEjeX() {
        Personaje personaje = new Personaje();
        personaje.moverHaciaLaDerecha();
        assertEquals(personaje.getX(), 1);
    }

    @Test
    public void elPersonajeSeMueveCorrectamenteSobreEjeY() {
        Personaje personaje = new Personaje();
        personaje.moverHaciaAbajo();
        assertEquals(personaje.getY(), 1);
    }

    @Test
    public void elPersonajeQueSeReiniciaVuelveAPosicionInicial() {
        Personaje personaje = new Personaje();
        personaje.moverHaciaAbajo();
        personaje.moverHaciaLaDerecha();
        personaje.reiniciar();
        Posicion posicion = new Posicion(0,0);
        assertEquals(personaje.posicionActual(), posicion);
    }

    @Test
    public void elPersonajeQueSeReiniciaBorraSuPizarra() {
        Personaje personaje = new Personaje();
        personaje.apoyarLapiz();
        personaje.moverHaciaAbajo();
        personaje.moverHaciaLaDerecha();
        personaje.reiniciar();
        Pizarra pizarra = new Pizarra();
        assertEquals(personaje.obtenerPizarra(), pizarra);
    }


}