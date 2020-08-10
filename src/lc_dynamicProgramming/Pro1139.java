package lc_dynamicProgramming;

import java.util.Arrays;

public class Pro1139 {
    public static void main(String[] args) {
        String s = "[[0,1,1,1,1,0],[1,1,0,1,1,0],[1,1,0,1,0,1],[1,1,0,1,1,1],[1,1,0,1,1,1],[1,1,1,1,1,1],[1,0,1,1,1,1],[0,0,1,1,1,1],[1,1,1,1,1,1]]";
        String[] rowlist = s.split("\\[*\\]");
        int rows = rowlist.length;
        String[] col = rowlist[0].split(",");
        int cols = col.length;
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] temp = rowlist[i].split(",");
            int jj = 0;
            for (int j = 0; j < temp.length; j++) {
                int len = temp[j].length();
                if(len == 0)
                    continue;
                int t = temp[j].charAt(len-1) - '0';
                grid[i][jj++] = t;
            }
        }

        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }

        int i = new Pro1139().largest1BorderedSquare(grid);
        System.out.println(i);
    }
    public int largest1BorderedSquare(int[][] grid) {
        int rows = grid.length;
        if(rows == 0)
            return 0;
        int cols = grid[0].length;
        if(cols == 0)
            return 0;
        int[][][] dp = new int[rows + 1][cols + 1][2];
        int maxLen = 0;
        for(int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (grid[i - 1][j - 1] == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                } else {
                    dp[i][j][0] = dp[i - 1][j][0] + 1;
                    dp[i][j][1] = dp[i][j - 1][1] + 1;
                    int len = Math.min(dp[i][j][0], dp[i][j][1]);
                    for(int k = 1; k <= len; k++)
                    {
                        if(dp[i-k+1][j][1] >= k && dp[i][j-k+1][0] >= k) {
                            maxLen = Math.max(maxLen, k);
                        }else
                        {
                            break;
                        }
                    }

                }
                System.out.print(dp[i][j][0]+" "+dp[i][j][1] + ";");
            }
            System.out.println();
        }
        return maxLen * maxLen;
    }
}
