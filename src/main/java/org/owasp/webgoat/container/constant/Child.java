package org.owasp.webgoat.container.constant;

public class Child extends Parent{

    public static String HOLA =  "1";
    public static String HI = "HI";

    @Override
    public void print() {
        System.out.println("Hi");
        System.out.println(HI);
        System.out.println("Hola");

        String name1 = "Carlos";

        System.out.println("Hola" + name1);

        String bye = "Adios";

        System.out.println("Hola" + HOLA);
    }

    public static class InsideClass {
        private static int HOLA = 2;

        public void print() {
            System.out.println("Hi");
            System.out.println(HI + HOLA);
            System.out.println("Hola");

            String name1 = "Carlos";

            System.out.println("Hola" + name1);

            String bye = "Adios";

            System.out.println("Hola" + HOLA);
        }
    }
}
