package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Bloque;
import javafx.scene.layout.BorderPane;

public abstract class Contenedor extends BorderPane {
    abstract void agregarNombreBloque(Bloque bloque);
    public abstract void eliminarUltimoNombreBloque();

}
