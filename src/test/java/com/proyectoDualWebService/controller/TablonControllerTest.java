package com.proyectoDualWebService.controller;

import com.proyectoDualWebService.dto.Tablon;
import com.proyectoDualWebService.persistence.manager.impl.ManagerTablonImpl;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class TablonControllerTest {

    private TablonController tablonController;
    private ManagerTablonImpl managerTablonMock;

    @BeforeEach
    public void setUp() {
        managerTablonMock = Mockito.mock(ManagerTablonImpl.class);
        tablonController = new TablonController();
    }

    @Test
    public void testFindAllTablon() {
        List<Tablon> tablonesMock = new ArrayList<>();
        Mockito.when(managerTablonMock.findAll()).thenReturn(tablonesMock);

        Response response = tablonController.findAllTablon();
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(tablonesMock, response.getEntity());
    }

    @Test
    public void testGetTablon() {
        int tablonId = 1;
        Tablon tablonMock = new Tablon();
        Mockito.when(managerTablonMock.findById(tablonId)).thenReturn(tablonMock);
        Response response = tablonController.getTablon(tablonId);

        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(tablonMock, response.getEntity());
    }

    @Test
    public void testGetTablonUser() {
        int userId = 1;
        List<Tablon> tablonesMock = new ArrayList<>();
        Mockito.when(managerTablonMock.findByIdUser(userId)).thenReturn(tablonesMock);
        Response response = tablonController.getTablonUser(userId);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(tablonesMock, response.getEntity());
    }

    @Test
    public void testAddTablon() {
        Tablon tablon = new Tablon();
        Response response = tablonController.addTablon(tablon);
        Assertions.assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        Assertions.assertEquals(tablon, response.getEntity());
    }

    @Test
    public void testUpdateTablon() {
        int tablonId = 1;
        Tablon tablon = new Tablon();
        tablon.setId(tablonId);
        Response response = tablonController.updateTablon(tablonId, tablon);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals("Tablon actualizado correctamente", response.getEntity());
    }

    @Test
    public void testDeleteTablon() {
        int tablonId = 1;
        Response response = tablonController.deleteTablon(tablonId);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals("Tablon eliminado correctamente", response.getEntity());
    }

}
