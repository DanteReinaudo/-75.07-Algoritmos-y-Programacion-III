package edu.fiuba.algo3.vista;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ContenedorAlgoritmo extends VBox {

    public  ContenedorAlgoritmo(Label label){
        super(label);
    }

    public void agregar(Label label){
        this.getChildren().add(label);
    }

    public void removerUltimo(){
        if(this.getChildren().size() > 1){
            this.getChildren().remove(this.getChildren().size()-1);
        }
    }

    public void removerTodo(){
        if (this.getChildren().size() > 1) {
            this.getChildren().subList(1, this.getChildren().size()).clear();
        }
    }
}