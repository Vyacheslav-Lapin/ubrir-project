package ru.vlapin.experiments.ubrirproject.model.jsonplaceholder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@Builder(toBuilder = true)
public class User {

  Long id;
  String name;

  @JsonProperty("username")
  String userName;

  String email;
  Address address;
  String phone;

  @JsonProperty("website")
  String webSite;
  Company company;
}
