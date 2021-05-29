package com.anand.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.Session;

public class Subscriber {
    private String mqHost;
    private String queue;
    private Connection connection=null;
    private Session session = null;
    private MQConnectionFactory connectionFactory;


}
