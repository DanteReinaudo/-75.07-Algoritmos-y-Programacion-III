package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloquePersonalizadoTest {

    @Test
    public void elAlgoritmoPersonalizadoSeCreaCorrectamente() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueDerecha derecha = new BloqueDerecha();
        algoritmo.agregarBloque(derecha);
        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo");
        try{
            personalizado.agregarAlgoritmo(algoritmo);
        }catch (AlgoritmoVacioException o){
            fail();
        }
        assertEquals(personalizado.obtenerNombre(), "Nuevo Algoritmo");

    }


    @Test
    public void seCreaUnNuevoAlgoritmoySeEjecuta() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo");
        try{
            personalizado.agregarAlgoritmo(algoritmo);
        }catch (AlgoritmoVacioException o){
            fail();
        }

        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(1,0));
        Trazo trazo2 = new Trazo( new Posicion(1,0),  new Posicion(1,1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);


        assertEquals(personalizado.ejecutar(personaje),pizarra);
    }

    @Test
    public void seEjecutaInvertidoElAlgoritmo() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizLevantado bloqueLapiz = new BloqueLapizLevantado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo");
        try{
            personalizado.agregarAlgoritmo(algoritmo);
        }catch (AlgoritmoVacioException o){
            fail();
        }


        Pizarra pizarra = new Pizarra();
        Trazo trazo1 = new Trazo( new Posicion(0,0),  new Posicion(-1,0));
        Trazo trazo2 = new Trazo( new Posicion(-1,0),  new Posicion(-1,-1));
        pizarra.pintarTrazo(trazo1);
        pizarra.pintarTrazo(trazo2);

        assertEquals(personalizado.ejecutarInvertido(personaje), pizarra);
    }

    @Test
    public void agregarAlgoritmoVacioLanzaExcepcion() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo");
        try{
            personalizado.agregarAlgoritmo(algoritmo);
        }catch (AlgoritmoVacioException o){
            assertTrue(true);
        }
    }

    @Test
    public void seCreaUnNuevoAlgoritmoPersonalizadoYSeLoObtiene() {
        ConjuntoBloques algoritmo = new ConjuntoBloques();
        BloqueLapizApoyado bloqueLapiz = new BloqueLapizApoyado();
        BloqueDerecha derecha = new BloqueDerecha();
        BloqueAbajo abajo = new BloqueAbajo();
        Personaje personaje1 = new Personaje();
        Personaje personaje2 = new Personaje();

        algoritmo.agregarBloque(bloqueLapiz);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(abajo);

        BloquePersonalizado personalizado = new BloquePersonalizado("Nuevo Algoritmo");
        try{
            personalizado.agregarAlgoritmo(algoritmo);
        }catch (AlgoritmoVacioException o){
            fail();
        }

        ConjuntoBloques algoritmoObtenido = personalizado.obtenerAlgoritmo();

        assertEquals(personalizado.ejecutar(personaje1),algoritmoObtenido.ejecutar(personaje2));
    }

    @Test
    public void elNuevoAlgoritmoPersonalizadoSeCreaEnCondicionValida() {
        BloquePersonalizado algoritmo = new BloquePersonalizado("Tranqui");
        Personaje personaje = new Personaje();
        assertEquals(algoritmo.ejecutar(personaje),new Pizarra());
    }



}