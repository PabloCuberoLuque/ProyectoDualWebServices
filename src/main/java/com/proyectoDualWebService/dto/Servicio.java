package com.proyectoDualWebService.dto;

import lombok.*;


import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {
    private int id;
    private String nombre;
    private String plan;
    private double precio;
    private String web;


    public Servicio(ResultSet result) {
        try {
            this.id = result.getInt("id");
            this.nombre = result.getString("nombre");
            this.plan = result.getString("plan");
            this.precio = result.getDouble("precio");
            this.web = result.getString("web");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
