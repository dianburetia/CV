public class Client {
    private int id;
    private int arrivalTime;
    private int serviceTime;

    public Client(int id,int t1,int t2, int i1, int i2) {
        int arrivalTime=(int)((Math.random() * (t2-t1))+t1);
        int serviceTime=(int)((Math.random()*(i2-i1)+i1));
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }
    public String toString(){
        return "("+this.id+","+this.arrivalTime+","+this.serviceTime+")";
    }
    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }
}
