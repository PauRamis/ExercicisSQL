package repos;

import models.Cotxe;

import java.sql.SQLException;

public interface CotxeDao {
    public abstract void save(Cotxe cotxe) throws SQLException;
}
