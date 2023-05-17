package com.proyectoDualWebService.persistence.manager;

import java.util.List;
import java.util.Set;
public interface Manager<T> {
    /**
     * Busca todos los objetos en la base de datos
     *
     * @return a {@link List} of {@link T}
     */
    List<T> findAll();


    /**
     * Busca todos los objetos en la base de datos con una lista de ID
     *
     * @param ids Lista de ids para la busqueda de objetos en la base de datos
     * @return a {@link List} of {@link T}
     */
    List<T> findAllById(Set<Integer> ids);


    /**
     * Inserta objeto en la base de datos
     *
     * @param obj
     */
    void insert(T obj);

    /**
     * Actualiza objeto en la base de datos
     *
     * @param obj
     */
    void update(T obj);

    /**
     * Inserta objeto en la base de datos
     *
     * @param id
     */
    void delete(int id);

}
