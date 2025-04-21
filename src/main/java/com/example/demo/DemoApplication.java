package com.example.demo;

import com.example.demo.model.Event;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static List<Event> events;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
