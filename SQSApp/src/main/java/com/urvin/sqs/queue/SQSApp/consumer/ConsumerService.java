package com.urvin.sqs.queue.SQSApp.consumer;

import com.amazon.sqs.javamessaging.message.SQSObjectMessage;
import com.urvin.sqs.queue.SQSApp.domain.User;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

@Service
public class ConsumerService {

    @JmsListener(destination = "TextMessageQueue",containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String message) throws JMSException {
        System.out.println("Message Received");
        System.out.println("Received message is:"+message);
    }

    @JmsListener(destination = "ObjectMessageQueue",containerFactory = "jmsListenerContainerFactory")
    public void receiveUserMessage(User message) {
        //try {
            System.out.println("User Message Received");
//            System.out.println("Received :" + (User) message.getObject());
        System.out.println("Received :"+message);
//        }catch (JMSException e) {
//            e.printStackTrace();
//        }
    }
}
