package ru.vlapin.experiments.ubrirproject.model.jsonplaceholder;

import static lombok.AccessLevel.PRIVATE;

import lombok.Data;
import lombok.Setter;

@Data
@Setter(PRIVATE)
public class Todo {

  Long userId;
  Long id;
  String title;
  Boolean completed;
}
