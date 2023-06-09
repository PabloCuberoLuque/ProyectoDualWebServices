package com.proyectoDualWebService.persistence.manager.impl;

import com.proyectoDualWebService.dto.Servicio;
import com.proyectoDualWebService.persistence.conector.MySQLConnector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManagerServicioImplTest {

    private ManagerServicioImpl managerServicio;
    private MySQLConnector mockConnector;

    @BeforeEach
    public void setUp() {
        mockConnector = Mockito.mock(MySQLConnector.class);
        managerServicio = Mockito.mock(ManagerServicioImpl.class);
    }

    @Test
    public void testFindAll() throws SQLException, ClassNotFoundException {
        List<Servicio> serviciosMock = new ArrayList<>();

        Connection mockConnection = Mockito.mock(Connection.class);
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        PreparedStatement mockStatement = Mockito.mock(PreparedStatement.class);

        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(mockConnection);
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockStatement.executeQuery("SELECT * FROM servicio")).thenReturn(mockResultSet);
        Mockito.when(mockResultSet.next()).thenReturn(true, false);
        Mockito.when(mockResultSet.getInt("ID")).thenReturn(1);
        Mockito.when(mockResultSet.getDouble("precio")).thenReturn(10.0);
        Mockito.when(mockResultSet.getString("nombre")).thenReturn("Netflix");
        Mockito.when(mockResultSet.getString("web")).thenReturn("www.netflix.com");

        List<Servicio> result = managerServicio.findAll();

        Assertions.assertEquals(serviciosMock, result);

        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
        Mockito.verify(mockConnection, Mockito.times(1)).createStatement();
        Mockito.verify(mockStatement, Mockito.times(1)).executeQuery("SELECT * FROM servicio");
        Mockito.verify(mockResultSet, Mockito.times(1)).next();
        Mockito.verify(mockResultSet, Mockito.times(1)).getInt("ID");
        Mockito.verify(mockResultSet, Mockito.times(1)).getDouble("precio");
        Mockito.verify(mockResultSet, Mockito.times(1)).getString("nombre");
        Mockito.verify(mockResultSet, Mockito.times(1)).getString("web");
    }

    @Test
    public void testFindAllById() throws SQLException, ClassNotFoundException {
        Set<Integer> ids = new HashSet<>();
        ids.add(1);
        ids.add(2);
        List<Servicio> serviciosMock = new ArrayList<>();

        Connection mockConnection = Mockito.mock(Connection.class);
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        PreparedStatement mockStatement = Mockito.mock(PreparedStatement.class);

        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(mockConnection);
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockStatement.executeQuery(Mockito.anyString())).thenReturn(mockResultSet);
        Mockito.when(mockResultSet.next()).thenReturn(true, false);
        Mockito.when(mockResultSet.getInt("ID")).thenReturn(1);
        Mockito.when(mockResultSet.getDouble("precio")).thenReturn(10.0);
        Mockito.when(mockResultSet.getString("nombre")).thenReturn("Netflix");
        Mockito.when(mockResultSet.getString("web")).thenReturn("www.netflix.com"); //TODO ARREGLAR EL RETURN

        List<Servicio> result = managerServicio.findAllById(ids);

        Assertions.assertEquals(serviciosMock, result);

        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
        Mockito.verify(mockConnection, Mockito.times(1)).createStatement();
        Mockito.verify(mockStatement, Mockito.times(1)).executeQuery(Mockito.anyString());
        Mockito.verify(mockResultSet, Mockito.times(1)).next();
        Mockito.verify(mockResultSet, Mockito.times(1)).getInt("ID");
        Mockito.verify(mockResultSet, Mockito.times(1)).getDouble("precio");
        Mockito.verify(mockResultSet, Mockito.times(1)).getString("nombre");
        Mockito.verify(mockResultSet, Mockito.times(1)).getString("web");
    }

    @Test
    public void testFindById() throws SQLException, ClassNotFoundException {
        int id = 1;
        Servicio servicioMock = new Servicio();
        Connection mockConnection = Mockito.mock(Connection.class);
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        PreparedStatement mockStatement = Mockito.mock(PreparedStatement.class);

        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(mockConnection);
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);
        Mockito.when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        Mockito.when(mockResultSet.next()).thenReturn(true, false);
        Mockito.when(mockResultSet.getInt("ID")).thenReturn(1);
        Mockito.when(mockResultSet.getDouble("precio")).thenReturn(10.0);
        Mockito.when(mockResultSet.getString("nombre")).thenReturn("Netflix");
        Mockito.when(mockResultSet.getString("web")).thenReturn("www.netflix.com"); //TODO

        Servicio result = managerServicio.findById(id);

        Assertions.assertEquals(servicioMock, result);

        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
        Mockito.verify(mockConnection, Mockito.times(1)).prepareStatement(Mockito.anyString());
        Mockito.verify(mockStatement, Mockito.times(1)).setInt(1, id);
        Mockito.verify(mockStatement, Mockito.times(1)).executeQuery();
        Mockito.verify(mockResultSet, Mockito.times(1)).next();
        Mockito.verify(mockResultSet, Mockito.times(1)).getInt("ID");
        Mockito.verify(mockResultSet, Mockito.times(1)).getDouble("precio");
        Mockito.verify(mockResultSet, Mockito.times(1)).getString("nombre");
        Mockito.verify(mockResultSet, Mockito.times(1)).getString("web");
    }

    @Test
    public void testFindByNombre() throws SQLException, ClassNotFoundException {
        String nombre = "Netflix"; //TODO NOMBRE DEL SERVICIO
        List<Servicio> serviciosMock = new ArrayList<>();
        Connection mockConnection = Mockito.mock(Connection.class);
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        PreparedStatement mockStatement = Mockito.mock(PreparedStatement.class);

        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(mockConnection);
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);
        Mockito.when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        Mockito.when(mockResultSet.next()).thenReturn(true, false);
        Mockito.when(mockResultSet.getInt("ID")).thenReturn(1);
        Mockito.when(mockResultSet.getDouble("precio")).thenReturn(10.0);
        Mockito.when(mockResultSet.getString("nombre")).thenReturn("Netflix");
        Mockito.when(mockResultSet.getString("web")).thenReturn("www.netflix.com");

        List<Servicio> result = managerServicio.findByNombre(nombre);

        Assertions.assertEquals(serviciosMock, result);

        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
        Mockito.verify(mockConnection, Mockito.times(1)).prepareStatement(Mockito.anyString());
        Mockito.verify(mockStatement, Mockito.times(1)).setString(1, nombre);
        Mockito.verify(mockStatement, Mockito.times(1)).executeQuery();
        Mockito.verify(mockResultSet, Mockito.times(1)).next();
        Mockito.verify(mockResultSet, Mockito.times(1)).getInt("ID");
        Mockito.verify(mockResultSet, Mockito.times(1)).getDouble("precio");
        Mockito.verify(mockResultSet, Mockito.times(1)).getString("nombre");
        Mockito.verify(mockResultSet, Mockito.times(1)).getString("web");
    }

    @Test
    public void testInsert() throws SQLException, ClassNotFoundException {

        Servicio servicioMock = new Servicio();
        Connection mockConnection = Mockito.mock(Connection.class);
        PreparedStatement mockStatement = Mockito.mock(PreparedStatement.class);
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(mockConnection);
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);

        managerServicio.insert(servicioMock);

        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
        Mockito.verify(mockConnection, Mockito.times(1)).prepareStatement(Mockito.anyString());
        Mockito.verify(mockStatement, Mockito.times(1)).setDouble(1, servicioMock.getPrecio());
        Mockito.verify(mockStatement, Mockito.times(1)).setString(2, servicioMock.getNombre());
        Mockito.verify(mockStatement, Mockito.times(1)).setString(3, servicioMock.getWeb());
        Mockito.verify(mockStatement, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void testUpdate() throws SQLException, ClassNotFoundException {

        Servicio servicioMock = new Servicio();
        Connection mockConnection = Mockito.mock(Connection.class);
        PreparedStatement mockStatement = Mockito.mock(PreparedStatement.class);
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(mockConnection);
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);

        managerServicio.update(servicioMock);

        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
        Mockito.verify(mockConnection, Mockito.times(1)).prepareStatement(Mockito.anyString());
        Mockito.verify(mockStatement, Mockito.times(1)).setString(1, servicioMock.getNombre());
        Mockito.verify(mockStatement, Mockito.times(1)).setDouble(2, servicioMock.getPrecio());
        Mockito.verify(mockStatement, Mockito.times(1)).setString(3, servicioMock.getWeb());
        Mockito.verify(mockStatement, Mockito.times(1)).setInt(4, servicioMock.getId());
        Mockito.verify(mockStatement, Mockito.times(1)).executeUpdate();
    }

    @Test
    public void testDelete() throws SQLException, ClassNotFoundException {
        int id = 1;
        Connection mockConnection = Mockito.mock(Connection.class);
        PreparedStatement mockStatement = Mockito.mock(PreparedStatement.class);
        Mockito.when(mockConnector.getMySQLConnection()).thenReturn(mockConnection);
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);

        managerServicio.delete(id);

        Mockito.verify(mockConnector, Mockito.times(1)).getMySQLConnection();
        Mockito.verify(mockConnection, Mockito.times(1)).prepareStatement(Mockito.anyString());
        Mockito.verify(mockStatement, Mockito.times(1)).setInt(1, id);
        Mockito.verify(mockStatement, Mockito.times(1)).executeUpdate();
    }
}
