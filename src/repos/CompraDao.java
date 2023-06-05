package repos;

import models.Compra;

import java.sql.SQLException;

public interface CompraDao {
    Compra findByCotxeAndPasswordAndNotValid(int idCotxe, String password) throws SQLException;

    void save(Compra compra);
}
