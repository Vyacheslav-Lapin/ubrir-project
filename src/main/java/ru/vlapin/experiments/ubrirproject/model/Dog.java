package ru.vlapin.experiments.ubrirproject.model;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Dog {

  @Include
  protected final int x;
  protected final int y;
  protected final int z;
}

@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
class Pudel extends Dog {
  int a;

  @Include
  int b;
  int c;

  public Pudel(int x,int y,int z, int a, int b, int c) {
    super(x, y, z);
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public static void main(String[] args) {
    System.out.println(new Pudel(1, 2, 3, 4, 5, 6)
        .equals(new Pudel(11, 22, 33, 44, 5, 66)));
  }
}
