package com.proyectoDualWebService.persistence.manager.impl;

import com.proyectoDualWebService.dto.Usuario;
import com.proyectoDualWebService.persistence.conector.MySQLConnector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.sql.*;
import java.util.*;

public class ManagerUsuarioImplTest {

    private ManagerUsuarioImpl managerUsuario;

    @Mock
    private MySQLConnector mockConnector;

    @BeforeEach
    public void setup() {
        mockConnector = Mockito.mock(MySQLConnector.class);
        managerUsuario = Mockito.mock(ManagerUsuarioImpl.class);
    }

    @Test
    public void testFindAll() throws SQLException, ClassNotFoundException {
        List<Usuario> usuariosMock = new ArrayList<>();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        List<Usuario> result = managerUsuario.findAll();
        Assertions.assertEquals(usuariosMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testFindAllById() throws SQLException, ClassNotFoundException {
        Set<Integer> ids = new HashSet<>();
        ids.add(1);
        ids.add(2);
        List<Usuario> usuariosMock = new ArrayList<>();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        List<Usuario> result = managerUsuario.findAllById(ids);
        Assertions.assertEquals(usuariosMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testFindById() throws SQLException, ClassNotFoundException {
        int id = 1;
        Usuario usuarioMock = new Usuario();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        Usuario result = managerUsuario.findById(id);
        Assertions.assertEquals(usuarioMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testFindByUsername() throws SQLException, ClassNotFoundException {
        String username = "lau";
        Usuario usuarioMock = new Usuario();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        Usuario result = managerUsuario.findByUsername(username);
        Assertions.assertEquals(usuarioMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testFindByEmail() throws SQLException, ClassNotFoundException {
        String email = "lau.cg@gmail.com";
        Usuario usuarioMock = new Usuario();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        Usuario result = managerUsuario.findByEmail(email);
        Assertions.assertEquals(usuarioMock, result);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testInsert() throws SQLException, ClassNotFoundException {
        Usuario usuario = new Usuario();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        managerUsuario.insert(usuario);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException {
        Usuario usuario = new Usuario();
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        managerUsuario.update(usuario);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }

    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {
        int id = 1;
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(null);
        managerUsuario.delete(id);
        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
    }
}
