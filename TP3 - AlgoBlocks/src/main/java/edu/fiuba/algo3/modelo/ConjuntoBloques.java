package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.Observer;

import java.util.ArrayList;


public class ConjuntoBloques implements Bloque, Observable {

    protected ArrayList<Bloque> bloques;
    private ArrayList<Observer> observers;

    public ConjuntoBloques() {
        this.observers = new ArrayList<>();
        this.bloques = new ArrayList<>();
    }

    public void agregarBloque(Bloque bloque) {
        bloques.add(bloque);
        notifyObserver();
    }

    public Bloque obtenerUltimoBloque() throws AlgoritmoVacioException{
        if(bloques.isEmpty()){
            throw new AlgoritmoVacioException();
        }
        else{
            return bloques.get(bloques.size()-1);
        }
    }

    public void removerUltimoBloque() throws AlgoritmoVacioException{
        if (bloques.isEmpty()){
            throw new AlgoritmoVacioException();
        }
        else {
            bloques.remove(bloques.size()-1);
        }
    }

    public void clonar(ConjuntoBloques nuevo){

        for (Bloque bloque: bloques ) {
            nuevo.agregarBloque(bloque);
        }

    }

    public boolean estaVacio() {
        return bloques.isEmpty();
    }

    @Override
    public Pizarra ejecutar(Personaje personaje) {
        Pizarra pizarra = new Pizarra();
        for (Bloque unBloque : bloques) {
            pizarra = unBloque.ejecutar(personaje);
        }
        return pizarra;
    }

    @Override
    public Pizarra ejecutarInvertido(Personaje personaje) {
        Pizarra pizarra = new Pizarra();
        for (Bloque unBloque : bloques) {
             pizarra = unBloque.ejecutarInvertido(personaje);
        }
        return pizarra;
    }


    @Override
    public String obtenerNombre() {
        return "Conjunto Bloques";
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(Observer::update);
    }

    public void removerAlgoritmo() {
        bloques.clear();
    }
}