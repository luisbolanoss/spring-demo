package com.labs.demo.services;

import com.labs.demo.jsons.JokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {
  private RestTemplate restTemplate;
  private final String baseURL = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

  @Autowired
  public JokeService(RestTemplateBuilder builder) {
    restTemplate = builder.build();
  }

  public String getJoke(String firstName, String lastName) {
    String URL = String.format("%s&firstName=%s&lastName=%s", this.baseURL, firstName, lastName);

    JokeResponse jokeResponse = this.restTemplate.getForObject(URL, JokeResponse.class);
    String output = jokeResponse != null ? jokeResponse.getValue().getJoke() : null;

    return output;
  }
}
