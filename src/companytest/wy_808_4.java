package companytest;

import java.util.Arrays;
import java.util.Scanner;

public class wy_808_4 {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0)
        {
//            int N = sc.nextInt();
//            int[] nums = new int[N];
//            int sum = 0;
//            for (int i = 0; i < N; i++) {
//                nums[i] = sc.nextInt();
//                sum += nums[i];
//            }
//            int bagsize = sum / 2;
//            int[] dp = new int[bagsize+1];
//            for (int i = 0; i < N; i++) {
//                for (int j = bagsize; j >= nums[i]; j--) {
//                    dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
//                }
//            }
//            System.out.println(Arrays.toString(dp));
//            System.out.println(dp[bagsize]);
            int n = sc.nextInt();
            int[] arr = new int[n];
            int total = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                total += arr[j];
            }
            min = Integer.MAX_VALUE;
            fun(arr, total);
        }
    }

    public static void fun(int[] arr, int total){
        dfs(arr, 0, 0, 0, total);
        System.out.println(min);
    }

    public static void dfs(int[] arr, int index, int sum_1, int sum_2, int total){
        if(index == arr.length && sum_1 == sum_2){
            min = Math.min(min, total - sum_1 * 2);
        }
        if(index >= arr.length)
            return;
        dfs(arr, index + 1, sum_1, sum_2, total);
        dfs(arr, index + 1, sum_1 + arr[index], sum_2, total);
        dfs(arr, index + 1, sum_1, sum_2 + arr[index], total);
    }
}
/*
1
5
30 60 5 15 30
 */