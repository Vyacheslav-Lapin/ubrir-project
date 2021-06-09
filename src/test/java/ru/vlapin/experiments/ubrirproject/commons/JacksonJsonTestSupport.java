package ru.vlapin.experiments.ubrirproject.commons;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import lombok.Setter;
import lombok.SneakyThrows;
import lombok.experimental.NonFinal;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public abstract class JacksonJsonTestSupport {

  @NonFinal
  @Setter(onMethod_ = @Autowired)
  MockMvc mockMvc;

  @SneakyThrows
  protected void testViaSendAndReceiveAsResponse(String url,
                                                 @Language("JSON") String content) {
    mockMvc
        .perform(post("/jackson" + url)
            .contentType(APPLICATION_JSON)
            .content(content))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON))
        .andExpect(mvcResult ->
                       assertThat(mvcResult.getResponse().getContentAsString()).isNotNull()
                           .isEqualToIgnoringWhitespace(content));
  }
}
