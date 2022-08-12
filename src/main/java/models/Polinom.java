package models;

import models.Monom;

import java.util.ArrayList;
import java.util.List;
public class Polinom {
    private List<Monom> monom;

    public Polinom(String polinom1) {
        List<Monom> a1= new ArrayList<Monom>();
        char[] prelucrare=new char[110000];
        for(int u=0;u<109999;u++){
            prelucrare[u]='#';
        }
        for(int y=0;y<polinom1.length();y++){
            if(polinom1.charAt(y)>='0' && polinom1.charAt(y)<='9'){
                prelucrare[y]=polinom1.charAt(y);
            }
            else if (polinom1.charAt(y)=='-'){
                prelucrare[y]='-';
            }
        }
        for(int u=0;u<=105000;u++){
            int val1=0,val2=0,semn=1;
            if(prelucrare[u]=='-'){
                semn=-1;u++;
            }
            while(!(prelucrare[u]>='0' && prelucrare[u]<='9') && u<100000)u++;
            while(prelucrare[u]>='0' && prelucrare[u]<='9'){
                val1=val1*10+(prelucrare[u]-'0');
                u++;
            }
            if(semn==-1)val1*=(-1);
            u++;u++;

            while(prelucrare[u]>='0' && prelucrare[u]<='9'){
                val2=val2*10+(prelucrare[u]-'0');
                u++;
            }
            u--;

            if(val1!=0 || val2!=0) {
                Monom w=new Monom(val1,val2);
                a1.add(w);
            }
        }
        this.monom=a1;
    }

    public void setMonom(List<Monom> monom) {
        this.monom = monom;
    }

    public List<Monom> getMonom() {
        return monom;
    }
    public void citire(String polinom1){
        List<Monom> a1= new ArrayList<Monom>();
        char[] prelucrare=new char[110000];
        for(int u=0;u<109999;u++){
            prelucrare[u]='#';
        }
        for(int y=0;y<polinom1.length();y++){
            if(polinom1.charAt(y)>='0' && polinom1.charAt(y)<='9'){
                prelucrare[y]=polinom1.charAt(y);
            }
            else if (polinom1.charAt(y)=='-'){
                prelucrare[y]='-';
            }
        }
        for(int u=0;u<=105000;u++){
            int val1=0,val2=0,semn=1;
            if(prelucrare[u]=='-'){
                semn=-1;u++;
            }
            while(!(prelucrare[u]>='0' && prelucrare[u]<='9') && u<100000)u++;
            while(prelucrare[u]>='0' && prelucrare[u]<='9'){
                val1=val1*10+(prelucrare[u]-'0');
                u++;
            }
            if(semn==-1)val1*=(-1);
            u++;u++;

            while(prelucrare[u]>='0' && prelucrare[u]<='9'){
                val2=val2*10+(prelucrare[u]-'0');
                u++;
            }
            u--;

            if(val1!=0 || val2!=0) {
                Monom w=new Monom(val1,val2);
                a1.add(w);
            }
        }
    }

}
