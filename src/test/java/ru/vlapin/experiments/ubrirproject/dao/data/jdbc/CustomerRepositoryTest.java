package ru.vlapin.experiments.ubrirproject.dao.data.jdbc;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vlapin.experiments.ubrirproject.model.Customer;

@SpringBootTest
@SuppressWarnings("ClassCanBeRecord")
class CustomerRepositoryTest {

  private final CustomerRepository customerRepo;

  @Autowired
  public CustomerRepositoryTest(CustomerRepository customerRepo) {
    this.customerRepo = customerRepo;
  }

  @Test
  @SneakyThrows
  @DisplayName("Customer table works correctly")
  void customerTableWorksCorrectlyTest() {

    val savedCustomer = customerRepo.save(
        new Customer()
            .setDob(LocalDate.of(1904, 5, 14))
            .setFirstName("Albert"));

    assertThat(savedCustomer.getId()).isNotNull();

    customerRepo.save(savedCustomer.setFirstName("Hans Albert"));

    assertThat(customerRepo.findById(savedCustomer.getId()))
        .isNotEmpty()
        .get()
        .extracting(Customer::getFirstName)
        .isEqualTo("Hans Albert");
  }
}
