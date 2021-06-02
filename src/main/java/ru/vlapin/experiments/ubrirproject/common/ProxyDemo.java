package ru.vlapin.experiments.ubrirproject.common;

@FunctionalInterface
interface FuncInt1 {
  String m1(String s);
}

public class ProxyDemo {
  public static void main(String[] args) {
//    val instance = (FuncInt1) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(),
//        new Class[]{FuncInt1.class},
//        (proxy, method, args1) -> "" + (proxy == instance));
//
  }
}
