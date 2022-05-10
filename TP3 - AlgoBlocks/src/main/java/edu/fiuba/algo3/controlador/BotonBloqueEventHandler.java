package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public abstract class BotonBloqueEventHandler implements EventHandler<MouseEvent> {

    protected ConjuntoBloques algoritmo;

    public BotonBloqueEventHandler(ConjuntoBloques algoritmo) {
        this.algoritmo = algoritmo;
    }
}