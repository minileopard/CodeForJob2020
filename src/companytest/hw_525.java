package companytest;

import java.util.Arrays;

public class hw_525 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,8,8,10};
        int target = 8;
        hw_525 h = new hw_525();
        System.out.println(Arrays.toString(h.searchRange(nums,target)));
    }
    public int[] searchRange(int[] nums, int target)
    {
        int[] res = {-1, -1};
        if(nums == null || target < nums[0] || target > nums[nums.length-1])
        {
            return res;
        }
        int index = search(nums, target);
        if(index == -1)
            return res;
        int left = index, right = index;
        while(left >= 0 && nums[left] == target)
        {
            left--;
        }
        while(right < nums.length && nums[right] == target)
        {
            right++;
        }
        res[0] = left + 1;
        res[1] = right - 1;
        return res;
    }
    public int search(int[] nums, int target)
    {
        int left = 0, right = nums.length - 1;
        while(left <= right)
        {
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
            {
                right = mid - 1;
            }else
            {
                left = mid + 1;
            }
        }
        return -1;
    }
}
