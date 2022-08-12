import view.Controller;
import view.View;
import view.ViewOrder;
import view.ViewProdus;

public class main {
    public static void main(String[] args) {
        View view1 = new View();

        ViewProdus viewProdus=new ViewProdus();
        ViewOrder viewOrder=new ViewOrder();
        Controller controller=new Controller(view1,viewProdus,viewOrder);
       // Controller controller1=new Controller(viewProdus);
    }
}
