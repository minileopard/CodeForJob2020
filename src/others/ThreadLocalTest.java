package others;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public  class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<Integer> tl = new ThreadLocal<>();
        tl.set(new Integer(1));
        tl.remove();
        BlockingQueue<Integer> que = new ArrayBlockingQueue<Integer>(5);

    }
}
