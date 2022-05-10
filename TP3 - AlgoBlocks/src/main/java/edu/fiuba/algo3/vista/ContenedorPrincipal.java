package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonBorrarEventHandler;
import edu.fiuba.algo3.controlador.BotonEjecutarEventHandler;
import edu.fiuba.algo3.controlador.BotonGuardarAlgoritmoEventHandler;
import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;



public class ContenedorPrincipal extends Contenedor {

    final private VistaPizarra vistaPizarra;
    final private ConjuntoBloques algoritmo;
    final private ContenedorBotones contenedorBotones;
    private ContenedorAlgoritmo contenedorAlgoritmo;
    private BackgroundImage miFondoDePantalla;

    public ContenedorPrincipal(ConjuntoBloques algoritmo, Personaje personaje, VistaPizarra vistaPizarra) {
        this.vistaPizarra = vistaPizarra;
        this.algoritmo = algoritmo;
        this.contenedorBotones = new ContenedorBotones(algoritmo, this);
        miFondoDePantalla= new BackgroundImage(new Image("file:src/main/java/edu/fiuba/algo3/vista/Imagenes/fondo-algoritmo1.jpg",
                32,32,false,false),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        this.contenedorBotones.setBackground(new Background(miFondoDePantalla));
        Label labelAlgoritmo = new Label("Algoritmo Actual");
        labelAlgoritmo.setStyle("-fx-font-weight:bolder;-fx-font-size: 20;");
        this.contenedorAlgoritmo = new ContenedorAlgoritmo(labelAlgoritmo);
        this.contenedorAlgoritmo.setBackground(new Background(miFondoDePantalla));
        this.setLeft(nuevoContenedorBloques());
        this.setCenter(nuevoContenedorPizzarra(personaje));
    }

    private HBox nuevoContenedorBloques() {

        contenedorBotones.setPrefWidth(256);
        contenedorBotones.setSpacing(33);
        contenedorBotones.setPadding(new Insets(15 , 0,0,0));
        contenedorBotones.setStyle("-fx-alignment: center;");

        contenedorAlgoritmo.setPrefWidth(256);
        contenedorAlgoritmo.setSpacing(10);
        contenedorAlgoritmo.setPadding(new Insets(34 , 0,0,50));
        contenedorAlgoritmo.setStyle("-fx-border-color: black;-fx-border-width: 0 0 0 2;");

        return new HBox(contenedorBotones, contenedorAlgoritmo);
    }

    private VBox nuevoContenedorPizzarra(Personaje personaje) {

        Button botonBorrar = new Button("Borrar Ultimo Bloque");
        Button botonGuardarAlgoritmo = new Button("Guardar algoritmo");
        Button botonEjecutar = new Button("Ejecutar");

        botonBorrar.setOnMouseClicked(new BotonBorrarEventHandler(algoritmo, this));
        botonGuardarAlgoritmo.setOnMouseClicked(new BotonGuardarAlgoritmoEventHandler(algoritmo, contenedorBotones, contenedorAlgoritmo));
        botonEjecutar.setOnMouseClicked(new BotonEjecutarEventHandler(algoritmo, personaje, vistaPizarra));

        HBox contenedorBotonesPizarra = new HBox(botonBorrar, botonGuardarAlgoritmo, botonEjecutar);

        VBox contenedorPizarra = new VBox(vistaPizarra.getPane(), contenedorBotonesPizarra);
        contenedorPizarra.setStyle("-fx-border-color: black;-fx-border-width: 0 0 0 2;");
        contenedorBotonesPizarra.setPadding(new Insets(50 , 0,90,30));
        contenedorBotonesPizarra.setSpacing(50);
        contenedorBotonesPizarra.setBackground(new Background(miFondoDePantalla));

        return contenedorPizarra;
    }

    public void agregarNombreBloque(Bloque bloque) {
        this.contenedorAlgoritmo.agregar(new Label(bloque.obtenerNombre()));
    }

    public void eliminarUltimoNombreBloque() {
        this.contenedorAlgoritmo.removerUltimo();
    }
}