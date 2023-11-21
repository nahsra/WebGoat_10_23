package org.owasp.webgoat.vulnerable_components;

public class MyRunnable implements Runnable {
    public void run() {
        int a = 1;
        MyOtherType.LOG.info("a={}",1);
    }
}
