/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.InterfazGrafica.dominio;

import com.neurosoft.InterfazGrafica.persistencia.Entidad;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author m.parra.davila
 */
public class Materia extends Entidad {

    private String nombre;
    private int cargaHoraria;
    //private List<Carrera> carreras;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

   /* public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
*/
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + this.cargaHoraria;
    //    hash = 29 * hash + Objects.hashCode(this.carreras);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia other = (Materia) obj;
        if (this.cargaHoraria != other.cargaHoraria) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
    /*    if (!Objects.equals(this.carreras, other.carreras)) {
            return false;
        }*/
        return true;

    }

    @Override
    public String toString() {
//        return "Materia{" + "id=" + this.getId() + ", nombre=" + nombre + ", cargaHoraria=" + cargaHoraria + ", carreras=" + carreras + '}';
        return "Materia{" + "id=" + this.getId() + ", nombre=" + nombre + ", cargaHoraria=" + cargaHoraria + '}';

    }


}
