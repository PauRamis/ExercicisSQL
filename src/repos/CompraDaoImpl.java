package repos;

import models.Compra;

import java.sql.*;

public class CompraDaoImpl implements CompraDao{
    Connection con = Database.getConnection();
    PreparedStatement ps = con.prepareStatement(
            "insert into compra (preu, idcotxe, idcomprador, idvendedor, data, valid, password)"
    );

    public CompraDaoImpl() throws SQLException {
    }

    @Override
    public Compra findByCotxeAndPasswordAndNotValid(int idCotxe, String password) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "select (idCotxe, idComprador, idVenedor, preu, data, password, valid) from compra  where valid=0 and idCotxe=? and password=?"
        );
        ps.setInt(1, idCotxe);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Compra compra = new Compra();
            compra.setIdCotxe(rs.getInt(1));
            compra.setIdComprador(rs.getInt(2));
            compra.setIdVenedor(rs.getInt(3));
            compra.setPreu(rs.getInt(4));
            compra.setData(rs.getDate(5));
            compra.setPassword(rs.getString(6));
            compra.setValid(rs.getBoolean(7));
            return compra;
        }
        return null;
    }

    @Override
    public void save(Compra compra) {

    }
    /*@Override
    public void save(Compra compra){
        Connection con = Database.getConnection();

    }*/
}
