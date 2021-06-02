package ru.vlapin.experiments.ubrirproject.common.jdbc;

public interface Entity<ID> {
  ID id();
  Entity<ID> id(ID id);
}
