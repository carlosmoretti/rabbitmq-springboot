package com.teste.messagequeue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.messagequeue.model.Parametro;
import com.teste.messagequeue.queue.ParametroQueueServiceImpl;

@RestController
@RequestMapping("/parametro")
public class ParametroController {
	
	@Autowired
	ParametroQueueServiceImpl service;
	
	@PostMapping()
	public void post() {
		service.publish(Parametro.create());
	}
	
}
