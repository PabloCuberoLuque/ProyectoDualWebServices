package com.proyectoDualWebService.dao;

import com.proyectoDualWebService.dto.Usuario;

import java.sql.Date;


public class UsuarioDAO {

    public Usuario findbyId(int id){
        Usuario user = new Usuario(id, "pepe", "1234", "pepe@gmail.com", "img.jpg", Date.valueOf("2001-05-16"), true);

        return user;
    }

}
