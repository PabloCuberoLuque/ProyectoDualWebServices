package com.proyectoDualWebService.persistence.manager.impl;

import com.proyectoDualWebService.dto.Servicio;
import com.proyectoDualWebService.persistence.conector.MySQLConnector;
import com.proyectoDualWebService.persistence.manager.ManagerServicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManagerServicioImpl implements ManagerServicio {
    private final static MySQLConnector conector = new MySQLConnector();

    @Override
    public List<Servicio> findAll() {
        List<Servicio> servicios = new ArrayList<>();

        try {
            Connection con = conector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("SELECT * FROM servicio");

            while (result.next()) {
                servicios.add(new Servicio(result));
            }

            con.close();

            return servicios;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Servicio> findAllById(Set<Integer> ids) {
        String sql = String.format("SELECT * FROM servicio WHERE id IN (%s)", ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining(", ")));

        try {
            Connection con = conector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery(sql);

            List<Servicio> servicios = new ArrayList<>();

            while (result.next()) {
                Servicio servicio = new Servicio();
                servicios.add(servicio);
            }

            con.close();

            return servicios;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public Servicio findById(int id) {
        String sql = "SELECT * FROM servicio WHERE ID = ?";

        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();


            //Inicializo variable
            Servicio servicio = null;


            while (result.next()) {
                //Inicializo un usuario para cada resultado
                servicio = new Servicio(result);
            }

            con.close();

            return servicio;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public void insert(Servicio obj) {
        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement statement = con.prepareStatement("INSERT INTO servicio (precio, nombre, web) VALUES (?, ?, ?)");
            statement.setDouble(1, obj.getPrecio());
            statement.setString(2, obj.getNombre());
            statement.setString(3, obj.getWeb());

            statement.executeUpdate();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Servicio obj) {
        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement statement = con.prepareStatement("UPDATE servicio SET nombre = ?, precio = ?, web = ? WHERE id = ?");
            statement.setString(1, obj.getNombre());
            statement.setDouble(2, obj.getPrecio());
            statement.setString(3, obj.getWeb());
            statement.setInt(4, obj.getId());

            statement.executeUpdate();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement statement = con.prepareStatement("DELETE FROM servicio WHERE id = ?");
            statement.setInt(1, id);

            statement.executeUpdate();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

