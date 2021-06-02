package ru.vlapin.experiments.ubrirproject.config;

import static lombok.AccessLevel.PRIVATE;
import static ru.vlapin.experiments.ubrirproject.aop.Loggable.LogLevel.WARN;

import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import lombok.Setter;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.vlapin.experiments.ubrirproject.aop.Loggable;
import ru.vlapin.experiments.ubrirproject.dao.CatRepository;
import ru.vlapin.experiments.ubrirproject.model.Cat;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Loggable(WARN)
//@RequiredArgsConstructor
public class DataJpaIniter implements ApplicationRunner, Dater {

  @NonFinal
  @Setter(value = PRIVATE, onMethod_ = @Autowired)
  CatRepository catRepository;

  @NonFinal
  @Setter
  String x;

  @PostConstruct
  private void init() {
    System.out.println("x = " + x);
  }

  @EventListener
  public void afterContextInitialization(ContextRefreshedEvent __) {
    System.out.println("!");
  }

  @Override
  public void run(ApplicationArguments __) {
    Stream.of("Мурзик, Барсик, Матроскин, Васька".split(", "))
        .map(Cat::new)
        .forEach(catRepository::save);
  }
}
