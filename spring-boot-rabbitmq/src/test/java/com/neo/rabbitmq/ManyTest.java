package com.neo.rabbitmq;

import com.neo.rabbit.many.NeoSender;
import com.neo.rabbit.many.NeoSender2;
import com.neo.rabbit.many.ack.NeoAckSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {
	@Autowired
	private NeoSender neoSender;

	@Autowired
	private NeoSender2 neoSender2;

	@Autowired
	private NeoAckSender neoAckSender;

	@Test
	public void oneToMany() throws Exception {
		for (int i=0;i<50;i++){
			neoSender.send(i);
		}
	}

	@Test
	public void manyToMany() throws Exception {
		for (int i=0;i<100;i++){
			neoSender.send(i);
			neoSender2.send(i);
		}
	}

	@Test
	public void ackOneToMany() throws Exception {
		for (int i=0;i<50;i++){
			neoAckSender.send(i);
		}
	}

}