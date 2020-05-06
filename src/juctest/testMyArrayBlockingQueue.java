package juctest;

public class testMyArrayBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        int size = 10;
        MyArrayBlockingQueue<Integer> queue = new MyArrayBlockingQueue<>(size);
        queue.put(10);
        System.out.printf(queue.take().toString());
    }
}
