package com.proyectoDualWebService.persistence.manager;

import com.proyectoDualWebService.dto.Servicio;

import java.util.List;
import java.util.Set;

public interface ManagerServicio extends Manager<Servicio> {

    /**
     *Busca todos los servicios en la base de datos
     *
     * @return a {@link List} of {@link Servicio}
     */
    List<Servicio> findAll();

    /**
     * Busca los servicios en la base de datos de una lista de ID.
     *
     * @param ids IDs de servicios para buscarlos en la base de datos.
     * @return Un/a Una {@link List} de {@link Servicio}.
     */
    List<Servicio> findAllById(Set<Integer> ids);

    /**
     * Busca el servicio en la base de datos de un ID.
     *
     * @param id ID de un servicio especifico para buscarlo en la base de datos.
     * @return Un/a {@link Servicio}.
     */
    Servicio findById(int id);



}