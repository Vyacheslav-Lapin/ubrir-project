package ru.vlapin.experiments.ubrirproject.model.jsonplaceholder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@Builder(toBuilder = true)
public class Geo {

  @JsonProperty("lat")
  Double latitude;

  @JsonProperty("lng")
  Double longitude;
}
