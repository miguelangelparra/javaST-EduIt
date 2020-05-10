/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.BaseDeDatos;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author m.parra.davila
 */
public interface Dao<T> {

    T grabar(T entidad) throws SQLException;

    void actualizar(T entidad) throws SQLException;

    void eliminar(Integer id) throws SQLException;

    T obtenerUno(Integer id) throws SQLException;

    List<T> obtenerTodos() throws SQLException;
}
