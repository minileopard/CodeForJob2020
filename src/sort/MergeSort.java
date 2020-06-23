package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {1,5,3,6,4,8,7,2,9};
        MergeSort ms = new MergeSort();
        ms.sort(array);
        System.out.println(Arrays.toString(array));
    }
    public void sort(int[] nums)
    {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length-1, temp);
    }
    public void sort(int[] nums, int left, int right, int[] temp)
    {
        if(left < right)
        {
            int mid = (left + right) / 2;
            sort(nums, left, mid, temp);
            sort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }
    public void merge(int[] nums, int left, int mid, int right, int[] temp)
    {
        int l = left, r = mid + 1, i = left;
        while(l <= mid && r <= right)
        {
            if(nums[l] <= nums[r])
            {
                temp[i++] = nums[l++];
            }else
            {
                temp[i++] = nums[r++];
            }
        }
        while(l <= mid)
        {
            temp[i++] = nums[l++];
        }
        while(l <= mid && r <= right)
        {
            temp[i++] = nums[r++];
        }
        while(--i>=left)
        {
            nums[i] = temp[i];
        }
    }
}
