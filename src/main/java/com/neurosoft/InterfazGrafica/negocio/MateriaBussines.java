/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.InterfazGrafica.negocio;

import com.neurosoft.InterfazGrafica.dominio.Materia;
import com.neurosoft.InterfazGrafica.persistencia.MateriaDao;
import com.neurosoft.InterfazGrafica.util.MateriaDuplicadaException;
import com.neurosoft.InterfazGrafica.util.NegocioException;

import java.sql.SQLException;

/**
 *
 * @author m.parra.davila
 */
public class MateriaBussines {

    private MateriaDao materiaDao;

    public MateriaBussines(MateriaDao materiaDao) {
        this.materiaDao = materiaDao;
    }

    public void crearMateria (String nombre, Integer cargaHoraria) throws NegocioException {
        //TODO agregar Validaciones

        Materia materia = new Materia();
        materia.setNombre(nombre);
        materia.setCargaHoraria(cargaHoraria);
        try {
            if(materiaDao.obtenerPor("nombre",nombre).size()>0){
                throw new MateriaDuplicadaException();
            }
            materiaDao.grabar(materia);
        } catch (SQLException e) {
            throw new NegocioException(e);
        }
    }
}
