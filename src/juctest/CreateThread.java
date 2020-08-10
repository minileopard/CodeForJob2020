package juctest;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class myThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("myThread");
        }
    }
}
class myRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++)
        {
            System.out.println("myRunnable");
        }
    }
}
class myCallable implements Callable{
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("myCallable");
        }
        return null;
    }
}
class myThreadPoolTask implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("threadpool task");
        }
    }
}
public class CreateThread {
    public static void main(String[] args) throws Exception {
        myThread mythread = new myThread();
        mythread.start();
        myRunnable myrunnable = new myRunnable();
        new Thread(myrunnable).start();
        myCallable mc = new myCallable();
        mc.call();
        myThreadPoolTask mt = new myThreadPoolTask();
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(mt);
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        es.shutdown();
    }
}
