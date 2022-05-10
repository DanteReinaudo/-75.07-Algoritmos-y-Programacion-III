package edu.fiuba.algo3.modelo.PruebasUnitarias;


import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConjuntoBloquesTest {

    @Test
    public void elAlgoritmoSeCreaCorrectamente() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        assertTrue(algoritmo.estaVacio());
    }

    @Test
    public void seAgreganVariosBloquesYSeEjecutan() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(1,0)));
        pizarra.pintarTrazo(new Trazo(new Posicion(1,0),new Posicion(1,1)));


        assertEquals(algoritmo.ejecutar(personaje), pizarra);
    }


    @Test
    public void seEjecutaInvertidoElAlgoritmo() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        Pizarra pizarra = new Pizarra();

        assertEquals(algoritmo.ejecutarInvertido(personaje), pizarra);
    }

    @Test
    public void seAnidanConjuntos() {
        ConjuntoBloques algoritmoA = new ConjuntoBloques();
        ConjuntoBloques algoritmoB = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmoA.agregarBloque(bloqueLapiz);
        algoritmoB.agregarBloque(derecha);
        algoritmoB.agregarBloque(abajo);
        algoritmoA.agregarBloque(algoritmoB);


        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(1,0)));
        pizarra.pintarTrazo(new Trazo(new Posicion(1,0),new Posicion(1,1)));

        assertEquals(algoritmoA.ejecutar(personaje), pizarra);
    }


    @Test
    public void elNombreDelBloqueEsElCorrecto() {
        ConjuntoBloques bloque = new ConjuntoBloques();
        assertEquals(bloque.obtenerNombre(), "Conjunto Bloques");
    }

    @Test
    public void elUltimoBloqueSeRemueveCorrectamente() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        BloqueArriba arriba = new BloqueArriba();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);
        algoritmo.agregarBloque(arriba);

        try {
            algoritmo.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }
        try {
            algoritmo.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }

        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(1,0)));

        assertEquals(algoritmo.ejecutar(personaje), pizarra);
    }

    @Test
    public void quitarUltimoBloqueABloqueVacioLanzaExcepcion() {
        assertThrows(AlgoritmoVacioException.class, () -> {
            new ConjuntoBloques().removerUltimoBloque();
        });
    }

    @Test
    public void seAgregaYsequitaUltimoAlgoritmoQuedaVacio() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueDerecha derecha = new BloqueDerecha();
        algoritmo.agregarBloque(derecha);
        try {
            algoritmo.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }
        assertTrue(algoritmo.estaVacio());
    }

    @Test
    public void seAgreganVariosBloquesYSeObtieneElUltimoCorrectamente() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        try {
            Bloque bloque = algoritmo.obtenerUltimoBloque();
            assertEquals(bloque,abajo);
        }catch (AlgoritmoVacioException o){
            fail();
        }

    }

    @Test
    public void seObtieneUltimoBloqueDeAlgoritmoVacioYSeLanzaExcepcion() {
        assertThrows(AlgoritmoVacioException.class, () -> {
            new ConjuntoBloques().obtenerUltimoBloque();
        });
    }

    @Test
    public void seAgreganVariosBloquesYSeEliminanTodos() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        algoritmo.removerAlgoritmo();
        assertTrue(algoritmo.estaVacio());
    }

    @Test
    public void removuevoTodosLosBloqueDeUnConjuntoVacio() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        algoritmo.removerAlgoritmo();
        assertTrue(algoritmo.estaVacio());
    }

    @Test
    public void seClonaUnConjunto() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje1 = new Personaje();
        Personaje personaje2 = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        algoritmo.removerAlgoritmo();
        ConjuntoBloques nuevoConjunto = new ConjuntoBloques();
        algoritmo.clonar(nuevoConjunto);
        assertEquals(algoritmo.ejecutar(personaje1),nuevoConjunto.ejecutar(personaje2));
    }

}







