package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueIzquierda;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.scene.input.MouseEvent;

public class BotonIzquierdaEventHandler extends BotonBloqueEventHandler {

    public BotonIzquierdaEventHandler(ConjuntoBloques algoritmo ) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        Bloque bloque = new BloqueIzquierda();
        algoritmo.agregarBloque(bloque);
    }
}