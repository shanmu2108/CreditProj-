package com.boot.restapi.RestAPIdemo;

import com.boot.restapi.RestAPIdemo.entity.Transactions;
import com.boot.restapi.RestAPIdemo.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class RestApIdemoApplication {
	public static final Logger LOGGER= LoggerFactory.getLogger(RestApIdemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(RestApIdemoApplication.class, args);
		LOGGER.info("Simple log {}{}{}","d1","d2","d3" );
	}

}











//		ConfigurableApplicationContext context = SpringApplication.run(RestApIdemoApplication.class, args);
//		//CustomerService customerService=context.getBean(CustomerService.class);
//		TransactionService transactionService=context.getBean(TransactionService.class);
//		for (Transactions transactions: transactionService.getTransactionsInAmountRange(25,26)){
//		System.out.println(transactions);}