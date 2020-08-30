package companytest;

import java.util.Scanner;

public class tx823_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int N = sc.nextInt();
        int[][] nums = new int[N][2];
        for (int i = 0; i < N; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        int len = input.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i; j < len; j++) {
                if(input.charAt(i) == input.charAt(j))
                {
                    dp[i][j] = (j - i < 3) || dp[i+1][j-1];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(getcount(dp,nums[i][0]-1,nums[i][1]-1));
        }
    }
    public static int getcount(boolean[][] dp, int start, int end)
    {
        int[] mincount = new int[end - start + 2];
        for (int i = start; i <= end; i++) {
            mincount[i-start+1] = mincount[i-start]+1;
            for (int j = start; j <= i; j++) {
                if(dp[j][i])
                {
                    mincount[i-start+1] = Math.min(mincount[i-start+1],mincount[j-start]+1);
                }
            }
        }
        return mincount[end-start+1];
    }
}
