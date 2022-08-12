package model;

public class Client {
    private int id;
    private String numec;
    private String address;
    public Client(int id, String numec,String address){
        this.id=id;
        this.numec=numec;
        this.address=address;
    }

    public String getAdresa() {
        return address;
    }

    public void setAdresa(String address) {
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNume(String numec) {
        this.numec = numec;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return numec;
    }
}
