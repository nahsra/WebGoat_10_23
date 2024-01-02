package org.owasp.webgoat.container.constant;

public class Parent implements MyInterface{

    public static final String HI = "Hi";
    @Override
    public void print() {
        System.out.println("Hi");
        System.out.println(HI);
        System.out.println("Hola");

        String name1 = "Carlos";

        System.out.println("Hola" + name1);

        String bye = "Adios";

        System.out.println("Hola" + bye);
    }
}
