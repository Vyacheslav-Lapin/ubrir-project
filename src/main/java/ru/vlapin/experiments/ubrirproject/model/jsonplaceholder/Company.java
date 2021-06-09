package ru.vlapin.experiments.ubrirproject.model.jsonplaceholder;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@Builder(toBuilder = true)
public class Company {

  String name;
  String catchPhrase;
  String bs;
}
