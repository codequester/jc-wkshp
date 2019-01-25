package com.wkshp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class ApplicationController {
	
	@Autowired
    MessageProducer producer;
    
    @Autowired
	private MessageRepository messageRepository;
	
    @RequestMapping(value="/")
	String showStatus(){
		return "AMQ Demo Application - running.";
    }
    
    @RequestMapping(value="/produce")
	String produce(@RequestParam("msg")String msg){
		producer.send(msg);
		return "Message -["+msg+"] Successfully Sent";
    }

    @RequestMapping(value="/messages")
	List<Message> getMessages(){
        return messageRepository.findAll();
    }
    
}