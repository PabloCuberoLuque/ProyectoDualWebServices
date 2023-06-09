package com.proyectoDualWebService.controller;

import com.proyectoDualWebService.dto.Servicio;
import com.proyectoDualWebService.persistence.manager.impl.ManagerServicioImpl;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ServicioControllerTest {

    private ServicioController servicioController;
    private ManagerServicioImpl managerServicioMock;

    @BeforeEach
    public void setUp() {
        managerServicioMock = Mockito.mock(ManagerServicioImpl.class);
        servicioController = new ServicioController();
    }

    @Test
    public void testGetAllServicio() {
        List<Servicio> serviciosMock = new ArrayList<>();
        Mockito.when(managerServicioMock.findAll()).thenReturn(serviciosMock);
        Response response = servicioController.getAllServicio();
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(serviciosMock, response.getEntity());
    }

    @Test
    public void testGetServicio() {
        Servicio servicioMock = new Servicio();
        Mockito.when(managerServicioMock.findById(1)).thenReturn(servicioMock);
        Response response = servicioController.getServicio(1);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(servicioMock, response.getEntity());
    }

    @Test
    public void testGetServicioN() {
        Servicio servicioMock = new Servicio();
        String nombreServicio = "Netflix";
        Mockito.when(managerServicioMock.findByNombre(nombreServicio)).thenReturn((List<Servicio>) servicioMock); //TODO REVISAR LA EXCEPCION

        Response response = servicioController.getServicioN(nombreServicio);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(servicioMock, response.getEntity());
    }

    @Test
    public void testInsertServicio() {
        Servicio servicioMock = new Servicio();
        Response response = servicioController.insertServicio(servicioMock);
        Assertions.assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
        Assertions.assertEquals("Servicio creado correctamente", response.getEntity());
    }

    @Test
    public void testUpdateServicio() {
        int id = 1;
        Servicio servicioMock = new Servicio();
        servicioMock.setId(id);
        Response response = servicioController.updateServicio(id, servicioMock);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals("Servicio actualizado correctamente", response.getEntity());
    }

    @Test
    public void testDeleteServicio() {
        int id = 1;
        Response response = servicioController.deleteServicio(id);
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals("Servicio eliminado correctamente", response.getEntity());
    }

}
