package com.proyectoDualWebService.dto;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int id;
    private String username;
    private String password;
    private String email;
    private String imagen;
    private LocalDate nacimiento;
    private boolean admin;

    public Usuario(ResultSet result) {
        try {
            this.id = result.getInt("id");
            this.username = result.getString("usuario");
            this.password = result.getString("pass");
            this.email = result.getString("email");
            this.imagen = result.getString("img_perfil");
            this.nacimiento = result.getDate("nacimiento").toLocalDate();
            this.admin = result.getBoolean("admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
