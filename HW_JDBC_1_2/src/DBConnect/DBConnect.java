package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/testoptsklad";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public DBConnect() {
    }

    public static Connection getConnection(){
        if (connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                System.out.println("Connection complete!");
                return connection;
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
