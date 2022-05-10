package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueAbajo;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.scene.input.MouseEvent;

public class BotonAbajoEventHandler extends BotonBloqueEventHandler {

    public BotonAbajoEventHandler(ConjuntoBloques algoritmo) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        Bloque bloque = new BloqueAbajo();
        algoritmo.agregarBloque(bloque);
    }
}