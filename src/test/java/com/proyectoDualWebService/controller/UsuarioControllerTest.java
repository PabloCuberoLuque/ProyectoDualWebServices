package com.proyectoDualWebService.controller;

import com.proyectoDualWebService.dto.Usuario;
import com.proyectoDualWebService.persistence.manager.impl.ManagerUsuarioImpl;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class UsuarioControllerTest {

    private UsuarioController usuarioController;
    private ManagerUsuarioImpl managerUsuarioMock;

    @BeforeEach
    public void setUp() {
        managerUsuarioMock = Mockito.mock(ManagerUsuarioImpl.class);
        usuarioController = new UsuarioController();
    }

    @Test
    public void testFindAllUsuario() {
        List<Usuario> usuariosMock = new ArrayList<>();
        Mockito.when(managerUsuarioMock.findAll()).thenReturn(usuariosMock);
        Response response = usuarioController.findAllUsuario();
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(usuariosMock, response.getEntity());
    }

    @Test
    public void testGetUsuario() {
        int usuarioId = 1;
        Usuario usuarioMock = new Usuario();
        Mockito.when(managerUsuarioMock.findById(usuarioId)).thenReturn(usuarioMock);
        Response response = usuarioController.getUsuario(usuarioId);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(usuarioMock, response.getEntity());
    }

    @Test
    public void testGetUsuarioName() {
        String username = "lau.cg";
        Usuario usuarioMock = new Usuario();
        Mockito.when(managerUsuarioMock.findByUsername(username)).thenReturn(usuarioMock);
        Response response = usuarioController.getUsuarioName(username);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(usuarioMock, response.getEntity());
    }

    @Test
    public void testGetUsuarioEmail() {
        String email = "lau.cg@gamil.com";
        Usuario usuarioMock = new Usuario();
        Mockito.when(managerUsuarioMock.findByEmail(email)).thenReturn(usuarioMock);
        Response response = usuarioController.getUsuarioEmail(email);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(usuarioMock, response.getEntity());
    }

    @Test
    public void testAddUsuario() {
        Usuario usuario = new Usuario();
        Response response = usuarioController.addUsuario(usuario);
        Assertions.assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        Assertions.assertEquals(usuario, response.getEntity());
    }

    @Test
    public void testUpdateUsuario() {
        int usuarioId = 1;
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        Response response = usuarioController.updateUsuario(usuarioId, usuario);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals("Usuario actualizado correctamente", response.getEntity());
    }

    @Test
    public void testEliminarUsuario() {
        int usuarioId = 1;
        Response response = usuarioController.eliminarUsuario(usuarioId);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals("Usuario eliminado correctamente", response.getEntity());
    }

}

