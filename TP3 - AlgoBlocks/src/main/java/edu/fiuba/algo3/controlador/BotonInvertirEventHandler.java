package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloqueInvertir;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorConjuntoBloques;
import edu.fiuba.algo3.vista.VistaAlgoritmo;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BotonInvertirEventHandler extends BotonConjuntoBloquesEventHandler {

    public BotonInvertirEventHandler(ConjuntoBloques algoritmo) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        BloqueInvertir bloqueinvertir = new BloqueInvertir();
        Stage stage = new Stage();

        ContenedorConjuntoBloques contenedor = new ContenedorConjuntoBloques(algoritmo, bloqueinvertir, stage);
        VistaAlgoritmo vistaAlgoritmo = new VistaAlgoritmo(bloqueinvertir, contenedor);
        bloqueinvertir.addObserver(vistaAlgoritmo);

        stage.setScene(new Scene(contenedor,720,420));
        stage.setResizable(false);
        stage.setTitle("Creación bloque Invertir");
        stage.show();
    }
}