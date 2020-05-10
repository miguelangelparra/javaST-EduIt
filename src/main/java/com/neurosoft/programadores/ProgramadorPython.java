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
public class ProgramadorPython extends Persona implements Programador, ScrumMaster {

    public ProgramadorPython(String nombre) {
        super(nombre);
    }

    @Override
    public void programar(String codigofuente) {
        System.out.println("Soy un programador Python y estoy utilizando un metodo desde una interface implementada que tambien usa el programador Java");
    }

    @Override
    public void debugear() {
        System.out.println("Soy un programador Python y estoy utilizando un metodo desde una interface implementada");
    }

    public void weekly() {
        System.out.println("Semanalmente reviso como Scrum");
    }

    @Override
    public String toString() {
        return "ProgramadorPython{" + getNombre()+'}';
    }

    
}
