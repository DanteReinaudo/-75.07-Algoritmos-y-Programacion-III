package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonBorrarEventHandler;
import edu.fiuba.algo3.controlador.BotonTerminadoEventHandler;
import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ContenedorConjuntoBloques extends Contenedor {

    private ContenedorBotones contenedorBotones;
    private ContenedorAlgoritmo contenedorAlgoritmos;

    public ContenedorConjuntoBloques(ConjuntoBloques algoritmo, ConjuntoBloques conjunto, Stage stage){
        contenedorBotones = new ContenedorBotones(conjunto, this);
        Label labelConjunto = new Label(conjunto.obtenerNombre());
        labelConjunto.setStyle("-fx-font-weight:bold");
        contenedorAlgoritmos = new ContenedorAlgoritmo(labelConjunto);

        agregarBotones(); //ver para los dos de setear el tamaño correcto
        agregarAlgoritmo(contenedorAlgoritmos);
        agregarBotonera(algoritmo, conjunto, stage);

    }
    private void agregarBotonera(ConjuntoBloques algoritmo, ConjuntoBloques conjunto, Stage stage ){

        Button botonTerminado = new Button("Terminado");
        botonTerminado.setOnMouseClicked(new BotonTerminadoEventHandler(algoritmo, conjunto, stage));
        Button botonBorrar = new Button("Borrar Ultimo Bloque");
        botonBorrar.setOnMouseClicked(new BotonBorrarEventHandler(conjunto, this));

        VBox botonera = new VBox(new Label(""),botonBorrar, botonTerminado);

        botonera.setSpacing(100);
        botonera.setPrefWidth(230);
        botonera.setPadding(new Insets(15 , 0,0,60));
        botonera.setStyle("-fx-border-color: black;-fx-border-width: 2;");
        setRight(botonera);
    }

    private void agregarBotones(){
        contenedorBotones.setPrefWidth(256);
        contenedorBotones.setSpacing(10);
        contenedorBotones.setPadding(new Insets(15 , 0,0,60));
        contenedorBotones.setStyle("-fx-border-color: black;-fx-border-width: 2;");

        setLeft(contenedorBotones);
    }

    private void agregarAlgoritmo(VBox contenedorAlgoritmo){

        contenedorAlgoritmo.setPrefWidth(256);
        contenedorAlgoritmo.setSpacing(10);
        contenedorAlgoritmo.setPadding(new Insets(15 , 0,0,60));
        contenedorAlgoritmo.setStyle("-fx-border-color: black;-fx-border-width: 2 1");

        setCenter(contenedorAlgoritmo);
    }

    public void agregarNombreBloque(Bloque bloque){
        this.contenedorAlgoritmos.agregar(new Label(bloque.obtenerNombre()));
    }

    public void eliminarUltimoNombreBloque(){
        this.contenedorAlgoritmos.removerUltimo();
    }
}
