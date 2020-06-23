package lc_company;

import java.util.Arrays;

public class Pro16_tx {
    public static void main(String[] args) {
        int[] nums = {-3, 2, 1, 0};
        int target = 1;
        Pro16_tx p = new Pro16_tx();
        System.out.println(p.threeSumClosest(nums, target));
    }
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length - 1; i++)
        {
            int left = 0, right = nums.length - 1;
            while(left < i && right > i)
            {
                int sum = nums[left] + nums[i] + nums[right];
                int cz = sum - target;
                if(Math.abs(cz) < Math.abs(closest))
                    closest = cz;
                if(sum == target)
                    return target;
                else if(sum < target)
                    left++;
                else
                    right--;
            }
        }
        return target + closest;
    }
}
