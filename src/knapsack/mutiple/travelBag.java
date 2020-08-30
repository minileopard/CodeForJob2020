package knapsack.mutiple;

import java.util.Scanner;

//https://blog.csdn.net/wenhuayuzhihui/article/details/16354807
//旅游背包(多维有界的背包问题)
public class travelBag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int W = sc.nextInt();
        int[][] nums = new int[N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        //dp[i][j][k] 前i种物品，体积不超过j,重量不超过k的最大价值,然后简化了i只留下jk就行
        int[][] dp = new int[V+1][W+1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= nums[i][0]; j--) {
                for (int k = W; k >= nums[i][1]; k--) {
                    int max = dp[j][k];//不选第i个物品
                    int count = Math.min(j/nums[i][0],k/nums[i][1]);
                    count = Math.min(count, nums[i][2]);
                    for (int l = 1; l <= count; l++) {
                        //选择l个第i个物品
                        max = Math.max(max, dp[j-l*nums[i][0]][k-l*nums[i][1]] + l*nums[i][3]);
                    }
                    dp[j][k] = max;
                }
            }
        }
        System.out.println(dp[V][W]);
    }

}
/*
5 500 100
30 3 10 4
50 8 10 5
10 2 10 2
23 5 8 3
130 20 5 11
输出：72
 */
