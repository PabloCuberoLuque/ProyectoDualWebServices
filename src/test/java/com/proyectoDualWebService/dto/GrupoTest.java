package com.proyectoDualWebService.dto;

import com.proyectoDualWebService.persistence.manager.impl.ManagerServicioImpl;
import com.proyectoDualWebService.persistence.manager.impl.ManagerUsuarioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GrupoTest {

    @Test
    public void testGrupoConstructorWithResultSet() throws SQLException {

        ResultSet resultSetMock = Mockito.mock(ResultSet.class);
        ManagerServicioImpl servicioManagerMock = Mockito.mock(ManagerServicioImpl.class);
        ManagerUsuarioImpl usuarioManagerMock = Mockito.mock(ManagerUsuarioImpl.class);

        Mockito.when(resultSetMock.getInt("id")).thenReturn(1);
        Mockito.when(resultSetMock.getInt("servicio")).thenReturn(1);
        Mockito.when(resultSetMock.getInt("user1")).thenReturn(1);
        Mockito.when(resultSetMock.getInt("user2")).thenReturn(2);
        Mockito.when(resultSetMock.getInt("user3")).thenReturn(3);
        Mockito.when(resultSetMock.getInt("user4")).thenReturn(4);
        Mockito.when(resultSetMock.getInt("user5")).thenReturn(5);
        Mockito.when(resultSetMock.getInt("user6")).thenReturn(6);
        Mockito.when(resultSetMock.getInt("user7")).thenReturn(7);
        Mockito.when(resultSetMock.getInt("user8")).thenReturn(8);

        Servicio servicioMock = Mockito.mock(Servicio.class);
        Usuario usuarioMock1 = Mockito.mock(Usuario.class);
        Usuario usuarioMock2 = Mockito.mock(Usuario.class);
        Usuario usuarioMock3 = Mockito.mock(Usuario.class);
        Usuario usuarioMock4 = Mockito.mock(Usuario.class);
        Usuario usuarioMock5 = Mockito.mock(Usuario.class);
        Usuario usuarioMock6 = Mockito.mock(Usuario.class);
        Usuario usuarioMock7 = Mockito.mock(Usuario.class);
        Usuario usuarioMock8 = Mockito.mock(Usuario.class);

        Mockito.when(servicioManagerMock.findById(1)).thenReturn(servicioMock);
        Mockito.when(usuarioManagerMock.findById(1)).thenReturn(usuarioMock1);
        Mockito.when(usuarioManagerMock.findById(2)).thenReturn(usuarioMock2);
        Mockito.when(usuarioManagerMock.findById(3)).thenReturn(usuarioMock3);
        Mockito.when(usuarioManagerMock.findById(4)).thenReturn(usuarioMock4);
        Mockito.when(usuarioManagerMock.findById(5)).thenReturn(usuarioMock5);
        Mockito.when(usuarioManagerMock.findById(6)).thenReturn(usuarioMock6);
        Mockito.when(usuarioManagerMock.findById(7)).thenReturn(usuarioMock7);
        Mockito.when(usuarioManagerMock.findById(8)).thenReturn(usuarioMock8);

        Grupo grupo = new Grupo(resultSetMock);

        Assertions.assertEquals(1, grupo.getId());
        Assertions.assertEquals(servicioMock, grupo.getServicio());
        Assertions.assertEquals(usuarioMock1, grupo.getUser1());
        Assertions.assertEquals(usuarioMock2, grupo.getUser2());
        Assertions.assertEquals(usuarioMock3, grupo.getUser3());
        Assertions.assertEquals(usuarioMock4, grupo.getUser4());
        Assertions.assertEquals(usuarioMock5, grupo.getUser5());
        Assertions.assertEquals(usuarioMock6, grupo.getUser6());
        Assertions.assertEquals(usuarioMock7, grupo.getUser7());
        Assertions.assertEquals(usuarioMock8, grupo.getUser8());
    }
}
