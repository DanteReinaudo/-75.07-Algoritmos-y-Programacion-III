package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.Pizarra;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Trazo;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizarraTest {

    @Test
    public void losTrazosSePintanCorrectamente() {
        Posicion posicion1 = new Posicion(0,0);
        Posicion posicion2 = new Posicion(4,20);
        Pizarra pizarra1 = new Pizarra();
        Pizarra pizarra2 = new Pizarra();
        Trazo trazo1 = new Trazo(posicion1,posicion2);
        Trazo trazo2 = new Trazo(posicion1,posicion2);

        pizarra1.pintarTrazo(trazo1);
        pizarra2.pintarTrazo(trazo2);

        assertEquals(pizarra1, pizarra2);
    }

    @Test
    public void loTrazosPintanCorrectamenteNoImportaElOrden() {
        Trazo trazo1 = new Trazo(new Posicion(0,0),new Posicion(4,20));
        Trazo trazo2 = new Trazo(new Posicion(1,2),new Posicion(2,22));
        Trazo trazo3 = new Trazo(new Posicion(2,3),new Posicion(4,20));
        Pizarra pizarra1 = new Pizarra();
        Pizarra pizarra2 = new Pizarra();

        pizarra1.pintarTrazo(trazo3);
        pizarra1.pintarTrazo(trazo2);
        pizarra1.pintarTrazo(trazo1);

        pizarra2.pintarTrazo(trazo1);
        pizarra2.pintarTrazo(trazo3);
        pizarra2.pintarTrazo(trazo2);

        assertEquals(pizarra1, pizarra2);
    }

    @Test
    public void losTrazosNoSeRepitenEnLaPizarra() {
        Trazo trazo = new Trazo(new Posicion(0,0),new Posicion(4,20));
        Pizarra pizarra1 = new Pizarra();
        Pizarra pizarra2 = new Pizarra();

        pizarra1.pintarTrazo(trazo);

        pizarra2.pintarTrazo(trazo);
        pizarra2.pintarTrazo(trazo);
        pizarra2.pintarTrazo(trazo);
        pizarra2.pintarTrazo(trazo);


        assertEquals(pizarra1, pizarra2);
    }

    @Test
    public void losTrazosSeAlmacenanCorrectamente() {
        HashSet<Trazo> trazosPintados = new HashSet<>();
        Pizarra pizarra = new Pizarra();
        trazosPintados.add(new Trazo(new Posicion(0,0),new Posicion(4,20)));
        pizarra.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(4,20)));

        assertEquals(pizarra.obtenerTrazos(), trazosPintados);
    }

    @Test
    public void siEliminoLosTrazoDeUnaPizarraVaciaEstaNoVaria() {
        Pizarra pizarra1 = new Pizarra();
        Pizarra pizarra2 = new Pizarra();
        pizarra1.eliminarTrazos();

        assertEquals(pizarra1, pizarra2);
    }

    @Test
    public void siEliminoTodosLosTrazoLaPizarraSeVacia() {
        Pizarra pizarra1 = new Pizarra();
        Pizarra pizarra2 = new Pizarra();
        pizarra1.pintarTrazo(new Trazo(new Posicion(0,0),new Posicion(4,20)));
        pizarra1.pintarTrazo(new Trazo(new Posicion(0,1),new Posicion(4,21)));
        pizarra1.eliminarTrazos();

        assertEquals(pizarra1, pizarra2);
    }

}