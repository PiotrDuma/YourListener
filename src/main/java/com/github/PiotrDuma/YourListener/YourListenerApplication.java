package com.github.PiotrDuma.YourListener;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
//@ComponentScan//attached in @SpringBootApplication
@EnableAutoConfiguration
public class YourListenerApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(YourListenerApplication.class,args);
		
		System.out.println(context.getBeanDefinitionCount());
		System.out.println("has this bean: "+context.containsBean("userDetailsServiceEngine"));
	}
}
