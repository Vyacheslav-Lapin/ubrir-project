package ru.vlapin.experiments.ubrirproject.common;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

  /**
   * Create a new {@code ApplicationEvent}.
   *
   * @param source the object on which the event initially occurred or with
   *               which the event is associated (never {@code null})
   */
  public CustomEvent(Object source) {
    super(source);
  }
}
