package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.vista.VistaPizarra;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonEjecutarEventHandler implements EventHandler<MouseEvent> {

    private ConjuntoBloques algoritmo;
    private Personaje personaje;
    private VistaPizarra vistaPizarra;

    public BotonEjecutarEventHandler(ConjuntoBloques algoritmo, Personaje personaje, VistaPizarra vistaPizarra) {
        this.algoritmo = algoritmo;
        this.personaje = personaje;
        this.vistaPizarra = vistaPizarra;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        personaje.reiniciar();
        this.algoritmo.ejecutar(this.personaje);
    }
}