package ru.vlapin.experiments.ubrirproject.service.jsonplaceholder;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vlapin.experiments.ubrirproject.model.jsonplaceholder.Address;
import ru.vlapin.experiments.ubrirproject.model.jsonplaceholder.Geo;
import ru.vlapin.experiments.ubrirproject.model.jsonplaceholder.User;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class UserServiceTest {

  UserService userService;

  @Test
  @SneakyThrows
  @DisplayName("Feign works correctly")
  void feignWorksCorrectlyTest() {
    assertThat(userService.findById(1L)).isNotNull()
//        .hasSize(10)
        .extracting(User::getAddress)
        .matches(address -> address.getZipCode().equals("92998-3874"))
        .extracting(Address::getGeo)
        .extracting(Geo::getLatitude, Geo::getLongitude)
        .contains(-37.3159, 81.1496);
  }
}
