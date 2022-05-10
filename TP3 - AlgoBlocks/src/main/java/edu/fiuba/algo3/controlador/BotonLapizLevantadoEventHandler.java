package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueLapizLevantado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.scene.input.MouseEvent;

public class BotonLapizLevantadoEventHandler extends BotonBloqueEventHandler {

    public BotonLapizLevantadoEventHandler(ConjuntoBloques algoritmo) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        Bloque bloque = new BloqueLapizLevantado();
        algoritmo.agregarBloque(bloque);
    }
}