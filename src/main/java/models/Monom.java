package models;

public class Monom {

    private float coeficient;
    private int putere;

    public Monom(float coeficient, int putere) {
        this.coeficient = coeficient;
        this.putere = putere;
    }

    public void setCoeficient(float coeficient) {
        this.coeficient = coeficient;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }



    public float getCoeficient() {
        return coeficient;
    }

    public int getPutere() {
        return putere;
    }
}
