import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//First, apply mysql-connector to project structure
public class Main {
    private static String DB_USERNAME = "root";
    private static String DB_PORT = ":8082";
    private static String DB_PASSWORD = "password";
    private static String DB_HOST = "localhost";
    private static String DB_DBNAME = "db";
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://"+DB_HOST+DB_PORT+"/"+DB_DBNAME,DB_USERNAME, DB_PASSWORD
        );
        String sql = "insert into test (text) values (?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "prova");
        ps.execute();
        ps.close();
    }
}
/*
Writing:
for (int i = 0; i < 100; i++) {
    String sql = "insert into test (text) values (?)";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, "prova" + i);
    ps.execute();
    ps.close();
}
con.close();

Comandes instalar Mysql
 docker run --name Demosql -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.33


Crear usuari root
 CREATE USER 'root'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'root';
*/