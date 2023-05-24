package com.proyectoDualWebService.persistence.manager.impl;

import com.proyectoDualWebService.dto.Grupo;
import com.proyectoDualWebService.persistence.conector.MySQLConnector;
import com.proyectoDualWebService.persistence.manager.ManagerGrupo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManagerGrupoImpl implements ManagerGrupo {
    private final static MySQLConnector conector = new MySQLConnector();

    @Override
    public List<Grupo> findAll() {
        List<Grupo> grupos = new ArrayList<>();

        try {
            Connection con = conector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("SELECT * FROM grupo");

            while (result.next()) {
                grupos.add(new Grupo(result));
            }

            con.close();

            return grupos;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Grupo> findAllById(Set<Integer> ids) {
        String sql = String.format("SELECT * FROM grupo WHERE id IN (%s)", ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining(", ")));

        try {
            Connection con = conector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery(sql);

            List<Grupo> grupos = new ArrayList<>();

            while (result.next()) {
                Grupo grupo = new Grupo();
                grupos.add(grupo);
            }

            con.close();

            return grupos;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }





    @Override
    public Grupo findById(int id) {
        String sql = "SELECT * FROM grupo WHERE ID = ?";

        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            //Inicializo variable
            Grupo grupo = null;


            while (result.next()) {
                //Inicializo un usuario para cada resultado
                grupo = new Grupo(result);
            }

            con.close();

            return grupo;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }


    }


    @Override
    public List<Grupo> findByServicio(int servicio) {
        String sql = "SELECT * FROM grupo WHERE SERVICIO = ?";

        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, servicio);
            ResultSet result = stmt.executeQuery();

            List<Grupo> grupos = new ArrayList<>();

            while (result.next()) {
                Grupo grupo = new Grupo();
                grupos.add(grupo);
            }

            con.close();

            return grupos;


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void insert(Grupo obj) {
        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement statement = con.prepareStatement("INSERT INTO grupo (servicio ,user1 ,user2 ,user3, user4, user5, user6, user7, user8 ) VALUES (? ,? ,? ,?, ?, ?, ?, ? , ?)");
            statement.setInt(1, obj.getServicio().getId());
            statement.setInt(2, obj.getUser1().getId());
            statement.setInt(3, obj.getUser2().getId());

            statement.setInt(4, obj.getUser3().getId());
            statement.setInt(5, obj.getUser4().getId());
            statement.setInt(6, obj.getUser5().getId());
            statement.setInt(7, obj.getUser6().getId());
            statement.setInt(8, obj.getUser7().getId());
            statement.setInt(9, obj.getUser8().getId());


            statement.executeUpdate();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Grupo obj) {
        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement statement = con.prepareStatement("UPDATE grupo SET servicio = ?, user1 = ?, user2 = ?, user3 = ? , user4 = ?, user5 = ? , user6 = ?, user7 = ?, user8 = ?  WHERE id = ?");
            statement.setInt(1, obj.getServicio().getId());
            statement.setInt(2, obj.getUser1().getId());
            statement.setInt(3, obj.getUser2().getId());
            statement.setInt(4, obj.getUser3().getId());
            statement.setInt(5, obj.getUser4().getId());
            statement.setInt(6, obj.getUser5().getId());
            statement.setInt(7, obj.getUser6().getId());
            statement.setInt(8, obj.getUser7().getId());
            statement.setInt(9, obj.getUser8().getId());


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
            PreparedStatement statement = con.prepareStatement("DELETE FROM grupo WHERE (id = ?)");
            statement.setInt(1, id);


            statement.executeUpdate();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
