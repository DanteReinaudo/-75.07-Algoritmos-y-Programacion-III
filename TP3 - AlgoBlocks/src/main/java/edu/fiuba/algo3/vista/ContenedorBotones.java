package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class ContenedorBotones extends VBox {

    private Button bloquePersonalizado;
    private Contenedor contenedor;

    public ContenedorBotones(ConjuntoBloques algoritmo, Contenedor contenedor) {

        Label tituloBloques = new Label("Bloques disponibles");
        tituloBloques.setStyle("-fx-font-weight:bold;-fx-font-size: 20;");

        this.contenedor = contenedor;

        Button bloqueArriba = new Button("Arriba");
        Button bloqueAbajo = new Button("Abajo");
        Button bloqueDerecha = new Button("Derecha");
        Button bloqueIzquierda = new Button("Izquierda");
        Button bloqueLevantarLapiz = new Button("Levantar Lapiz");
        Button bloqueApoyarLapiz = new Button("Apoyar Lapiz");
        Button bloqueRepetirX2 = new Button("RepetirX2");
        Button bloqueRepetirX3 = new Button("RepetirX3");
        Button bloqueInvertir = new Button("Invertir Comportamiento");
        bloquePersonalizado = new Button();


        bloqueArriba.setOnMouseClicked(new BotonArribaEventHandler(algoritmo));
        bloqueAbajo.setOnMouseClicked(new BotonAbajoEventHandler(algoritmo));
        bloqueDerecha.setOnMouseClicked(new BotonDerechaEventHandler(algoritmo));
        bloqueIzquierda.setOnMouseClicked(new BotonIzquierdaEventHandler(algoritmo));
        bloqueLevantarLapiz.setOnMouseClicked(new BotonLapizLevantadoEventHandler(algoritmo));
        bloqueApoyarLapiz.setOnMouseClicked(new BotonLapizApoyadoEventHandler(algoritmo));
        bloqueRepetirX2.setOnMouseClicked(new BotonRepetirX2EventHandler(algoritmo));
        bloqueRepetirX3.setOnMouseClicked(new BotonRepetirX3EventHandler(algoritmo));
        bloqueInvertir.setOnMouseClicked(new BotonInvertirEventHandler(algoritmo));
        bloquePersonalizado.setVisible(false);
        bloquePersonalizado.setDisable(true);

        ObservableList<Node> nodos = this.getChildren();
        nodos.add(tituloBloques);
        nodos.add(bloqueAbajo);
        nodos.add(bloqueArriba);
        nodos.add(bloqueDerecha);
        nodos.add(bloqueIzquierda);
        nodos.add(bloqueLevantarLapiz);
        nodos.add(bloqueApoyarLapiz);
        nodos.add(bloqueRepetirX2);
        nodos.add(bloqueRepetirX3);
        nodos.add(bloqueInvertir);
        nodos.add(this.bloquePersonalizado);
    }

    public void habilitarBLoquePersonalizado(String nombre, BloquePersonalizado bloque, ConjuntoBloques algoritmo){

        bloquePersonalizado.setOnMouseClicked(new BotonPersonalizadoEventHandler(algoritmo, bloque));
        bloquePersonalizado.setVisible(true);
        bloquePersonalizado.setDisable(false);
        bloquePersonalizado.setText(nombre);
    }

    public void agregarVista(BloquePersonalizado bloque){
        VistaAlgoritmo vistaAlgoritmo = new VistaAlgoritmo(bloque.obtenerAlgoritmo(), contenedor);
        bloque.agregarObserver(vistaAlgoritmo);
    }
}