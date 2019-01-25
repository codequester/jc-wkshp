package com.wkshp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
class MessageConsumer{

	@Autowired
	private MessageRepository messageRepository;

    @JmsListener(destination = "${jms.queue.destination}")
    public void processMsg(String message) {
        System.out.println("============= Received: " + message);
        messageRepository.save(new Message(message));
    }
}