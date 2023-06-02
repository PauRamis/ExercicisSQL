import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static String DB_USERNAME = "root";
    private static String DB_PASSWORD = "password";
    private static String DB_PORT = ":3306";
    private static String DB_HOST = "localhost";
    private static String DB_DBNAME = "ProgramacioBD";

    static String url = "jdbc:mysql://" + DB_HOST + DB_PORT + "/" + DB_DBNAME;
    static Connection con;
    static {
        try {
            con = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
