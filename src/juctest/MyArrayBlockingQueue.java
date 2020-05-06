package juctest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyArrayBlockingQueue<E> {
    private final Object[] items;
    private final int size;
    private int count = 0;
    private int putindex = 0;
    private int getindex = 0;
    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    public MyArrayBlockingQueue(int size) {
        this.size = size;
        items = new Object[size];
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }
    public int inc(int index)
    {
        return (index+1) % this.size;
    }
    public E extract()
    {
        Object res = items[getindex];
        items[getindex] = null;
        getindex = inc(getindex);
        count--;
        notFull.signal();
        return (E)res;
    }
    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            return extract();
        }finally {
            lock.unlock();
        }
    }
    public void insert(E e)
    {
        items[putindex] = e;
        putindex = inc(putindex);
        count++;
        notEmpty.signal();
    }
    public void put(E e) throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == size) {
                notFull.await();
            }
            insert(e);
        }finally {
            lock.unlock();
        }
    }
}
