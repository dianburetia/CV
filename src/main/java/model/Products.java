package model;

public class Products {
    private int id;
    private String numep;
    private int cantitate;
    private int pret;
    public Products(int idp,String numep, int cantitate,int pret){
        this.id = idp;
        this.numep=numep;
        this.cantitate=cantitate;
        this.pret=pret;
    }

    public void setId(int idp) {
        this.id = idp;
    }

    public void setNumep(String numep) {
        this.numep = numep;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public int getId() {
        return id;
    }

    public String getNumep() {
        return numep;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getPret() {
        return pret;
    }
}
