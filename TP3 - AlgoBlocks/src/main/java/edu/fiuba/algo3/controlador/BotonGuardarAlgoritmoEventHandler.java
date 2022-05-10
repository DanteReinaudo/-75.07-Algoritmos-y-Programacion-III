package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.Contenedor;
import edu.fiuba.algo3.vista.ContenedorAlgoritmo;
import edu.fiuba.algo3.vista.ContenedorBotones;
import edu.fiuba.algo3.vista.ContenedorGuardarAlgoritmo;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonGuardarAlgoritmoEventHandler extends BotonConjuntoBloquesEventHandler {

    private ContenedorBotones contenedorBotones;
    private ContenedorAlgoritmo contenedorAlgoritmo;
    public BotonGuardarAlgoritmoEventHandler(ConjuntoBloques algoritmo, ContenedorBotones contenedor, ContenedorAlgoritmo contenedorAlgoritmo) {
        super(algoritmo);
        contenedorBotones = contenedor;
        this.contenedorAlgoritmo = contenedorAlgoritmo;
    }

    @Override
    public void handle(MouseEvent event) {
        if(algoritmo.estaVacio()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("No se puede guardar un algoritmo vacio");
            a.show();
        }else {
            Stage stage = new Stage();
            stage.setScene(new Scene(new ContenedorGuardarAlgoritmo(algoritmo, contenedorBotones, stage, contenedorAlgoritmo),
                    520, 120));
            stage.setTitle("Guardar algoritmo personalizado");
            stage.show();
        }
    }
}