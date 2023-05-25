package com.proyectoDualWebService.service;

import com.proyectoDualWebService.conector.MySQLConnector;
import com.proyectoDualWebService.dto.Tablon;
import com.proyectoDualWebService.persistence.manager.ManagerTablon;
import com.proyectoDualWebService.persistence.manager.impl.ManagerTablonImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TablonService {
    private Connection connection;
    private static final MySQLConnector connector = new MySQLConnector();

    private final ManagerTablon managerTablon;

    public TablonService(ManagerTablonImpl managerTablon) {
        this.managerTablon = managerTablon;
    }

    public List<Tablon> findAll() {
        List<Tablon> tablones = new ArrayList<>();
        String sql = "SELECT * FROM tablon";
        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {
            while (result.next()) {
                Tablon tablon = new Tablon(result);
                tablones.add(tablon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tablones;
    }

    public Tablon findById(int id) {
        return managerTablon.findById(id);
    }

    public int createTablon(Tablon tablon) {
        return managerTablon.create(tablon);
    }

    public boolean updateTablon(Tablon tablon) {
        return managerTablon.update(tablon);
    }

    public boolean deleteTablon(int id) {
        return managerTablon.delete(id);
    }
}