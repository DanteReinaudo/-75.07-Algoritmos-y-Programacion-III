package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoritmoVacioException;
import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.vista.ContenedorAlgoritmo;
import edu.fiuba.algo3.vista.ContenedorBotones;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BotonAgregarEventHandler implements EventHandler<MouseEvent> {

    private ConjuntoBloques algoritmo;
    private BloquePersonalizado bloquePersonalizado;
    private TextField texto;
    private ContenedorBotones contenedorBotones;
    private Stage stage;
    private ContenedorAlgoritmo contenedorAlgoritmo;
    public BotonAgregarEventHandler(ConjuntoBloques algoritmo,
                                    TextField texto, ContenedorBotones contenedorBotones, Stage stage, ContenedorAlgoritmo contenedorAlgoritmo) {
        this.algoritmo = algoritmo;
        this.texto = texto;
        this.contenedorBotones = contenedorBotones;
        this.stage = stage;
        this.contenedorAlgoritmo = contenedorAlgoritmo;
    }

    @Override
    public void handle(MouseEvent event) {
        if (!texto.getText().isEmpty()){
            bloquePersonalizado = new BloquePersonalizado(texto.getText());
            contenedorBotones.habilitarBLoquePersonalizado(texto.getText(), bloquePersonalizado, algoritmo);
            contenedorAlgoritmo.removerTodo();
            try {
                bloquePersonalizado.agregarAlgoritmo(algoritmo);
            } catch (AlgoritmoVacioException o){ }
            algoritmo.removerAlgoritmo();
            stage.close();
        }else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("No se puede guardar con un nombre vacio");
            a.show();
        }
    }
}