package com.urvin.sqs.queue.SQSApp.producer;

import com.urvin.sqs.queue.SQSApp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProducerService {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(String message) throws IOException {
        System.out.println("Send Message");
        jmsTemplate.convertAndSend("TextMessageQueue",message);
    }

    public void sendUserMessage(User user) throws IOException{
        System.out.println("Send User Message");
        jmsTemplate.setMessageConverter(new MappingJackson2MessageConverter());
        jmsTemplate.convertAndSend("ObjectMessageQueue",user);
    }
}
