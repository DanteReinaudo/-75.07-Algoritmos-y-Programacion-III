package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloqueRepetirTest {

    @Test
    public void elBloqueRepetirSeCreaCorrectamente() {
        BloqueRepetir repeticion = new BloqueRepetir(2);
        assertTrue(repeticion.estaVacio());
    }

    @Test
    public void seAgreganVariosBloquesYSeRepiten2Veces() {
        BloqueRepetir repeticion = new BloqueRepetir(2);
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();
        bloqueLapiz.ejecutar(personaje);
        repeticion.agregarBloque(abajo);
        repeticion.agregarBloque(derecha);

        Pizarra pizarra = new Pizarra();
        for (int i = 0; i < 2; ++i){
            pizarra.pintarTrazo(new Trazo(new Posicion(i,i),new Posicion(i,i+1)));
            pizarra.pintarTrazo(new Trazo(new Posicion(i,i+1),new Posicion(i+1,i+1)));
        }

        assertEquals(repeticion.ejecutar(personaje),pizarra);
    }


    @Test
    public void ejecutarInvertidoInvierteLosBloquesEItera() {
        BloqueRepetir repeticion = new BloqueRepetir(2);
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();
        bloqueLapiz.ejecutar(personaje);
        repeticion.agregarBloque(derecha);
        repeticion.agregarBloque(abajo);

        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(-1,0)));
        pizarra.pintarTrazo(new Trazo(new Posicion(-1,0),new Posicion(-1,-1)));
        pizarra.pintarTrazo(new Trazo(new Posicion(-1,-1),new Posicion(-2,-1)));
        pizarra.pintarTrazo(new Trazo(new Posicion(-2,-1),new Posicion(-2,-2)));

        assertEquals(repeticion.ejecutarInvertido(personaje), pizarra);
    }

    @Test
    public void seAnidanDosBloquesDeRepeticion() {
        BloqueRepetir repeticionI = new BloqueRepetir(2);
        BloqueRepetir repeticionJ = new BloqueRepetir(2);
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();
        bloqueLapiz.ejecutar(personaje);
        repeticionI.agregarBloque(derecha);
        repeticionJ.agregarBloque(abajo);
        repeticionI.agregarBloque(repeticionJ);

        Pizarra pizarra = new Pizarra();

        pizarra.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(1,0)));
        pizarra.pintarTrazo(new Trazo(new Posicion(1,0),new Posicion(1,1)));
        pizarra.pintarTrazo(new Trazo(new Posicion(1,1),new Posicion(1,2)));
        pizarra.pintarTrazo(new Trazo(new Posicion(1,2),new Posicion(2,2)));
        pizarra.pintarTrazo(new Trazo(new Posicion(2,2),new Posicion(2,3)));
        pizarra.pintarTrazo(new Trazo(new Posicion(2,3),new Posicion(2,4)));

        assertEquals(repeticionI.ejecutar(personaje), pizarra);
    }

    @Test
    public void elNombreDelBloqueEsElCorrecto() {
        BloqueRepetir bloque = new BloqueRepetir(3);
        assertEquals(bloque.obtenerNombre(), "RepetirX3");
    }

    @Test
    public void elUltimoBloqueSeRemueveCorrectamente() {
        BloqueRepetir repeticion = new BloqueRepetir(3);
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        BloqueArriba arriba = new BloqueArriba();
        Personaje personaje = new Personaje();
        bloqueLapiz.ejecutar(personaje);
        repeticion.agregarBloque(derecha);
        repeticion.agregarBloque(abajo);
        repeticion.agregarBloque(arriba);
        try {
            repeticion.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }
        try {
            repeticion.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }

        Pizarra pizarra = new Pizarra();
        pizarra.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(1,0)));
        pizarra.pintarTrazo(new Trazo(new Posicion(1,0),new Posicion(2,0)));
        pizarra.pintarTrazo(new Trazo(new Posicion(2,0),new Posicion(3,0)));

        assertEquals(repeticion.ejecutar(personaje), pizarra);
    }

    @Test
    public void quitarUltimoBloqueABloqueVacioNoHaceNada() {
        assertThrows(AlgoritmoVacioException.class, () -> {
            new BloqueRepetir(3).removerUltimoBloque();
        });
    }

    @Test
    public void seAgregaYsequitaUltimoAlgoritmoQuedaVacio() {
        BloqueRepetir repeticion = new BloqueRepetir(3);
        BloqueDerecha derecha = new BloqueDerecha();
        repeticion.agregarBloque(derecha);
        try {
            repeticion.removerUltimoBloque();
        }catch (AlgoritmoVacioException o){
            fail();
        }
        assertTrue(repeticion.estaVacio());
    }

    @Test
    public void seAgreganVariosBloquesYSeObtieneElUltimoCorrectamente() {
        BloqueRepetir repeticion = new BloqueRepetir(2);
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();

        repeticion.agregarBloque(bloqueLapiz);
        repeticion.agregarBloque(derecha);
        repeticion.agregarBloque(abajo);

        try {
            Bloque bloque = repeticion.obtenerUltimoBloque();
            assertEquals(bloque,abajo);
        }catch (AlgoritmoVacioException o){
            fail();
        }

    }

    @Test
    public void seObtieneUltimoBloqueDeAlgoritmoVacioYSeLanzaExcepcion() {
        assertThrows(AlgoritmoVacioException.class, () -> {
            new BloqueRepetir(2).obtenerUltimoBloque();
        });
    }

    @Test
    public void seAgreganVariosBloquesYSeEliminanTodos() {
        BloqueRepetir repeticion = new BloqueRepetir(2);
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();

        repeticion.agregarBloque(bloqueLapiz);
        repeticion.agregarBloque(derecha);
        repeticion.agregarBloque(abajo);

        repeticion.removerAlgoritmo();
        assertTrue(repeticion.estaVacio());
    }

    @Test
    public void removuevoTodosLosBloqueDeUnConjuntoVacio() {
        BloqueRepetir repeticion = new BloqueRepetir(2);
        repeticion.removerAlgoritmo();
        assertTrue(repeticion.estaVacio());
    }

    @Test
    public void seClonaUnConjunto() {
        BloqueRepetir repeticion = new BloqueRepetir(2);
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje1 = new Personaje();
        Personaje personaje2 = new Personaje();

        repeticion.agregarBloque(bloqueLapiz);
        repeticion.agregarBloque(derecha);
        repeticion.agregarBloque(abajo);

        repeticion.removerAlgoritmo();
        ConjuntoBloques nuevoConjunto = new ConjuntoBloques();
        repeticion.clonar(nuevoConjunto);
        assertEquals(repeticion.ejecutar(personaje1),nuevoConjunto.ejecutar(personaje2));
    }

}