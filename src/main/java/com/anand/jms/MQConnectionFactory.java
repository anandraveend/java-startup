package com.anand.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MQConnectionFactory {
    private String connectionString;
    private ActiveMQConnectionFactory factory;
    private static MQConnectionFactory singleton;

    MQConnectionFactory(){

    }

    MQConnectionFactory(String connectionString){

        

        this.connectionString = connectionString;
        try{
            this.factory = new ActiveMQConnectionFactory(connectionString);
        }catch(Exception e){
            System.out.println("Unable to create a connection " + e.getMessage());
            throw e;
        }
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public ActiveMQConnectionFactory getFactory() {
        return factory;
    }

    public void setFactory(ActiveMQConnectionFactory factory) {
        this.factory = factory;
    }
}
