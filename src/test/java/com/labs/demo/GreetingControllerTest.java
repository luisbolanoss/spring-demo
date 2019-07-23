package com.labs.demo;

import static junit.framework.TestCase.assertEquals;

import com.labs.demo.entities.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment = WebEnvironment.RANDOM_PORT)
public class GreetingControllerTest {
  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  public void greeting() {
    ResponseEntity<Greeting> entity = testRestTemplate.getForEntity("/rest", Greeting.class);
    Greeting greeting =  entity.getBody();

    assertEquals(entity.getStatusCode(), HttpStatus.OK);
    assertEquals(entity.getHeaders().getContentType(), MediaType.APPLICATION_JSON_UTF8);
    assertEquals(greeting.getMessage(), "Hello World");

  }

  // open build/reports/tests/test/index.html
}
