package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueInvertirTest {

    @Test
    public void elBloqueInvertirSeCreaCorrectamente() {
        BloqueInvertir invertir = new BloqueInvertir();
        assertTrue(invertir.estaVacio());
    }

    @Test
    public void seAgreganVariosBloquesYSeEjecutan() {
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        bloqueLapiz.ejecutar(personaje);
        invertir.agregarBloque(derecha);
        invertir.agregarBloque(abajo);

        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(-1,0));
        Trazo trazo2 = new Trazo( new Posicion(-1,0),  new Posicion(-1,-1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);


        assertEquals(invertir.ejecutar(personaje), pizarra);
    }

    @Test
    public void seEjecutaInvertidoElBloqueInvertir() {
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        invertir.agregarBloque(bloqueLapiz);
        invertir.agregarBloque(derecha);
        invertir.agregarBloque(abajo);


        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(1,0));
        Trazo trazo2 = new Trazo( new Posicion(1,0),  new Posicion(1,1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);

        assertEquals(invertir.ejecutarInvertido(personaje), pizarra);
    }

    @Test
    public void seAnidanBloquesInvertirYSeCancelan() {
        BloqueInvertir invertirA = new BloqueInvertir();
        BloqueInvertir invertirB = new BloqueInvertir();
        BloqueLapizLevantado bloqueLapiz = new BloqueLapizLevantado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        invertirA.agregarBloque(bloqueLapiz);
        invertirB.agregarBloque(derecha);
        invertirB.agregarBloque(abajo);
        invertirA.agregarBloque(invertirB);


        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(1,0));
        Trazo trazo2 = new Trazo( new Posicion(1,0),  new Posicion(1,1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);

        assertEquals(invertirA.ejecutar(personaje), pizarra);
    }

    @Test
    public void elNombreDelBloqueEsElCorrecto() {
        BloqueInvertir bloque = new BloqueInvertir();
        assertEquals(bloque.obtenerNombre(), "Invertir Comportamiento");
    }

    @Test
    public void elUltimoBloqueSeRemueveCorrectamente() {
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueLapizLevantado bloqueLapiz = new BloqueLapizLevantado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        BloqueArriba arriba = new BloqueArriba();
        Personaje personaje = new Personaje();

        invertir.agregarBloque(bloqueLapiz);
        invertir.agregarBloque(derecha);
        invertir.agregarBloque(abajo);
        invertir.agregarBloque(arriba);

        try {
            invertir.removerUltimoBloque();
        } catch (AlgoritmoVacioException o){
            fail();
        }
        try {
            invertir.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }


        Pizarra pizarra = new Pizarra();
        Trazo trazo = new Trazo( new Posicion(0,0),  new Posicion(-1,0));
        pizarra.pintarTrazo(trazo);

        assertEquals(invertir.ejecutar(personaje), pizarra);
    }

    @Test
    public void quitarUltimoBloqueABloqueVacioNoHaceNada() {
        assertThrows(AlgoritmoVacioException.class, () -> {
            new BloqueInvertir().removerUltimoBloque();
        });
    }

    @Test
    public void seAgregaYsequitaUltimoAlgoritmoQuedaVacio() {
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueDerecha derecha = new BloqueDerecha();
        invertir.agregarBloque(derecha);
        try {
            invertir.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }
        assertTrue(invertir.estaVacio());
    }

    @Test
    public void seAgreganVariosBloquesYSeObtieneElUltimoCorrectamente() {
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();

        invertir.agregarBloque(bloqueLapiz);
        invertir.agregarBloque(derecha);
        invertir.agregarBloque(abajo);

        try {
            Bloque bloque = invertir.obtenerUltimoBloque();
            assertEquals(bloque,abajo);
        }catch (AlgoritmoVacioException o){
            fail();
        }

    }

    @Test
    public void seObtieneUltimoBloqueDeAlgoritmoVacioYSeLanzaExcepcion() {
        assertThrows(AlgoritmoVacioException.class, () -> {
            new BloqueInvertir().obtenerUltimoBloque();
        });
    }

    @Test
    public void seAgreganVariosBloquesYSeEliminanTodos() {
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();

        invertir.agregarBloque(bloqueLapiz);
        invertir.agregarBloque(derecha);
        invertir.agregarBloque(abajo);

        invertir.removerAlgoritmo();
        assertTrue(invertir.estaVacio());
    }

    @Test
    public void removuevoTodosLosBloqueDeUnConjuntoVacio() {
        BloqueInvertir invertir = new BloqueInvertir();
        invertir.removerAlgoritmo();
        assertTrue(invertir.estaVacio());
    }

    @Test
    public void seClonaUnConjunto() {
        BloqueInvertir invertir = new BloqueInvertir();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje1 = new Personaje();
        Personaje personaje2 = new Personaje();

        invertir.agregarBloque(bloqueLapiz);
        invertir.agregarBloque(derecha);
        invertir.agregarBloque(abajo);

        invertir.removerAlgoritmo();
        ConjuntoBloques nuevoConjunto = new ConjuntoBloques();
        invertir.clonar(nuevoConjunto);
        assertEquals(invertir.ejecutar(personaje1),nuevoConjunto.ejecutar(personaje2));
    }

}