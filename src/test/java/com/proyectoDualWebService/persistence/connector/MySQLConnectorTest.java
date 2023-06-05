package com.proyectoDualWebService.persistence.connector;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class MySQLConnectorTest {

    @Test
    public void testGetMySQLConnection() throws ClassNotFoundException, SQLException {
        // Create a mock properties object
        Properties props = mock(Properties.class);
        when(props.getProperty(MySQLConstants.DRIVER)).thenReturn("com.mysql.jdbc.Driver");
        when(props.getProperty(MySQLConstants.URL_PREFIX)).thenReturn("jdbc:mysql://");
        when(props.getProperty(MySQLConstants.URL_HOST)).thenReturn("localhost");
        when(props.getProperty(MySQLConstants.URL_PORT)).thenReturn("3306");
        when(props.getProperty(MySQLConstants.URL_SCHEMA)).thenReturn("test");
        when(props.getProperty(MySQLConstants.USER)).thenReturn("user");
        when(props.getProperty(MySQLConstants.PASSWD)).thenReturn("password");
        when(props.getProperty(MySQLConstants.URL_SSL)).thenReturn("false");
        when(props.getProperty(MySQLConstants.ALLOW_PUBLIC_KEY_RETRIEVAL)).thenReturn("true");
        when(props.getProperty(MySQLConstants.USE_JDBC_COMPLIANT_TIMEZONE_SHIFT)).thenReturn("true");
        when(props.getProperty(MySQLConstants.USE_LEGACY_DATE_TIME_CODE)).thenReturn("false");
        when(props.getProperty(MySQLConstants.SERVER_TIMEZONE)).thenReturn("UTC");

        Connection mockConn = mock(Connection.class);
        MySQLConnector connectorMock = mock(MySQLConnector.class);
        when(connectorMock.getMySQLConnection()).thenReturn(mockConn);
        when(connectorMock.getURL()).thenReturn("");
        Connection connection = connectorMock.getMySQLConnection();
        assertEquals(mockConn, connection);
    }
}
