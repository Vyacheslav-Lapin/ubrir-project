package ru.vlapin.experiments.ubrirproject.dao.jdbc;

public interface Entity<ID> {
  ID id();
  void id(ID id);
}
