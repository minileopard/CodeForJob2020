package companytest;

import java.util.Scanner;

public class dd821_2 {
    static int count = 0;
    static int[][] move = {{0, 1},{1, 0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N < 3)
        {
            System.out.println(0);
            return;
        }
        char[][] list = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                list[i][j] = input.charAt(j);
            }
        }
        boolean[][] flag = new boolean[N][N];
        char[] target = {'C','H','I','N','A'};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(list[i][j] == 'C')
                {
                    fun(list, i, j, 0, flag, target);
                }
            }
        }
        System.out.println(count);
    }
    public static void fun(char[][] list, int r, int c, int len , boolean[][] flag, char[] target)
    {

        if(r < 0 || r >= list.length || c < 0 || c >= list.length || flag[r][c] || list[r][c] != target[len])
        {
            return;
        }
        if(len == target.length - 1)
        {
            count++;
            return;
        }
        flag[r][c] = true;
        for (int i = 0; i < move.length; i++) {
            int tr = r + move[i][0];
            int tc = c + move[i][1];
            fun(list,tr,tc,len+1,flag,target);
        }
        flag[r][c] = false;
    }
}
/*
4
CHIA
CANA
CHIC
BBDE
 */
