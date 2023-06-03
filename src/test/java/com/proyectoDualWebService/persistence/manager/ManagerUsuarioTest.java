package com.proyectoDualWebService.persistence.manager;

import com.proyectoDualWebService.dto.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ManagerUsuarioTest {

    private ManagerUsuario managerUsuario;

    @BeforeEach
    public void setUp() {
        managerUsuario = Mockito.mock(ManagerUsuario.class);
    }

    @Test
    public void testFindAll() {
        List<Usuario> usuariosMock = new ArrayList<>();
        Mockito.when(managerUsuario.findAll()).thenReturn(usuariosMock);
        List<Usuario> result = managerUsuario.findAll();
        Assertions.assertEquals(usuariosMock, result);
    }

    @Test
    public void testFindAllById() {
        Set<Integer> ids = Set.of(1, 2, 3);
        List<Usuario> usuariosMock = new ArrayList<>();
        Mockito.when(managerUsuario.findAllById(ids)).thenReturn(usuariosMock);
        List<Usuario> result = managerUsuario.findAllById(ids);
        Assertions.assertEquals(usuariosMock, result);
    }

    @Test
    public void testFindById() {
        int id = 1;
        Usuario usuarioMock = new Usuario();
        Mockito.when(managerUsuario.findById(id)).thenReturn(usuarioMock);
        Usuario result = managerUsuario.findById(id);
        Assertions.assertEquals(usuarioMock, result);
    }

    @Test
    public void testFindByUsername() {
        String username = "lau";
        Usuario usuarioMock = new Usuario();
        Mockito.when(managerUsuario.findByUsername(username)).thenReturn(usuarioMock);
        Usuario result = managerUsuario.findByUsername(username);
        Assertions.assertEquals(usuarioMock, result);
    }

    @Test
    public void testFindByEmail() {
        String email = "lau.cg@gmail.com";
        Usuario usuarioMock = new Usuario();
        Mockito.when(managerUsuario.findByEmail(email)).thenReturn(usuarioMock);
        Usuario result = managerUsuario.findByEmail(email);
        Assertions.assertEquals(usuarioMock, result);
    }

}