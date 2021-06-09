package ru.vlapin.experiments.ubrirproject.model.jsonplaceholder;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@Builder(toBuilder = true)
public class Comment {

  Long postId;
  Long id;
  String name;
  String email;
  String body;
}
