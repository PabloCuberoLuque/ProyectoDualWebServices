package com.proyectoDualWebService.service;


import com.proyectoDualWebService.conector.MySQLConnector;
import com.proyectoDualWebService.dto.Servicio;
import com.proyectoDualWebService.persistence.manager.ManagerServicio;
import com.proyectoDualWebService.persistence.manager.impl.ManagerServicioImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioService {
    private static final MySQLConnector connector = new MySQLConnector();
    private final ManagerServicio managerServicio;
    private Connection connection;

    public ServicioService(ManagerServicioImpl managerServicio) {
        this.managerServicio = managerServicio;
    }

    public List<Servicio> findAllServicio() {
        List<Servicio> servicios = new ArrayList<>();
        try {
            Connection connection = connector.getMySQLConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM servicio");
            while (resultSet.next()) {
                Servicio servicio = new Servicio(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getFloat("precio"),
                        resultSet.getString("web")
                );
                servicios.add(servicio);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return servicios;
    }

    public Servicio findByIdServicio(int id) {
        return managerServicio.findById(id);
    }


    public int createServicio(Servicio servicio) {
        return managerServicio.create(servicio);
    }



    public boolean updateServicio(Servicio servicio) {
        return managerServicio.update(servicio);
    }

    public boolean deleteServicio(int id) {
        return managerServicio.delete(id);
    }

}