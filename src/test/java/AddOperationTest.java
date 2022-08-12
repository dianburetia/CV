import controller.Controller;
import controller.Operatii;
import models.Monom;
import models.Polinom;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//import org.testng.annotations.Test;

import java.util.List;

//import static org.testng.AssertJUnit.assertEquals;
public class AddOperationTest {
    Polinom u=new Polinom("3X^45+6X^21-5X^0");
    Polinom w=new Polinom("1X^45+8X^10-2X^2");
    Polinom u1=new Polinom("3X^45");
    Polinom w1=new Polinom("8X^10");
    Polinom m1=new Polinom("24X^55");
    Polinom m=new Polinom("4X^45+6X^21-5X^0+8X^10-2X^2");
    @Test
    public void addTest(){
        Operatii op=new Operatii();
        List<Monom> g= op.adunare(u,w);
        Polinom max=new Polinom("");
        max.setMonom(g);
        for(Monom qwer:m.getMonom()){
            qwer.setCoeficient(qwer.getCoeficient()*(-1));
        }
        List<Monom> qq=op.scadere(max,m);
        int ok=0, ok1=0;
        for(Monom www:qq)
            if(www.getCoeficient() !=0)
                ok=1;
        Assert.assertEquals(ok,ok1);
    }
    public void addTest1(){
        Operatii op=new Operatii();
        List<Monom> g= op.inmultire(u1,w1);
        Polinom max=new Polinom("");
        max.setMonom(g);
        Assert.assertEquals(m1,max);
    }
}
