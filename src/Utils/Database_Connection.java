package Utils;

import oracle.jdbc.OracleDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connection {
    public static Connection getConnection() {
        Connection c = null;
        // Register JDBC Driver with DriverManager
        Driver myDriver = new OracleDriver();
        try {
            DriverManager.registerDriver(myDriver);
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl21c", "GARAOTO_IS216_DATABASE", "uitisquan");
            if (c != null) {
                System.out.println("Connection status: Successful");
            }else System.out.println("Error");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // get the connection
        // URL Sever
        return c;
    }
    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printInfo(Connection c) {
        if (c != null) {
            try {
                System.out.println("DatabaseProductName: " + c.getMetaData().getDatabaseProductName());
                System.out.println("DatabaseProductVersion: " + c.getMetaData().getDatabaseProductVersion());
                System.out.println("DriverVersion: " + c.getMetaData().getDriverVersion());
                System.out.println("DriverName: " + c.getMetaData().getDriverName());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
