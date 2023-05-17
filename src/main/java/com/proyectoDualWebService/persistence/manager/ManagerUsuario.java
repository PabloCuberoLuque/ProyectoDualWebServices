package com.proyectoDualWebService.persistence.manager;

import com.proyectoDualWebService.dto.Usuario;
import java.util.List;
import java.util.Set;
/**
 * Usuario DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Usuario data.
 *
 */
public interface ManagerUsuario extends Manager<Usuario> {

    /**
     *Busca todos los usuarios en la base de datos
     *
     * @return a {@link List} of {@link Usuario}
     */
    List<Usuario> findAll();


    /**
     * Busca los usuarios en la base de datos de una lista de ID.
     *
     * @param ids IDs de usuarios para buscarlos en la base de datos.
     * @return Un/a Una {@link List} de {@link Usuario}.
     */
    List<Usuario> findAllById(Set<Integer> ids);


    /**
     * Busca el usuario en la base de datos de un ID.
     *
     * @param id ID de un usuario especifico para buscarlo en la base de datos.
     * @return Un/a {@link Usuario}.
     */
    Usuario findById( int id);


    /**
     * Busca el usuario en la base de datos de un nombre de usuario.
     *
     * @param username username de un usuario especifico para buscarlo en la base de datos.
     * @return Un/a {@link Usuario}.
     */
    Usuario findByUsername(String username);


    /**
     * Busca el usuario en la base de datos de un email.
     *
     * @param email email de un usuario especifico para buscarlo en la base de datos.
     * @return Un/a {@link Usuario}.
     */
    Usuario findByEmail(String email);




}
