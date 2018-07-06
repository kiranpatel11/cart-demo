package com.example.hazelcastmember;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.hazelcast.core.Hazelcast;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class HazelcastMemberApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HazelcastMemberApplication.class, args);
		
		for(String name : context.getBeanDefinitionNames()) {
			System.out.println("####" + name);
		}
	}

	@Override
	public void run(String... args) throws Exception {
        //Hazelcast.newHazelcastInstance();
	}
	
	
	
}
