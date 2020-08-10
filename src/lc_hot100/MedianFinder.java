package lc_hot100;

import sort.MergeSort;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> maxheap, minheap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>((o1,o2)->(o2-o1));
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(-1);
        System.out.println(m.findMedian());
        m.addNum(-2);
        System.out.println(m.findMedian());
        m.addNum(-3);
        System.out.println(m.findMedian());
        m.addNum(-4);
        System.out.println(m.findMedian());
        m.addNum(-5);
        System.out.println(m.findMedian());
//        m.addNum(6);
//        m.addNum(7);
//        System.out.println(m.findMedian());
//        m.addNum(8);
//        System.out.println(m.findMedian());
    }
    public void addNum(int num) {
        if(maxheap.size() == 0)
        {
            maxheap.add(num);
        }
        else if(num > maxheap.peek())//只能放右边
        {
            minheap.add(num);
            int min = minheap.poll();
            if(minheap.size() >= maxheap.size())
            {
                maxheap.add(min);
            }else
            {
                minheap.add(min);
            }
        }else//只能放左边
        {
            maxheap.add(num);
            int max = maxheap.poll();
            if(maxheap.size() > minheap.size())
            {
                minheap.add(max);
            }else
            {
                maxheap.add(max);
            }
        }
    }

    public double findMedian() {
        int len = maxheap.size() + minheap.size();
        if(len == 0)
            return 0.0;
        if(len % 2 == 1)
        {
            return maxheap.peek();
        }else
        {
            return (maxheap.peek()+minheap.peek())/2.0;
        }
    }
}
