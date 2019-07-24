package com.labs.demo;

import java.text.NumberFormat;
import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public NumberFormat defaulltCurrencyFormat() {
		return NumberFormat.getCurrencyInstance();
	}

	@Bean
	public NumberFormat germanCurrencyFormat() {
		return NumberFormat.getCurrencyInstance(Locale.GERMANY);
	}
}
