package ru.vlapin.experiments.ubrirproject.model;

import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Customer {

  @Id
  Long id;
  String firstName;
  LocalDate dob;
}
