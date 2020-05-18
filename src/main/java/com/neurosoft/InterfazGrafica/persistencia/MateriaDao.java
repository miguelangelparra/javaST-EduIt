/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neurosoft.InterfazGrafica.persistencia;

import com.neurosoft.InterfazGrafica.dominio.Materia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author m.parra.davila
 */
public class MateriaDao extends DaoSupport<Materia> {

    private ConnectionManager connectionManager;

    public MateriaDao(ConnectionManager connectionManager) {
        super(connectionManager);
    }

    @Override
    protected String sqlActualizar(Materia entidad) {
        return "UPDATE materia set nombre= ? , carga_horaria= ? WHERE id = ?";
    }

    @Override
    protected Materia createEntity(ResultSet resultSet) throws SQLException {
        Materia materia = new Materia();
        materia.setId(resultSet.getInt("id"));
        materia.setNombre(resultSet.getString("nombre"));
        materia.setCargaHoraria(resultSet.getInt("carga_horaria"));
        return materia;
    }

    @Override
    protected String tableName() {
        return "materia";
    }

    @Override
    protected String sqlInsert(Materia entidad
    ) {
        return "insert into Materia (nombre,carga_horaria) values(?,?)";
    }

    @Override
    protected Map<Integer, Object> getParameters(Materia entidad
    ) {
        Map<Integer, Object> parametros = new HashMap<>();
        parametros.put(1, entidad.getNombre());
        parametros.put(2, entidad.getCargaHoraria());
        return parametros;
    }

    /*
    @Override
    public Materia grabar(Materia entidad) throws SQLException {

        String sql = "insert into materia(nombre,carga_horaria¨) value (?,?)";
        PreparedStatement stmt = connectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, entidad.getNombre());
        stmt.setInt(2, entidad.getCargaHoraria());
        stmt.executeUpdate();

        ResultSet keys = stmt.getGeneratedKeys();
        if (keys.next()) {
            entidad.setId(keys.getInt(1));
        }
        return entidad;
    }

    @Override
    public void actualizar(Materia entidad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Materia obtenerUno(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Materia> obtenerTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     */
}
