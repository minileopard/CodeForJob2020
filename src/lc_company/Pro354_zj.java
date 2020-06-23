package lc_company;

import java.util.Arrays;

public class Pro354_zj {
    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        Pro354_zj p = new Pro354_zj();
        System.out.println(p.maxEnvelopes(envelopes));
    }
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;
        int max = 0, len = envelopes.length;
        Arrays.sort(envelopes, (o1, o2) -> (o1[0] - o2[0]));
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(envelopes[j][0] < envelopes[i][0]
                        && envelopes[j][1] < envelopes[i][1])
                {
                    count = Math.max(count, dp[j]);
                }
            }
            dp[i] = count + 1;
        }
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
