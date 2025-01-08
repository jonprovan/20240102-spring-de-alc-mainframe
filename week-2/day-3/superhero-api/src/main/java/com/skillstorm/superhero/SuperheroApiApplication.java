package com.skillstorm.superhero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// this annotation is required in the root class for an application
// it's actually a composite annotation, consisting of three other annotations
// @Configuration, @EnableAutoConfiguration, @ComponentScan
// @Configuration lets us define other Beans in this class that will be added to the ApplicationContext
// @EnableAutoConfiguration allows the app to auto-configure itself unless we override it
// @ComponentScan looks through this package and any subpackages for components, beans, etc. and auto-adds them to the context
// CAREFUL WITH THIS!! Make sure none of your components are in other/parent packages

@SpringBootApplication
public class SuperheroApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperheroApiApplication.class, args);
	}

}