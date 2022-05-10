package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.Observer;

import java.util.ArrayList;

public class Personaje implements Observable {

    private Lapiz lapiz;
    private Pizarra pizarra;
    private Posicion posicion;
    private Posicion posicionAnterior;
    private ArrayList<Observer> observers;

    public Personaje() {
        observers = new ArrayList<>();
        pizarra = new Pizarra();
        reiniciar();
    }


    public Pizarra levantarLapiz() {
        lapiz = new LapizLevantado();
        return pizarra;
    }

    public Pizarra apoyarLapiz() {
        lapiz = new LapizApoyado();
        return pizarra;
    }

    public Pizarra moverHaciaArriba() {
        this.posicionAnterior = new Posicion(posicion);
        posicion.arriba();
        notifyObserver();
        return actualizarPizarra(new Trazo(posicionAnterior, new Posicion(posicion)));
    }

    public Pizarra moverHaciaAbajo() {
        this.posicionAnterior = new Posicion(posicion);
        posicion.abajo();
        notifyObserver();
        return actualizarPizarra(new Trazo(posicionAnterior, new Posicion(posicion)));
    }

    public Pizarra moverHaciaLaIzquierda() {
        this.posicionAnterior = new Posicion(posicion);
        posicion.izquierda();
        notifyObserver();
        return actualizarPizarra(new Trazo(posicionAnterior, new Posicion(posicion)));
    }

    public Pizarra moverHaciaLaDerecha() {
        this.posicionAnterior = new Posicion(posicion);
        posicion.derecha();
        notifyObserver();
        return actualizarPizarra(new Trazo(posicionAnterior, new Posicion(posicion)));
    }

    private Pizarra actualizarPizarra(Trazo trazo) {
        lapiz.pintar(trazo, pizarra);
        return pizarra;
    }

    public void reiniciar() {
        levantarLapiz();
        posicion = new Posicion(0,0);
        pizarra.eliminarTrazos();
        notifyObserver();
    }

    public Pizarra obtenerPizarra(){
        return pizarra;
    }

    public Posicion posicionActual() {
        return posicion;
    }

    public int getX() {
        return this.posicion.getX();
    }

    public int getY() {
        return this.posicion.getY();
    }

    public void agregarObserverALaPizarra(Observer observer){
        pizarra.addObserver(observer);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(Observer::update);
    }
}