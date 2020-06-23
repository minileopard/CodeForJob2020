package lc_hot100;

import java.util.*;
import java.util.stream.Collectors;

public class Pro140 {
    public static void main(String[] args) {
        String[] list =  {"apple", "pen", "applepen", "pine", "pineapple"};
        List<String> wordDict = Arrays.stream(list).collect(Collectors.toList());
        String s = "pineapplepenapple";
        new Pro140().wordBreak(s, wordDict);
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>();
        for(String st:wordDict)
            set.add(st);
        List<String>[] dp = new LinkedList[len+1];
        List<String> temp = new LinkedList<>();
        temp.add("");//利用dp[i]的大小来标志是否存在于字典中
        dp[0] = temp;
        for(int i = 1; i <= len; i++)
        {
            List<String> list = new LinkedList<>();
            for(int j = 0; j < i; j++)
            {
                String temps = s.substring(j, i);
                if(dp[j].size() > 0 && set.contains(temps))
                {
                    //找到满足条件的，加入到结果中来
                    for(String ss:dp[j])
                    {
                        list.add(ss + (ss.equals("")?"":" ")+ temps);
                    }
                }
            }
            dp[i] = list;
        }
        return dp[len];
    }
}
