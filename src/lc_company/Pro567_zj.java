package lc_company;

import java.util.Arrays;
import java.util.HashMap;

public class Pro567_zj {
    public static void main(String[] args) {
        String s1 = "abaaccaab ", s2 = "aobboapbabaaacdc";
        Pro567_zj p = new Pro567_zj();
        System.out.println(p.checkInclusion(s1, s2));
    }
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1 > len2)
            return false;
        int[] a1 = new int[26], a2 = new int[26];
        for (Character c:s1.toCharArray()) {
            a1[c-'a']++;
        }
        for (int i = 0; i < len1; i++) {
            Character c = s2.charAt(i);
            a2[c-'a']++;
        }
        if(isEqual(a1, a2))
            return true;
        for (int i = 1; i <= len2 - len1; i++) {
            char cl = s2.charAt(i-1), cr = s2.charAt(i + len1 - 1);
            a2[cl-'a']--;
            a2[cr-'a']++;
            if(isEqual(a1, a2))
                return true;
        }
        return false;
    }
    public boolean isEqual(int[] a1, int[] a2)
    {
        for (int i = 0; i < a1.length; i++) {
            if(a1[i] != a2[i])
                return false;
        }
        return true;
    }
}
