package com.example.ec.explorecaliTour;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.ec.explorecaliTour.services.TourPackageService;



/**
 * Hello world!
 *
 */
//@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class App implements CommandLineRunner 
{
	@Autowired
	private TourPackageService tourPackageService;

    public static void main( String[] args )throws RestClientException, IOException {
		SpringApplication.run(App.class, args);
    System.out.println("Explorecali tour microservice.");
    System.out.println("Tour service to add and remove tours");
    }
    
    @Override
	public void run(String... arg0) throws Exception {
	
    tourPackageService.createTourPackage("BP","backpack");
	tourPackageService.createTourPackage("a","aaaaa");
	tourPackageService.createTourPackage("b","bbbbb");
	tourPackageService.createTourPackage("c","ccccc");
    
  
    }
    @Configuration
    class Config{
    	@LoadBalanced
    	@Bean
    	public RestTemplate restTemplate(){
    		return new RestTemplate();
    	}
    }

}