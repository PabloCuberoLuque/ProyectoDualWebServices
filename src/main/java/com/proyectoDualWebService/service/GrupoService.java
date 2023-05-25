package com.proyectoDualWebService.service;


import com.proyectoDualWebService.dto.Grupo;
import com.proyectoDualWebService.persistence.connector.MySQLConnector;
import com.proyectoDualWebService.persistence.manager.ManagerGrupo;
import com.proyectoDualWebService.persistence.manager.impl.ManagerGrupoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrupoService {

    private static final MySQLConnector connector = new MySQLConnector();

    private final ManagerGrupo managerGrupo;
    private Connection connection;

    public GrupoService(ManagerGrupoImpl managerGrupo) {
        this.managerGrupo = managerGrupo;
    }

    public List<Grupo> findAllGrupo() {
        List<Grupo> grupos = new ArrayList<>();
        String sql = "SELECT * FROM grupo";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()) {
            while (result.next()) {
                grupos.add(new Grupo(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grupos;
    }

    public Grupo findByIdGrupo(int id) {
        return managerGrupo.findById(id);
    }

    public int createGrupo(Grupo grupo) {
        return managerGrupo.create(grupo);
    }

    public boolean updateGrupo(Grupo grupo) {
        return managerGrupo.update(grupo);
    }

    public boolean deleteGrupo(int id) throws SQLException, ClassNotFoundException{
        return managerGrupo.delete(id);
    }
}
