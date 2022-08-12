import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

public class Scheduler implements Runnable {
    //private Vector<Client> clients;
    private Vector<Client> clientVector = new Vector<Client>();
    private Vector<Client> toRemove = new Vector<>();
    private int client1;
    private Vector<Queue> queue = new Vector<Queue>();
    private int n, q, t1, t2, i1, i2;
    private int TmaxSim;
    private int timpAsteptare;
    private Vector<Integer> peakTime = new Vector<>();
    private Vector<Integer> peakHourClients = new Vector<>();
    private int oradeVarf;
    private int peakHourClientsCompared;
    private View view1;

    public Scheduler(int n, int q, int TmaxSim, int t1, int t2, int i1, int i2,View view1) {
        this.TmaxSim = TmaxSim;
        this.n = n;
        this.q = q;
        this.t1 = t1;
        this.t2 = t2;
        this.i1 = i1;
        this.i2 = i2;
        this.view1=view1;
        //initializam vectorul de cozi cu timp asteptare 0
        for (int i = 0; i < q; i++) {
            queue.add(new Queue());
            queue.elementAt(i).setTminAsteptare(0);
        }
    }
    @Override
    public synchronized void run() {
        String ggg=new String("");
        for (Queue w : queue) {
            w.setTminAsteptare(0);//la inceput timpul de asteptare e 0 pt fiecare coada
            Thread t = new Thread(w);
            t.start();//pornim un nou fir de executie pt fiecare casierie in sine
        }
        int timpCurent = 0;
        while (timpCurent <= TmaxSim) {
            int minPeriod = queue.elementAt(0).getWaitingPeriod();
            int minPeriodIndex = 0;
            for (Queue q : queue) {
                if (minPeriod > q.getWaitingPeriod()) {
                    minPeriod = q.getWaitingPeriod();
                    minPeriodIndex = queue.indexOf(q);
                }
            }
            String rezultat = new String("Timp " + timpCurent + "\n");
            for (int wQueueSize = 0; wQueueSize < clientVector.size() && wQueueSize >= 0; wQueueSize++) {
                if (clientVector.elementAt(wQueueSize).getArrivalTime() == timpCurent) {
                    int g = 1;
                    int minWaitingTime = 100000;
                    int p = 0, kkk = 0;
                    rezultat+=("am adaugat clientul (" + clientVector.elementAt(wQueueSize).getId() + "," + clientVector.elementAt(wQueueSize).getArrivalTime() + "," + clientVector.elementAt(wQueueSize).getServiceTime() + ")" + " in secunda " + timpCurent + "in coada cu numarul " + minPeriodIndex);
                    queue.elementAt(minPeriodIndex).adaugaInCoada(clientVector.elementAt(wQueueSize));
                    queue.elementAt(minPeriodIndex).setTminAsteptare(clientVector.elementAt(wQueueSize).getServiceTime());
                    clientVector.remove(wQueueSize);
                    wQueueSize--;

                }
            }
            rezultat += "In asteptare: ";
            if (!clientVector.isEmpty()) {//daca avem clienti
                for (Client c : clientVector) {
                    rezultat += c.toString() + ", ";
                }
                rezultat += "\n";
            } else {
                rezultat += "closed\n";
            }
            for (Queue mmm : queue) {
                rezultat += "Queue " + queue.indexOf(mmm) + ": ";
                if (!mmm.getClientVector().isEmpty()) {
                    for (Client c : mmm.getClientVector()) {
                        oradeVarf++;
                        rezultat += c.toString() + ", ";
                    }
                } else rezultat += "close ";
            }
            System.out.println(rezultat + "\n");
            ggg+=(rezultat+"\n");
            timpCurent++; view1.setText19(ggg+"\n");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int y=0;y<queue.size();y++){
            queue.elementAt(y).stopQueue();
        }

    }
    public Vector<Client> generareClient(int n, int q, int t1, int t2, int i1, int i2) {
        for (int i = 1; i <= n; i++) {
            Client c = new Client(i, t1, t2, i1, i2);
            clientVector.add(c);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (clientVector.elementAt(i).getArrivalTime() > clientVector.elementAt(j).getArrivalTime()) {
                    Collections.swap(clientVector, i, j);//ordonam vectorul crescator in functie de timpul de sosire
                }
            }
        }
        return clientVector;
    }
}
