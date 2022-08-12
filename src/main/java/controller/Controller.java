package controller;
import models.Monom;
import models.Polinom;
import view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Controller {
    private View view1;
    public Controller(View view1) {
        this.view1 = view1;
       // this.hotel = hotel;
       // this.view1.addEgalListener(new EgalListener());
        this.view1.addAdunareListener(new AdunareListener());
        this.view1.addScadereListener(new ScadereListener());
        this.view1.addInmultireListener(new InmultireListener());
        this.view1.addImpartireListener(new ImpartireListener());
        this.view1.addDerivareListener(new DerivareListener());
        this.view1.addIntegrareListener(new IntegrareListener());
    }
    class AdunareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String polinom1= view1.getText11();//citire din primul chenar
            view1.setText11();
            Polinom q= new Polinom(polinom1);
            for(Monom w:q.getMonom()){
                System.out.println(w.getCoeficient()+ " "+w.getPutere());
            }
            // al doilea polinom
            String polinom2=view1.getText22();
            view1.setText22();
            Polinom q2= new Polinom(polinom2);
            for(Monom w:q2.getMonom()){
                System.out.println(w.getCoeficient()+ " "+w.getPutere());
            }
            //adunarea
            Operatii op=new Operatii();
            List<Monom> q3;
            q3=op.adunare(q,q2);
            String s = new String("");

            for(Monom w:q3){
                if(w.getCoeficient() >0 && w != q3.get(0))
                    s=s.concat("+"+w.getCoeficient()+"X"+ "^"+w.getPutere());
                else  s=s.concat(w.getCoeficient()+"X"+ "^"+w.getPutere());
            }
            view1.showMessage("Polinomul rezultat este: "+s);
        }
    }
    class ScadereListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String polinom1 = view1.getText11();//citire din primul polinom
            view1.setText11();


            Polinom q = new Polinom(polinom1);
            for (Monom w : q.getMonom()) {
                System.out.println(w.getCoeficient() + " " + w.getPutere());
            }
            // al doilea polinom


            String polinom2 = view1.getText22();
            view1.setText22();


            Polinom q2 = new Polinom(polinom2);
            for (Monom w : q2.getMonom()) {
                w.setCoeficient(w.getCoeficient() * (-1));
            }
            Operatii op=new Operatii();
            List<Monom> q3;
            q3=op.scadere(q,q2);
            String s = new String("");

            for (Monom w : q3) {
                if (w.getCoeficient() > 0 && w != q3.get(0))
                    s = s.concat("+" + w.getCoeficient() + "X" + "^" + w.getPutere());
                else s = s.concat(w.getCoeficient() + "X" + "^" + w.getPutere());
            }
            view1.showMessage("Polinomul rezultat este: " + s);
        }
    }
    class InmultireListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String polinom1= view1.getText11();//citire din primul polinom
            view1.setText11();
            Polinom q= new Polinom(polinom1);
            for(Monom w:q.getMonom()){
                System.out.println(w.getCoeficient()+ " "+w.getPutere());
            }
            // al doilea polinom
            String polinom2=view1.getText22();
            view1.setText22();
            Polinom q2= new Polinom(polinom2);
            for(Monom w:q2.getMonom()){
                System.out.println(w.getCoeficient()+ " "+w.getPutere());
            }
            //calculul inmultirii dintre cele 2 polinoame
           Operatii op=new Operatii();
            List<Monom> a4;
            a4=op.inmultire(q,q2);
            String s=new String("");
            for(Monom w:a4){
                if(w.getCoeficient() >0 && w != a4.get(0))
                    s=s.concat("+"+w.getCoeficient()+"X"+ "^"+w.getPutere());
                else  s=s.concat(w.getCoeficient()+"X"+ "^"+w.getPutere());
            }
            view1.showMessage("Polinomul rezultat este: "+s);
        }
    }
    class ImpartireListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String polinom1= view1.getText11();//citire din primul polinom
            view1.setText11();


            Polinom q= new Polinom(polinom1);
            for(Monom w:q.getMonom()){
                System.out.println(w.getCoeficient()+ " "+w.getPutere());
            }
            // al doilea polinom


            String polinom2=view1.getText22();
            view1.setText22();


            Polinom q2= new Polinom(polinom2);
            for(Monom w:q2.getMonom()){
                System.out.println(w.getCoeficient()+ " "+w.getPutere());
            }
            //calculul impartirii dintre cele 2 polinoame
            Operatii op=new Operatii();
            List<Monom> a3= new ArrayList<Monom>();
            List<Monom> a4=new ArrayList<>();
            List<Polinom> rezultat=new ArrayList<>();
            rezultat=op.impartireCat(q,q2);

            a3=rezultat.get(0).getMonom();
            a4=rezultat.get(1).getMonom();
            String s=new String("");
            for(Monom w:a3){
                if(w.getCoeficient() >0 && w != a3.get(0))
                    s=s.concat("+"+w.getCoeficient()+"X"+ "^"+w.getPutere());
                else  s=s.concat(w.getCoeficient()+"X"+ "^"+w.getPutere());
            }

            String s1=new String("");
            for(Monom w:a4){
                if(w.getCoeficient() >0 && w != a4.get(0))
                    s1=s1.concat("+"+w.getCoeficient()+"X"+ "^"+w.getPutere());
                else  s1=s1.concat(w.getCoeficient()+"X"+ "^"+w.getPutere());
            }
            view1.showMessage("Catul este: "+s+" iar restul: "+s1);//de facut ultimul pas pt a aflat restu, doar ultima scadere.
        }

    }
    class DerivareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view1.getText11().equals(""))
                view1.showMessage("Va rog introduceti un polinom in primul chenar");
            else {
                String polinom1 = view1.getText11();//citire din primul polinom
                view1.setText11();


                Polinom q = new Polinom(polinom1);
                for (Monom w : q.getMonom()) {
                    System.out.println(w.getCoeficient() + " " + w.getPutere());
                }

                List<Monom> a8 = new ArrayList<Monom>();
                // Polinom rezultat=new Polinom(a3);
                for (Monom w2 : q.getMonom()) {
                    float sum = 0;
                    int putere = 0;
                    sum = w2.getCoeficient() * w2.getPutere();
                    putere = w2.getPutere() - 1;
                    Monom c = new Monom(sum, putere);
                    if(putere >=0)
                        a8.add(c);
                }
                String s = new String("");

                for (Monom w : a8) {
                    if (w.getCoeficient() > 0 && w != a8.get(0))
                        s = s.concat("+" + w.getCoeficient() + "X" + "^" + w.getPutere());
                    else s = s.concat(w.getCoeficient() + "X" + "^" + w.getPutere());
                }
                view1.showMessage("Polinomul rezultat este: " + s);
            }
        }
    }
    class IntegrareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (view1.getText11().equals(""))
                view1.showMessage("Va rog introduceti un polinom in primul chenar");
            else {
                String polinom1 = view1.getText11();//citire din primul polinom
                view1.setText11();
                Polinom q = new Polinom(polinom1);
                for (Monom w : q.getMonom()) {
                    System.out.println(w.getCoeficient() + " " + w.getPutere());
                }
                List<Monom> a8 = new ArrayList<Monom>();
                // Polinom rezultat=new Polinom(a3);
                for (Monom w2 : q.getMonom()) {
                    float sum = 0;
                    int putere = 0;

                    putere = w2.getPutere() + 1;
                    sum = (w2.getCoeficient()/putere);
                    Monom c = new Monom(sum, putere);
                    a8.add(c);
                }
                String s = new String("");
                for (Monom w : a8) {
                    if (w.getCoeficient() > 0 && w != a8.get(0))
                        s = s.concat("+" + w.getCoeficient() + "X" + "^" + w.getPutere());
                    else s = s.concat(w.getCoeficient() + "X" + "^" + w.getPutere());
                }
                view1.showMessage("Polinomul rezultat este: " + s);
            }
        }
    }
}
