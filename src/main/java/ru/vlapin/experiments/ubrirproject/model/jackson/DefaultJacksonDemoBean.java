package ru.vlapin.experiments.ubrirproject.model.jackson;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@Builder(toBuilder = true)
@SuppressWarnings("ClassCanBeRecord")
public class DefaultJacksonDemoBean {

  int x;
  String s;
  boolean z;
}
