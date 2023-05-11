package com.proyectoDualWebService.dao;

import com.proyectoDualWebService.dto.Usuario;

import java.time.LocalDate;


public class UsuarioDAO {

    public Usuario findbyId(int id){
        Usuario user = new Usuario(id, "pepe", "1234", "pepe@gmail.com", "img.jpg", LocalDate.now(), true);

        return user;
    }

}
