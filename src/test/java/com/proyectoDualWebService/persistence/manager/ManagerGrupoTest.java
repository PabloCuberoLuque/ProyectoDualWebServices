package com.proyectoDualWebService.persistence.manager;

import com.proyectoDualWebService.dto.Grupo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ManagerGrupoTest {

    private ManagerGrupo managerGrupo;

    @BeforeEach
    public void setUp() {
        managerGrupo = Mockito.mock(ManagerGrupo.class);
    }

    @Test
    public void testFindAll() {
        List<Grupo> gruposMock = new ArrayList<>();
        Mockito.when(managerGrupo.findAll()).thenReturn(gruposMock);
        List<Grupo> result = managerGrupo.findAll();
        Assertions.assertEquals(gruposMock, result);
    }

    @Test
    public void testFindAllById() {
        Set<Integer> ids = Set.of(1, 2, 3);
        List<Grupo> gruposMock = new ArrayList<>();
        Mockito.when(managerGrupo.findAllById(ids)).thenReturn(gruposMock);
        List<Grupo> result = managerGrupo.findAllById(ids);
        Assertions.assertEquals(gruposMock, result);
    }

    @Test
    public void testFindById() {
        int id = 1;
        Grupo grupoMock = new Grupo();
        Mockito.when(managerGrupo.findById(id)).thenReturn(grupoMock);
        Grupo result = managerGrupo.findById(id);
        Assertions.assertEquals(grupoMock, result);
    }

    @Test
    public void testFindByServicio() {
        int servicio = 1;
        List<Grupo> gruposMock = new ArrayList<>();
        Mockito.when(managerGrupo.findByServicio(servicio)).thenReturn(gruposMock);
        List<Grupo> result = managerGrupo.findByServicio(servicio);
        Assertions.assertEquals(gruposMock, result);
    }

}
