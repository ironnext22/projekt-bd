import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class baza {
    private static String URL = "jdbc:mariadb://localhost:3306/bazaprojekt";
    private static String user = "root";
    private static String password = "";

    public static Connection connect()
    {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("Connected to database!");
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
        return connection;
    }
    public static void main(String[] args)
    {
        baza.connect();
    }
}
