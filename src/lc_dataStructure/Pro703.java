package lc_dataStructure;

import java.util.PriorityQueue;

public class Pro703 {
    PriorityQueue<Integer> que;

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4,5,8,2};
        Pro703 p = new Pro703(k, nums);
        System.out.println(p.add(3));
        System.out.println(p.add(5));
        System.out.println(p.add(10));
        System.out.println(p.add(9));
        System.out.println(p.add(4));
    }
    public Pro703(int k, int[] nums) {
        que = new PriorityQueue<Integer>((o1, o2) -> (o2-o1));
        for(int i = 0; i < k && i < nums.length; i++)
        {
            que.add(nums[i]);
        }
        for(int i = k; i < nums.length; i++)
        {
            add(nums[i]);
        }
    }
    public int add(int val) {
        int top = que.poll();
        if(val >= top)
        {
            que.add(top);
        }else
        {
            que.add(val);
        }
        return que.peek();
    }
}
