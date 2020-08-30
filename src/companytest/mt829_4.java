package companytest;

import java.util.Scanner;

public class mt829_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = i; j <= M ; j++) {
                if(fun(nums, i, j))
                {
                    count += M - j + 1;
                    break;
                }
            }
        }
        System.out.println(count);
    }
    public static boolean fun(int[] nums, int l, int r)
    {
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] >= l && nums[i] <= r)
            {
                continue;
            }
            if(nums[i] < max)
            {
                return false;
            }
            max = nums[i];
        }
        return true;
    }
}
/*
5 5
4 1 4 1 2
 */