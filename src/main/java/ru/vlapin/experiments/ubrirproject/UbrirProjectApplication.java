package ru.vlapin.experiments.ubrirproject;

import java.util.Date;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.event.EventListener;
import ru.vlapin.experiments.ubrirproject.common.CustomEvent;

@SpringBootApplication
@ConfigurationPropertiesScan
@ComponentScan(includeFilters = @Filter(Aspect.class))
public class UbrirProjectApplication {

  public static void main(String[] args) {
    SpringApplication.run(UbrirProjectApplication.class, args);
  }

  @EventListener
  public void customEventListener(CustomEvent c) {
    System.out.println("!!!Произошло кастомное событие!!! - " + c.getSource());
  }

  @Bean
  Date date() {
    return new Date();
  }
}
