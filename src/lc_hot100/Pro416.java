package lc_hot100;

import java.util.PriorityQueue;
import java.util.Queue;

public class Pro416 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(new Pro416().canPartition(nums));
    }
    public boolean canPartition(int[] nums) {
        if(nums==null || nums.length <= 1)
            return false;
        int suml = 0, sumr = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sumr += nums[i];
        }
        if((sumr & 1) == 1)//奇数肯定不能等分
            return false;
        int half = sumr >> 1;
        boolean[] bp = new boolean[half];
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > half)
                return false;
            for (int j = half - nums[i] - 1; j >= 0; j--) {
                if(bp[j] && !bp[j + nums[i]])
                {
                    bp[j + nums[i]] = true;
                    if(j + nums[i] == half - 1)
                        return true;
                }
            }
            bp[nums[i] - 1] = true;
        }
        return bp[half - 1];
    }
}
