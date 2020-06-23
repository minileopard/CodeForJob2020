package juctest;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCAS {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        int j = i.get() + 1;
        i.compareAndSet(i.get(),j);
    }
}
