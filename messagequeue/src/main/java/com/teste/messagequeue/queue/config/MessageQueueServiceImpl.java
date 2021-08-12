package com.teste.messagequeue.queue.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.teste.messagequeue.queue.MessageQueueService;

public abstract class MessageQueueServiceImpl<T>
	implements MessageQueueService<T> {
	
	@Autowired
	RabbitTemplate template;
	
	private String queueName;
	private String exchangeName;
	
	public MessageQueueServiceImpl(String queueName, String exchangeName) {
		this.queueName = queueName;
		this.exchangeName = exchangeName;
	}
	
	@Bean
	public Queue declareQueue() {
		return QueueBuilder.durable(queueName)
				.build();
	}
	
	@Bean
	public Exchange declareExchange() {
		return ExchangeBuilder.directExchange(exchangeName)
				.durable(true)
				.build();
	}
	
	@Bean
	public Binding declareBinding(Exchange exchange, Queue queue) {
		return BindingBuilder.bind(queue)
				.to(exchange)
				.with("")
				.noargs();
	}
	
	public void publish(T object) {
		template.convertAndSend(queueName, object);
	}
}
