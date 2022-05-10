package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueArriba;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.scene.input.MouseEvent;

public class BotonArribaEventHandler extends BotonBloqueEventHandler {

    public BotonArribaEventHandler(ConjuntoBloques algoritmo) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        Bloque bloque = new BloqueArriba();
        algoritmo.agregarBloque(bloque);
    }
}