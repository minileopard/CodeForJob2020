package juctest;
import java.util.concurrent.*;

public class MyThreadExecutor {
    private volatile boolean running = true;//运行标志
    private static BlockingQueue<Runnable> tasklist;//任务队列
    private ConcurrentLinkedQueue<Worker> worker;//工作者队列
    private ConcurrentLinkedQueue<Thread> threadQue;//工作线程队列
    int threadpool = 0;//准许的线程池大小
    int corethread = 0;//工作的线程数

    public MyThreadExecutor(int num)
    {
        threadpool = num;
        tasklist = new LinkedBlockingQueue<Runnable>();
        worker = new ConcurrentLinkedQueue<Worker>();
        threadQue = new ConcurrentLinkedQueue<Thread>();
    }

    public void submit(Runnable task) throws InterruptedException
    {
        if(corethread >= threadpool)//线程池达到设定大小就提交任务到等待队列
        {
            tasklist.put(task);
        }else//线程池未达到设定大小直接分配线程运行
        {
            addThread(task);
        }
    }

    public void shutdown()
    {
        //关闭逻辑,应该是要等到任务完成之后关闭线程池
        while(!tasklist.isEmpty());//等待任务全部被取走完成
//		System.out.println(tasklist.size());
        running = false;
    }

    public void addThread(Runnable task) throws InterruptedException
    {
        Worker wk = new Worker(task);
        worker.add(wk);
        Thread t = new Thread(wk);
        threadQue.add(t);
        t.start();
        corethread++;
    }


    public static void main(String[] args) throws InterruptedException{
        // TODO Auto-generated method stub
        MyThreadExecutor te = new MyThreadExecutor(5);
        for(int i = 0; i < 10; i++)
        {
            te.submit(new Runnable(){
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    System.out.println(Thread.currentThread().getId() + "线程正在工作！！");
                }
            });
        }
        te.shutdown();
    }
    private class Worker implements Runnable{

        public Worker(Runnable task) throws InterruptedException
        {
            tasklist.put(task);
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
            while(running)
            {
                try {
                    Runnable task = tasklist.take();//取，如果阻塞可以等待
                    task.run();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            //如果running为false那么打断线程，配合shutdown工作
            Thread.currentThread().interrupt();
        }
    }
}
