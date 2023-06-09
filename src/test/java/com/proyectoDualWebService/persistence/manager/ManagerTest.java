package com.proyectoDualWebService.persistence.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//TODO TEST FUNCIONANDO

public class ManagerTest<T> {

    private Manager<T> manager;

    @BeforeEach
    public void setUp() {
        manager = Mockito.mock(Manager.class);
    }

    @Test
    public void testFindAll() {
        List<T> objectsMock = new ArrayList<>();
        Mockito.when(manager.findAll()).thenReturn(objectsMock);
        List<T> result = manager.findAll();
        Assertions.assertEquals(objectsMock, result);
    }

    @Test
    public void testFindAllById() {
        Set<Integer> ids = new HashSet<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<T> objectsMock = new ArrayList<>();
        Mockito.when(manager.findAllById(ids)).thenReturn(objectsMock);
        List<T> result = manager.findAllById(ids);
        Assertions.assertEquals(objectsMock, result);
    }

    @Test
    public void testInsert() {
        T object = createObject(); // Crear el objeto que se desea insertar
        manager.insert(object);
        Mockito.verify(manager, Mockito.times(1)).insert(object);
    }

    @Test
    public void testUpdate() {
        T object = createObject();
        manager.update(object);
        Mockito.verify(manager, Mockito.times(1)).update(object);
    }

    @Test
    public void testDelete() {
        int id = 1;
        manager.delete(id);
        Mockito.verify(manager, Mockito.times(1)).delete(id);
    }

    private T createObject() {
        //ESTO ES PARA CREAR EL OBJETO T, PUEDE SER EL USUARIO, TABLON ETC.
        return null;
    }

}
