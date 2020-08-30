package companytest;

import java.util.Scanner;

public class dj810_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int[][] nums = new int[N][3];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = sc.nextInt();
            }
            min = Math.min(min, nums[i][0]);
        }
        if(min > T)
        {
            System.out.println(0);
            return;
        }
        /*
动态规划：状态定义dp[i][j]前i个物品，预算不超过j的最大满意度
转移方程：dp[i][j] = Max(dp[i-1][j], dp[i-1][j-k*nums[i][0]]+k*nums[i][1])
                                        1 <= k <= Min(j/nums[i][0], nums[i][2])
简化空间：状态i只和状态i-1有关，故可定义为一维数组然后逆向打表。
         */
        int[] dp = new int[T+1];
        for (int i = 0; i < N; i++) {
            for (int j = T; j >= nums[i][1]; j--) {
                int max = dp[j];
                int count = Math.min(j/nums[i][0],nums[i][2]);
                for (int k = 1; k <= count; k++) {
                    max = Math.max(max, dp[j-k*nums[i][0]]+k*nums[i][1]);
                }
                dp[j] = max;
            }
        }
        System.out.println(dp[T]);
    }
}
/*
给N种商品和预算T、每种商品的价格满意度和数量给出，该预算下的最大满意度
6 10
2 2 4
2 1 8
3 4 2
3 1 1
4 2 1
1 1 1
 */