package com.proyectoDualWebService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Grupo {
    private int id;
    private Servicio servicio;
    private Usuario user1;
    private Usuario user2;
    private Usuario user3;
    private Usuario user4;
    private Usuario user5;
    private Usuario user6;
    private Usuario user7;
    private Usuario user8;

    /*public Grupo(ResultSet result){
        try  {
            this.id = result.getInt("id");
            this.servicio = new ServivioDAO.getId(result.getInt("servicio"));
            this.user1 = result.getInt("user1");
            this.user2 = result.getInt("user2");
            this.user3 = (Integer) result.getObject("user3");
            this.user4 = (Integer) result.getObject("user4");
            this.user5 = (Integer) result.getObject("user5");
            this.user6 = (Integer) result.getObject("user6");
            this.user7 = (Integer) result.getObject("user7");
            this.user8 = (Integer) result.getObject("user8");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}