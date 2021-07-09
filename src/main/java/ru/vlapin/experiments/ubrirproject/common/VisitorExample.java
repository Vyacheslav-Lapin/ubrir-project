package ru.vlapin.experiments.ubrirproject.common;

import lombok.SneakyThrows;

class Rename implements Visitor {

  @Override
  public int visit(A a) {
    return 1;
  }

  @Override
  public int visit(B a) {
    return 2;
  }

  @Override
  public int visit(C c) {
    return 3;
  }

  @Override
  public int visit(D a) {
    return 4;
  }
}

public class VisitorExample {

  public static void main(String... __) {
    new VisitorExample().method(new A());
    new VisitorExample().method(new B());
//    new VisitorExample().method(new C());
    new VisitorExample().method(new D());
    new VisitorExample().method(null);

    System.out.println("new A().visit(new Rename()) = " + new A().visit(new Rename()));
    System.out.println("new C().visit(new Rename()) = " + new C().visit(new Rename()));
  }


  @SneakyThrows
  public final void method(A a ) {
    System.out.println("\"A\" = " + "A");
  }

  @SneakyThrows
  public final void method(B b) {
    System.out.println("\"B\" = " + "B");
  }

//  @SneakyThrows
//  public final void method(@NotNull C c) {
//    System.out.println("\"C\" = " + "C");
//  }
//
  @SneakyThrows
  public final void method(D d) {
    System.out.println("\"D\" = " + "D");
  }


}

interface Visitor {
  int visit(A a);
  int visit(B a);
  int visit(C c);
  int visit(D a);
}

class A {

  int visit(Visitor visitor) {
    return visitor.visit(this);
  }
}

class B extends A {

  int visit(Visitor visitor) {
    return visitor.visit(this);
  }
}

class C extends A {

  int visit(Visitor visitor) {
    return visitor.visit(this);
  }

}

class D extends B {

  int visit(Visitor visitor) {
    return visitor.visit(this);
  }

}
