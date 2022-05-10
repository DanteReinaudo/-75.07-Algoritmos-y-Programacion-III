package edu.fiuba.algo3.modelo.entrega2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega2Test {

    @Test
    public void laPizarraSeCreaCorrectamente(){
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        Personaje personaje = new Personaje();
        Pizarra pizarra = new Pizarra();
        assertEquals(algoritmo.ejecutar(personaje),pizarra);
    }

    @Test
    public void testMoverElPersonajeConElLapizLevantadoNoPintaLaPizarra(){
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        Personaje personaje = new Personaje();
        algoritmo.agregarBloque(new BloqueAbajo());
        algoritmo.agregarBloque(new BloqueDerecha());
        Pizarra pizarra = new Pizarra();
        assertEquals(algoritmo.ejecutar(personaje),pizarra);
    }

    @Test
    public void testMoverElPersonajeConElLapizAbajoPintaLaPizarra(){
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        Personaje personaje = new Personaje();
        algoritmo.agregarBloque(new BloqueLapizApoyado());
        algoritmo.agregarBloque(new BloqueAbajo());
        algoritmo.agregarBloque(new BloqueDerecha());
        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo(new Posicion(0,0),new Posicion(0,1));
        Trazo trazo2 = new Trazo(new Posicion(0,1),new Posicion(1,1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);
        assertEquals(algoritmo.ejecutar(personaje),pizarra);
    }

    @Test
    public void crearAlgoritmoConBloqueRepeticion2veces(){
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        Personaje personaje = new Personaje();
        BloqueRepetir bloqueRepeticion = new BloqueRepetir(2);
        bloqueRepeticion.agregarBloque(new BloqueDerecha());
        algoritmo.agregarBloque(new BloqueLapizApoyado());
        algoritmo.agregarBloque(bloqueRepeticion);

        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo(new Posicion(0,0),new Posicion(1,0));
        Trazo trazo2 = new Trazo(new Posicion(1,0),new Posicion(2,0));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);

        assertEquals(algoritmo.ejecutar(personaje),pizarra);
    }

    @Test
    public void crearAlgoritmoConBloqueRepeticion3veces(){
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        Personaje personaje = new Personaje();

        BloqueLapizApoyado bloqueApoyarLapiz = new BloqueLapizApoyado();
        BloqueRepetir bloqueRepeticion = new BloqueRepetir(3);
        bloqueRepeticion.agregarBloque(new BloqueAbajo());
        bloqueRepeticion.agregarBloque(new BloqueDerecha());
        algoritmo.agregarBloque(bloqueApoyarLapiz);
        algoritmo.agregarBloque(bloqueRepeticion);

        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo(new Posicion(0,0),new Posicion(0,1));
        Trazo trazo2 = new Trazo(new Posicion(0,1),new Posicion(1,1));
        Trazo trazo3 = new Trazo(new Posicion(1,1),new Posicion(1,2));
        Trazo trazo4 = new Trazo(new Posicion(1,2),new Posicion(2,2));
        Trazo trazo5 = new Trazo(new Posicion(2,2),new Posicion(2,3));
        Trazo trazo6 = new Trazo(new Posicion(2,3),new Posicion(3,3));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);
        pizarra.pintarTrazo(trazo3);
        pizarra.pintarTrazo(trazo4);
        pizarra.pintarTrazo(trazo5);
        pizarra.pintarTrazo(trazo6);

        assertEquals(algoritmo.ejecutar(personaje),pizarra);
    }
}