import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Controller {
    private int n;
    private int q;
    private int t1;
    private int t2;
    private int i1;
    private int i2;
    private int TmaxSim;
    private boolean isInputGood;
    private View view1;

    public int getTmaxSim() {
        return TmaxSim;
    }

    public Controller(View view1) {
        this.view1 = view1;
        this.view1.addGenerareListener(new GenerareListener());
    }

    class GenerareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                n = Integer.parseInt(view1.getText11());
                q = Integer.parseInt(view1.getText12());
                TmaxSim = Integer.parseInt(view1.getText13());
                t1 = Integer.parseInt(view1.getText14());
                t2 = Integer.parseInt(view1.getText15());
                i1 = Integer.parseInt(view1.getText16());
                i2 = Integer.parseInt(view1.getText17());
                isInputGood = true;
            } catch (NumberFormatException parseException){
                System.out.println(parseException.getMessage());
            }
            if(isInputGood) {
                Vector<Client> clientVector = new Vector<>(100);
                Scheduler scheduler = new Scheduler(n, q, TmaxSim, t1, t2, i1, i2,view1);
                clientVector = scheduler.generareClient(n, q, t1, t2, i1, i2);//am generat vectorul de clienti
                int par = 0;
                float suma = 0;
                float timpMediuDurata = 0;
                for (Client c : clientVector) {
                    suma += c.getServiceTime();
                }
                timpMediuDurata = suma / n;
                String hhh = new String("Perioada medie de asteptare in cazul listei generate e de:" + timpMediuDurata + "\n");
                int[] v = new int[100000];
                for (int mac = 1; mac <= TmaxSim; mac++) {
                    v[mac] = 0;
                }
                for (int qq = 1; qq < v.length; qq++) {
                    for (Client c : clientVector) {
                        if (qq >= c.getArrivalTime() && qq <= c.getServiceTime() + c.getArrivalTime()) {
                            v[qq]++;
                        }
                    }
                }
                int max = 0;
                int secundaMaxima = 0;
                for (int qq = 0; qq < TmaxSim; qq++) {
                    if (v[qq] >= max) {
                        secundaMaxima = qq;
                        max = v[qq];
                    }
                }
                // hhh+='\n';
                hhh += "\nSecunda maxima este: " + secundaMaxima;
//            for (int y = 1; y <= q; y++) {
//                Queue queue = new Queue();
//                Thread tj = new Thread(queue);
//                //Scheduler sc=new Scheduler();
//                tj.start();
//                rr.start();
//            }
                Thread evolutieTimp = new Thread(scheduler);
                evolutieTimp.start();
                //view1.setText19(hhh);
                //File myObj = new File("result.txt");
                FileWriter myWriter = null;
                try {
                    myWriter = new FileWriter("filename.txt");
                    myWriter.write(hhh);
                    myWriter.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }
}
