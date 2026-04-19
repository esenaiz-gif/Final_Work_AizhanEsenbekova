import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/tourism_db";
    private static final String USER = "root";
    private static final String PASSWORD = "@izhan5647Gu";

    public static Connection connect() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}