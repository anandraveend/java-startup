package com.anand.jms;

import javax.jms.*;


public class ProducerThread implements Runnable {
    private MQConnectionFactory factory;
    ProducerThread(MQConnectionFactory f){
        this.factory = f;
    }

    @Override
    public void run() {
        Connection conn = factory.getQConnection();
        Session sess = factory.getSession(conn);
        MessageProducer producer = factory.getProducer(sess,false);
        try {
            for(int i=1;i<=5;i++){
                Message msg = sess.createTextMessage("Publishing from " + Thread.currentThread().getName());
                producer.send(msg);
                Thread.sleep(1000);
            }
            Message empty = MQConnectionFactory.getEmptyMessage(sess);
            producer.send(empty);
            System.out.println( Thread.currentThread().getName() + " Producer completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
