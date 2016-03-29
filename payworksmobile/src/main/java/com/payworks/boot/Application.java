package com.payworks.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.payworks.model.SuperHero;

/**
 * Entry point of the application
 * @author franciscotineo
 *
 */
@SpringBootApplication(scanBasePackages = { "com.payworks" })
public class Application {
	
	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		LOG.info("Application::main() -> Starting Application");
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

	}
}
