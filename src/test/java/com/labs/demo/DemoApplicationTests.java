package com.labs.demo;

import java.text.NumberFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	@Qualifier("defaulltCurrencyFormat")
	private NumberFormat defaultNumberFormat;

	@Test
	public void contextLoads() {
		for(String beanName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
	}

	@Test
	public void defaultCurrency() {
		double amount = 12345.2345667;
		System.out.println(defaultNumberFormat.format(amount));
	}

	@Test
	public void germanCurrencyFormat() {
		double amount = 12345.2345667;
		NumberFormat germanFormat = applicationContext.getBean("germanCurrencyFormat", NumberFormat.class);
		System.out.println(germanFormat.format(amount));
	}
}
