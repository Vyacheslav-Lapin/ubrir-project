package ru.vlapin.experiments.ubrirproject.model.jackson;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vlapin.experiments.ubrirproject.commons.JacksonJsonTestSupport;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class DefaultJacksonSerializationBehaviourJsonTest extends JacksonJsonTestSupport {

  @Test
  @SneakyThrows
  @DisplayName("Default Jackson works correctly")
  void defaultJacksonWorksCorrectlyTest() {
    testViaSendAndReceiveAsResponse("/default", """
        {
          "x": 1,
          "s": "lorem",
          "z": true
        }""");
  }
}

