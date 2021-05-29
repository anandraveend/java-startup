package com.anand.threads.deadlock;


public class DeadlockTest {
    public static void main(String[] args) {
        DBResource db =new DBResource();
        NetworkResource net = new NetworkResource();
        db.setNet(net);
        net.setDb(db);

        Worker w1 = new Worker(db,net,1);
        Thread t1=new Thread(w1, "Thread #" + 1);
        Worker w2 = new Worker(db,net,2);
        Thread t2=new Thread(w2, "Thread #" + 2);

        t1.start();
        t2.start();

        while(t1.isAlive() && t2.isAlive()){
            System.out.println(t1.getName() + " : " + t1.getState());
            System.out.println(t2.getName() + " : " + t2.getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
