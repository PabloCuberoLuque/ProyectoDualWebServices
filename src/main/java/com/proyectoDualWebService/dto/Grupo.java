package com.proyectoDualWebService.dto;

import com.proyectoDualWebService.persistence.manager.impl.ManagerServicioImpl;
import com.proyectoDualWebService.persistence.manager.impl.ManagerUsuarioImpl;
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

    public Grupo(ResultSet result) {
        try {
            this.id = result.getInt("id");
            this.servicio = new ManagerServicioImpl().findById(result.getInt("servicio"));
            this.user1 = new ManagerUsuarioImpl().findById(result.getInt("user1"));
            this.user2 = new ManagerUsuarioImpl().findById(result.getInt("user2"));
            this.user3 = new ManagerUsuarioImpl().findById(result.getInt("user3"));
            this.user4 = new ManagerUsuarioImpl().findById(result.getInt("user4"));
            this.user5 = new ManagerUsuarioImpl().findById(result.getInt("user5"));
            this.user6 = new ManagerUsuarioImpl().findById(result.getInt("user6"));
            this.user7 = new ManagerUsuarioImpl().findById(result.getInt("user7"));
            this.user8 = new ManagerUsuarioImpl().findById(result.getInt("user8"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
