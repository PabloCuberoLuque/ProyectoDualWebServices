package com.proyectoDualWebService.controller;

import com.proyectoDualWebService.dto.Grupo;
import com.proyectoDualWebService.persistence.manager.impl.ManagerGrupoImpl;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class GrupoControllerTest {

    private GrupoController grupoController;
    private ManagerGrupoImpl managerGrupoMock;

    @BeforeEach
    public void setUp() {
        managerGrupoMock = Mockito.mock(ManagerGrupoImpl.class);
        grupoController = new GrupoController();
    }

    @Test
    public void testGetAllGrupo() {
        List<Grupo> gruposMock = new ArrayList<>();
        Mockito.when(managerGrupoMock.findAll()).thenReturn(gruposMock);
        Response response = grupoController.getAllGrupo();
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(gruposMock, response.getEntity());
    }

    @Test
    public void testGetGrupo() {
        int grupoId = 1;
        Grupo grupoMock = new Grupo();
        Mockito.when(managerGrupoMock.findById(grupoId)).thenReturn(grupoMock);
        Response response = grupoController.getGrupo(grupoId);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(grupoMock, response.getEntity());
    }

    @Test
    public void testAddGrupo() {
        Grupo grupo = new Grupo();
        Response response = grupoController.addGrupo(grupo);
        Assertions.assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        Assertions.assertEquals("Grupo creado correctamente", response.getEntity());
    }

    @Test
    public void testUpdateGrupo() {
        int grupoId = 1;
        Grupo grupo = new Grupo();
        grupo.setId(grupoId);
        Response response = grupoController.updateGrupo(grupoId, grupo);
        Assertions.assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        Assertions.assertEquals("Grupo actualizado correctamente", response.getEntity());
    }

    @Test
    public void testDeleteGrupo() {
        int grupoId = 1;
        Response response = grupoController.deleteGrupo(grupoId);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals("Grupo eliminado correctamente", response.getEntity());
    }
}
