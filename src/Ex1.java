import java.sql.*;

//First, apply mysql-connector to project structure
public class Ex1 {
    public static void main(String[] args) throws SQLException {
        Connection con = Database.con;
        if (con != null) {
            System.out.println("Connected to the database");
        } else throw new RuntimeException("Err: Not connected to database");

        String query = "SELECT * FROM taula1";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet result = ps.executeQuery(query);
        System.out.println("Found in table: ");
        while(result.next()) {
            System.out.print(result.getString(1));
            System.out.println();
        }

        /*String sql = "insert into test (text) values (?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "prova");
        ps.execute();
        ps.close();*/
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