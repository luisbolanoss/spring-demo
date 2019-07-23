package com.labs.demo.controllers;

import com.labs.demo.entities.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
  @GetMapping("rest")
  public Greeting greeting(
      @RequestParam(defaultValue = "World", required = false) String name) {

    return new Greeting(String.format("Hello %s", name));
  }
}
