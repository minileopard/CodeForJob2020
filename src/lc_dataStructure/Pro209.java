package lc_dataStructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pro209 {
    public static void main(String[] args) {
//        int s = 7;
//        int[] nums = {2,3,1,2,4,3,7};
//        int res = new Pro209().minSubArrayLen2(s, nums);
//        System.out.println(res);
    }
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < n) {
            sum += nums[right];
            right++;
            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)
            return 0;
        int left = 0, right = 0, min = Integer.MAX_VALUE,sum = 0;
        while(right < nums.length || left < nums.length)
        {
            while(sum < s && right < nums.length)
            {
                sum += nums[right];
                right++;
            }
            if(left == 0 && right == nums.length && sum < s)
                return 0;
            while(sum - nums[left] >= s && left <= right)
            {
                sum -= nums[left];
                left++;
            }
            min = Math.min(min, right - left);
            if(right == nums.length)
                break;
            sum -= nums[left++];
            sum += nums[right++];
        }
        return min;
    }
}
