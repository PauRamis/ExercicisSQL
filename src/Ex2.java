import java.sql.*;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) throws SQLException {
        Connection con = Database.con;
        if (con != null) {
            System.out.println("Connected to the database");
        } else throw new RuntimeException("Err: Not connected to database");

        Scanner scanner = new Scanner(System.in);
        System.out.println("1 per veure la taula");
        System.out.println("2 per afegir un cotxe");
        System.out.println("3 per afegir i veure la taula");
        int action = scanner.nextInt();
        if (action == 1)
            watchTable(con);
        if (action == 2)
            addEntry(con);
        if (action == 3){
            addEntry(con);
            watchTable(con);
        }
    }

    //Crear nou cotxe
    private static void addEntry(Connection con) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("INSERT INTO `cotxes`:");
        String query = scanner.nextLine();
        //String query  = "INSERT INTO `cotxes`(`id`, `matricula`, `any_matriculacio`) VALUES ('1','ABC123','2023')";
        PreparedStatement ps = con.prepareStatement(query);
        ps.execute(query);
        ps.close();
    }

    //Imprimir el contingut
    private static void watchTable(Connection con) throws SQLException {
        String query2  = "SELECT * FROM `cotxes`;";
        PreparedStatement ps = con.prepareStatement(query2);
        ResultSet result = ps.executeQuery(query2);

        int i = 0;
        while (result.next()) {
            int id = result.getInt("id");
            String matricula = result.getString("matricula");
            int any_matriculacio = result.getInt("any_matriculacio");
            System.out.println(id+" "+matricula+" "+any_matriculacio);
        }
        ps.close();
    }
}
