package com.teste.messagequeue.queue;

public interface MessageQueueService<T> {
	void publish(T object);
}
