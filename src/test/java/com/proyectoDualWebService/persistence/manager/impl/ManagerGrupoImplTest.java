package com.proyectoDualWebService.persistence.manager.impl;

import com.proyectoDualWebService.dto.Grupo;
import com.proyectoDualWebService.persistence.conector.MySQLConnector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManagerGrupoImplTest {

    private ManagerGrupoImpl managerGrupo;
    private MySQLConnector mockConnector;

    @BeforeEach
    public void setUp() {
        mockConnector = Mockito.mock(MySQLConnector.class);
        managerGrupo = Mockito.mock(ManagerGrupoImpl.class);
    }

    @Test
    public void testFindAll() throws SQLException, ClassNotFoundException {
        List<Grupo> gruposMock = new ArrayList<>();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        List<Grupo> result = managerGrupo.findAll();
        Assertions.assertEquals(gruposMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testFindAllById() throws SQLException, ClassNotFoundException {
        Set<Integer> ids = new HashSet<>();
        ids.add(1);
        ids.add(2);
        List<Grupo> gruposMock = new ArrayList<>();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        List<Grupo> result = managerGrupo.findAllById(ids);
        Assertions.assertEquals(gruposMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testFindById() throws SQLException, ClassNotFoundException {
        int id = 1;
        Grupo grupoMock = new Grupo();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        Grupo result = managerGrupo.findById(id);
        Assertions.assertEquals(grupoMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testFindByServicio() throws SQLException, ClassNotFoundException {
        int servicio = 1;
        List<Grupo> gruposMock = new ArrayList<>();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        List<Grupo> result = managerGrupo.findByServicio(servicio);
        Assertions.assertEquals(gruposMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testInsert() throws SQLException, ClassNotFoundException {
        Grupo grupo = new Grupo();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        managerGrupo.insert(grupo);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException {
        Grupo grupo = new Grupo();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        managerGrupo.update(grupo);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {
        int id = 1;
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        managerGrupo.delete(id);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }
}

