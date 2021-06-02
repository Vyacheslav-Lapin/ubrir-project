package ru.vlapin.experiments.ubrirproject.service;

import static lombok.AccessLevel.PRIVATE;

import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import ru.vlapin.experiments.ubrirproject.dao.CatRepository;

/**
 * Limitations:
 * - no defaults (!!!)
 */
@Getter
@ToString
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties("mail.credentials")
public final class AnnotationBasedImmutablePropertiesPlaceholderExample {

  /**
   * Auth method
   */
  String authMethod;

  /**
   * login
   */
  String username;

  /**
   * pwd
   */
  String password;

  @NonFinal
  @Setter(value = PRIVATE, onMethod_ = @Autowired)
  CatRepository catRepository;

  @PostConstruct
  private void init() {
    System.out.println("toString() = " + toString());
  }
}
