package lc_company;

import java.util.Arrays;
import java.util.List;

public class Pro120_zj {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len+1][len+1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[1][1] = triangle.get(0).get(0);
        for (int i = 2; i <= len; i++) {
            List<Integer> temp = triangle.get(i-1);
            int tlen = temp.size();
            for (int j = 1; j <= tlen; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + temp.get(j-1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            min = Math.min(min, dp[len][i]);
        }
        return min;
    }
}
