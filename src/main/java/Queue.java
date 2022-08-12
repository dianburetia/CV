import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue implements Runnable {
    private int SimulationTime;
    private int n;
    private Thread t;
    private int TminAsteptare;
    private boolean ok;
    private Vector<Client> clientVector = new Vector<Client>();
    private int waitingPeriod;

    public int getTminAsteptare() {
        return TminAsteptare;
    }

    public void setTminAsteptare(int tminAsteptare) {
        TminAsteptare = tminAsteptare;
    }

    public Queue() {
        this.ok=true;
    }

    public void setClientVector(Vector<Client> clientVector) {
        this.clientVector = clientVector;
    }

    public Vector<Client> getClientVector() {
        return clientVector;
    }
    //public void addTask(Client c, int q){
    // clientVector.add(c);
    // waitingPeriod.set(waitingPeriod.get()+1);

    //}
    public void adaugaInCoada(Client c) {
        this.clientVector.add(c);//adaugam clientul in coada
        waitingPeriod += c.getServiceTime();
    }

    public void stopQueue(){
        ok=false;
    }
    public void run() {
        int i = 1;
        //scadem timpul de procesare al primului client din fiecare coada
        //se face pe o coada
        while (ok) {
            if (!clientVector.isEmpty()) {
                Client client = clientVector.elementAt(0);
                try {
                    Thread.sleep(client.getServiceTime() * 100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitingPeriod -= client.getServiceTime();
                clientVector.remove(0);
            }
            try {
                t.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public int getWaitingPeriod() {
        return waitingPeriod;
    }

    public int getSimulationTime() {
        return SimulationTime;
    }

    public void setSimulationTime(int simulationTime) {
        SimulationTime = simulationTime;
    }

}
