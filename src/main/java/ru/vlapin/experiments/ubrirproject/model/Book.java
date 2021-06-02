package ru.vlapin.experiments.ubrirproject.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import lombok.Setter;
import lombok.Value;
import lombok.With;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.NonFinal;
import ru.vlapin.experiments.ubrirproject.common.jdbc.Entity;

@With
@Value
@FieldNameConstants
@Accessors(fluent = true)
@Builder(toBuilder = true)
public class Book implements Entity<UUID> {

  @Setter
  @NonFinal
  UUID id;

  String title;
  String comment;
  LocalDate releaseDate;
  String author;
}
