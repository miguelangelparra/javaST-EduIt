/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.programadores;

/**
 *
 * @author m.parra.davila
 */
public class ProgramadorJava extends Persona implements Programador {

    private String senority;

    public ProgramadorJava(String nombre, String senority) {
        super(nombre);
        this.senority = senority;
    }

    @Override
    public void programar(String codigofuente) {
        System.out.println("Soy un programador Java y estoy utilizando un metodo desde una interface implementada");
    }

    @Override
    public void debugear() {
        System.out.println("Debugueando en  Java y estoy utilizando un metodo desde una interface implementada");

    }

    @Override
    public String toString() {
        return "ProgramadorJava{" + "nombre=" + getNombre() + ",senority=" + senority + '}';
    }

}
