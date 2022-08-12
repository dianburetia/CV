package controller;

import models.Monom;
import models.Polinom;
import view.View;
import java.util.ArrayList;
import java.util.List;

public class Operatii {
    public Operatii() {
    }
    public List<Monom> adunare(Polinom q, Polinom q2){
        List<Monom> a3= new ArrayList<Monom>();
        for(Monom w2:q2.getMonom()){
            float sum=0;
            sum=w2.getCoeficient();
            for(Monom w1: q.getMonom()){

                if(w1.getPutere() ==w2.getPutere() && w1.getPutere() !=-1){
                    sum+=w1.getCoeficient();
                    //w1.setCoeficient(0);
                    w1.setPutere(-1);
                }
            }
            Monom c=new Monom(sum,w2.getPutere());
            a3.add(c);
        }
        for(Monom bam:q.getMonom()){
            if(bam.getPutere()!=-1){
                a3.add(bam);
            }
        }

        return a3;
    }
    public List<Monom> scadere(Polinom q,Polinom q2){
        List<Monom> a3= new ArrayList<Monom>();
        for (Monom w2 : q2.getMonom()) {
            float sum = 0;
            sum = w2.getCoeficient();
            for (Monom w1 : q.getMonom()) {
                if (w1.getPutere() == w2.getPutere() && w1.getPutere() != -1) {
                    sum += w1.getCoeficient();
                    //w1.setCoeficient(0);
                    w1.setPutere(-1);
                }
            }
            Monom c = new Monom(sum, w2.getPutere());
            a3.add(c);
        }
        for (Monom bam : q.getMonom()) {
            if (bam.getPutere() != -1) {
                a3.add(bam);
            }
        }
       return a3;
    }
    public List<Monom> inmultire(Polinom q, Polinom q2){
        List<Monom> a3= new ArrayList<Monom>();
        // Polinom rezultat=new Polinom(a3);
        for(Monom w2:q2.getMonom()){
            float coef=1;
            int putere1=0;
            for(Monom w1: q.getMonom()){
                coef=w1.getCoeficient() *w2.getCoeficient();
                putere1=w1.getPutere()+w2.getPutere();
                Monom c=new Monom(coef,putere1);
                a3.add(c);
            }
        }
        List<Monom> a4= new ArrayList<Monom>();

        for(Monom w2:a3){
            float sum=0;
            sum=w2.getCoeficient();
            for(Monom w1: a3){
                if(w1.getPutere() ==w2.getPutere() && w1.getPutere() !=-1 && w1.getPutere()!=w2.getPutere()){
                    sum+=w1.getCoeficient();
                    //w1.setCoeficient(0);
                    w1.setPutere(-1);
                }
            }


            Monom c=new Monom(sum,w2.getPutere());
            a4.add(c);
        }

        return a4;
    }
    public int grad(Polinom q){
        for(Monom m: q.getMonom()){
            if(m.getCoeficient() !=0)
                return m.getPutere();
        }
        return 0;
    }
    public Monom getMonomMax(Polinom q){
        for(Monom m:q.getMonom()){
            if(m.getCoeficient() !=0)
                return m;
        }
        return null;
    }
    public void remove1(Polinom q){

    }
    public List<Polinom> impartireCat(Polinom q, Polinom q2) {
        List<Monom> a3 = new ArrayList<Monom>();
        a3.clear();
        List<Monom> a4 = new ArrayList<Monom>();
        List<Monom> qqq = new ArrayList<>();
        Operatii op = new Operatii();
        int c = grad(q);
        int d = grad(q2);
        Polinom z1 = new Polinom("");
        for (int i = 0; i <= c + d - 3; i++) {
            System.out.println("mmm");
            Monom md = op.getMonomMax(q);

            Monom mi = op.getMonomMax(q2);
            float z = (md.getCoeficient() / mi.getCoeficient());
            int putere = md.getPutere() - mi.getPutere();
            Monom mc = new Monom(z, putere);

            a3.add(mc);
            qqq.add(mc);//in qqq e catul
            z1.setMonom(qqq);
            List<Monom> aux = op.inmultire(q2, z1);
            Polinom aux11 = new Polinom("");

            aux11.setMonom(aux);
            for (Monom y1 : aux11.getMonom()) {
                y1.setCoeficient(y1.getCoeficient() * (-1));
            }
            List<Monom> www = op.scadere(q, aux11);
            q.setMonom(www);

            for (Monom y1 : q.getMonom()) {
                for (Monom y2 : q.getMonom()) {
                    if (y1.getPutere() > y2.getPutere()) {
                        Monom fff = y1;
                        y1 = y2;
                        y2 = fff;
                    }
                }
            }
            q.getMonom().remove(i);
        }
        int par = 0;
        for (Monom y : a3){
        if (par == 1) a3.remove(y);
        if (y.getPutere() == 0) {
                par = 1;
            }
        }
        Polinom kkk = new Polinom("");
        List<Polinom> rezultat = new ArrayList<>();
        kkk.setMonom(a3);//in polinom kkk e catul
        rezultat.add(kkk);
        List<Monom> aux = op.inmultire(q2, kkk);
        Polinom jjj=new Polinom("");
        jjj.setMonom(aux);
        List<Monom> sss= op.scadere(q,jjj);
        Polinom hhh=new Polinom("");
        hhh.setMonom(sss);
        rezultat.add(hhh);
        return rezultat;
        }
    }


