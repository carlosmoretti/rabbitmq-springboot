package com.teste.messagequeue.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import com.teste.messagequeue.model.Parametro;
import com.teste.messagequeue.queue.config.MessageQueueServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ParametroQueueServiceImpl
	extends MessageQueueServiceImpl<Parametro> {
	
	private static final String QUEUE_NAME = "ParametroQueue";
	private static final String EXCHANGE_NAME = "ParametroExchange";
	
	public ParametroQueueServiceImpl() {
		super(QUEUE_NAME, EXCHANGE_NAME);
	}
	
	@RabbitListener(queues = { QUEUE_NAME })
	public void consume(Parametro message) {
		log.info(message.getValor().toString());
		
		try {
			Thread.sleep(35000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("Processo completo");
	}
}
