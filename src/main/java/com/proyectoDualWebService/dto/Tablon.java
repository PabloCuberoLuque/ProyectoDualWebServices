package com.proyectoDualWebService.dto;

import lombok.*;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tablon {
    private int id;
    private String message;
    private int idUsuario;
    private int likes = 0;
    private Timestamp createAt;


    public Tablon(ResultSet result) {
        try {
            this.id = result.getInt("id");
            this.message = result.getString("mensage");
            this.idUsuario = result.getInt("id_user");
            this.likes = result.getInt("likes");
            this.createAt = result.getTimestamp("create_at");

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}
