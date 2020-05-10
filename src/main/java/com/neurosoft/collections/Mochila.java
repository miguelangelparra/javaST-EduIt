/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.collections;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author m.parra.davila
 */
//Es necesasrio hacerlo comparable para agregarlo al treeset
public class Mochila implements Comparable<Mochila> {

    private String color;
    private String capacidad;

    public Mochila(String color, String capacidad) {
        this.color = color;
        this.capacidad = capacidad;
    }

    public String getColor() {
        return color;
    }

    public String getCapacidad() {
        return capacidad;
    }

    //Es necesario darle el criterio de comparacion sobreescribiendo el metodo compareTo
    @Override
    public int compareTo(Mochila o) {
        int res = color.compareTo(o.color);
        if (res == 0) {
            res= Integer.valueOf(capacidad).compareTo(Integer.valueOf(o.capacidad));
        }
        return res;
    }

    @Override
    public String toString() {
        return "Mochila{" + "color=" + color + ", capacidad=" + capacidad + '}';
    }

}
