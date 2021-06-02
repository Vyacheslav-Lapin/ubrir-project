package ru.vlapin.experiments.ubrirproject.dao.jdbc;

import java.util.Optional;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public interface CrudDao<E extends Entity<ID>, ID> {

  @NotNull Stream<E> all();
  @NotNull Optional<E> get(@NotNull ID id);
  void add(@NotNull E e);
  void merge(@NotNull E e);
  void delete(@NotNull E e);

  default void save(@NotNull E e) {
    if (e.id() == null)
      add(e);
    else
      merge(e);
  }
}
