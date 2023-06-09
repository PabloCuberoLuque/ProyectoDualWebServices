package com.proyectoDualWebService.persistence.connector;

import com.proyectoDualWebService.persistence.conector.MySQLConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MySQLConstantsTest {

    @Test
    public void testMySQLConstants() {
        String expectedPasswd = "jdbc.mysql.passwd";
        String expectedUser = "jdbc.mysql.user";
        String expectedDriver = "jdbc.mysql.driver";
        String expectedUrlPrefix = "jdbc.mysql.url.prefix";
        String expectedUrlHost = "jdbc.mysql.url.host";
        String expectedUrlPort = "jdbc.mysql.url.port";
        String expectedUrlSchema = "jdbc.mysql.url.schema";
        String expectedUrlSSL = "jdbc.mysql.url.ssl";
        String expectedAllowPublicKeyRetrieval = "jdbc.mysql.url.allowPublicKeyRetrieval";
        String expectedUseJDBCCompliantTimezoneShift = "jdbc.mysql.url.useJDBCCompliantTimezoneShift";
        String expectedUseLegacyDateTimeCode = "jdbc.mysql.url.useLegacyDatetimeCode";
        String expectedServerTimezone = "jdbc.mysql.url.serverTimezone";

        Assertions.assertEquals(expectedPasswd, MySQLConstants.PASSWD);
        Assertions.assertEquals(expectedUser, MySQLConstants.USER);
        Assertions.assertEquals(expectedDriver, MySQLConstants.DRIVER);
        Assertions.assertEquals(expectedUrlPrefix, MySQLConstants.URL_PREFIX);
        Assertions.assertEquals(expectedUrlHost, MySQLConstants.URL_HOST);
        Assertions.assertEquals(expectedUrlPort, MySQLConstants.URL_PORT);
        Assertions.assertEquals(expectedUrlSchema, MySQLConstants.URL_SCHEMA);
        Assertions.assertEquals(expectedUrlSSL, MySQLConstants.URL_SSL);
        Assertions.assertEquals(expectedAllowPublicKeyRetrieval, MySQLConstants.ALLOW_PUBLIC_KEY_RETRIEVAL);
        Assertions.assertEquals(expectedUseJDBCCompliantTimezoneShift, MySQLConstants.USE_JDBC_COMPLIANT_TIMEZONE_SHIFT);
        Assertions.assertEquals(expectedUseLegacyDateTimeCode, MySQLConstants.USE_LEGACY_DATE_TIME_CODE);
        Assertions.assertEquals(expectedServerTimezone, MySQLConstants.SERVER_TIMEZONE);
    }
}
