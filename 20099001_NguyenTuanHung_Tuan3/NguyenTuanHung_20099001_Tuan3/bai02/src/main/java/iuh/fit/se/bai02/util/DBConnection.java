package iuh.fit.se.bai02.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // MSSQL
// private static final String JDBC_URL ="jdbc:sqlserver://localhost:1433;databaseName=UploadFileServletDB;encrypt=false;";
// private static final String JDBC_USER = "sa";
// private static final String JDBC_PASSWORD ="sapassword";
    // MariaDB
    private static final String JDBC_URL =
            "jdbc:mariadb://localhost:3300/tuanhaibaihai";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    static {
        try {
            // Load driver chỉ một lần duy nhất

           // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws
            SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER,
                JDBC_PASSWORD);
    }
}