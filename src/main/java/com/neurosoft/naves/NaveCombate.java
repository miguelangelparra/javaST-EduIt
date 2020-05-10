/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.naves;

import java.util.ArrayList;

/**
 *
 * @author m.parra.davila
 */
public class NaveCombate extends Nave {

    private boolean visible;
    private boolean misilesDespleados;
    private ArrayList<String> mensajes = new ArrayList<String>();

    public NaveCombate(int velocidad, int direccion, int combustible, boolean visible, boolean misilesDesplegados) {
        super(velocidad, direccion, combustible);
        this.visible = visible;
        this.misilesDespleados = misilesDesplegados;

    }

    public void volverseVisible() {
        this.visible = true;
    }

    public void volverseInvisible() {
        this.visible = false;
    }

    public boolean estaInVisible() {
        return !this.visible;
    }

    public void desplegarMisiles() {
        this.misilesDespleados = true;
    }

    public void replegarMisiles() {
        this.misilesDespleados = false;
    }

    public boolean estanMisilesDesplegados() {
        return this.misilesDespleados;
    }

    public void emitirMensajes(String mensaje) {
        mensajes.add(mensaje);
    }

    public ArrayList<String> mensajesEmitidos() {
        return mensajes;
    }

    public String primerMensaje() {
        return mensajes.get(0);
    }

    public String ultimoMensaje() {
        return mensajes.get(mensajes.size() - 1);
    }

    //Es escueta si un mensaje es menor a 30 
    public boolean esEscueta() {
        for (int i = 0; i <= mensajes.size(); i++) {
            if (mensajes.get(i).length() < 30) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void pasosExtras() {
        // super.prepararViaje();
        this.volverseInvisible();
        this.acelerar(15000);
        this.emitirMensajes("Saliendo en Mision");
    }

    @Override
    protected void escapar() {
        this.acercarsePocoAlSol();
        this.acercarsePocoAlSol();
    }

    @Override
    protected void avisar() {
       this.emitirMensajes("Amenaza recibida");
    }

}
