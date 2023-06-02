package models;

import java.sql.Date;

public class Compra {
    int preu;
    int idComprador;
    int idVenedor;
    int idCotxe;
    Date data;

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public int getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    public int getIdVenedor() {
        return idVenedor;
    }

    public void setIdVenedor(int idVenedor) {
        this.idVenedor = idVenedor;
    }

    public int getIdCotxe() {
        return idCotxe;
    }

    public void setIdCotxe(int idCotxe) {
        this.idCotxe = idCotxe;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
