package com.proyectoDualWebService.dto;

import com.proyectoDualWebService.persistence.manager.impl.ManagerUsuarioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TablonTest {

    @Test
    public void testTablonConstructorWithResultSet() throws SQLException {

        ResultSet resultSetMock = Mockito.mock(ResultSet.class);
        Mockito.when(resultSetMock.getInt("id")).thenReturn(1);
        Mockito.when(resultSetMock.getString("message")).thenReturn("Hello, world!");
        Mockito.when(resultSetMock.getInt("id_user")).thenReturn(1);
        Mockito.when(resultSetMock.getInt("likes")).thenReturn(10);
        Mockito.when(resultSetMock.getTimestamp("create_at")).thenReturn(new Timestamp(System.currentTimeMillis()));

        Usuario usuarioMock = Mockito.mock(Usuario.class);
        Mockito.when(usuarioMock.getId()).thenReturn(1);
        Mockito.when(usuarioMock.getUsername()).thenReturn("john_doe");

        ManagerUsuarioImpl managerUsuarioMock = Mockito.mock(ManagerUsuarioImpl.class);
        Mockito.when(managerUsuarioMock.findById(1)).thenReturn(usuarioMock);

        Tablon tablon = new Tablon(resultSetMock);

        Assertions.assertEquals(1, tablon.getId());
        Assertions.assertEquals("Hello, world!", tablon.getMessage());
        Assertions.assertEquals(usuarioMock, tablon.getIdUsuario());
        Assertions.assertEquals(10, tablon.getLikes());
        Assertions.assertNotNull(tablon.getCreateAt());
    }
}
