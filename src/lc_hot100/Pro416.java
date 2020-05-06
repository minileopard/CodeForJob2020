package lc_hot100;

import java.util.PriorityQueue;
import java.util.Queue;

public class Pro416 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        System.out.println(new Pro416().canPartition(nums));
    }
    public boolean canPartition(int[] nums) {
        if(nums==null || nums.length <= 1)
            return false;
        Queue<Integer> queright = new PriorityQueue<>();
        int suml = 0, sumr = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sumr += nums[i];
            queright.add(nums[i]);
        }
        if((sumr & 1) == 1)//奇数肯定不能等分
            return false;
        int half = sumr >> 1;
        return false;
    }
}
