package com.proyectoDualWebService.persistence.manager.impl;

import com.proyectoDualWebService.dto.Usuario;
import com.proyectoDualWebService.persistence.conector.MySQLConnector;
import com.proyectoDualWebService.persistence.manager.ManagerUsuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManagerUsuarioImpl implements ManagerUsuario {
    private final static MySQLConnector conector = new MySQLConnector();

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            Connection con = conector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("SELECT * FROM usuario");

            while (result.next()) {
                usuarios.add(new Usuario(result));
            }

            con.close();

            return usuarios;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public List<Usuario> findAllById(Set<Integer> ids) {
        String sql = String.format("SELECT * FROM usuario WHERE id IN (%s)", ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining(", ")));

        try {
            Connection con = conector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery(sql);

            List<Usuario> usuarios = new ArrayList<>();

            while (result.next()) {
                Usuario usuario = new Usuario();
                usuarios.add(usuario);
            }

            con.close();

            return usuarios;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }


    }


    @Override
    public Usuario findById(int id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();


            //Inicializo variable
            Usuario usuario = null;


            while (result.next()) {
                //Inicializo un usuario para cada resultado
                usuario = new Usuario(result);
            }

            con.close();

            return usuario;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Usuario findByUsername(String username) {
        String sql = "SELECT * FROM usuario WHERE usuario = ?";

        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();


            //Inicializo variable
            Usuario usuario = null;


            while (result.next()) {
                //Inicializo un usuario para cada resultado
                usuario = new Usuario(result);
            }

            return usuario;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario findByEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE email = ?";

        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();


            //Inicializo variable
            Usuario usuario = null;


            while (result.next()) {
                //Inicializo un usuario para cada resultado
                usuario = new Usuario(result);
            }

            con.close();

            return usuario;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insert(Usuario obj) {
        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement statement = con.prepareStatement("INSERT INTO usuario (usuario, pass, email, img_perfil, nacimiento, admin) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, obj.getUsername());
            statement.setString(2, obj.getPassword());
            statement.setString(3, obj.getEmail());
            statement.setString(4, obj.getImagen());
            statement.setDate(5, Date.valueOf(obj.getNacimiento()));
            statement.setBoolean(6, obj.isAdmin());


            statement.executeUpdate();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Usuario obj) {
        try {
            Connection con = conector.getMySQLConnection();
            PreparedStatement statement = con.prepareStatement("UPDATE usuario SET usuario = ?, pass = ?, email = ?,img_perfil = ? , nacimiento = ?, admin = ? WHERE id = ?");
            statement.setString(1, obj.getUsername());
            statement.setString(2, obj.getPassword());
            statement.setString(3, obj.getEmail());
            statement.setString(4, obj.getImagen());
            statement.setDate(5, Date.valueOf(obj.getNacimiento()));
            statement.setBoolean(6, obj.isAdmin());
            statement.setInt(7, obj.getId());


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





