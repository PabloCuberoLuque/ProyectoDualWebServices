package com.proyectoDualWebService.persistence.connector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnectorTest {

    private MySQLConnector connector;
    private Properties propertiesMock;

    @BeforeEach
    public void setUp() throws IOException {
        propertiesMock = Mockito.mock(Properties.class);
        connector = new MySQLConnector();
        connector.setProp(propertiesMock);
    }

    @Test
    public void testGetMySQLConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb?user=root&password=secret&useSSL=false";

        Mockito.when(propertiesMock.getProperty(MySQLConstants.DRIVER)).thenReturn(driver);

        Connection connection = connector.getMySQLConnection();

        Assertions.assertNotNull(connection);

        Mockito.verify(propertiesMock, Mockito.times(1)).getProperty(Mockito.anyString());
    }
}
