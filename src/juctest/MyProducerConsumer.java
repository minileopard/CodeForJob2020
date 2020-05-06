package juctest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Consumer implements Runnable{
    MyArrayBlockingQueue<Integer> que;
    public Consumer(MyArrayBlockingQueue<Integer> que) {
        this.que = que;
    }
    @Override
    public void run() {
        System.out.printf("开始消费");
        try {
            while(true) {
                System.out.println(que.take().toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Producer implements Runnable{
    MyArrayBlockingQueue<Integer> que;
    int count = 0;
    public Producer (MyArrayBlockingQueue<Integer> que) {
        this.que = que;
    }

    @Override
    public void run() {
        System.out.println("开始生产");
        try {
            while (true)
            {
                Thread.sleep(500);
                que.put(count++);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class MyProducerConsumer {
    public static void main(String[] args) {
        MyArrayBlockingQueue<Integer> que = new MyArrayBlockingQueue<>(10);
        Producer producer1 = new Producer(que);
        Producer producer2 = new Producer(que);
        Producer producer3 = new Producer(que);
        Consumer consumer1 = new Consumer(que);
        Consumer consumer2 = new Consumer(que);
        Consumer consumer3 = new Consumer(que);
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(producer1);
        es.execute(producer2);
        es.execute(producer3);
        es.execute(consumer1);
        es.execute(consumer2);
        es.execute(consumer3);
        es.shutdown();
    }
}
