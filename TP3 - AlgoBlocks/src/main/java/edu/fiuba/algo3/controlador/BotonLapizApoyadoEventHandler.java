package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueLapizApoyado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.scene.input.MouseEvent;

public class BotonLapizApoyadoEventHandler extends BotonBloqueEventHandler {

    public BotonLapizApoyadoEventHandler(ConjuntoBloques algoritmo) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        Bloque bloque = new BloqueLapizApoyado();
        algoritmo.agregarBloque(bloque);
    }
}