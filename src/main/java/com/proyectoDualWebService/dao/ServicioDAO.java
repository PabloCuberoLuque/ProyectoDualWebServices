package com.proyectoDualWebService.dao;


import com.proyectoDualWebService.conector.MySQLConnector;
import com.proyectoDualWebService.model.Servicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO {
    private static final MySQLConnector connector = new MySQLConnector();
    private Connection connection;

    public List<Servicio> obtenerTodoServicio() {
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

    public Servicio obtenerServicio(int id) {
        Servicio servicio = null;
        try {
            Connection connection = connector.getMySQLConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM servicio WHERE id = ?"
            );
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                servicio = new Servicio(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getFloat("precio"),
                        resultSet.getString("web")
                );
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return servicio;
    }


    public void insertarServicio(Servicio servicio) {
        try {
            Connection connection = connector.getMySQLConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO servicio (nombre, precio, web) VALUES (?, ?, ?)"
            );
            statement.setString(1, servicio.getNombre());
            statement.setDouble(2, servicio.getPrecio());
            statement.setString(3, servicio.getWeb());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }



    public void actualizarServicio(Servicio servicio) {
        try {
            Connection connection = connector.getMySQLConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE servicio SET nombre = ?, precio = ?, web = ? WHERE id = ?"
            );
            statement.setString(1, servicio.getNombre());
            statement.setDouble(2, servicio.getPrecio());
            statement.setString(3, servicio.getWeb());
            statement.setInt(4, servicio.getId());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarServicio(int id) {
        try {
            Connection connection = connector.getMySQLConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM usuario WHERE id = ?"
            );
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}