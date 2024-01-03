package org.owasp.webgoat.container.constant;

public class Child extends Parent{

    public static String HOLA =  "1";

    @Override
    public void print() {
        int total =  ONE + 2;
        System.out.println("Hi");
        System.out.println(total);
        System.out.println("Hola");

        String name1 = "Carlos";

        System.out.println("Hola" + name1);

        String bye = "Adios";

        System.out.println("Hola" + bye);
    }

    public static class InsideClass {
        private static int HOLA = 2;

        public void print() {
            int total =  ONE + 2;
            System.out.println("Hi");
            System.out.println(total);
            System.out.println("Hola");

            String name1 = "Carlos";

            System.out.println("Hola" + name1);

            String bye = "Adios";

            System.out.println("Hola" + bye);
        }
    }
}
