package ru.vlapin.experiments.ubrirproject.common.jdbc;

import javax.sql.DataSource;
import lombok.experimental.Delegate;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class NamedParameterJdbcDaoSupport {
  @Delegate(types = Methods.class)
  org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport namedParameterJdbcDaoSupport =
      new org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport();

  private interface Methods {
    @NotNull NamedParameterJdbcTemplate getNamedParameterJdbcTemplate();
    @NotNull JdbcTemplate getJdbcTemplate();
  }

  @Autowired
  private void setDataSource(DataSource dataSource) {
    namedParameterJdbcDaoSupport.setDataSource(dataSource);
  }
}
