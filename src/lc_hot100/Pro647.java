package lc_hot100;

public class Pro647 {
    public static void main(String[] args) {
        String s = "aaa";
        int res = new Pro647().countSubstrings(s);
        System.out.println(res);
    }
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        for(int i = 0; i < len; i++)
        {
            int col = i, row = 0;
            for(int j = i; j < len; j++)
            {
                if(col == row)
                    dp[row][col] = true;
                else if(col == row + 1 && s.charAt(col) == s.charAt(row))
                {
                    dp[row][col] = true;
                }else if(col > row + 1 && s.charAt(col) == s.charAt(row) && dp[row+1][col-1])
                {
                    dp[row][col] = true;
                }
                else
                {
                    dp[row][col] = false;
                }
                if(dp[row][col])
                    count++;
                col++;
                row++;
            }
        }
        return count;
    }
}
