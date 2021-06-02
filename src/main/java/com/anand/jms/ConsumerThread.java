package com.anand.jms;

import javax.jms.*;

public class ConsumerThread implements Runnable {

    private MQConnectionFactory factory;
    ConsumerThread(MQConnectionFactory f){
        this.factory = f;
    }

    @Override
    public void run() {

        Connection conn = factory.getQConnection();
        Session sess = factory.getSession(conn);
        MessageConsumer consumer = factory.getConsumer(sess,false);
        Message msg = null;
        try {
            while(!MQConnectionFactory.isEmptyMessage(msg = consumer.receive())){
                System.out.println("Received msg into " + Thread.currentThread().getName() + " : " +((TextMessage) msg).getText());
//                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Stopping consumer " + Thread.currentThread().getName());
    }
}
