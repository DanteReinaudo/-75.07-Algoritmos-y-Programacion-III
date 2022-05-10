package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Personaje;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaPersonaje implements Observer {

    private Personaje personaje;
    private ImageView playerImage;

    private final int n = 10; //Numero de posibles segmentos
    private final int TAM_LINEA = 51; //Tamaño de cada linea
    private final int posInicialX = (n * TAM_LINEA)/2 - 64;
    private final int posInicialY = (n * TAM_LINEA)/2 - 32;

    public VistaPersonaje(Personaje personaje, VistaPizarra vistaPizarra) {
        this.personaje = personaje;
        playerImage = new ImageView();
        playerImage.setScaleY(1);
        playerImage.setScaleX(1);
        playerImage.setFitHeight(64);
        playerImage.setFitWidth(64);
        playerImage.setX(posInicialX);
        playerImage.setY(posInicialY);
        playerImage.setImage(new Image("file:src/main/java/edu/fiuba/algo3/vista/Imagenes/playerTransparente.png"));
        vistaPizarra.setPlayerView(playerImage);
    }

    @Override
    public void update() {
        int xActual = personaje.getX();
        int yActual = personaje.getY();
        playerImage.setX(posInicialX + 10 + TAM_LINEA*xActual);
        playerImage.setY(posInicialY + 6 + TAM_LINEA*yActual);
    }
}