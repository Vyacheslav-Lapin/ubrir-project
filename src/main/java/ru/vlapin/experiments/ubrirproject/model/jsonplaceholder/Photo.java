package ru.vlapin.experiments.ubrirproject.model.jsonplaceholder;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@Builder(toBuilder = true)
public class Photo {

  Long albumId;
  Long id;
  String title;
  String url;
  String thumbnailUrl;
}
