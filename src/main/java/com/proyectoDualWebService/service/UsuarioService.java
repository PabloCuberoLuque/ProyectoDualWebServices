package com.proyectoDualWebService.service;

//TODO REVISAR LOS .CLOSE()

import com.proyectoDualWebService.conector.MySQLConnector;
import com.proyectoDualWebService.dto.Usuario;
import com.proyectoDualWebService.persistence.manager.ManagerUsuario;
import com.proyectoDualWebService.persistence.manager.impl.ManagerUsuarioImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private static final MySQLConnector connector = new MySQLConnector();
    private final ManagerUsuario managerUsuario;
    private Connection connection;

    public UsuarioService(ManagerUsuarioImpl managerUsuario){
        this.managerUsuario = managerUsuario;
    }

    public List<Usuario> findAllUsuario() {
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
        return managerUsuario.findById(id);
    }

    //TODO
    //IMPLEMENTAR METODO
    //private static final String FIND_BY_NAME = "SELECT * FROM user WHERE name=?";

    public int createUser(Usuario usuario) {
        return managerUsuario.create(usuario);
    }

    public boolean updateUser(Usuario usuario) {
        return managerUsuario.update(usuario);
    }

    public boolean deleteUser(int id) throws SQLException, ClassNotFoundException{
            return managerUsuario.delete(id);
    }

}
