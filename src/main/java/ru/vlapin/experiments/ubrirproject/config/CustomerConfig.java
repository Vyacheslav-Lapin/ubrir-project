package ru.vlapin.experiments.ubrirproject.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJdbcRepositories // (1)
public class CustomerConfig { // (2)

  @Bean
  NamedParameterJdbcOperations operations(DataSource dataSource) { // (3)
    return new NamedParameterJdbcTemplate(dataSource);
  }

  @Bean
  PlatformTransactionManager transactionManager(DataSource dataSource) { // (4)
    return new DataSourceTransactionManager(dataSource);
  }

  //
  @Bean
  DataSource dataSource() { // (5)
    return new EmbeddedDatabaseBuilder()
        .generateUniqueName(true)
        .setType(EmbeddedDatabaseType.H2)
        .addScript("schema.sql")
        .build();
  }
}

