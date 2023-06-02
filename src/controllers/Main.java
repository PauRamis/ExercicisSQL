package controllers;

import models.Compra;
import repos.CompraDao;
import repos.CompraDaoImpl;
import repos.CotxeDaoImpl;
import repos.Database;
import models.Cotxe;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = Database.getConnection();
        if (con != null) {
            System.out.println("Connected to the database");
        } else throw new RuntimeException("Err: Not connected to database");

        Scanner scanner = new Scanner(System.in);
        System.out.println("1 per veure la taula");
        System.out.println("2 per afegir un cotxe");
        System.out.println("3 comprar un cotxe");
        int action = scanner.nextInt();
        switch (action){
            case 1:
                watchTable(con);
                break;
            case 2:
                addEntry(con);
                break;
            case 3:
                compra();
                break;
            default:
                System.out.println("opcio no valida");
        }
    }

    private static void compra() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("id del cotxe:");
        int idCotxe = scanner.nextInt();
        System.out.println("id del comprador:");
        int idComprador = scanner.nextInt();
        System.out.println("id del venedor:");
        int idVenedor = scanner.nextInt();
        System.out.println("preu:");
        int preu = scanner.nextInt();
        Compra compra = new Compra();
        compra.setIdCotxe(idCotxe);
        compra.setIdComprador(idComprador);
        compra.setIdVenedor(idVenedor);
        compra.setPreu(preu);
        compra.setData(new Date(System.currentTimeMillis()));

        try {
            CompraDao compraDao = new CompraDaoImpl();
        } catch (Error e){
            throw new RuntimeException("e");
        }
    }

    //Crear nou cotxe
    private static void addEntry(Connection con) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("id del cotxe:");
        int id = scanner.nextInt();
        System.out.println("matricula del cotxe:");
        String matricula = scanner.nextLine();
        System.out.println("any matriculació del cotxe:");
        int anyMatriculacio = scanner.nextInt();

        Cotxe cotxe = new Cotxe(id, matricula, anyMatriculacio);
        //Todo
        //CotxeDaoImpl.save;

        String query = "";
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