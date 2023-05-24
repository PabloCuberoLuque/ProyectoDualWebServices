package com.proyectoDualWebService.dao;

//TODO REVISAR LOS .CLOSE()

import com.proyectoDualWebService.conector.MySQLConnector;
import com.proyectoDualWebService.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static final MySQLConnector connector = new MySQLConnector();
    private Connection connection;

    public List<Usuario> obtenerTodoUsuario() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection connection = connector.getMySQLConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuario");
            while (resultSet.next()) {
                Usuario usuario = new Usuario(resultSet);
                usuarios.add(usuario);
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public Usuario findById(int id) {
        Usuario usuario = null;
        try {
            Connection connection = connector.getMySQLConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM usuario WHERE id = ?"
            );
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                usuario = new Usuario(resultSet);
            }
            return usuario;
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //IMPLEMENTAR METODO
    //private static final String FIND_BY_NAME = "SELECT * FROM user WHERE name=?";

    public void insertarUsuario(Usuario usuario) {
        try {
            Connection connection = connector.getMySQLConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO usuario (usuario, pass, email, nacimiento, admin) VALUES (?, ?, ?, ?, ?)"
            );
            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getPassword());
            statement.setString(3, usuario.getEmail());
            statement.setDate(4, Date.valueOf(usuario.getNacimiento()));
            statement.setInt(5, usuario.isAdmin() ? 1 : 0);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarUsuario(Usuario usuario) {
        try {
            Connection connection = connector.getMySQLConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE usuario SET usuario = ?, pass = ?, email = ?, nacimiento = ?, admin = ? WHERE id = ?"
            );
            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getPassword());
            statement.setString(3, usuario.getEmail());
            statement.setDate(4, Date.valueOf(usuario.getNacimiento()));
            statement.setInt(5, usuario.isAdmin() ? 1 : 0);
            statement.setInt(6, usuario.getId());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int id) {
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
