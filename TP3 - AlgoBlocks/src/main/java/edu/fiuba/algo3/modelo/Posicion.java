package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Posicion {

    private final int NMAX = 5;

    private int x;
    private int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Posicion(Posicion posicion) {
        this.x = posicion.x;
        this.y = posicion.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return x == posicion.x && y == posicion.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void arriba() {
        if(y == -NMAX) {
            y = NMAX;
        } else {
            y = y - 1;
        }
    }

    public void abajo() {
        if(y == NMAX) {
            y = -NMAX;
        } else {
            y = y + 1;
        }
    }

    public void izquierda() {
        if(x == -NMAX) {
            x = NMAX;
        } else {
            x = x - 1;
        }
    }

    public void derecha() {
        if(x == NMAX) {
            x = -NMAX;
        } else {
            x = x + 1;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}