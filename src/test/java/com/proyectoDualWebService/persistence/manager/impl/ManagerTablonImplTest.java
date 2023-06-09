package com.proyectoDualWebService.persistence.manager.impl;

import com.proyectoDualWebService.comparators.TablonComparator;
import com.proyectoDualWebService.dto.Tablon;
import com.proyectoDualWebService.persistence.conector.MySQLConnector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class ManagerTablonImplTest {

    private ManagerTablonImpl managerTablon;

    @Mock
    private MySQLConnector mockConnector;

    @BeforeEach
    public void setup() {
        mockConnector = Mockito.mock(MySQLConnector.class);
        managerTablon = Mockito.mock(ManagerTablonImpl.class);
    }

    @Test
    public void testFindAll() throws SQLException, ClassNotFoundException {
        List<Tablon> postsMock = new ArrayList<>();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        List<Tablon> result = managerTablon.findAll();
        Assertions.assertEquals(postsMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testFindAllById() throws SQLException, ClassNotFoundException {
        Set<Integer> ids = new HashSet<>();
        ids.add(1);
        ids.add(2);
        List<Tablon> postsMock = new ArrayList<>();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        List<Tablon> result = managerTablon.findAllById(ids);
        Assertions.assertEquals(postsMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testFindById() throws SQLException, ClassNotFoundException {
        int id = 1;
        Tablon postMock = new Tablon();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        Tablon result = managerTablon.findById(id);
        Assertions.assertEquals(postMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testFindByIdUser() throws SQLException, ClassNotFoundException {
        int idUsuario = 1;
        List<Tablon> postsMock = new ArrayList<>();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        List<Tablon> result = managerTablon.findByIdUser(idUsuario);
        Assertions.assertEquals(postsMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testFindByDate() throws SQLException, ClassNotFoundException {
        Timestamp createAt = new Timestamp(System.currentTimeMillis());
        List<Tablon> postsMock = new ArrayList<>();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        List<Tablon> result = managerTablon.findByDate(createAt);
        Assertions.assertEquals(postsMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testInsert() throws SQLException, ClassNotFoundException {
        Tablon post = new Tablon();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        managerTablon.insert(post);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException {
        Tablon post = new Tablon();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        managerTablon.update(post);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {
        int id = 1;
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        managerTablon.delete(id);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }
}




