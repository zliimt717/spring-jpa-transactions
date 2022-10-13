package com.example.springjpatransactions;

import com.example.springjpatransactions.entity.dto.FlightBookingAcknowledgement;
import com.example.springjpatransactions.entity.dto.FlightBookingRequest;
import com.example.springjpatransactions.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class SpringJpaTransactionsApplication {
	@Autowired
	private FlightBookingService service;

	@PostMapping(path="/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){

		return service.bookFlightTicket(request);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaTransactionsApplication.class, args);
	}

}
