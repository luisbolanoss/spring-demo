package com.labs.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.Matchers.is;

import com.labs.demo.controllers.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerIntegrationTest {

  @Autowired
  MockMvc mvc;

  @Test
  public void testWithoutName() throws Exception {
    mvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isOk())
        .andExpect(view().name("Hello"))
        .andExpect(model().attribute("user", is("World")));

  }

  @Test
  public void testWithName() throws Exception {
    mvc.perform(get("/hello")
        .param("name", "Luis")
        .accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isOk())
        .andExpect(view().name("Hello"))
        .andExpect(model().attribute("user", is("Luis")));

  }
}
