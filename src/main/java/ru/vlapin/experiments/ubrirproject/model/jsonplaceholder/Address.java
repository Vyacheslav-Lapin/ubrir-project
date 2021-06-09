package ru.vlapin.experiments.ubrirproject.model.jsonplaceholder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@Builder(toBuilder = true)
public class Address {

  String street;
  String suite;
  String city;

  @JsonProperty("zipcode")
  String zipCode;

  Geo geo;
}
