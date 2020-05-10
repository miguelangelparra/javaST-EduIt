/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.BaseDeDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author m.parra.davila
 */
public class EstudianteDao implements Dao<Estudiante> {

    private ConnectionManager connectionManager;

    public EstudianteDao(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public Estudiante grabar(Estudiante estudiante) throws SQLException {
        //Los simbolos ? indican que alli iran valores. 
        String sql = "insert into estudiante (nombre, apellido, padron) values (?, ?, ?)";
        //Prepara el script que será eejecutado. El segundo paramentro pide el id generado
        PreparedStatement statement = connectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        //Setea los valores, comenzando por 1
        statement.setString(1, estudiante.getNombre());
        statement.setString(2, estudiante.getApellido());
        statement.setString(3, estudiante.getPadron());
        //Ejecuta el script 
        statement.executeUpdate();

        // vuelve a consultar la base para pedirle el idgenerado
        ResultSet keys = statement.getGeneratedKeys();
        //Setea al objeto el id generado
        if (keys.next()) {
            estudiante.setId(keys.getInt(1));
        }
        return estudiante;
    }

    @Override
    public void actualizar(Estudiante estudiante) throws SQLException {
        String sql = "UPDATE estudiante set nombre=?,apellido=?,padron=? WHERE id= ?";
        PreparedStatement stmt = connectionManager.getConnection().prepareStatement(sql);
        stmt.setString(1, estudiante.getNombre());
        stmt.setString(2, estudiante.getApellido());
        stmt.setString(3, estudiante.getPadron());
        stmt.setInt(4, estudiante.getId());
        stmt.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        String sql = "DELETE from estudiante WHERE id=?";
        PreparedStatement stmt = connectionManager.getConnection().prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    @Override
    public Estudiante obtenerUno(Integer id) throws SQLException {
        String sql = "SELECT * FROM estudiante WHERE id= ?";
        PreparedStatement statement = connectionManager.getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Estudiante estudiante = null;
        if (resultSet.next()) {
            estudiante = construirEstudiante(resultSet);
        }
        return estudiante;

    }

    @Override
    public List<Estudiante> obtenerTodos() throws SQLException {
        String sql = "SELECT * from estudiante";
        Statement stmt = connectionManager.getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        while (resultSet.next()) {
            estudiantes.add(construirEstudiante(resultSet));
        }
        return estudiantes;
    }

    private Estudiante construirEstudiante(ResultSet resultSet) throws SQLException {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(resultSet.getInt("id"));
        estudiante.setNombre(resultSet.getString("nombre"));
        estudiante.setApellido(resultSet.getString("apellido"));
        estudiante.setPadron(resultSet.getString("padron"));
        return estudiante;

    }

}
