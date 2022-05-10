package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.BloquePersonalizado;
import edu.fiuba.algo3.modelo.ConjuntoBloques;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AlgoBlocks extends Application{

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoBlocks");

        Personaje personaje = new Personaje();
        ConjuntoBloques algoritmo = new ConjuntoBloques();

        VistaPizarra vistaPizarra = new VistaPizarra(personaje.obtenerPizarra());

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(algoritmo, personaje,
                vistaPizarra);

        VistaPersonaje vistaPersonaje = new VistaPersonaje(personaje, vistaPizarra);
        personaje.addObserver(vistaPersonaje);

        personaje.agregarObserverALaPizarra(vistaPizarra);

        VistaAlgoritmo vistaAlgoritmo = new VistaAlgoritmo(algoritmo, contenedorPrincipal);
        algoritmo.addObserver(vistaAlgoritmo);

        Scene escenaPrincipal = new Scene(contenedorPrincipal, 1024, 668);
        stage.setScene(escenaPrincipal);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}