package com.proyectoDualWebService.dao;

import com.proyectoDualWebService.comparators.TablonComparator;
import com.proyectoDualWebService.dto.Tablon;
import com.proyectoDualWebService.persistence.conector.MySQLConnector;

import java.sql.*;
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

    public Tablon findById(int id){
        try {
            Connection con = connector.getMySQLConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM tablon WHERE id = ?");
            stmt.setInt(1,id);
            ResultSet result = stmt.executeQuery();
            Tablon tab = null;
            while (result.next()){
                tab = new Tablon(result);
            }
            con.close();
            return tab;
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Tablon> findByUserId(int id){
        try {
            Connection con = connector.getMySQLConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM tablon WHERE id_user = ?");
            stmt.setInt(1,id);
            ResultSet result = stmt.executeQuery();
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
