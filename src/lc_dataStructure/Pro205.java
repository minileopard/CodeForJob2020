package lc_dataStructure;

import java.util.HashMap;
import java.util.Map;

public class Pro205 {
    public static void main(String[] args) {
        String s = "a", t = "a";
        System.out.println(new Pro205().isIsomorphic(s,t));
    }
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null)
            return false;
        int len = s.length();
        char[] map = new char[256];
        for(int i = 0; i < len; i++)
        {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(map[sc] != map[tc+128])
            {
                return false;
            }
            map[sc] = sc;
            map[tc+128] = sc;
        }
        return true;
    }
}
/*
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        char[] map = new char[256];
        for (int i = cs.length - 1; i >= 0; i--) {
            if (map[cs[i]] != map[ct[i] + 128]) {
                return false;
            }
            map[cs[i]] = map[ct[i] + 128] = cs[i];
        }
        return true;
 */