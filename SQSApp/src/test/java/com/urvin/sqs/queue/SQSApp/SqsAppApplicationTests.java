package com.urvin.sqs.queue.SQSApp;

import com.urvin.sqs.queue.SQSApp.domain.User;
import com.urvin.sqs.queue.SQSApp.producer.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class SqsAppApplicationTests {

	@Autowired
	ProducerService producerService;

	@Test
	public void testProducer() {
		try {
			producerService.sendMessage("Hello World");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUserProducer() {
		try {
			producerService.sendUserMessage(new User("Harshal shah","harshal@gmail.com","9878778999989"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void contextLoads() {
	}

}
