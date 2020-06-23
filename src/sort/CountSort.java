package sort;

import java.util.Arrays;

//计数排序  参考：https://www.runoob.com/w3cnote/counting-sort.html
//思路hash表存每种元素出现的个数
public class CountSort {
    public static void main(String[] args) {
        CountSort c = new CountSort();
        System.out.println(4 >> 1 + 1 % 2);
        int[] array = {1,5,3,6,4,8,7,2,9,2,10,-1,5,7,12,3,3,2,2};
        c.sort(array);
        System.out.println(Arrays.toString(array));
    }
    public void sort(int[] nums)
    {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i:nums)
        {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int len = max - min + 1;
        int[] temp = new int[len];
        for(int i:nums)
        {
            temp[i-min]++;
        }
        for(int i = 0, j = 0; i < len && j < nums.length; i++)
        {
            while(temp[i]>0)
            {
                nums[j++] = i + min;
                temp[i]--;
            }
        }
    }
}
