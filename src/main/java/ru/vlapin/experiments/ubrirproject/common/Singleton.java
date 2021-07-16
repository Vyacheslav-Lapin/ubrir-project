package ru.vlapin.experiments.ubrirproject.common;

import org.jetbrains.annotations.Contract;

public class Singleton {
//public enum Singleton {
  //  INSTANCE;

  @Contract(pure = true)
  private Singleton() {
    //    throw new UnsupportedOperationException();
  }

  private static Singleton instance;

  public static Singleton getInstance() {

    if (instance == null)
      synchronized (Singleton.class) {
        if (instance == null)
          instance = new Singleton();
      }

    return instance;
  }
}
