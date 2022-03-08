package com.mictexx.bootcampspring1.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mictexx.bootcampspring1.entities.Client;
import com.mictexx.bootcampspring1.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void run(String... args) throws Exception {

		//Instant.parse("01/01/2001")	

		Client c1 = new Client(null, "Michel Teixeira", "248248248-98", 1000.00, Instant.parse("1979-04-16T08:25:24.00Z"),2);
		Client c2 = new Client(null, "Adriana Taira", "285285285-00", 1000.00, Instant.parse("1982-02-08T08:25:24.00Z"),1);
		
		clientRepository.saveAll(Arrays.asList(c1,c2));
		
	}

}
