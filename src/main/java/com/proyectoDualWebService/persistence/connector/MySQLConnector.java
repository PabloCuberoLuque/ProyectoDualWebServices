package com.proyectoDualWebService.persistence.connector;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnector {
    @Setter
    @Getter
    Properties prop = new Properties();

    public MySQLConnector() {
        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(prop.getProperty(MySQLConstants.DRIVER));

            return DriverManager.getConnection(getURL());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    String getURL() {
        //jdbc:mysql://${url_host}:${port}/${schema}?user=${user}&password=${pass}&useSSL=false&...;
        return prop.getProperty(MySQLConstants.URL_PREFIX) +
                prop.getProperty(MySQLConstants.URL_HOST) + ":" +
                prop.getProperty(MySQLConstants.URL_PORT) + "/" +
                prop.getProperty(MySQLConstants.URL_SCHEMA) + "?user=" +
                prop.getProperty(MySQLConstants.USER) + "&password=" +
                prop.getProperty(MySQLConstants.PASSWD) + "&useSSL=" +
                prop.getProperty(MySQLConstants.URL_SSL) + ("&allowPublicKeyRetrieval=") +
                prop.getProperty(MySQLConstants.ALLOW_PUBLIC_KEY_RETRIEVAL) + ("&useJDBCCompliantTimezoneShift=") +
                prop.getProperty(MySQLConstants.USE_JDBC_COMPLIANT_TIMEZONE_SHIFT) + ("&useLegacyDatetimeCode=") +
                prop.getProperty(MySQLConstants.USE_LEGACY_DATE_TIME_CODE) + ("&serverTimezone=") +
                prop.getProperty(MySQLConstants.SERVER_TIMEZONE);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MySQLConnector connector = new MySQLConnector();
        Connection connection = connector.getMySQLConnection();
        System.out.println(connection.getCatalog());
        connection.close();
    }

}