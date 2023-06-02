package repos;

import models.Cotxe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CotxeDaoImpl implements CotxeDao {

    @Override
    public void save(Cotxe cotxe) throws SQLException {
        Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into cotxe (nat, any) values (?,')");
        
    }
}
