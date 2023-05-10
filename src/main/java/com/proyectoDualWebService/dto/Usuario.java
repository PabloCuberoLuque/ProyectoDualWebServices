package com.proyectoDualWebService.dto;

import lombok.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
    private int id;
    private String username;
    private String password;
    private String email;
    private String imagen;
    private Date nacimiento;
    private boolean admin;

    public Usuario(ResultSet result){
        try{
            this.id = result.getInt("id");
            this.username = result.getString("username");
            this.password = result.getString("password");
            this.email = result.getString("email");
            this.imagen = result.getString("img_perfil");
            this.nacimiento = result.getDate("nacimiento");
            this.admin = result.getBoolean("admin");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}