package companyexercise;

import java.util.Arrays;
import java.util.Scanner;

public class pdd_190728_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] lw = new int[N][2];
        for (int i = 0; i < N; i++) {
            lw[i][0] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            lw[i][1] = sc.nextInt();
        }
        Arrays.sort(lw, (o1, o2) -> {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
        });
        int[][] dp = new int[N][N];
        int res = 0;
        for (int i = 0; i < N; i++) {
            dp[i][0] = lw[i][1];
            for (int j = 1; j <= i ; j++) {
                int min = Integer.MAX_VALUE, mindex = Integer.MAX_VALUE;
                for (int k = 0; k < i; k++) {
                    if(dp[k][j-1] > 0 && min > dp[k][j-1])
                    {
                        min = dp[k][j-1];
                        mindex = k;
                    }
                }
                if(min != Integer.MAX_VALUE && dp[i][0]*7 >= min && lw[i][0] > lw[mindex][0])
                {
                    dp[i][j] = min + dp[i][0];
                    res = Math.max(res, j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(res+1);
    }
}
