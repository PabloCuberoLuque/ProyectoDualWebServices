package com.proyectoDualWebService.dao;

import com.proyectoDualWebService.dto.Usuario;
import com.proyectoDualWebService.persistence.conector.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {

    private final static MySQLConnector connector = new MySQLConnector();

    public Usuario findbyId(int id) {
        try {
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            Usuario usu = null;
            while (result.next()) {
                usu = new Usuario(result);
            }
            return usu;
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Usuario findbyEmail(String email){
        try {
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario WHERE email LIKE ?");
            stmt.setString(1, "%"+email+"%");
            ResultSet result = stmt.executeQuery();
            Usuario usu = null;
            while (result.next()) {
                usu = new Usuario(result);
            }
            return usu;
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
