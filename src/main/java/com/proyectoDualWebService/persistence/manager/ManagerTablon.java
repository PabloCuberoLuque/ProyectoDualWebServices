package com.proyectoDualWebService.persistence.manager;

import com.proyectoDualWebService.dto.Tablon;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public interface ManagerTablon extends Manager<Tablon>{
    /**
     *Busca todos los post en la base de datos
     *
     * @return a {@link List} of {@link Tablon}
     */
    List<Tablon> findAll();

    /**
     * Busca los post en la base de datos de una lista de ID.
     *
     * @param ids IDs de post para buscarlos en la base de datos.
     * @return Un/a Una {@link List} de {@link Tablon}.
     */
    List<Tablon> findAllById(Set<Integer> ids);

    /**
     * Busca el post en la base de datos de un ID.
     *
     * @param id ID de un post especifico para buscarlo en la base de datos.
     * @return Un/a {@link Tablon}.
     */
    Tablon findById(int id);

    /**
     * Busca el post en la base de datos de un ID de un usuario.
     *
     * @param idUsuario ID de un usuario especifico para buscar sus post en la base de datos.
     * @return @return Un/a Una {@link List} de {@link Tablon}.
     */
    List<Tablon> findByIdUser(int idUsuario);


    /**
     * Busca el post en la base de datos de una fecha especifica.
     *
     * @param createAt Fecha de un post especifico para buscar los posts en la base de datos.
     * @return @return Un/a Una {@link List} de {@link Tablon}.
     */
    List<Tablon> findByDate(Timestamp createAt);






}
