package com.anand.jms;

import com.anand.threads.producer.consumer.Consumer;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

public class MQConnectionFactory {
    private ActiveMQConnectionFactory tFactory;
    private ActiveMQConnectionFactory qFactory;

    private List<Connection> connections;
    private List<Session> sessions;
    private final String QUEUE="java-starter.queue";
    private final String TOPIC="java-starter.topic";

    MQConnectionFactory(){
        try {
            Context ctx = new InitialContext();
            qFactory = (ActiveMQConnectionFactory)ctx.lookup("ConnectionFactory");
            tFactory = (ActiveMQConnectionFactory)ctx.lookup("ConnectionFactory");
            connections = new ArrayList<>();
            sessions = new ArrayList<>();

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


    public Connection getQConnection(){
        Connection con = null;
        try {
            con= qFactory.createQueueConnection();
            con.start();
            connections.add(con);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return con;
    }

    public Session getSession(Connection con){
        Session sess = null;

        try {
            sess = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            sessions.add(sess);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return sess;
    }

    public  MessageProducer getProducer(Session sess,boolean isQueue){
        MessageProducer producer = null;
        try{
            Destination dest = isQueue? sess.createQueue(QUEUE):sess.createTopic(TOPIC);
            producer = sess.createProducer(dest);
        }catch (Exception e){
            e.printStackTrace();
        }
        return producer;
    }

    public  MessageConsumer getConsumer(Session sess,boolean isQueue){
        MessageConsumer consumer = null;
        try{
            Destination dest = isQueue? sess.createQueue(QUEUE):sess.createTopic(TOPIC);
            consumer = sess.createConsumer(dest);
        }catch (Exception e){
            e.printStackTrace();
        }
        return consumer;
    }
    public static Message getEmptyMessage(Session sess){
        Message emptyMsg = null;
        try {
            emptyMsg = sess.createMessage();
            emptyMsg.setBooleanProperty("isEmpty",true);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return emptyMsg;
    }

    public static boolean isEmptyMessage(javax.jms.Message msg) {
        try {
            if(msg.getBooleanProperty("isEmpty")) {
                System.out.println("=========Empty msg");
                return true;
            }

        } catch (JMSException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void cleanUpOnClose()
    {
        System.out.println("Cleaning up connections and sessions");
        for(Session sess:sessions){
            if(sess != null)
                try {
                    sess.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
        }

        for (Connection conn:connections){
            if(conn != null){
                try {
                    conn.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void finalize()
    {
        cleanUpOnClose();
    }
}
