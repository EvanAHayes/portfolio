package com.ehayes.portfolio.Ehayes.Portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
public class EhayesPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhayesPortfolioApplication.class, args);
	}

}
