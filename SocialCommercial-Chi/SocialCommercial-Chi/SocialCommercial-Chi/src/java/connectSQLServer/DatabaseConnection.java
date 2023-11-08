
package connectSQLServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements DatabaseInfor {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to SQL Server!");
        } catch (ClassNotFoundException e) {
            System.out.println("SQL Server JDBC driver not found. Please check the driverName.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed. Please check the URL, username, and password.");
            e.printStackTrace();
        }
        return conn;
    }


}

