package com.anand.threads;

public class WaitNotifyTest extends Thread {
    private Boolean canRun = true;
    private Boolean suspended = false;

    private synchronized void stopRun(){
        this.canRun = false;
        this.notify();
    }

    private synchronized void isSuspended(Boolean susp){
        this.suspended = susp;

        if(!susp)
            this.notify();
    }


    @Override
    public void run() {
        try {
            while(canRun){
                System.out.println("Running");
                Thread.sleep(1000);
                synchronized (this){
                    while(suspended){
                        System.out.println("Suspended...");
                        this.wait();
                        System.out.println("Resume...");
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Complete..");
    }

    public static void main(String[] args) {
        WaitNotifyTest t1 = new WaitNotifyTest();
        t1.start();
        try {
            Thread.sleep(2000);
            t1.isSuspended(true);
            Thread.sleep(2000);
            t1.isSuspended(false);
            Thread.sleep(2000);
            t1.stopRun();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
