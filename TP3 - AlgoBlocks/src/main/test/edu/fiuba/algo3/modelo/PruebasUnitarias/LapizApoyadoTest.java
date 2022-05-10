package edu.fiuba.algo3.modelo.PruebasUnitarias;

import edu.fiuba.algo3.modelo.LapizApoyado;
import edu.fiuba.algo3.modelo.Pizarra;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Trazo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LapizApoyadoTest {

    @Test
    public void elLapizApoyadoPintaSobreLaPizarra() {
        LapizApoyado lapiz = new LapizApoyado();
        Trazo trazo = new Trazo(new Posicion(0,0), new Posicion(1,0));
        Pizarra pizarra1 = new Pizarra();
        lapiz.pintar(trazo, pizarra1);

        Pizarra pizarra2 = new Pizarra();
        pizarra2.pintarTrazo(trazo);

        assertEquals(pizarra1, pizarra2);
    }

}