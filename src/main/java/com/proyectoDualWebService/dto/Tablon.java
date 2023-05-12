package com.proyectoDualWebService.dto;

import com.proyectoDualWebService.dao.UsuarioDAO;
import jakarta.json.bind.annotation.JsonbDateFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tablon {

    private int id;
    private String mensaje;
    private Usuario id_user;
    private int likes;
    @JsonbDateFormat
    private LocalDateTime createdAt;

    public Tablon(ResultSet result){
        try {
            this.id = result.getInt("id");
            this.mensaje = result.getString("mensage");
            this.id_user = new UsuarioDAO().findbyId(result.getInt("id_user"));
            this.likes = result.getInt("likes");
            this.createdAt = result.getTimestamp("create_at").toLocalDateTime();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}