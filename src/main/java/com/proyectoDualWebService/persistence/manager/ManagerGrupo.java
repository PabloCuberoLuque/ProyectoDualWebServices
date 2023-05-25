package com.proyectoDualWebService.persistence.manager;

import com.proyectoDualWebService.dto.Grupo;


import java.util.List;
import java.util.Set;

public interface ManagerGrupo extends Manager<Grupo>{
    /**
     *Busca todos los grupos en la base de datos
     *
     * @return a {@link List} of {@link Grupo}
     */
    List<Grupo> findAll();

    /**
     * Busca los grupos en la base de datos de una lista de ID.
     *
     * @param ids IDs de grupos para buscarlos en la base de datos.
     * @return Un/a Una {@link List} de {@link Grupo}.
     */
    List<Grupo> findAllById(Set<Integer> ids);

    /**
     * Busca el grupo en la base de datos de un ID.
     *
     * @param id ID de un grupo especifico para buscarlo en la base de datos.
     * @return Un/a {@link Grupo}.
     */
    Grupo findById(int id);

    /**
     * Busca el grupo en la base de datos de un ID.
     *
     * @param servicio ID de un grupo especifico para buscarlo en la base de datos.
     * @return Un/a {@link Grupo}.
     */
    List<Grupo> findByServicio(int servicio);
}