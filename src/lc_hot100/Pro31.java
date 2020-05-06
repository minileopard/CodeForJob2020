package lc_hot100;

import java.util.Arrays;
import java.util.Collections;

public class Pro31 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,7,6,5,1};//,7,6,5,1
        nextPermutation(nums);
    }
    public static void nextPermutation(int[] nums)
    {
        if(nums == null)
            return;
        int len = nums.length;
        if(len <= 1)
            return;
        //从右往左，找到一个递减的点，调换（换右边大于该点的最小的1237651）
        int index = len - 2;
        while(index >= 0 && nums[index] >= nums[index + 1]) {index--;}
        if(index >= 0)
        {
            int i = len - 1;
            while(i >= 0 && nums[i--] <= nums[index]);
            swap(nums, index, i + 1);
        }
        //将调换后面的递减的都变成递增的
        reverse(nums, index + 1);

        for(int i : nums)
        {
            System.out.print(i + " ");
        }
    }
    public static void reverse(int[] nums, int start)
    {
        int l = start, r = nums.length - 1;
        while(l < r)
        {
            swap(nums, l++, r--);
        }
    }

    public static void swap(int[] nums, int s, int e)
    {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
}
