package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoritmoVacioException;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.Contenedor;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class BotonBorrarEventHandler implements EventHandler<MouseEvent> {

    protected ConjuntoBloques algoritmo;
    protected Contenedor contenedor;


    public BotonBorrarEventHandler(ConjuntoBloques algoritmo, Contenedor contenedor) {
        this.algoritmo = algoritmo;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(MouseEvent event) {
        try{
            algoritmo.removerUltimoBloque();
            contenedor.eliminarUltimoNombreBloque();
        } catch (AlgoritmoVacioException o) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("El algoritmo esta vacio");
            a.show();
        }
    }
}