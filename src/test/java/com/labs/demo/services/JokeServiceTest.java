package com.labs.demo.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment = WebEnvironment.RANDOM_PORT)
public class JokeServiceTest {
  @Autowired
  private JokeService jokeService;

  @Test
  public void getJoke() {
    String joke = this.jokeService.getJoke("Craig", "Walls");
    assertTrue(joke.contains("Craig") || joke.contains("Walls"));
  }
}