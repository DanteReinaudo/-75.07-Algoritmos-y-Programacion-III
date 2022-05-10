package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.vista.Observer;

public interface Observable {

    void addObserver(Observer observer);
    void notifyObserver();
}
