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

		Client c1 	= new Client(null, "Michel Teixeira", "248248248-98", 1000.00, Instant.parse("1979-04-16T08:25:24.00Z"),2);
		Client c2 	= new Client(null, "Adriana Taira", "285285285-00", 1000.00, Instant.parse("1982-02-08T08:25:24.00Z"),1);
		Client c3 	= new Client(null, "Pedro Taira Teixeira", "000000000-00", 100.00, Instant.parse("2020-02-29T08:25:24.00Z"),1);
		
		Client c4 	= new Client(null, "Francisco Teixeira Filho", "000000000-00", 2500.00, Instant.parse("1957-01-07T08:25:24.00Z"),1);
		Client c5 	= new Client(null, "Marlene Teixeira", "000000000-00", 1000.00, Instant.parse("1962-01-12T08:25:24.00Z"),1);
		Client c6 	= new Client(null, "Milene Cristina Teixeira", "000000000-00", 1500.00, Instant.parse("2000-02-18T08:25:24.00Z"),1);
		Client c7 	= new Client(null, "Jimi Teixeira", "000000000-00", 100.00, Instant.parse("2015-04-16T08:25:24.00Z"),1);
		Client c8 	= new Client(null, "Nekinho Teixeira", "000000000-00", 100.00, Instant.parse("2015-04-16T08:25:24.00Z"),1);
		Client c9 	= new Client(null, "Mia Teixeira", "000000000-00", 100.00, Instant.parse("2017-02-08T08:25:24.00Z"),1);
		Client c10 	= new Client(null, "Piloto Teixeira", "000000000-00", 50.00, Instant.parse("1989-02-28T08:25:24.00Z"),1);
		Client c11 	= new Client(null, "Shake Teixeira", "000000000-00", 50.00, Instant.parse("2004-02-28T08:25:24.00Z"),1);
		Client c12 	= new Client(null, "Rusty Taira", "000000000-00", 50.00, Instant.parse("1998-02-28T08:25:24.00Z"),1);
		
		
		clientRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12));
		
	}

}
