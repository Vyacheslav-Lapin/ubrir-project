package ru.vlapin.experiments.ubrirproject.config;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

public interface Dater {

  Dater setX(String x);

  @Autowired
  default void setDate(Date date) {
    setX(date.toString());
  }
}
