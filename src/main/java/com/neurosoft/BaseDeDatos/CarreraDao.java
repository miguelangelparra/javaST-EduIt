/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.BaseDeDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author m.parra.davila
 */
public class CarreraDao extends DaoSupport<Carrera> {

    @Override
    protected Carrera createEntity(ResultSet rs) throws SQLException {
        Carrera carrera = new Carrera();
        carrera.setId(rs.getInt("id"));
        carrera.setNombre(rs.getString("nombre"));
        return carrera;
    }

    @Override
    protected String sqlActualizar(Carrera entidad) {
        return "UPDATE carrera SET nombre=? WHERE id= ?";
    }

    @Override
    protected String tableName() {
        return "carrera";
    }

    public CarreraDao(ConnectionManager cm) {
        super(cm);
    }

    @Override
    protected String sqlInsert(Carrera entidad) {
        return "insert into carrera (nombre) values (?)";
    }

    @Override
    protected Map<Integer, Object> getParameters(Carrera entidad) {
        Map<Integer, Object> parametros = new HashMap<>();
        parametros.put(1, entidad.getNombre());
        return parametros;
    }
}
