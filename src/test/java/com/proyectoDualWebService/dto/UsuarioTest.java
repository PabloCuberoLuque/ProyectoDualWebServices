package com.proyectoDualWebService.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsuarioTest {

    @Test
    public void testConstructorWithResultSet() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("usuario")).thenReturn("lau");
        when(resultSet.getString("pass")).thenReturn("123456");
        when(resultSet.getString("email")).thenReturn("lau.cg@gmail.com");
        when(resultSet.getString("img_perfil")).thenReturn("lauImagen.jpg");
        when(resultSet.getDate("nacimiento")).thenReturn(java.sql.Date.valueOf("2000-01-03"));
        when(resultSet.getInt("admin")).thenReturn(1);

        Usuario usuario = new Usuario(resultSet);

        Assertions.assertEquals(1, usuario.getId());
        Assertions.assertEquals("lau", usuario.getUsername());
        Assertions.assertEquals("123456", usuario.getPassword());
        Assertions.assertEquals("lau.cg@gmail.com", usuario.getEmail());
        Assertions.assertEquals("lauImagen.jpg", usuario.getImagen());
        Assertions.assertEquals(LocalDate.of(2000, 1, 3), usuario.getNacimiento());
        Assertions.assertTrue(usuario.isAdmin());
    }

}
