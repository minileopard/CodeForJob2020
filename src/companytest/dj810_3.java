package companytest;

import java.util.*;

public class dj810_3 {
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] leets = new String[N];
        for (int i = 0; i < N; i++) {
            leets[i] = sc.next();
        }
        int M = sc.nextInt();
        String[] words = new String[M];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            words[i] = sc.next();
            if(fun(leets, words[i]))
                list.add(words[i]);
        }
        for(String s:list)
            System.out.println(s);
        list.sort(((o1, o2) -> {
            return o1.charAt(0) - o2.charAt(0);
        }));
        for(String s:list)
            System.out.println(s);
    }
    public static boolean fun(String[] leets, String aim)
    {
        int aimlen = aim.length();
        for (int i = 0; i < leets.length; i++) {
            String temp = leets[i];
            for (int j = 0; j < temp.length(); j++) {
                if(temp.charAt(j) == aim.charAt(0))
                {
                    return dfs(leets, i, j, aim, 0);
                }
            }
        }
        return false;
    }
    public static boolean dfs(String[] leets, int row, int col, String aim, int cur)
    {
        for (int i = 1; i < aim.length(); i++) {
            boolean t1 = false;
            for (int j = 0; j < move.length; j++) {
                row += move[j][0];
                col += move[j][1];
                if(row < 0 || row >= leets.length || col < 0 || col >= leets[row].length())
                {
                    row -= move[j][0];
                    col -= move[j][1];
                    continue;
                }
                if(leets[row].charAt(col) == aim.charAt(i))
                {
                    t1 = true;
                    break;
                }else
                {
                    row -= move[j][0];
                    col -= move[j][1];
                }
            }
            if(t1 == false)
            {
                return false;
            }
        }
        return true;
    }
}
/*
4
atmb
fueg
lyin
pkjd
4
flying
dji
drone
ideas
 */