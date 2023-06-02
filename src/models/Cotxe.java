package models;

public class Cotxe {
    int id;
    int anyMatr;
    String matr;

    public Cotxe(int id, String matricula, int anyMatriculacio) {
        setId(id);
        setMatr(matricula);
        setAnyMatr(anyMatriculacio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnyMatr() {
        return anyMatr;
    }

    public void setAnyMatr(int anyMatr) {
        this.anyMatr = anyMatr;
    }

    public String getMatr() {
        return matr;
    }

    public void setMatr(String matr) {
        this.matr = matr;
    }
}
