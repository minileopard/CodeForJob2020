package companytest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class tx823_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int N = sc.nextInt();
        TreeSet<String> set = new TreeSet<String>((s1,s2)->{
            int i = 0;
            for (; i < s1.length() && i < s2.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i))
                {
                    return s1.charAt(i) - s2.charAt(i);
                }
            }
            if(s1.length() > s2.length())
            {
                if(s1.charAt(i) != s2.charAt(i-1))
                    return s1.charAt(i) - s2.charAt(i-1);
                else
                    return 1;
            }else if(s1.length() < s2.length())
            {
                if(s2.charAt(i) != s1.charAt(i-1))
                    return s2.charAt(i) - s1.charAt(i-1);
                else
                    return -1;
            }
            return s1.charAt(i-1) - s2.charAt(i-1);
        });
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                set.add(s.substring(i,j+1));
            }
        }
        String res = "";
        for (int i = 0; i < N; i++) {
            res = set.pollFirst();
        }
        System.out.println(res);
    }
}
