package com.proyectoDualWebService.dao;

import com.proyectoDualWebService.dto.Tablon;
import com.proyectoDualWebService.persistence.conector.MySQLConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class TablonDAO {

    private final static MySQLConnector connector = new MySQLConnector();

    public Set<Tablon> findAll(){
        try {
            Connection con = connector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("SELECT * FROM tablon");

            Set<Tablon> res = new HashSet<>();
            while (result.next()){
                res.add(new Tablon(result));
            }
            con.close();
            return res;
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
