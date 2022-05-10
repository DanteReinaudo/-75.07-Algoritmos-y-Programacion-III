package edu.fiuba.algo3.controlador;


import edu.fiuba.algo3.modelo.BloqueRepetir;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorConjuntoBloques;
import edu.fiuba.algo3.vista.VistaAlgoritmo;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BotonRepetirX3EventHandler extends BotonConjuntoBloquesEventHandler {

    public BotonRepetirX3EventHandler(ConjuntoBloques algoritmo) {
        super(algoritmo);
    }

    @Override
    public void handle(MouseEvent event) {
        BloqueRepetir bloqueRepetir = new BloqueRepetir(3);
        Stage stage = new Stage();

        ContenedorConjuntoBloques contenedor = new ContenedorConjuntoBloques(algoritmo, bloqueRepetir, stage);
        VistaAlgoritmo vistaAlgoritmo = new VistaAlgoritmo(bloqueRepetir, contenedor);
        bloqueRepetir.addObserver(vistaAlgoritmo);

        stage.setScene(new Scene(contenedor,720,420));
        stage.setResizable(false);
        stage.setTitle("Creación bloque repetir tres veces");
        stage.show();
    }
}