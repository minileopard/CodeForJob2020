package companytest;

import java.util.Scanner;
//类似01背包问题
public class qax_801_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int N = sc.nextInt();
        if(target <= 0 || N <= 0)
        {
            System.out.println(0);
            return;
        }
        int[] price = new int[N];
        int[] weight = new int[N];
        for (int i = 0; i < N; i++) {
            price[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }
        int[] dp = new int[target+1];
        for (int i = 1; i <= target; i++) {
            int max = 0;
            for (int j = 0; j < N; j++) {
                max = Math.max(max, (i-price[j])<0?0:(dp[(i-price[j])] + weight[j]));
            }
            dp[i] = max;
        }
        System.out.println(dp[target]);
    }
}
/*
77
5
77 92
22 22
29 36
50 46
99 90
 */
