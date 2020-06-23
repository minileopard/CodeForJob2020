package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MyPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> (o1 - o2)));
        int[] nums = {1,5,3,6,4,8,7,2,2,2,3,5};
        for (int i:nums) {
            queue.add(i);
        }
        while(!queue.isEmpty())
        {
            System.out.print(queue.poll()+" ");
        }
    }
}
