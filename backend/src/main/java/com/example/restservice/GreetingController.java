package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();


	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);


	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("greeting")
	public void greetingPost(@RequestBody String body){
		logger.debug("post", body);
	}

	@DeleteMapping("greeting/{id}")
	public void greetingDelete(@PathVariable("id") Long todoId){
		logger.debug("greetingDelete", todoId);
	}

}
