package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.Observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Pizarra implements Observable {

    private HashSet<Trazo> trazosPintados;
    private ArrayList<Observer> observers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizarra pizarra = (Pizarra) o;
        return pizarra.trazosPintados.equals(this.trazosPintados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trazosPintados);
    }

    public Pizarra() {
        observers = new ArrayList<>();
        trazosPintados = new HashSet<>();
        notifyObserver();
    }

    public void pintarTrazo(Trazo trazo) {
        trazosPintados.add(trazo);
        notifyObserver();
    }

    public void eliminarTrazos() {
        trazosPintados.clear();
        notifyObserver();
    }

    public HashSet<Trazo> obtenerTrazos(){
        return trazosPintados;
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