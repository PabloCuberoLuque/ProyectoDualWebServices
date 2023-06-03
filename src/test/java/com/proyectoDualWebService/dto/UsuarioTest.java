package com.proyectoDualWebService.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;

public class UsuarioTest {

    @Test
    public void testUsuarioConstructorWithResultSet() throws SQLException {

        ResultSet resultSetMock = Mockito.mock(ResultSet.class);
        Mockito.when(resultSetMock.getInt("id")).thenReturn(1);
        Mockito.when(resultSetMock.getString("usuario")).thenReturn("john_doe");
        Mockito.when(resultSetMock.getString("pass")).thenReturn("123456");
        Mockito.when(resultSetMock.getString("email")).thenReturn("john@example.com");
        Mockito.when(resultSetMock.getString("imagen")).thenReturn("profile.jpg");
        Mockito.when(resultSetMock.getDate("nacimiento")).thenReturn(Date.valueOf(LocalDate.of(1990, 1, 1)));
        Mockito.when(resultSetMock.getBoolean("admin")).thenReturn(true);

        Usuario usuario = new Usuario(resultSetMock);

        Assertions.assertEquals(1, usuario.getId());
        Assertions.assertEquals("john_doe", usuario.getUsername());
        Assertions.assertEquals("123456", usuario.getPassword());
        Assertions.assertEquals("john@example.com", usuario.getEmail());
        Assertions.assertEquals("profile.jpg", usuario.getImagen());
        Assertions.assertEquals(LocalDate.of(1990, 1, 1), usuario.getNacimiento());
        Assertions.assertTrue(usuario.isAdmin());
    }
}
