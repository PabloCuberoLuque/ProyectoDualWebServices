package com.proyectoDualWebService.persistence.manager.impl;

import com.proyectoDualWebService.comparators.TablonComparator;
import com.proyectoDualWebService.dto.Tablon;
import com.proyectoDualWebService.persistence.conector.MySQLConnector;
import com.proyectoDualWebService.persistence.manager.ManagerTablon;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class ManagerTablonImpl implements ManagerTablon {
    private final static MySQLConnector conector = new MySQLConnector();

    @Override
    public List<Tablon> findAll() {
        List<Tablon> posts = new ArrayList<>();

        try {
            Connection con = conector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("SELECT * FROM tablon");

            while (result.next()) {
                posts.add(new Tablon(result));
            }

            Collections.sort(posts, new TablonComparator());
            con.close();

            return posts;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Tablon> findAllById(Set<Integer> ids) {
        String sql = String.format("SELECT * FROM tablon WHERE id IN (%s)", ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining(", ")));

        try {
            Connection con = conector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery(sql);

            List<Tablon> posts = new ArrayList<>();

            while (result.next()) {
                Tablon post = new Tablon();
                posts.add(post);
            }

            Collections.sort(posts, new TablonComparator());

            con.close();

            return posts;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Tablon findById(int id) {
        String sql = "SELECT * FROM tablon WHERE id = ?";

        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            //Inicializo variable
            Tablon post = null;


            while (result.next()) {
                //Inicializo un usuario para cada resultado
                post = new Tablon(result);
            }

            con.close();

            return post;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Tablon> findByIdUser(int idUsuario) {
        String sql = "SELECT * FROM tablon WHERE id_user = ?";

        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, idUsuario);
            ResultSet result = stmt.executeQuery();

            List<Tablon> posts = new ArrayList<>();

            while (result.next()) {
                Tablon post = new Tablon();
                posts.add(post);
            }

            Collections.sort(posts, new TablonComparator());
            con.close();

            return posts;


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Tablon> findByDate(Timestamp createAt) {
        String sql = "SELECT * FROM tablon WHERE create_at = ?";

        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setTimestamp(1, createAt);
            ResultSet result = stmt.executeQuery();

            List<Tablon> posts = new ArrayList<>();

            while (result.next()) {
                Tablon post = new Tablon();
                posts.add(post);
            }

            Collections.sort(posts, new TablonComparator());

            con.close();

            return posts;


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insert(Tablon obj) {
        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement statement = con.prepareStatement("INSERT INTO tablon (mensage, id_user, likes, create_at) VALUES (?, ?, ?, ?)");
            statement.setString(1, obj.getMessage());
            statement.setInt(2, obj.getIdUsuario());
            statement.setInt(3, obj.getLikes());
            statement.setTimestamp(4, obj.getCreateAt());

            statement.executeUpdate();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Tablon obj) {
        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement statement = con.prepareStatement("UPDATE tablon SET mensage = ?, id_user = ?, likes = ?, create_at = ? WHERE id = ?");
            statement.setString(1, obj.getMessage());
            statement.setInt(2, obj.getIdUsuario());
            statement.setInt(3, obj.getLikes());
            statement.setTimestamp(4, obj.getCreateAt());
            statement.setInt(5, obj.getId());


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
            PreparedStatement statement = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
            statement.setInt(1, id);


            statement.executeUpdate();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

