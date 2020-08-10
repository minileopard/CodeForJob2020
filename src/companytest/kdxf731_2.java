package companytest;

import java.util.Scanner;
//快速排序中间序列输出
public class kdxf731_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        quickSort(nums, 0, N-1);
    }
    static void quickSort(int[] nums, int start, int end)
    {

        int mid = partition(nums, start, end);
        if(mid > start)
            quickSort(nums, start, mid - 1);
        if(mid < end)
            quickSort(nums, mid + 1, end);

    }
    static void printNums(int[] nums)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
    static int partition(int[] nums, int start, int end)
    {
        if(start == end)
            return start;
        int left = start + 1;
        while(end >= left && nums[end] >= nums[start])
            end--;
        while(left < end)
        {
            if(nums[left] > nums[start])
            {
                swap(nums, left, end);
                while(end >= left && nums[end] >= nums[start])
                    end--;
            }
            left++;
        }
        swap(nums, start, end);
        printNums(nums);
        return end;
    }
    static void swap(int[] nums, int f, int t)
    {
        int temp = nums[f];
        nums[f] = nums[t];
        nums[t] = temp;
    }
}
/*
15 20 21 25 47 27 68 35 84
15 20 21 25 47 27 68 35 84
15 20 21 25 47 27 68 35 84
15 20 21 25 35 27 47 68 84
15 20 21 25 27 35 47 68 84
15 20 21 25 27 35 47 68 84
 */
/*
15 20 21 25 47 27 68 35 84
15 20 21 25 47 27 68 35 84
15 20 21 25 47 27 68 35 84
15 20 21 25 27 35 47 68 84
15 20 21 25 27 35 47 68 84
15 20 21 25 27 35 47 68 84
15 20 21 25 27 35 47 68 84
15 20 21 25 27 35 47 68 84
15 20 21 25 27 35 47 68 84
 */