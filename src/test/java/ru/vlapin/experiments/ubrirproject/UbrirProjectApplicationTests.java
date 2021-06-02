package ru.vlapin.experiments.ubrirproject;

import java.util.Date;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@RequiredArgsConstructor(onConstructor_ = @Autowired)
class UbrirProjectApplicationTests {

  private static Date date;

  @Autowired
  void setDate(Date date) {
    if (UbrirProjectApplicationTests.date == null)
      UbrirProjectApplicationTests.date = date;
  }

  @Test
  void contextLoads() {
  }

  @Test
  @SneakyThrows
  @DisplayName("Date bean injected correctly")
  void dateBeanInjectedCorrectlyTest() {
    Assertions.assertThat(date).isNotNull()
        .isAfter(new Date(0L));
  }
}
