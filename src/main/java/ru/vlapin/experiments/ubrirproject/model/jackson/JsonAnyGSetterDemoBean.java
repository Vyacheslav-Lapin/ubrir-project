package ru.vlapin.experiments.ubrirproject.model.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@Builder(toBuilder = true)
@SuppressWarnings("ClassCanBeRecord")
public class JsonAnyGSetterDemoBean {

  String name;

  @Singular
  @JsonAnySetter
  @Getter(onMethod_ = @JsonAnyGetter)
  Map<String, Object> properties;
}
