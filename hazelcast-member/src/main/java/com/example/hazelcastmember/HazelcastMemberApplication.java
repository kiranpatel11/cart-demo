package com.example.hazelcastmember;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class HazelcastMemberApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastMemberApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
	}	
	
}
