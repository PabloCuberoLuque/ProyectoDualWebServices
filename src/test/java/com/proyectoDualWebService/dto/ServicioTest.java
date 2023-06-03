package com.proyectoDualWebService.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicioTest {

    @Test
    public void testServicioConstructorWithResultSet() throws SQLException {

        ResultSet resultSetMock = Mockito.mock(ResultSet.class);
        Mockito.when(resultSetMock.getInt("id")).thenReturn(1);
        Mockito.when(resultSetMock.getString("nombre")).thenReturn("Servicio 1");
        Mockito.when(resultSetMock.getString("plan")).thenReturn("Plan básico");
        Mockito.when(resultSetMock.getFloat("precio")).thenReturn(9.99f);
        Mockito.when(resultSetMock.getString("web")).thenReturn("www.servicio1.com");

        Servicio servicio = new Servicio(resultSetMock);

        Assertions.assertEquals(1, servicio.getId());
        Assertions.assertEquals("Servicio 1", servicio.getNombre());
        Assertions.assertEquals("Plan básico", servicio.getPlan());
        Assertions.assertEquals(9.99f, servicio.getPrecio());
        Assertions.assertEquals("www.servicio1.com", servicio.getWeb());
    }
}
