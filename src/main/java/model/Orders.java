package model;

public class Orders {
    private int id;
    private int idc;
    private String numec;
    private String address;
    private int idp;
    private String numep;
    private int cantitate;
    private int pret;
    public Orders(){

    }
    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public String getAddress() {
        return address;
    }

    public int getPret() {
        return pret;
    }

    public Client setClient(int idc, String numec, String adresa) {
        Client c=new Client(idc, numec,adresa);return c;
    }

    public Products setProdus(int idp, String numep, int cantitate,int pret) {
        Products p=new Products(idp,numep,cantitate, pret);
        return p;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public void setNumec(String numec) {
        this.numec = numec;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public void setNumep(String numep) {
        this.numep = numep;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public int getIdc() {
        return idc;
    }

    public String getNumec() {
        return numec;
    }

    public int getIdp() {
        return idp;
    }

    public String getNumep() {
        return numep;
    }

    public int getCantitate() {
        return cantitate;
    }

    public int getId() {
        return id;
    }
}
