package com.proyectoDualWebService.dao;

import com.proyectoDualWebService.comparators.TablonComparator;
import com.proyectoDualWebService.dto.Tablon;
import com.proyectoDualWebService.persistence.conector.MySQLConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class TablonDAO {

    private final static MySQLConnector connector = new MySQLConnector();

    public List<Tablon> findAll(){
        try {
            Connection con = connector.getMySQLConnection();
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("SELECT * FROM tablon");

            List<Tablon> res = new ArrayList<>();
            while (result.next()){
                res.add(new Tablon(result));
            }

            Collections.sort(res, new TablonComparator());

            con.close();
            return res;
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
