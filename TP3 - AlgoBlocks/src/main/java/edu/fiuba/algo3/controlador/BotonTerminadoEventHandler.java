package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BotonTerminadoEventHandler implements EventHandler<MouseEvent> {

    private ConjuntoBloques algoritmo;
    private ConjuntoBloques conjunto;
    private Stage stage;

    public BotonTerminadoEventHandler(ConjuntoBloques algoritmo, ConjuntoBloques conjunto, Stage stage) {
        this.algoritmo = algoritmo;
        this.conjunto = conjunto;
        this.stage = stage;
    }

    @Override
    public void handle(MouseEvent event) {
        algoritmo.agregarBloque(conjunto);
        stage.close();
    }
}