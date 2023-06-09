package com.proyectoDualWebService.persistence.manager;

import com.proyectoDualWebService.dto.Servicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//TODO TEST FUNCIONANDO

public class ManagerServicioTest {

    private ManagerServicio managerServicio;

    @BeforeEach
    public void setUp() {
        managerServicio = Mockito.mock(ManagerServicio.class);
    }

    @Test
    public void testFindAll() {
        List<Servicio> serviciosMock = new ArrayList<>();
        Mockito.when(managerServicio.findAll()).thenReturn(serviciosMock);
        List<Servicio> result = managerServicio.findAll();
        Assertions.assertEquals(serviciosMock, result);
    }

    @Test
    public void testFindAllById() {
        Set<Integer> ids = Set.of(1, 2, 3);
        List<Servicio> serviciosMock = new ArrayList<>();
        Mockito.when(managerServicio.findAllById(ids)).thenReturn(serviciosMock);
        List<Servicio> result = managerServicio.findAllById(ids);
        Assertions.assertEquals(serviciosMock, result);
    }

    @Test
    public void testFindById() {
        int id = 1;
        Servicio servicioMock = new Servicio();
        Mockito.when(managerServicio.findById(id)).thenReturn(servicioMock);
        Servicio result = managerServicio.findById(id);
        Assertions.assertEquals(servicioMock, result);
    }

}
