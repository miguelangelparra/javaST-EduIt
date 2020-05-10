/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.collections;

/**
 *
 * @author m.parra.davila
 */
public class Poblacion {

    private String pais;
    private Long poblacion;

    public Poblacion(String pais, Long poblacion) {
        this.pais = pais;
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Poblacion{" + "pais=" + pais + ", poblacion=" + poblacion + '}';
    }

}
