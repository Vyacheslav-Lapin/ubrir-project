package ru.vlapin.experiments.ubrirproject;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
//@WithMockUser(authorities = "ADMIN")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CatTest {

  MockMvc mockMvc;

  @Test
  @Tag("slow")
  @SneakyThrows
  @DisplayName("Cats is accessible via REST")
  void catsIsAccessibleViaRestTest() {
    mockMvc.perform(get("/cats"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(HAL_JSON_VALUE))
        .andExpect(jsonPath("$.page.totalElements").isNumber())
        .andExpect(jsonPath("$.page.totalElements").value(4));
  }
}
