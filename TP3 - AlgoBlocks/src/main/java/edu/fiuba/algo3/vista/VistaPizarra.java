package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Pizarra;
import edu.fiuba.algo3.modelo.Trazo;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import java.util.ArrayList;

public class VistaPizarra implements Observer {

    private final int n = 10; //Numero de posibles segmentos
    private final int TAM_LINEA = 51; //Tamaño de cada linea

    private final int posInicial = (n * TAM_LINEA)/2;

    private Pizarra pizarra;

    public Path recorrido;
    public Pane root;
    private ArrayList<Circle> circulos;

    public VistaPizarra(Pizarra pizarra){
        //Group grupo = new Group(path); Ejemplos de google dicen que hay que agregar el recorrido a un objeto de
        //tipo grupo pero no veo cambio alguno, lo dejo por las dudas
        this.pizarra = pizarra;
        recorrido = new Path();
        root = new Pane(this.recorrido);
        root.setPrefSize(n * TAM_LINEA, n * TAM_LINEA);
        root.setPadding(new Insets(85,0,0,0));
        BackgroundImage miBackground= new BackgroundImage(new Image("file:src/main/java/edu/fiuba/algo3/vista/Imagenes/fondo-pizarra.jpg",
                n * TAM_LINEA,n * TAM_LINEA,false,false),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        root.setBackground(new Background(miBackground));
        recorrido.setStrokeWidth(4.5);
        root.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
                new BorderWidths(2))));
        this.circulos = new ArrayList<>();
    }

    public Pane getPane(){
        return this.root;
    }

    @Override
    public void update() {
        clear();
        for(Trazo trazo : pizarra.obtenerTrazos()) {
            int xPosA = posInicial + TAM_LINEA * trazo.getPosicionA().getX();
            int yPosA = posInicial + TAM_LINEA * trazo.getPosicionA().getY();
            int xPosB = posInicial + TAM_LINEA * trazo.getPosicionB().getX();
            int yPosB = posInicial + TAM_LINEA * trazo.getPosicionB().getY();
            if(!trazo.estaDesfasado()) {
                recorrido.getElements().add(new MoveTo(xPosA, yPosA));
                recorrido.getElements().add(new LineTo(xPosB, yPosB));
            }
            dibujarCirculo(xPosA, yPosA);
            dibujarCirculo(xPosB, yPosB);
        }
    }

    public void clear() {
        recorrido.getElements().clear();
        for (Circle circulo:circulos) {
            root.getChildren().remove(circulo);
        }
    }

    public void setPlayerView(ImageView playerView) {
        root.getChildren().add(playerView);
    }

    private void dibujarCirculo(int x, int y){
        Circle circulo = new Circle(x, y,4);
        circulo.setFill(Color.BLACK);
        circulos.add(circulo);
        root.getChildren().add(circulo);
    }
}