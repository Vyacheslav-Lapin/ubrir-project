package ru.vlapin.experiments.ubrirproject.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest@AutoConfigureMockMvc
//@org.springframework.security.test.context.support.WithMockUser(authorities = "ADMIN")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class ControllerExampleTest {

  MockMvc mockMvc;

  @Test
  @SneakyThrows
  @DisplayName("Cat returns correctly")
  void catReturnsCorrectlyTest() {
    mockMvc.perform(get("/example/1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON));
  }
}
