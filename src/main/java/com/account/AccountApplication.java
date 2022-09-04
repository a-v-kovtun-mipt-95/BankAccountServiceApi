package com.account;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountApplication {

	@Bean
	public CommandLineRunner loadData(AccountRepository repository) {
		return (args) -> {
			repository.save(new AccountBuilder()
				.withAccountNumber(1000123)
				.withCurrecy(978)
				.withBalance(new BigDecimal(0))
				.withStatus(Status.OPEN)
				.build()
			);
			repository.save(new AccountBuilder()
				.withAccountNumber(1000456)
				.withCurrecy(840)
				.withBalance(new BigDecimal(1002))
				.withStatus(Status.OPEN)
				.build()
			);
			repository.save(new AccountBuilder()
				.withAccountNumber(1000678)
				.withCurrecy(978)
				.withBalance(new BigDecimal(345))
				.withStatus(Status.OPEN)
				.build()
			);
			repository.save(new AccountBuilder()
				.withAccountNumber(1000236)
				.withCurrecy(978)
				.withBalance(new BigDecimal(0))
				.withStatus(Status.CLOSED)
				.build()
			);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

}
