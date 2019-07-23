package com.labs.demo;

import static junit.framework.TestCase.assertEquals;

import com.labs.demo.controllers.HelloController;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

public class HelloControllerUnitTest {
  @Test
  public void sayHello() {
    HelloController helloController = new HelloController();
    Model model = new BindingAwareModelMap();

    String result = helloController.sayhello("World", model);
    assertEquals(result, "Hello");
    assertEquals(model.asMap().get("user"), "World");
  }
}
