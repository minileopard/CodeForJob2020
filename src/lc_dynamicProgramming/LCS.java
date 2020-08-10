package lc_dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//https://www.nowcoder.com/questionTerminal/181a1a71c7574266ad07f9739f791506
public class LCS {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            if(s1.length() > s2.length())
            {
                String temp = s1;
                s1 = s2;
                s2 = temp;
            }
            int len1 = s1.length(), len2 = s2.length();
            int[][] dp = new int[len1+1][len2+1];
            Arrays.sort(dp, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return 0;
                }
            });
            int max = 0, maxIndex_i = 0;
            for(int i = 1; i <= len1; i++)
            {
                for(int j = 1; j <= len2; j++)
                {
                    if(s1.charAt(i-1) == s2.charAt(j-1))
                    {
                        dp[i][j] = dp[i-1][j-1] + 1;
                        if(dp[i][j] > max)
                        {
                            max = dp[i][j];
                            maxIndex_i = i-1;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < max; i++)
            {
                sb.insert(0,s1.charAt(maxIndex_i--));
            }
            System.out.println(sb.toString());
        }
    }
}
/*

llmgzeesikliqfeguiiivvx
bzgzrfsgysrfnryfjuzzrdwvgrdgntuctylbdsrfxftslxvdnhaojykvsbvrfabgqiyggtducdglegjouhmwgicbtfxwvxoetxudfoaddjeerrxlvpafsksfruxkdzzbagcetfutbiallwgeevkfrvbnqzyescpvpdvbsqfjlncfyyflqitiqjpajatascusgvojebudfguatzvfakovjtiguheizezhljdl

llmgz
bzgzll
 */
