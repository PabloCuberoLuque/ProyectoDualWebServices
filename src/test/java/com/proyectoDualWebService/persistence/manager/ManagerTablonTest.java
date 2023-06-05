package com.proyectoDualWebService.persistence.manager;

import com.proyectoDualWebService.dto.Tablon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//TODO TEST FUNCIONANDO

public class ManagerTablonTest {

    private ManagerTablon managerTablon;

    @BeforeEach
    public void setUp() {
        managerTablon = Mockito.mock(ManagerTablon.class);
    }

    @Test
    public void testFindAll() {
        List<Tablon> tablonesMock = new ArrayList<>();
        Mockito.when(managerTablon.findAll()).thenReturn(tablonesMock);
        List<Tablon> result = managerTablon.findAll();
        Assertions.assertEquals(tablonesMock, result);
    }

    @Test
    public void testFindAllById() {
        Set<Integer> ids = Set.of(1, 2, 3);
        List<Tablon> tablonesMock = new ArrayList<>();
        Mockito.when(managerTablon.findAllById(ids)).thenReturn(tablonesMock);
        List<Tablon> result = managerTablon.findAllById(ids);
        Assertions.assertEquals(tablonesMock, result);
    }

    @Test
    public void testFindById() {
        int id = 1;
        Tablon tablonMock = new Tablon();
        Mockito.when(managerTablon.findById(id)).thenReturn(tablonMock);
        Tablon result = managerTablon.findById(id);
        Assertions.assertEquals(tablonMock, result);
    }

    @Test
    public void testFindByIdUser() {
        int idUsuario = 1;
        List<Tablon> tablonesMock = new ArrayList<>();
        Mockito.when(managerTablon.findByIdUser(idUsuario)).thenReturn(tablonesMock);
        List<Tablon> result = managerTablon.findByIdUser(idUsuario);
        Assertions.assertEquals(tablonesMock, result);
    }

    @Test
    public void testFindByDate() {
        Timestamp createAt = Timestamp.valueOf("2023-05-31 10:00:00");
        List<Tablon> tablonesMock = new ArrayList<>();
        Mockito.when(managerTablon.findByDate(createAt)).thenReturn(tablonesMock);
        List<Tablon> result = managerTablon.findByDate(createAt);
        Assertions.assertEquals(tablonesMock, result);
    }

}
