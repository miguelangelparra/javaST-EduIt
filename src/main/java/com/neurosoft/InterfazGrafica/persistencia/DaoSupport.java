/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.InterfazGrafica.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author m.parra.davila
 */
public abstract class DaoSupport<T extends Entidad> implements Dao<T> {

    private ConnectionManager connectionManager;

    public DaoSupport(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    //Metodo que crea la entidad cada clase de entidad define como se construye.
    protected abstract T createEntity(ResultSet resultSet) throws SQLException;

    //Metodo que devuelve nombre de la tabla a afectar. Lo define la entidad
    protected abstract String tableName();

    protected abstract String sqlActualizar(T entidad);

    protected abstract String sqlInsert(T entidad);

    protected abstract Map<Integer, Object> getParameters(T entidad);

    //Metodo generico para setear el preparedStatement
    private void setParameters(T entidad, PreparedStatement preparedStatement) {
        getParameters(entidad).forEach((Integer position, Object value) -> {
            try {
                preparedStatement.setObject(position, value);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public T grabar(T entidad) throws SQLException {
        String sql = sqlInsert(entidad);
        PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        setParameters(entidad, preparedStatement);
        preparedStatement.executeUpdate();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            entidad.setId(generatedKeys.getInt(1));
        }

        return entidad;
    }

    @Override
    public void actualizar(T entidad) throws SQLException {
        String sql = sqlActualizar(entidad);
        PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement(sql);
        setParameters(entidad, preparedStatement);
        preparedStatement.setInt(getParameters(entidad).size() + 1, entidad.getId());
        preparedStatement.executeUpdate();

    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        String sql = "DELETE FROm " + tableName() + " WHERE id = ?";
        PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public T obtenerUno(Integer id) throws SQLException {
        String sql = "SELECT * from " + tableName() + " WHERE id = ?";
        PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        T entidad = null;
        //Confirma si se obtuvo un resultado
        if (resultSet.next()) {
            //Crea una entidad con el resultado de la query
            entidad = createEntity(resultSet);
        }
        return entidad;
    }

    @Override
    public List<T> obtenerTodos() throws SQLException {
        String sql = "SELECT * from " + tableName();
        Statement statement = connectionManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<T> entidades = new ArrayList<>();
        while (resultSet.next()) {
            entidades.add(createEntity(resultSet));
        }
        return entidades;
    }

    public List<T> obtenerPor(String campo, Object value) throws SQLException {
        String sql = "SELECT * from " + tableName() + " where " + campo + " = ?";
        PreparedStatement preparedStatement = connectionManager.getConnection().prepareStatement(sql);
        preparedStatement.setObject(1, value);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<T> entidades = new ArrayList<>();
        while (resultSet.next()) {
            entidades.add(createEntity(resultSet));
        }
        return entidades;
    }


}
